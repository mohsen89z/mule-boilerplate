package xyz.homapay.hampay.core.server.dao;

import xyz.homapay.hampay.core.common.data.model.FeeCharge;
import xyz.homapay.hampay.core.common.data.model.UserGroup;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.FeeChargeNotFoundException;

import java.util.List;

/**
 * Created by sima on 10/18/15.
 * sima.ahmadvand@gmail.com
 */
public interface FeeChargeDao {

    List<FeeCharge> findFeeChargeByBillingGroup(UserGroup.BillingGroup billingGroup, Long amount) throws FeeChargeNotFoundException, DatabaseException;
}
