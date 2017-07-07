package xyz.homapay.hampay.core.servermock;

import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.core.model.request.BankListRequest;
import xyz.homapay.hampay.common.core.model.request.ContactUsRequest;
import xyz.homapay.hampay.common.core.model.request.TransactionListRequest;
import xyz.homapay.hampay.common.core.model.request.UserProfileRequest;
import xyz.homapay.hampay.common.core.model.response.BankListResponse;
import xyz.homapay.hampay.common.core.model.response.ContactUsResponse;
import xyz.homapay.hampay.common.core.model.response.TransactionListResponse;
import xyz.homapay.hampay.common.core.model.response.UserProfileResponse;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * @author Siavash Mahmoudpour
 */
public class MockServicesTest {

    public MockServicesTest() {

    }

    public static void main(String[] args) {
        MockServicesTest test = new MockServicesTest();
        test.testUserProfile();
        test.testBankList1();
        test.testContactUs();
        test.testTransactionList();
    }

    private void testBankList1() {

        HttpURLConnection connection = null;
        try {

            RequestHeader header = new RequestHeader();
            header.setAuthToken("008ewe");
            header.setVersion("1.0-PA");

            RequestMessage<BankListRequest> message = new RequestMessage<BankListRequest>();
            message.setRequestHeader(header);
            BankListRequest request = new BankListRequest();
            request.setRequestUUID("1234");
            message.setService(request);

            Type requestType = new com.google.gson.reflect.TypeToken<RequestMessage<BankListRequest>>() {
            }.getType();
            String jsonRequest = new Gson().toJson(message, requestType);

            URL url = new URL("http://176.58.104.158:9093/banks");
//            URL url = new URL("http://localhost:9093/banks");

            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonRequest.getBytes());
            outputStream.flush();

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            Gson gson = new Gson();
            ResponseMessage<BankListResponse> responseMessage = gson.fromJson(reader, new TypeToken<ResponseMessage<BankListResponse>>() {
            }.getType());

            if (responseMessage != null && responseMessage.getService() != null) {
                System.out.println("Response requestUUID : " + responseMessage.getService().getRequestUUID());
                System.out.println("Response bank list size : " + responseMessage.getService().getBanks().size());
            } else {
                System.out.println("Response is null...");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }

    }

