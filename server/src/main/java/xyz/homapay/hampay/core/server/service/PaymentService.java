package xyz.homapay.hampay.core.server.service;

import xyz.homapay.hampay.common.core.model.dto.UserVerificationStatus;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.exception.DestinationIsNotEligibleToPayException;
import xyz.homapay.hampay.core.common.exception.PaymentIsNotInRangeException;
import xyz.homapay.hampay.core.common.exception.UserNotEligibleToPayException;
import xyz.homapay.hampay.core.server.helper.PropertiesUtil;

/**
 * Created by sima on 8/18/15.
 */
public class PaymentService {

    private PropertiesUtil propertiesUtil;

    public void setPropertiesUtil(PropertiesUtil propertiesUtil) {
        this.propertiesUtil = propertiesUtil;
    }

    public void checkRequestEligibilityToDoBusinessPayment(User user, Long requestAmount) throws UserNotEligibleToPayException, PaymentIsNotInRangeException {
        if (!user.getIsActive() || user.getVerificationStatus() != UserVerificationStatus.DELEGATED)
            throw new UserNotEligibleToPayException();
        if (requestAmount < propertiesUtil.getMinimumUserTransferAmount() || requestAmount > propertiesUtil.getMaximumUserTransferAmount())
            throw new PaymentIsNotInRangeException();
    }

    public void checkRequestEligibilityToDoIndividualPayment(User source, User destination, Long requestAmount) throws UserNotEligibleToPayException, DestinationIsNotEligibleToPayException, PaymentIsNotInRangeException {
        if (!source.getIsActive() || source.getVerificationStatus() != UserVerificationStatus.DELEGATED)
            throw new UserNotEligibleToPayException();
        if (!destination.getIsActive())
            throw new DestinationIsNotEligibleToPayException();
        if (requestAmount < propertiesUtil.getMinimumUserTransferAmount() || requestAmount > propertiesUtil.getMaximumUserTransferAmount())
            throw new PaymentIsNotInRangeException();
    }
}
