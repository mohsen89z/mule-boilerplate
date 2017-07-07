package xyz.homapay.hampay.core.server.service;

import org.apache.commons.lang.StringUtils;
import xyz.homapay.hampay.common.core.model.request.RegistrationConfirmUserDataRequest;
import xyz.homapay.hampay.common.core.model.response.RegistrationFetchUserDataResponse;
import xyz.homapay.hampay.common.switchbay.model.response.AccountProfileResponse;
import xyz.homapay.hampay.core.common.data.dto.IdpUserValidity;
import xyz.homapay.hampay.core.common.data.dto.UserDTO;
import xyz.homapay.hampay.core.common.data.model.IdentityAcknowledgment;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.data.model.UserDevice;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.InvalidUserDataException;
import xyz.homapay.hampay.core.server.dao.IdentityAcknowledgmentDao;
import xyz.homapay.hampay.core.server.dao.impl.IdentityAcknowledgmentDaoImpl;
import xyz.homapay.hampay.core.server.helper.PropertiesUtil;

import java.util.Date;

/**
 * Created by Ebrahim Pasbani.
 */
public class SecurityService {
    private IdentityAcknowledgmentDao acknowledgmentDao = new IdentityAcknowledgmentDaoImpl();

    public Boolean checkMemorableWord(String memWord) {
        char[] restrictedChars = new PropertiesUtil().getMemWordRestrictedValuesAsArrCharArray();
        boolean result = StringUtils.containsAny(memWord, restrictedChars);
        return !result;
    }

    public RegistrationFetchUserDataResponse convertSwitchAccountProfileToRegistrationUserDataResponse(User user, AccountProfileResponse accountProfileResponse) {
        RegistrationFetchUserDataResponse response = new RegistrationFetchUserDataResponse();
        response.setAccountNumber(accountProfileResponse.getAccount().getAccountNumber());
        response.setCellNumber(user.getMobileNo());
        response.setFulName(accountProfileResponse.getName());
        response.setNationalCode(accountProfileResponse.getNationalId());
        return response;
    }

    public Date confirmRegistrationUserData(RegistrationConfirmUserDataRequest request, User user) throws DatabaseException, InvalidUserDataException {
        Date confirmDate = new Date();
        checkUserDataValidity(request, user);
        IdentityAcknowledgment acknowledgment = new IdentityAcknowledgment();
        acknowledgment.setConfirmDate(confirmDate);
        acknowledgment.setDeviceId(request.getDeviceId());
        acknowledgment.setImei(request.getImei());
        acknowledgment.setIp(request.getIp());
        acknowledgment.setUserIdToken(request.getUserIdToken());
        acknowledgmentDao.save(acknowledgment);
        return confirmDate;
    }

    private void checkUserDataValidity(RegistrationConfirmUserDataRequest request, User user) throws InvalidUserDataException {
        if (!request.getUserIdToken().equals(user.getUserIdToken()))
            throw new InvalidUserDataException();
        for (UserDevice userDevice : user.getDevices()) {
            if (userDevice.getImei().equals(request.getImei()))
                return;
        }
        throw new InvalidUserDataException();
    }

    public UserDTO createUserDTOFromIdp(IdpUserValidity idpUser) {
        UserDTO user = new UserDTO();
        if (idpUser != null) {
            user.setUserId(idpUser.getUid());
            user.setValid(idpUser.getValid());
        }
        return user;
    }

}