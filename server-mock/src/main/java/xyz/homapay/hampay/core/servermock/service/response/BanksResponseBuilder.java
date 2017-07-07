package xyz.homapay.hampay.core.servermock.service.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.BankListRequest;
import xyz.homapay.hampay.common.core.model.response.BankListResponse;
import xyz.homapay.hampay.common.core.model.response.dto.BankDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siavash Mahmoudpour
 */
public class BanksResponseBuilder {

    public ResponseMessage<BankListResponse> createBankListFailureResponse(BankListRequest request) {

        ResponseMessage<BankListResponse> responseMessage = new ResponseMessage<BankListResponse>();
        BankListResponse response = new BankListResponse();
        response.setBanks(null);
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<BankListResponse> createBankListSuccessResponse(BankListRequest request) {
        ResponseMessage<BankListResponse> responseMessage = new ResponseMessage<BankListResponse>();
        BankListResponse response = new BankListResponse();
        response.setBanks(getBanks());
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    private List<BankDTO> getBanks() {
        List<BankDTO> banks = new ArrayList<BankDTO>();

        BankDTO bank1 = new BankDTO();
        bank1.setCode("18");
        bank1.setTitle("بانک تجارت");
        bank1.setAccountFormat("##########");
        banks.add(bank1);

        BankDTO bank2 = new BankDTO();
        bank2.setCode("9");
        bank2.setTitle("بانک خاورميانه");
        bank2.setAccountFormat("####/##/###/#########");
        banks.add(bank2);

        BankDTO bank3 = new BankDTO();
        bank3.setCode("27");
        bank3.setTitle("بانک سامان");
        bank3.setAccountFormat("###/###/#######/#");
        banks.add(bank3);

        return banks;
    }
}
