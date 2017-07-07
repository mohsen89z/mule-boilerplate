package xyz.homapay.hampay.core.server.transformers.exception;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.core.model.response.UploadImageResponse;
import xyz.homapay.hampay.core.server.helper.ExceptionUtility;

/**
 * Created by sima on 10/12/15.
 * sima.ahmadvand@gmail.com
 */
public class UploadImageExceptionToResponseTransformer extends AbstractMessageTransformer {


    @Override
    public Object transformMessage(MuleMessage muleMessage, String s) throws TransformerException {
        try {
            return new ExceptionUtility().createJsonFailureResponseMessage(muleMessage, createResponseMessageObject());
        } catch (Exception e) {
            throw new TransformerException(this, muleMessage.getExceptionPayload().getException().getCause());
        }
    }

    private ResponseMessage<UploadImageResponse> createResponseMessageObject() {
        ResponseMessage<UploadImageResponse> responseMessage = new ResponseMessage<>();
        responseMessage.setService(new UploadImageResponse());
        return responseMessage;
    }
}
