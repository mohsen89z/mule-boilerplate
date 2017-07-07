package xyz.homapay.hampay.core.server.transformers.exception;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.response.RegistrationVerifyTransferMoneyResponse;
import xyz.homapay.hampay.common.core.model.response.VerifyTransferMoneyResponse;
import xyz.homapay.hampay.core.common.exception.SwitchVerificationFailureException;
import xyz.homapay.hampay.core.server.helper.ExceptionUtility;
import xyz.homapay.hampay.core.server.helper.PropertiesUtil;

/**
 * Created by sima on 7/2/15.
 */
public class VerifyXferExceptionToResponseTransformer extends AbstractMessageTransformer {

    @Override
    public Object transformMessage(MuleMessage muleMessage, String s) throws TransformerException {
        Throwable throwable = muleMessage.getExceptionPayload().getException().getCause();
        if (throwable instanceof SwitchVerificationFailureException) {
            RequestMessage requestMessage = muleMessage.getProperty("requestPayload", PropertyScope.INVOCATION);
            return createUnverifiedMoneyResponse(requestMessage.getService().getRequestUUID());
        } else {
            try {
                ExceptionUtility exceptionUtility = new ExceptionUtility();
                return exceptionUtility.createJsonFailureResponseMessage(muleMessage, createResponseMessageObject());
            } catch (Exception e) {
                throw new TransformerException(this, muleMessage.getExceptionPayload().getException().getCause());
            }
        }
    }

    private String createUnverifiedMoneyResponse(String requestUUID) {
        ResponseMessage<RegistrationVerifyTransferMoneyResponse> responseMessage = new ResponseMessage<>();
        responseMessage.setService(new RegistrationVerifyTransferMoneyResponse());
        responseMessage.getService().setResultStatus(ResultStatus.SUCCESS);
        responseMessage.getService().setIsVerified(false);
        responseMessage.getService().setRequestUUID(requestUUID);
        responseMessage.getService().setMessage(new PropertiesUtil().getNotVerifiedMessage());
        return new Gson().toJson(responseMessage, new TypeToken<ResponseMessage<RegistrationVerifyTransferMoneyResponse>>() {
        }.getType());
    }

    private ResponseMessage<VerifyTransferMoneyResponse> createResponseMessageObject() {
        ResponseMessage<VerifyTransferMoneyResponse> responseMessage = new ResponseMessage<>();
        responseMessage.setService(new VerifyTransferMoneyResponse());
        return responseMessage;
    }


}
