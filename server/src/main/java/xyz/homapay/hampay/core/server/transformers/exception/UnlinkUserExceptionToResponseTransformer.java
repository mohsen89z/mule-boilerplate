package xyz.homapay.hampay.core.server.transformers.exception;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.core.model.response.UnlinkUserResponse;
import xyz.homapay.hampay.core.server.helper.ExceptionUtility;

/**
 * Created by sima on 8/23/15.
 */
public class UnlinkUserExceptionToResponseTransformer extends AbstractMessageTransformer {

    @Override
    public Object transformMessage(MuleMessage muleMessage, String s) throws TransformerException {
        try {
            return new ExceptionUtility().createJsonFailureResponseMessage(muleMessage, createResponseMessageObject());
        } catch (Exception e) {
            throw new TransformerException(this, muleMessage.getExceptionPayload().getException().getCause());
        }
    }

    private ResponseMessage<UnlinkUserResponse> createResponseMessageObject() {
        ResponseMessage<UnlinkUserResponse> responseMessage = new ResponseMessage<>();
        responseMessage.setService(new UnlinkUserResponse());
        return responseMessage;
    }
}
