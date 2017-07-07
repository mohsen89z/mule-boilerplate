package xyz.homapay.hampay.core.server.dao.impl;

import xyz.homapay.hampay.core.common.data.model.FeeCharge;
import xyz.homapay.hampay.core.common.data.model.UserGroup;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.FeeChargeNotFoundException;
import xyz.homapay.hampay.core.server.dao.FeeChargeDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;
import java.util.List;

/**
 * Created by sima on 10/18/15.
 * sima.ahmadvand@gmail.com
 */
public class FeeChargeDaoImpl implements FeeChargeDao {

    @Override
    public List<FeeCharge> findFeeChargeByBillingGroup(UserGroup.BillingGroup billingGroup, Long amount) throws FeeChargeNotFoundException, DatabaseException {
        try {
            List<FeeCharge> feeCharges = DbConnection.datastore().find(FeeCharge.class)
                    .field("billingGroup").equal(billingGroup).field("floorAmount").lessThan(amount).order("order").asList();
            if (feeCharges == null || feeCharges.size() == 0)
                throw new FeeChargeNotFoundException();
            return feeCharges;
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }
}
