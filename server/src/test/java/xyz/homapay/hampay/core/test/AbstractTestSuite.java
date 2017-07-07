package xyz.homapay.hampay.core.test;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.mule.api.MuleMessage;
import org.mule.api.transport.PropertyScope;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import org.mule.munit.runner.functional.FunctionalMunitSuite;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.switchbay.model.SwitchResponseStatus;
import xyz.homapay.hampay.common.switchbay.model.response.PaymentResponse;
import xyz.homapay.hampay.common.switchbay.model.response.SwitchResponseService;
import xyz.homapay.hampay.core.common.data.dto.IdpUserValidity;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Ebrahim Pasbani.
 */
public class AbstractTestSuite extends FunctionalMunitSuite {
    private GsonBuilder gsonBuilder = null;
    private Properties securityProperties, switchProperties;


    public AbstractTestSuite() {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(DateFormat.LONG);
        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
                    JsonParseException {
                try {
                    Calendar cal = Calendar.getInstance();
                    cal.setTimeInMillis(json.getAsLong());
                    return cal.getTime();
                } catch (Exception e) {
                }
                return null;
            }
        });
        securityProperties = new Properties();
        switchProperties = new Properties();
        try {
            securityProperties.load(this.getClass().getResourceAsStream("/security.properties"));
            switchProperties.load(this.getClass().getResourceAsStream("/hampay-switch.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void mockIDPAuthenticateSuccess(String authToken) {

        whenEndpointWithAddress(createAuthenticationURL(authToken)).thenApply(new MuleMessageTransformer() {
            @Override
            public MuleMessage transform(MuleMessage muleMessage) {
                muleMessage.setProperty("http.status", "200", PropertyScope.INBOUND);
                IdpUserValidity idpUserValidity = new IdpUserValidity();
                idpUserValidity.setRealm("/");
                idpUserValidity.setUid("0083519076");
                idpUserValidity.setValid(true);
                muleMessage.setPayload(new Gson().toJson(idpUserValidity, IdpUserValidity.class));
                return muleMessage;

            }
        });
    }

    public void mockIDPAuthenticateFailure(String authToken) {

        whenEndpointWithAddress(createAuthenticationURL(authToken)).thenApply(new MuleMessageTransformer() {
            @Override
            public MuleMessage transform(MuleMessage muleMessage) {
                muleMessage.setProperty("http.status", "401", PropertyScope.INBOUND);
                return muleMessage;

            }
        });
    }

    public void mockIDPLoginSuccess() {

        whenEndpointWithAddress(createLoginURL()).thenApply(new MuleMessageTransformer() {
            @Override
            public MuleMessage transform(MuleMessage muleMessage) {
                muleMessage.setProperty("http.status", "200", PropertyScope.INBOUND);
                muleMessage.setPayload("9387593847593847594387598375@@%$#$56^&*!7834");
                return muleMessage;

            }
        });
    }

    public void mockIDPLoginFailure() {

        whenEndpointWithAddress(createLoginURL()).thenApply(new MuleMessageTransformer() {
            @Override
            public MuleMessage transform(MuleMessage muleMessage) {
                muleMessage.setProperty("http.status", "401", PropertyScope.INBOUND);
                muleMessage.setPayload("{Invalid password!}");
                return muleMessage;

            }
        });
    }

    public void mockIDPReadUserNotFound(String username) {

        whenEndpointWithAddress(createReadUserURL(username)).thenApply(new MuleMessageTransformer() {
            @Override
            public MuleMessage transform(MuleMessage muleMessage) {
                muleMessage.setProperty("http.status", "401", PropertyScope.INBOUND);
                return muleMessage;
            }
        });
    }


    public void mockCreateSuccessUser() {

        whenEndpointWithAddress(createUserURL()).thenApply(new MuleMessageTransformer() {
            @Override
            public MuleMessage transform(MuleMessage muleMessage) {
                muleMessage.setProperty("http.status", "200", PropertyScope.INBOUND);
                return muleMessage;

            }
        });
    }

    public void mockLogoutSuccess() {

        whenEndpointWithAddress(createLogoutURL()).thenApply(new MuleMessageTransformer() {
            @Override
            public MuleMessage transform(MuleMessage muleMessage) {
                muleMessage.setProperty("http.status", "200", PropertyScope.INBOUND);
                return muleMessage;

            }
        });
    }

    public void mockSwitchPaymentSuccess() {

        whenEndpointWithAddress(createSwitchPaymentURL()).thenApply(new MuleMessageTransformer() {
            @Override
            public MuleMessage transform(MuleMessage muleMessage) {
                ResponseMessage<PaymentResponse> responseMessage = new ResponseMessage<>();
                PaymentResponse service = new PaymentResponse();
                service.setRequestUUID("54301321");
                service.setSwitchResponseStatus(SwitchResponseStatus.SUCCESS);
                responseMessage.setService(service);
                muleMessage.setPayload(new Gson().toJson(responseMessage, new TypeToken<ResponseMessage<? extends SwitchResponseService>>() {
                }.getType()));
                return muleMessage;

            }
        });
    }


    public void mockSwitchPaymentFailure() {

        whenEndpointWithAddress(createSwitchPaymentURL()).thenApply(new MuleMessageTransformer() {
            @Override
            public MuleMessage transform(MuleMessage muleMessage) {
                ResponseMessage<PaymentResponse> responseMessage = new ResponseMessage<>();
                PaymentResponse service = new PaymentResponse();
                service.setRequestUUID("54301321");
                service.setSwitchResponseStatus(SwitchResponseStatus.AMOUNT_TOO_LARGE);
                responseMessage.setService(service);
                muleMessage.setPayload(new Gson().toJson(responseMessage, new TypeToken<ResponseMessage<? extends SwitchResponseService>>() {
                }.getType()));
                return muleMessage;

            }
        });
    }

    private String createAuthenticationURL(String authToken) {
        return new StringBuilder(securityProperties.getProperty("idp.uri")).append("/json/sessions/")
                .append(authToken).append("?_action=validate").toString();
    }

    private String createLoginURL() {
        return new StringBuilder(securityProperties.getProperty("idp.uri")).append("/json/authenticate").toString();
    }

    private String createReadUserURL(String userName) {
        return new StringBuilder(securityProperties.getProperty("idp.uri")).append("/json/users/").append(userName).toString();
    }

    private String createUserURL() {
        return new StringBuilder(securityProperties.getProperty("idp.uri")).append("/json/users/?_action=create").toString();
    }

    private String createLogoutURL() {
        return new StringBuilder(securityProperties.getProperty("idp.uri")).append("/json/sessions/?_action=logout").toString();
    }

    private String createSwitchPaymentURL() {
        return new StringBuilder(switchProperties.getProperty("hampay-switch-host")).append(":")
                .append(switchProperties.getProperty("hampay-switch-port")).append("/payment").toString();
    }

    protected Gson gson() {
        return gsonBuilder.create();
    }

    @Override
    protected boolean haveToDisableInboundEndpoints() {
        return true;
    }

    @Override
    protected boolean haveToMockMuleConnectors() {
        return true;
    }

    @Override
    protected String getConfigResources() {
        return "mule-test-config.xml";
    }


}
