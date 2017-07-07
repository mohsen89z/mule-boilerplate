package xyz.homapay.hampay.core.servermock.service.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.IllegalAppListRequest;
import xyz.homapay.hampay.common.core.model.response.IllegalAppListResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sima on 11/10/15.
 */
public class IllegalAppsResponseBuilder {

    public ResponseMessage<IllegalAppListResponse> createIllegalAppSuccessResponse(IllegalAppListRequest request){
        ResponseMessage<IllegalAppListResponse> responseMessage = new ResponseMessage<>();
        IllegalAppListResponse service = new IllegalAppListResponse();
        service.setResultStatus(ResultStatus.SUCCESS);
        service.setRequestUUID(request.getRequestUUID());
        service.setIllegalAppList(createIllegalAppList());
        responseMessage.setService(service);
        return responseMessage;
    }

    private List<String> createIllegalAppList() {
        List<String> appList = new ArrayList<>(3);
        appList.add("app1");
        appList.add("app2");
        appList.add("app3");
        return appList;
    }
}
