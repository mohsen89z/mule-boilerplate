package xyz.homapay.hampay.core.server.helper;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoException;
import org.apache.http.conn.ConnectTimeoutException;
import org.mule.api.MuleMessage;
import org.mule.api.transport.PropertyScope;
import org.mule.transport.ConnectException;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResponseService;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.core.common.exception.*;

import javax.naming.SizeLimitExceededException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Created by sima on 8/5/15.
 */
public class ExceptionUtility {

    public String createJsonFailureResponseMessage(MuleMessage muleMessage, ResponseMessage responseMessage) throws Exception {
        RequestMessage requestMessage = muleMessage.getProperty("requestPayload", PropertyScope.INVOCATION);
        if (requestMessage != null) {
            createFailureResponse(requestMessage.getService().getRequestUUID(),
                    responseMessage, getResultStatusByThrowable(muleMessage.getExceptionPayload().getException().getCause()));
            return new Gson().toJson(responseMessage, new TypeToken<ResponseMessage<? extends ResponseService>>() {
            }.getType());
        } else
            throw new Exception();
    }

    private void createFailureResponse(String requestUUID, ResponseMessage responseMessage, ResultStatus resultStatus) {
        responseMessage.getService().setRequestUUID(requestUUID);
        responseMessage.getService().setResultStatus(resultStatus);
    }

    public ResultStatus getResultStatusByThrowable(Throwable throwable) {
        ResultStatus resultStatus;

        if (throwable instanceof DatabaseException)
            resultStatus = ResultStatus.DATABASE_EXCEPTION;
        else if (throwable instanceof DuplicateKeyException)
            resultStatus = ResultStatus.DATABASE_EXCEPTION;
        else if (throwable instanceof MongoException)
            resultStatus = ResultStatus.MONGO_DB_TIMEOUT;
        else if (throwable instanceof BusinessNotFoundException)
            resultStatus = ResultStatus.INVALID_BUSINESS_CODE;
        else if (throwable instanceof UserNotFoundException)
            resultStatus = ResultStatus.INVALID_TOKEN_ID;
        else if (throwable instanceof SwitchResponseException)
            resultStatus = ResultStatus.SWITCH_FAILURE;
        else if (throwable instanceof CustomerIsNotIndividualException)
            resultStatus = ResultStatus.NOT_INDIVIDUAL_CUSTOMER;
        else if (throwable instanceof RegistrationInvalidStepException)
            resultStatus = ResultStatus.REGISTRATION_INVALID_STEP;
        else if (throwable instanceof RegistrationDateExpiredException)
            resultStatus = ResultStatus.REGISTRATION_DATE_EXPIRED;
        else if (throwable instanceof InvalidUserDataException)
            resultStatus = ResultStatus.INVALID_USER_DATA;
        else if (throwable instanceof InvalidBankCodeException)
            resultStatus = ResultStatus.INVALID_BANK_CODE;
        else if (throwable instanceof SMSNotSentException)
            resultStatus = ResultStatus.SEND_SMS_FAILURE;
        else if (throwable instanceof SMSTimeoutException)
            resultStatus = ResultStatus.SMS_CONNECTION_TIMEOUT;
        else if (throwable instanceof UserLinksToOtherCellphoneException)
            resultStatus = ResultStatus.USER_LINKED_TO_CELL_PHONE;
        else if (throwable instanceof CustomerNotFoundException)
            resultStatus = ResultStatus.NOT_INDIVIDUAL_CUSTOMER;
        else if (throwable instanceof CellNumberAlreadyBoundToAnotherUserException)
            resultStatus = ResultStatus.CELL_LINKED_TO_OTHER_USER;
        else if (throwable instanceof UserInfoIsNotUnlinkedException)
            resultStatus = ResultStatus.USER_IS_NOT_UNLINKED;
        else if (throwable instanceof UserNotEligibleToPayException)
            resultStatus = ResultStatus.USER_IS_NOT_DELEGATED;
        else if (throwable instanceof DestinationIsNotEligibleToPayException)
            resultStatus = ResultStatus.DESTINATION_IS_NOT_ACTIVATED;
        else if (throwable instanceof PaymentIsNotInRangeException)
            resultStatus = ResultStatus.AMOUNT_IS_NOT_IN_RANGE;
        else if (throwable instanceof NationalCodeNotBelongsToAccountException)
            resultStatus = ResultStatus.NATIONAL_CODE_NOT_BELONGS_TO_ACCOUNT;
        else if (throwable instanceof InvalidAccountException)
            resultStatus = ResultStatus.ACCOUNT_NOT_FOUND;
        else if (throwable instanceof DeviceNotFoundException)
            resultStatus = ResultStatus.DEVICE_ID_NOT_FOUND;
        else if (throwable instanceof SizeLimitExceededException)
            resultStatus = ResultStatus.IMAGE_SIZE_LIMIT_EXCEEDED;
        else if (throwable instanceof InvalidFormatException)
            resultStatus = ResultStatus.INVALID_EMAIL;
        else if (throwable instanceof UnknownHostException || throwable instanceof ConnectException ||
                throwable instanceof ConnectTimeoutException || throwable instanceof SocketTimeoutException)
            resultStatus = ResultStatus.END_POINT_TIMEOUT;
        else resultStatus = ResultStatus.FAILURE;
        return resultStatus;
    }

}
