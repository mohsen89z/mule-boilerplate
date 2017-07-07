package xyz.homapay.hampay.core.server.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import xyz.homapay.hampay.common.core.model.dto.ContactDTO;
import xyz.homapay.hampay.common.core.model.response.RegistrationCredentialsResponse;
import xyz.homapay.hampay.common.switchbay.model.SwitchResponseStatus;
import xyz.homapay.hampay.common.switchbay.model.response.PaymentResponse;
import xyz.homapay.hampay.core.common.data.dto.GNotificationMessageDTO;
import xyz.homapay.hampay.core.common.data.model.*;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.UserNotFoundException;
import xyz.homapay.hampay.core.common.exception.VersionNotFoundException;
import xyz.homapay.hampay.core.server.dao.NotificationDao;
import xyz.homapay.hampay.core.server.helper.PropertiesUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sima on 9/20/15.
 * sima.ahmadvand@gmail.com
 */
public class NotificationService {

    private final static Logger logger = Logger.getLogger(NotificationService.class);
    private TransactionService transactionService;
    private UserService userService;
    private PropertiesUtil propertiesUtil;
    private VersionService versionService;
    private DeviceService deviceService;
    private int maxAppUpdateUserPerNotification;
    private NotificationDao notificationDao;

    public void setNotificationDao(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    public void setMaxAppUpdateUserPerNotification(int maxAppUpdateUserPerNotification) {
        this.maxAppUpdateUserPerNotification = maxAppUpdateUserPerNotification;
    }

    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    public void setVersionService(VersionService versionService) {
        this.versionService = versionService;
    }

    public void setPropertiesUtil(PropertiesUtil propertiesUtil) {
        this.propertiesUtil = propertiesUtil;
    }

    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String createPaymentNotification(PaymentResponse paymentResponse) {
        if (isPaymentEligibleToNotify(paymentResponse.getSwitchResponseStatus())) {
            try {
                Transaction transaction = transactionService.findTransactionByReferenceCode(paymentResponse.getTransactionId());
                User receiverUser = userService.findActivatedUserByCellNumber(transaction.getDestinationAccount().getCustomer().getPhoneNumber());

                if (isPaymentSuccessful(paymentResponse.getSwitchResponseStatus())) {
                    return createNotificationMessageForSuccessful(transaction, receiverUser);

                } else if (isPaymentGotInsufficientAmount(paymentResponse.getSwitchResponseStatus())) {
                    return createNotificationMessageForInsufficientAmount(transaction, receiverUser);
                }
            } catch (Exception ignored) {
            }
        }

        return "";
    }

    private String createNotificationMessageForInsufficientAmount(Transaction transaction, User receiverUser)
            throws DatabaseException, UserNotFoundException {
        User senderUser = userService.findActivatedUserByCellNumber(transaction.getSourceAccount().getCustomer().getPhoneNumber());
        GNotificationMessageDTO notificationMessage = new GNotificationMessageDTO();
        notificationMessage.createData(GNotificationMessageDTO.NOTIFICATION_TYPE_TITLE, NotificationType.PAYMENT.name());
        String registrationId = senderUser.getFirstActiveDevice().getRegistrationId();
        if (registrationId == null)
            return "";
        notificationMessage.addRegId(registrationId);
        notificationMessage.createData(GNotificationMessageDTO.NOTIFICATION_NAME_TITLE, propertiesUtil.getUnsuccessfulPaymentName());
        notificationMessage.createData(GNotificationMessageDTO.NOTIFICATION_MESSAGE_TITLE, propertiesUtil.getInsufficientAmountPaymentNotificationMessage(receiverUser.getCustomer().getName()));
        return new Gson().toJson(notificationMessage, new TypeToken<GNotificationMessageDTO>() {
        }.getType());
    }

    private String createNotificationMessageForSuccessful(Transaction transaction, User receiverUser) {
        String registrationId = receiverUser.getFirstActiveDevice().getRegistrationId();
        GNotificationMessageDTO notificationMessage = new GNotificationMessageDTO();
        notificationMessage.createData(GNotificationMessageDTO.NOTIFICATION_TYPE_TITLE, NotificationType.PAYMENT.name());
        if (registrationId == null)
            return "";
        notificationMessage.addRegId(registrationId);
        notificationMessage.createData(GNotificationMessageDTO.NOTIFICATION_NAME_TITLE, receiverUser.getCustomer().getName());
        notificationMessage.createData(GNotificationMessageDTO.NOTIFICATION_MESSAGE_TITLE,
                propertiesUtil.getSuccessfulPaymentNotificationMessage(transaction.getAmount()));
        return new Gson().toJson(notificationMessage, new TypeToken<GNotificationMessageDTO>() {
        }.getType());
    }

    private boolean isPaymentEligibleToNotify(SwitchResponseStatus switchResponseStatus) {
        return switchResponseStatus == SwitchResponseStatus.SUCCESS || switchResponseStatus == SwitchResponseStatus.SUCCESSFUL_BUT_SOURCE_LEG_COULD_NOT_TRANSFERRED
                || switchResponseStatus == SwitchResponseStatus.NOT_SUFFICIENT_FUNDS;
    }

    private boolean isPaymentSuccessful(SwitchResponseStatus switchResponseStatus) {
        return switchResponseStatus == SwitchResponseStatus.SUCCESS || switchResponseStatus == SwitchResponseStatus.SUCCESSFUL_BUT_SOURCE_LEG_COULD_NOT_TRANSFERRED;
    }

    private boolean isPaymentGotInsufficientAmount(SwitchResponseStatus switchResponseStatus) {
        return switchResponseStatus == SwitchResponseStatus.NOT_SUFFICIENT_FUNDS;
    }


    public List<String> createJointNotification(RegistrationCredentialsResponse response, double maxNotifications) {
        try {
            List<String> notifications = new ArrayList<>();
            boolean hasAtLeastOneRegId = false;
            User user = userService.findUserByUserIdToken(response.getUserIdToken());
            int notificationNumbers = (int) (Math.ceil((double) response.getContacts().size() / maxNotifications));
            for (int i = 0; i < notificationNumbers; i++) {
                GNotificationMessageDTO notificationMessage = new GNotificationMessageDTO();
                notificationMessage.createData(GNotificationMessageDTO.NOTIFICATION_TYPE_TITLE, NotificationType.JOINT.name());
                notificationMessage.createData(GNotificationMessageDTO.NOTIFICATION_NAME_TITLE, user.getCustomer().getName());
                notificationMessage.createData(GNotificationMessageDTO.NOTIFICATION_MESSAGE_TITLE, propertiesUtil.getJointNotificationMessage());
                for (ContactDTO contactDTO : response.getContacts()) {
                    try {
                        User contactUser = userService.findActivatedUserByCellNumber(contactDTO.getCellNumber());
                        if (contactUser.getFirstActiveDevice().getRegistrationId() != null) {
                            hasAtLeastOneRegId = true;
                            notificationMessage.addRegId(contactUser.getFirstActiveDevice().getRegistrationId());
                        }
                    } catch (DatabaseException | UserNotFoundException ignored) {
                    }
                    if (notificationMessage.getRegistration_ids().size() == maxNotifications) {
                        notifications.add(new Gson().toJson(notificationMessage, new TypeToken<GNotificationMessageDTO>() {
                        }.getType()));
                        break;
                    }
                }
            }
            if (hasAtLeastOneRegId)
                return notifications;
        } catch (Exception ignored) {
        }
        return null;
    }

    public boolean checkIfAppVersionIsNotifiable() {
        try {
            versionService.findNotAppliedCurrentVersions();
            return true;
        } catch (DatabaseException | VersionNotFoundException e) {
            if (logger.isDebugEnabled())
                logger.debug("There is no app update version for notification");
        }
        return false;
    }

    public void createAppUpdateNotificationMessages() throws DatabaseException, VersionNotFoundException {
        Version version = versionService.findNotAppliedCurrentAndroidVersion();
        try {
            versionService.updateVersionToApplied(version);
            long userCount = deviceService.getOutOfDateUsersCount(version);
            int notificationNumbers = (int) (Math.ceil((double) userCount / (double) maxAppUpdateUserPerNotification));
            for (int i = 0; i < notificationNumbers; i++) {
                int beginIndex = i * maxAppUpdateUserPerNotification;
                List<UserDevice> userDevices = deviceService.getOutOfDateUsersInRange(beginIndex, beginIndex + maxAppUpdateUserPerNotification, version);
                List<String> registrationIds = new ArrayList<>(userDevices.size());
                for (UserDevice userDevice : userDevices) {
                    registrationIds.add(userDevice.getRegistrationId());
                }
                createNotification(registrationIds, version.getName());
            }
        } catch (Exception e) {
            versionService.updateVersionToNotApplied(version);
        }

    }

    private void createNotification(List<String> registrationIds, String versionName) throws DatabaseException {
        Notification notification = new Notification();
        notification.setNotificationStatus(NotificationStatus.READY_TO_SEND);
        notification.setDateTime(new Date());
        notification.setMessage(createAppUpdateNotificationMessage(registrationIds, versionName));
        notificationDao.save(notification);
    }

    private String createAppUpdateNotificationMessage(List<String> registrationIds, String versionName) {
        GNotificationMessageDTO notificationMessage = new GNotificationMessageDTO();
        notificationMessage.createData(GNotificationMessageDTO.NOTIFICATION_TYPE_TITLE, NotificationType.APP_UPDATE.name());
        notificationMessage.addRegIds(registrationIds);
        notificationMessage.createData(GNotificationMessageDTO.NOTIFICATION_NAME_TITLE, propertiesUtil.getAppUpdateNotificationName());
        notificationMessage.createData(GNotificationMessageDTO.NOTIFICATION_MESSAGE_TITLE, propertiesUtil.getAppUpdateNotificationMessage(versionName));
        return new Gson().toJson(notificationMessage, new TypeToken<GNotificationMessageDTO>() {
        }.getType());
    }

    public List<Notification> getAppUpdateNotificationRecords(int maxNotificationMessagePerJob) throws DatabaseException {
        notificationDao.updateNotificationsToReadyToSend(maxNotificationMessagePerJob);
        return notificationDao.getAppUpdateNotificationRecords(maxNotificationMessagePerJob);
    }

    public long getAppUpdateNotificationMessageCounts() throws DatabaseException {
        return notificationDao.getAppUpdateNotificationMessageCounts();
    }

    public void removeNotifiedMessage(List<Notification> notifications) {
        try {
            notificationDao.removeAll(notifications);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
