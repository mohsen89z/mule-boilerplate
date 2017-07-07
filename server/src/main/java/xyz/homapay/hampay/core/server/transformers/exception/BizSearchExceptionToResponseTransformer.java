package xyz.homapay.hampay.core.server.transformers.exception;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.core.model.response.BusinessListResponse;
import xyz.homapay.hampay.core.server.helper.ExceptionUtility;

/**
 * Created by sima on 7/2/15.
 */
public class BizSearchExceptionToResponseTransformer extends AbstractMessageTransformer {

    @Override
    public Object transformMessage(MuleMessage muleMessage, String s) throws TransformerException {
        try {
            return new ExceptionUtility().createJsonFailureResponseMessage(muleMessage, createResponseMessageObject());
        } catch (Exception e) {
            throw new TransformerException(this, muleMessage.getExceptionPayload().getException().getCause());
        }
    }

    private ResponseMessage<BusinessListResponse> createResponseMessageObject() {
        ResponseMessage<BusinessListResponse> responseMessage = new ResponseMessage<>();
        responseMessage.setService(new BusinessListResponse());
        return responseMessage;
    }

}
