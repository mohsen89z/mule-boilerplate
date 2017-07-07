package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.response.IllegalAppListResponse;
import xyz.homapay.hampay.core.common.data.model.IllegalApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sima on 10/21/15.
 * sima.ahmadvand@gmail.com
 */
public class IllegalAppsResponseProvider {

    public ResponseMessage<IllegalAppListResponse> createIllegalAppListRequest(List<IllegalApp> illegalApps, String requestUUID) {
        ResponseMessage<IllegalAppListResponse> responseMessage = new ResponseMessage<>();
        IllegalAppListResponse service = new IllegalAppListResponse();
        service.setIllegalAppList(getIllegalAppNames(illegalApps));
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.SUCCESS);
        responseMessage.setService(service);
        return responseMessage;
    }

    private List<String> getIllegalAppNames(List<IllegalApp> illegalApps) {
        List<String> appNames = new ArrayList<>(illegalApps.size());
        for (IllegalApp illegalApp : illegalApps) {
            appNames.add(illegalApp.getName());
        }
        return appNames;
    }
}
