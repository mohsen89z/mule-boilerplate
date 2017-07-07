package xyz.homapay.hampay.core.servermock.service.response;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.BusinessListRequest;
import xyz.homapay.hampay.common.core.model.request.BusinessSearchRequest;
import xyz.homapay.hampay.common.core.model.response.BusinessListResponse;
import xyz.homapay.hampay.common.core.model.response.dto.BusinessDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siavash Mahmoudpour
 */
public class BusinessesResponseBuilder {

    public ResponseMessage<BusinessListResponse> createBusinessListFailureResponse(BusinessListRequest request) {

        ResponseMessage<BusinessListResponse> responseMessage = new ResponseMessage<BusinessListResponse>();
        BusinessListResponse response = new BusinessListResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        response.setPageNumber(-1);
        response.setPageSize(-1);
        response.setBusinesses(null);

        responseMessage.setService(response);
        return responseMessage;

    }

    public ResponseMessage<BusinessListResponse> createBusinessListSuccessResponse(BusinessListRequest request) {

        ResponseMessage<BusinessListResponse> responseMessage = new ResponseMessage<BusinessListResponse>();
        BusinessListResponse response = new BusinessListResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setPageNumber(request.getPageNumber());
        response.setPageSize(request.getPageSize());
        response.setBusinesses(getBusinesses(request.getPageSize()));

        responseMessage.setService(response);
        return responseMessage;
    }

    private List<BusinessDTO> getBusinesses(int pageSize) {
        List<BusinessDTO> businesses = new ArrayList<BusinessDTO>();

        for (int i = 0; i < pageSize; i++) {
            BusinessDTO dto1 = new BusinessDTO();
            dto1.setCategory("Charity");
            dto1.setCode(RandomStringUtils.randomNumeric(4));
            dto1.setDefaultPhoneNumber(RandomStringUtils.randomNumeric(8));
            dto1.setLatitude(RandomUtils.nextDouble());
            dto1.setLongitude(RandomUtils.nextDouble());
            dto1.setSummary("Mahak Institute");
            dto1.setTitle("Mahak");
            dto1.setWebsiteAddress("http://mahak.com");
            businesses.add(dto1);
        }
//        BusinessDTO dto1 = new BusinessDTO();
//        dto1.setCategory("Charity");
//        dto1.setCode("1234");
//        dto1.setDefaultPhoneNumber("88888888");
//        dto1.setLatitude(1038284.4534452);
//        dto1.setLongitude(1038290.4534535);
//        dto1.setSummary("Mahak Institute");
//        dto1.setTitle("Mahak");
//        dto1.setWebsiteAddress("http://mahak.com");
//        businesses.add(dto1);

//        BusinessDTO dto2 = new BusinessDTO();
//        dto2.setCategory("Sport");
//        dto2.setCode("1235");
//        dto2.setDefaultPhoneNumber("77777777");
//        dto2.setLatitude(1038345.1234452);
//        dto2.setLongitude(1038123.3214535);
//        dto2.setSummary("Barca Athletic Club");
//        dto2.setTitle("Barca");
//        dto2.setWebsiteAddress("http://barca.com");
//        businesses.add(dto2);

//        BusinessDTO dto3 = new BusinessDTO();
//        dto3.setCategory("Charity");
//        dto3.setCode("1236");
//        dto3.setDefaultPhoneNumber("66666666");
//        dto3.setLatitude(1038352.4534452);
//        dto3.setLongitude(1038652.4534535);
//        dto3.setSummary("Unicef");
//        dto3.setTitle("Unicef");
//        dto3.setWebsiteAddress("http://unicef.org");
//        businesses.add(dto3);
//
        return businesses;
    }

    public ResponseMessage<BusinessListResponse> createSearchBusinessSuccessResponse(BusinessSearchRequest request) {
        ResponseMessage<BusinessListResponse> responseMessage = new ResponseMessage<BusinessListResponse>();
        BusinessListResponse response = new BusinessListResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setPageNumber(request.getPageNumber());
        response.setPageSize(request.getPageSize());
        response.setBusinesses(getBusinesses(request.getPageSize(), request.getTerm()));
        responseMessage.setService(response);
        return responseMessage;
    }

    private List<BusinessDTO> getBusinesses(int pageSize, String title) {
        List<BusinessDTO> businesses = new ArrayList<BusinessDTO>();

        for (int i = 0; i < pageSize; i++) {
            BusinessDTO dto1 = new BusinessDTO();
            dto1.setCategory("Charity");
            dto1.setCode(RandomStringUtils.randomNumeric(4));
            dto1.setDefaultPhoneNumber(RandomStringUtils.randomNumeric(8));
            dto1.setLatitude(RandomUtils.nextDouble());
            dto1.setLongitude(RandomUtils.nextDouble());
            dto1.setSummary("Mahak Institute");
            dto1.setTitle(title + "test" + i);
            dto1.setWebsiteAddress("http://mahak.com");
            businesses.add(dto1);
        }
        return businesses;
    }
}
