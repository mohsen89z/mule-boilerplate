package xyz.homapay.hampay.core.server.transformers;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.core.model.response.RegistrationCredentialsResponse;
import xyz.homapay.hampay.common.switchbay.model.response.AccountProfileResponse;
import xyz.homapay.hampay.common.switchbay.model.response.PaymentResponse;
import xyz.homapay.hampay.common.switchbay.model.response.VerifyTransactionResponse;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ebrahim Pasbani.
 */
public class JsonToResponseMessageTransformer extends AbstractTransformer {
    private String payloadType;

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }

    @Override
    protected Object doTransform(Object o, String s) throws TransformerException {

        Gson gson = createGson();

        if (payloadType == null || o == null)
            return null;

        //Switch Account Profile Response
        if (payloadType.equals(AccountProfileResponse.class.getSimpleName())) {
            Type requestType = new TypeToken<ResponseMessage<AccountProfileResponse>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }
        //Switch Verify Transaction Response
        if (payloadType.equals(VerifyTransactionResponse.class.getSimpleName())) {
            Type requestType = new TypeToken<ResponseMessage<VerifyTransactionResponse>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }
        //Switch Payment Response
        if (payloadType.equals(PaymentResponse.class.getSimpleName())) {
            Type requestType = new TypeToken<ResponseMessage<PaymentResponse>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }
        //Registration Credential Response
        if (payloadType.equals(RegistrationCredentialsResponse.class.getSimpleName())) {
            Type requestType = new TypeToken<ResponseMessage<RegistrationCredentialsResponse>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }
        return null;
    }

    private Gson createGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(DateFormat.LONG);
        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
                    JsonParseException {
                try {
                    Calendar cal = Calendar.getInstance();
                    cal.setTimeInMillis(json.getAsLong());
                    return cal.getTime();
                } catch (Exception ignored) {
                }
                return null;
            }
        });

        return gsonBuilder.create();
    }
}
