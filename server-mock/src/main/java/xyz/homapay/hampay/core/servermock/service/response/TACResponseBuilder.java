package xyz.homapay.hampay.core.servermock.service.response;

import org.apache.commons.io.IOUtils;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.dto.ContactDTO;
import xyz.homapay.hampay.common.core.model.dto.UserVerificationStatus;
import xyz.homapay.hampay.common.core.model.request.TACAcceptRequest;
import xyz.homapay.hampay.common.core.model.request.TACRequest;
import xyz.homapay.hampay.common.core.model.response.TACAcceptResponse;
import xyz.homapay.hampay.common.core.model.response.TACResponse;
import xyz.homapay.hampay.common.core.model.response.dto.UserProfileDTO;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Siavash Mahmoudpour
 */
public class TACResponseBuilder {

    public ResponseMessage<TACResponse> createTACFailureResponse(TACRequest request) {

        ResponseMessage<TACResponse> responseMessage = new ResponseMessage<>();
        TACResponse response = new TACResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        response.setShouldAcceptTAC(false);
        response.setTac(null);
        response.setLastTACAcceptedDate(null);
        response.setLastTACAcceptedVersion(null);
        response.setUserProfile(null);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<TACResponse> createTACSuccessResponse(TACRequest request, String userId) {

        ResponseMessage<TACResponse> responseMessage = new ResponseMessage<>();
        TACResponse response = new TACResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setShouldAcceptTAC(true);
        response.setTac(getTACAsString());
        response.setLastTACAcceptedDate(null);
        response.setLastTACAcceptedVersion(null);
        response.setUserProfile(null);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<TACResponse> createTACAcceptedFailureResponse(TACRequest request) {

        ResponseMessage<TACResponse> responseMessage = new ResponseMessage<>();
        TACResponse response = new TACResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        response.setShouldAcceptTAC(false);
        response.setTac(null);
        response.setLastTACAcceptedDate(null);
        response.setLastTACAcceptedVersion(null);
        response.setUserProfile(null);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<TACResponse> createTACAcceptedSuccessResponse(TACRequest request, String userId) {

        ResponseMessage<TACResponse> responseMessage = new ResponseMessage<>();
        TACResponse response = new TACResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setShouldAcceptTAC(false);
        response.setTac(null);
        response.setLastTACAcceptedDate(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000));
        response.setLastTACAcceptedDate(new Date());
        response.setLastTACAcceptedVersion("1.0.0");
        response.setUserProfile(getUserProfile(userId));

        responseMessage.setService(response);
        return responseMessage;
    }

    private String getTACAsString() {
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(getClass().getResourceAsStream("/hampaytac.txt"), writer, "UTF-8");
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResponseMessage<TACAcceptResponse> createTACAcceptFailureResponse(TACAcceptRequest request) {

        ResponseMessage<TACAcceptResponse> responseMessage = new ResponseMessage<TACAcceptResponse>();
        TACAcceptResponse response = new TACAcceptResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        response.setUserProfile(null);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<TACAcceptResponse> createTACAcceptSuccessResponse(TACAcceptRequest request, String userId) {

        ResponseMessage<TACAcceptResponse> responseMessage = new ResponseMessage<TACAcceptResponse>();
        TACAcceptResponse response = new TACAcceptResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setUserProfile(getUserProfile(userId));

        responseMessage.setService(response);
        return responseMessage;
    }

    private UserProfileDTO getUserProfile(String userId) {
        UserProfileDTO userProfile = new UserProfileDTO();
        userProfile.setTitle("Mr.");
        userProfile.setAccountNumber("182556005645");
        userProfile.setBankName("بانک تجارت");
        userProfile.setFullName("هومن امينی");
        userProfile.setCellNumber("09129479928");
        userProfile.setVerificationStatus(UserVerificationStatus.DELEGATED);
        userProfile.setLastLoginDate(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000));
        userProfile.setMinXferAmount(2000L);
        userProfile.setMaxXferAmount(5000L);


        List<ContactDTO> selectedContacts = new ArrayList<ContactDTO>();

        ContactDTO contact1 = new ContactDTO();
        contact1.setCellNumber("09121111111");
        contact1.setDisplayName("هم پی يار تجارت");
        selectedContacts.add(contact1);

        ContactDTO contact2 = new ContactDTO();
        contact2.setCellNumber("09123333333");
        contact2.setDisplayName("مجيد زمانی");
        selectedContacts.add(contact2);

        ContactDTO contact3 = new ContactDTO();
        contact3.setCellNumber("09124444444");
        contact3.setDisplayName("مونا حاج علی اصغر");
        selectedContacts.add(contact3);

        ContactDTO contact4 = new ContactDTO();
        contact4.setCellNumber("09125555555");
        contact4.setDisplayName("پيام افضلی");
        selectedContacts.add(contact4);


        userProfile.setSelectedContacts(selectedContacts);

        return userProfile;
    }
}
