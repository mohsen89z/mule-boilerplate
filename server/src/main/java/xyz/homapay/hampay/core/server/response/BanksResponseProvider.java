package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.response.BankListResponse;
import xyz.homapay.hampay.common.core.model.response.dto.BankDTO;
import xyz.homapay.hampay.core.common.data.model.Bank;
import xyz.homapay.hampay.core.server.dao.BankDao;
import xyz.homapay.hampay.core.server.dao.impl.BankDaoImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siavash Mahmoudpour
 */
public class BanksResponseProvider {

    private BankDao bankDao = new BankDaoImpl();

    public ResponseMessage<BankListResponse> createBankListResponse(String requestUUID) {
        ResponseMessage<BankListResponse> responseMessage = new ResponseMessage<>();
        BankListResponse response = new BankListResponse();
        response.setBanks(getBankDTOs());
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(requestUUID);
        responseMessage.setService(response);
        return responseMessage;
    }

    private List<BankDTO> getBankDTOs() {
        List<BankDTO> bankDTOs = new ArrayList<>(3);
        List<Bank> bankList = bankDao.getAllBanks();
        for (Bank bank : bankList) {
            BankDTO bankDTO = new BankDTO();
            bankDTO.setAccountFormat(bank.getAccountFormat());
            bankDTO.setCode(bank.getCode());
            bankDTO.setTitle(bank.getName());
            bankDTOs.add(bankDTO);
        }
        return bankDTOs;
    }

}
