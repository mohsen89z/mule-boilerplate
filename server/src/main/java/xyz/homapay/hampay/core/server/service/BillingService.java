package xyz.homapay.hampay.core.server.service;

import xyz.homapay.hampay.core.common.data.model.FeeCharge;
import xyz.homapay.hampay.core.common.data.model.UserGroup;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.FeeChargeNotFoundException;
import xyz.homapay.hampay.core.server.dao.FeeChargeDao;

import java.util.List;

/**
 * Created by sima on 10/18/15.
 * sima.ahmadvand@gmail.com
 */
public class BillingService {

    private FeeChargeDao feeChargeDao;

    public void setFeeChargeDao(FeeChargeDao feeChargeDao) {
        this.feeChargeDao = feeChargeDao;
    }

    public long calculateFeeCharge(UserGroup.BillingGroup billingGroup, Long amount) throws DatabaseException, FeeChargeNotFoundException {
        List<FeeCharge> feeCharges = feeChargeDao.findFeeChargeByBillingGroup(billingGroup, amount);
        if (billingGroup == UserGroup.BillingGroup.ACCUMULATIVE) {
            feeCharges.get(feeCharges.size() - 1).setCeilAmount(amount);
            return calculateAccumulativeFeeCharge(feeCharges, 0l,feeCharges.size() - 1);
        } else if (billingGroup == UserGroup.BillingGroup.FLAT)
            return calculateFlatFeeCharge(feeCharges, amount);

        throw new IllegalStateException();
    }

    private Long calculateAccumulativeFeeCharge(List<FeeCharge> feeCharges, long feeAmount,int lastIndex) {
        FeeCharge feeCharge = feeCharges.get(lastIndex);
        feeAmount = feeAmount + ((feeCharge.getCeilAmount() - feeCharge.getFloorAmount()) * feeCharge.getPercent()) / 100;
        if (lastIndex == 0)
            return feeAmount;
        return calculateAccumulativeFeeCharge(feeCharges, feeAmount,--lastIndex);
    }

    private long calculateFlatFeeCharge(List<FeeCharge> feeCharges, Long amount) {
        return (feeCharges.get(feeCharges.size() - 1).getPercent()*amount)/100;
    }
}