    private void testUserProfile() {

        HttpParams httpParameters = new BasicHttpParams();
        // Set the timeout in milliseconds until a connection is established.
        // The default value is zero, that means the timeout is not used.
        int timeoutConnection = 30000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
        // Set the default socket timeout (SO_TIMEOUT)
        // in milliseconds which is the timeout for waiting for data.
        int timeoutSocket = 30000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        HttpClient httpClient = new DefaultHttpClient(httpParameters);


        HttpHost host = new HttpHost("176.58.104.158", 9093);
//        HttpHost host = new HttpHost("localhost", 9093);
        HttpRequest request = new HttpPost("/users/profile");

        HttpResponse response;
        try {
            String json = createUserProfileJsonMessage();
            StringEntity entity = new StringEntity(json, "UTF-8");
            entity.setContentType("application/json");
            System.out.println("User profile request : " + json);
            ((HttpPost) request).setEntity(entity);

            response = httpClient.execute(host, request);

            HttpEntity responseEntity = response.getEntity();
            StatusLine responseStatus = response.getStatusLine();
            int statusCode = responseStatus != null ? responseStatus.getStatusCode() : 0;
            String result = EntityUtils.toString(responseEntity);

            System.out.println("User profile response, status  : " + String.valueOf(statusCode) + " , payload : " + result);

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    return new Date(json.getAsJsonPrimitive().getAsLong());
                }
            });
            Gson gson = builder.create();

            Type responseType = new com.google.gson.reflect.TypeToken<ResponseMessage<UserProfileResponse>>() {
            }.getType();
            ResponseMessage<UserProfileResponse> userProfileResponse = gson.fromJson(result, responseType);

            if (userProfileResponse != null && userProfileResponse.getService() != null && userProfileResponse.getService().getUserProfile() != null) {
                System.out.println("Full name : " + userProfileResponse.getService().getUserProfile().getFullName());
                System.out.println("Cell number : " + userProfileResponse.getService().getUserProfile().getCellNumber());
                System.out.println("Account number : " + userProfileResponse.getService().getUserProfile().getAccountNumber());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    private void testContactUs() {

        HttpParams httpParameters = new BasicHttpParams();
        // Set the timeout in milliseconds until a connection is established.
        // The default value is zero, that means the timeout is not used.
        int timeoutConnection = 30000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
        // Set the default socket timeout (SO_TIMEOUT)
        // in milliseconds which is the timeout for waiting for data.
        int timeoutSocket = 30000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        HttpClient httpClient = new DefaultHttpClient(httpParameters);


        HttpHost host = new HttpHost("176.58.104.158", 9093);
//        HttpHost host = new HttpHost("localhost", 9093);
        HttpRequest request = new HttpPost("/contactus");

        HttpResponse response;
        try {
            String json = createContactUsJsonMessage();
            StringEntity entity = new StringEntity(json, "UTF-8");
            entity.setContentType("application/json");
            System.out.println("Contact us request : " + json);
            ((HttpPost) request).setEntity(entity);

            response = httpClient.execute(host, request);

            HttpEntity responseEntity = response.getEntity();
            StatusLine responseStatus = response.getStatusLine();
            int statusCode = responseStatus != null ? responseStatus.getStatusCode() : 0;
            String result = EntityUtils.toString(responseEntity);

            System.out.println("Contact us response, status  : " + String.valueOf(statusCode) + " , payload : " + result);

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    return new Date(json.getAsJsonPrimitive().getAsLong());
                }
            });
            Gson gson = builder.create();

            Type responseType = new com.google.gson.reflect.TypeToken<ResponseMessage<ContactUsResponse>>() {
            }.getType();
            ResponseMessage<ContactUsResponse> contactusResponse = gson.fromJson(result, responseType);

            if (contactusResponse != null && contactusResponse.getService() != null) {
                System.out.println("Phone number : " + contactusResponse.getService().getPhoneNumber());
                System.out.println("Email : " + contactusResponse.getService().getEmailAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    private void testTransactionList() {

        HttpParams httpParameters = new BasicHttpParams();
        // Set the timeout in milliseconds until a connection is established.
        // The default value is zero, that means the timeout is not used.
        int timeoutConnection = 30000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
        // Set the default socket timeout (SO_TIMEOUT)
        // in milliseconds which is the timeout for waiting for data.
        int timeoutSocket = 30000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        HttpClient httpClient = new DefaultHttpClient(httpParameters);


        HttpHost host = new HttpHost("176.58.104.158", 9093);
//        HttpHost host = new HttpHost("localhost", 9093);
        HttpRequest request = new HttpPost("/transactions");

        HttpResponse response;
        try {
            String json = createTransactionListJsonMessage();
            StringEntity entity = new StringEntity(json, "UTF-8");
            entity.setContentType("application/json");
            System.out.println("Transaction list request : " + json);
            ((HttpPost) request).setEntity(entity);

            response = httpClient.execute(host, request);

            HttpEntity responseEntity = response.getEntity();
            StatusLine responseStatus = response.getStatusLine();
            int statusCode = responseStatus != null ? responseStatus.getStatusCode() : 0;
            String result = EntityUtils.toString(responseEntity);

            System.out.println("Transaction list response, status  : " + String.valueOf(statusCode) + " , payload : " + result);

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    return new Date(json.getAsJsonPrimitive().getAsLong());
                }
            });
            Gson gson = builder.create();

            Type responseType = new com.google.gson.reflect.TypeToken<ResponseMessage<TransactionListResponse>>() {
            }.getType();
            ResponseMessage<TransactionListResponse> transactionsResponse = gson.fromJson(result, responseType);

            if (transactionsResponse != null && transactionsResponse.getService() != null && transactionsResponse.getService().getTransactions() != null) {
                System.out.println("Transaction list size : " + transactionsResponse.getService().getTransactions().size());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    private void testBankList2() {

        HttpParams httpParameters = new BasicHttpParams();
        // Set the timeout in milliseconds until a connection is established.
        // The default value is zero, that means the timeout is not used.
        int timeoutConnection = 30000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
        // Set the default socket timeout (SO_TIMEOUT)
        // in milliseconds which is the timeout for waiting for data.
        int timeoutSocket = 30000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        HttpClient httpClient = new DefaultHttpClient(httpParameters);


        HttpHost host = new HttpHost("176.58.104.158", 9093);
//        HttpHost host = new HttpHost("localhost", 9093);
        HttpRequest request = new HttpPost("/banks");

        HttpResponse response;
        try {
            StringEntity entity = new StringEntity(createBankListJsonMessage(), "UTF-8");
            entity.setContentType("application/json");
            ((HttpPost) request).setEntity(entity);

            response = httpClient.execute(host, request);

            HttpEntity responseEntity = response.getEntity();
            StatusLine responseStatus = response.getStatusLine();
            int statusCode = responseStatus != null ? responseStatus.getStatusCode() : 0;
            String result = EntityUtils.toString(responseEntity);

            System.out.println("Bank list response, status  : " + String.valueOf(statusCode) + " , payload : " + result);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    private String createBankListJsonMessage() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");


        RequestMessage<BankListRequest> message = new RequestMessage<BankListRequest>();
        message.setRequestHeader(header);
        BankListRequest request = new BankListRequest();
        request.setRequestUUID("1234");
        message.setService(request);

        Type requestType = new com.google.gson.reflect.TypeToken<RequestMessage<BankListRequest>>() {
        }.getType();
        return new Gson().toJson(message, requestType);
    }

    private String createUserProfileJsonMessage() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");


        RequestMessage<UserProfileRequest> message = new RequestMessage<UserProfileRequest>();
        message.setRequestHeader(header);
        UserProfileRequest request = new UserProfileRequest();
        request.setRequestUUID("1234");
        message.setService(request);

        Type requestType = new com.google.gson.reflect.TypeToken<RequestMessage<UserProfileRequest>>() {
        }.getType();
        return new Gson().toJson(message, requestType);
    }

    private String createContactUsJsonMessage() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");


        RequestMessage<ContactUsRequest> message = new RequestMessage<ContactUsRequest>();
        message.setRequestHeader(header);
        ContactUsRequest request = new ContactUsRequest();
        request.setRequestUUID("1234");
        message.setService(request);

        Type requestType = new com.google.gson.reflect.TypeToken<RequestMessage<ContactUsRequest>>() {
        }.getType();
        return new Gson().toJson(message, requestType);
    }

    private String createTransactionListJsonMessage() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");


        RequestMessage<TransactionListRequest> message = new RequestMessage<TransactionListRequest>();
        message.setRequestHeader(header);
        TransactionListRequest request = new TransactionListRequest();
        request.setRequestUUID("1234");
        request.setPageSize(10);
        request.setPageNumber(0);
        message.setService(request);

        Type requestType = new com.google.gson.reflect.TypeToken<RequestMessage<TransactionListRequest>>() {
        }.getType();
        return new Gson().toJson(message, requestType);
    }

}
