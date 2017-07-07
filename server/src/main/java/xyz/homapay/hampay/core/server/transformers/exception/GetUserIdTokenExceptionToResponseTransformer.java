package xyz.homapay.hampay.core.server.transformers.exception;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.core.model.response.GetUserIdTokenResponse;
import xyz.homapay.hampay.core.server.helper.ExceptionUtility;

/**
 * Created by sima on 9/30/15.
 * sima.ahmadvand@gmail.com
 */
public class GetUserIdTokenExceptionToResponseTransformer extends AbstractMessageTransformer {


    @Override
    public Object transformMessage(MuleMessage muleMessage, String s) throws TransformerException {
        try {
            return new ExceptionUtility().createJsonFailureResponseMessage(muleMessage, createResponseMessageObject());
        } catch (Exception e) {
            throw new TransformerException(this, muleMessage.getExceptionPayload().getException().getCause());
        }
    }

    private ResponseMessage<GetUserIdTokenResponse> createResponseMessageObject() {
        ResponseMessage<GetUserIdTokenResponse> responseMessage = new ResponseMessage<>();
        responseMessage.setService(new GetUserIdTokenResponse());
        return responseMessage;
    }
}