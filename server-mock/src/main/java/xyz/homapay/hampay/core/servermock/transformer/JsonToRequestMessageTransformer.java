package xyz.homapay.hampay.core.servermock.transformer;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.core.model.request.*;
import xyz.homapay.hampay.common.switchbay.model.request.AccountProfileRequest;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Siavash Mahmoudpour
 */

public class JsonToRequestMessageTransformer extends AbstractTransformer {

    private String payloadType;

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }

    @Override
    protected Object doTransform(Object o, String s) throws TransformerException {

        if (payloadType == null || o == null)
            return null;

        Gson gson = createGson();

        //Bank List Request
        if (payloadType.equals(BankListRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<BankListRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Business List Request
        } else if (payloadType.equals(BusinessListRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<BusinessListRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Business Payment Confirm Request
        } else if (payloadType.equals(BusinessPaymentConfirmRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<BusinessPaymentConfirmRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Business Payment Request
        } else if (payloadType.equals(BusinessPaymentRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<BusinessPaymentRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Change Memorable Word Request
        } else if (payloadType.equals(ChangeMemorableWordRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<ChangeMemorableWordRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Change Pass Code Request
        } else if (payloadType.equals(ChangePassCodeRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<ChangePassCodeRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Contacts Hampay Enabled Request
        } else if (payloadType.equals(ContactsHampayEnabledRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<ContactsHampayEnabledRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Contact Us Request
        } else if (payloadType.equals(ContactUsRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<ContactUsRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Individual Payment Confirm Request
        } else if (payloadType.equals(IndividualPaymentConfirmRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<IndividualPaymentConfirmRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Individual Payment Request
        } else if (payloadType.equals(IndividualPaymentRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<IndividualPaymentRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Registration Account Info Request
        } else if (payloadType.equals(RegistrationAccountInfoRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<RegistrationAccountInfoRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Registration Confirm User Data Request
        } else if (payloadType.equals(RegistrationConfirmUserDataRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<RegistrationConfirmUserDataRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Registration Credentials Request
        } else if (payloadType.equals(RegistrationCredentialsRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<RegistrationCredentialsRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Mobile Registration ID Entry Request
        } else if (payloadType.equals(MobileRegistrationIdEntryRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<MobileRegistrationIdEntryRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Registration Fetch User Data Request
        } else if (payloadType.equals(RegistrationFetchUserDataRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<RegistrationFetchUserDataRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
            //Registration Resend Sms Token Request
        } else if (payloadType.equals(RegistrationSendSmsTokenRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<RegistrationSendSmsTokenRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Registration Entry Request
        } else if (payloadType.equals(RegistrationEntryRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<RegistrationEntryRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Registration Verify Account Request
        } else if (payloadType.equals(RegistrationVerifyAccountRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<RegistrationVerifyAccountRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Registration Verify Mobile Request
        } else if (payloadType.equals(RegistrationVerifyMobileRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<RegistrationVerifyMobileRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //TAC Accept Request
        } else if (payloadType.equals(TACAcceptRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<TACAcceptRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //TAC Request
        } else if (payloadType.equals(TACRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<TACRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Transaction List Request
        } else if (payloadType.equals(TransactionListRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<TransactionListRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //User Profile Request
        } else if (payloadType.equals(UserProfileRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<UserProfileRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Verify Account Request
        } else if (payloadType.equals(VerifyAccountRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<VerifyAccountRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);

            //Verify Transfer Money Request
        } else if (payloadType.equals(VerifyTransferMoneyRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<VerifyTransferMoneyRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }
        //Switch Account Profile Request
        else if (payloadType.equals(AccountProfileRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<AccountProfileRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }
        //Business Search Request
        else if (payloadType.equals(BusinessSearchRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<BusinessSearchRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }
        //Registration Verify Account Request
        else if (payloadType.equals(RegistrationVerifyAccountRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<RegistrationVerifyAccountRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }
        //Registration Verify Transfer Money Request
        else if (payloadType.equals(RegistrationVerifyTransferMoneyRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<RegistrationVerifyTransferMoneyRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }
        //Terms and Conditions Request
        else if (payloadType.equals(TACRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<TACRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }
        //Terms and Conditions Accept Request
        else if (payloadType.equals(TACAcceptRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<TACAcceptRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }
        //User Profile Request
        else if (payloadType.equals(UserProfileRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<UserProfileRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }
        //Event List Request
        else if (payloadType.equals(EventListRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<EventListRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }
        //Registration Credential Entry Request
        else if (payloadType.equals(RegistrationCredentialsRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<RegistrationCredentialsRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }//Unlink User Request
        else if (payloadType.equals(UnlinkUserRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<UnlinkUserRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }//Get User Id Token Request
        else if (payloadType.equals(GetUserIdTokenRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<GetUserIdTokenRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }//Upload Image Request
        else if (payloadType.equals(UploadImageRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<UploadImageRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }//Change Email Request
        else if (payloadType.equals(ChangeEmailRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<ChangeEmailRequest>>() {
            }.getType();
            return gson.fromJson(o.toString(), requestType);
        }//Illegal App List Request
        else if (payloadType.equals(IllegalAppListRequest.class.getSimpleName())) {
            Type requestType = new TypeToken<RequestMessage<IllegalAppListRequest>>() {
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
                } catch (Exception e) {
                }
                return null;
            }
        });

        return gsonBuilder.create();
    }
}