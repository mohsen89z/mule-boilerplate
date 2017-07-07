package xyz.homapay.hampay.core.server.transformers.exception;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.LifecycleException;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transport.ConnectException;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResponseService;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.response.BankListResponse;

import java.util.NoSuchElementException;

/**
 * Created by sima on 8/6/15.
 */
public class RestRouterExceptionToResponseTransformer extends AbstractMessageTransformer {
    @Override
    public Object transformMessage(MuleMessage muleMessage, String s) throws TransformerException {
        ResponseMessage<BankListResponse> responseMessage = new ResponseMessage<>();
        responseMessage.setService(new BankListResponse());
        Throwable throwable = muleMessage.getExceptionPayload().getException().getCause();
        String errorMessage = muleMessage.getExceptionPayload().getException().getMessage();
        if ((errorMessage.contains("amqpRabbitMQConnector") || errorMessage.contains("amqp"))
                && (throwable instanceof LifecycleException || throwable instanceof NoSuchElementException ||
                throwable instanceof ConnectException))
            responseMessage.getService().setResultStatus(ResultStatus.MQ_EXCEPTION);
        else
            responseMessage.getService().setResultStatus(ResultStatus.UNKNOWN);

        return new Gson().toJson(responseMessage, new TypeToken<ResponseMessage<? extends ResponseService>>() {
        }.getType());
    }
}
