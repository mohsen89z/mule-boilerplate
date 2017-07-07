package xyz.homapay.hampay.core.server.service;

import xyz.homapay.hampay.common.core.model.response.IndividualPaymentConfirmResponse;
import xyz.homapay.hampay.core.common.exception.CustomerIsNotIndividualException;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.UserNotFoundException;

/**
 * Created by Ebrahim Pasbani.
 */
public class IndividualCustomerService {

    public IndividualPaymentConfirmResponse getIndividualCustomerResponseByCellNumber(String cellNo) throws UserNotFoundException, DatabaseException, CustomerIsNotIndividualException {
//        IndividualPaymentConfirmResponse response = null;
//
//        HttpURLConnection httpURLConnection = null;
//        try {
//            httpURLConnection = SwitchRequestService.instance().sendRequestAccountProfile(new UserService().getUserByCellNumber(cellNo));
//            if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
//                response.setResultStatus(ResultStatus.FAILURE);
//                return response;
//            }
//            Gson gson = new Gson();
//            ResponseMessage<AccountProfileResponse> responseMessage = gson.fromJson(new InputStreamReader(httpURLConnection.getInputStream()), new TypeToken<ResponseMessage<AccountProfileResponse>>() {
//            }.getType());
//
//            if (responseMessage.getService().getResultStatus() == ResultStatus.SUCCESS) {
//                if(responseMessage.getService().getCustomerType()!= CustomerType.INDIVIDUAL_ACCOUNT)
//                    throw new CustomerIsNotIndividualException();
//                response = new IndividualPaymentConfirmResponse();
//                response.setCellNumber(cellNo);
//                response.setFullName(responseMessage.getService().getName());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (httpURLConnection != null)
//                httpURLConnection.disconnect();
//            if (response == null) {
//                response = new IndividualPaymentConfirmResponse();
//                response.setResultStatus(ResultStatus.FAILURE);
//            }
//        }
//        return response;
        return null;
    }

}
