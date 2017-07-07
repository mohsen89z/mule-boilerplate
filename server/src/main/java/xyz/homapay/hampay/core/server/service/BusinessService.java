package xyz.homapay.hampay.core.server.service;

import org.bson.types.ObjectId;
import xyz.homapay.hampay.common.core.model.response.BusinessPaymentConfirmResponse;
import xyz.homapay.hampay.common.core.model.response.dto.BusinessDTO;
import xyz.homapay.hampay.core.common.data.model.Business;
import xyz.homapay.hampay.core.common.data.model.Customer;
import xyz.homapay.hampay.core.common.exception.BusinessNotFoundException;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.server.dao.BusinessDao;
import xyz.homapay.hampay.core.server.dao.impl.BusinessDaoImpl;
import xyz.homapay.hampay.core.server.transformers.BusinessToBusinessDTOTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ebrahim Pasbani.
 */
public class BusinessService {
    private BusinessDao businessDao = new BusinessDaoImpl();

    public List<BusinessDTO> getListAllBusiness(Integer pageSize, Integer pageNumber) throws DatabaseException {
        List<Business> bizList = businessDao.getAllBusinesses(pageSize, pageNumber);

        return new BusinessToBusinessDTOTransformer().fromModels(bizList);
    }

    public BusinessPaymentConfirmResponse getBusinessInfo(String bizCode) throws BusinessNotFoundException, DatabaseException {
//        BusinessPaymentConfirmResponse response = null;
//
//        HttpURLConnection httpURLConnection = null;
//        try {
//            httpURLConnection = SwitchRequestService.instance().sendRequestAccountProfile(findBusinessByCode(bizCode));
//            if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
//                response.setResultStatus(ResultStatus.FAILURE);
//                return response;
//            }
//            Gson gson = new Gson();
//            ResponseMessage<AccountProfileResponse> responseMessage = gson.fromJson(new InputStreamReader(httpURLConnection.getInputStream()), new TypeToken<ResponseMessage<AccountProfileResponse>>() {
//            }.getType());
//
//            if (responseMessage.getService().getResultStatus() == ResultStatus.SUCCESS) {
//                response = new BusinessPaymentConfirmResponse();
//                response.setBusinessCode(bizCode);
//                response.setFullName(responseMessage.getService().getName());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (httpURLConnection != null)
//                httpURLConnection.disconnect();
//            if (response == null) {
//                response = new BusinessPaymentConfirmResponse();
//                response.setResultStatus(ResultStatus.FAILURE);
//            }
//        }
//        return response;
        return null;
    }


    public List<BusinessDTO> findBusiness(Integer pageSize, Integer pageNumber, String term) throws DatabaseException {
        List<BusinessDTO> result;
        List<Business> bizList = businessDao.findBusinessByTermTitleInRange(term, pageSize, pageNumber);
        result = new BusinessToBusinessDTOTransformer().fromModels(bizList);
        if (result == null)
            result = new ArrayList<>();
        return result;
    }

    public Business findBusinessByCode(String code) throws BusinessNotFoundException, DatabaseException {
        return businessDao.findBusinessByCode(code);
    }

    public Customer findBusinessByAccountId(ObjectId id) throws BusinessNotFoundException {
        return businessDao.findBusinessByAccountId(id);
    }
}
