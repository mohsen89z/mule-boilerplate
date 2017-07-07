package xyz.homapay.hampay.core.test.service;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import xyz.homapay.hampay.core.common.data.model.FeeCharge;
import xyz.homapay.hampay.core.common.data.model.UserGroup;
import xyz.homapay.hampay.core.server.dao.FeeChargeDao;
import xyz.homapay.hampay.core.server.service.BillingService;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.easymock.EasyMock.*;

/**
 * Created by sima on 10/29/15.
 * sima.ahmadvand@gmail.com
 */
public class BillingServiceTest {

    private BillingService billingService = new BillingService();
    private FeeChargeDao feeChargeDaoMock;

    @Before
    public void init() throws Exception {
        feeChargeDaoMock = createMock(FeeChargeDao.class);
        billingService.setFeeChargeDao(feeChargeDaoMock);
    }

    @Test
    public void calculateFeeCharge1() throws Exception {
        List<FeeCharge> feeCharges = new ArrayList<>(4);
        createFeeChargeList1(feeCharges, 0, 1000l, 0, 1,4);
        reset(feeChargeDaoMock);
        expect(feeChargeDaoMock.findFeeChargeByBillingGroup(UserGroup.BillingGroup.ACCUMULATIVE, 6000l)).andReturn(feeCharges);
        replay(feeChargeDaoMock);
        long fee = billingService.calculateFeeCharge(UserGroup.BillingGroup.ACCUMULATIVE, 6000l);
        assertEquals(fee,600);
    }
    @Test
    public void calculateFeeCharge2() throws Exception {
        List<FeeCharge> feeCharges = new ArrayList<>(3);
        createFeeChargeList1(feeCharges, 0, 1000l, 0, 1,3);
        reset(feeChargeDaoMock);
        expect(feeChargeDaoMock.findFeeChargeByBillingGroup(UserGroup.BillingGroup.ACCUMULATIVE, 2500l)).andReturn(feeCharges);
        replay(feeChargeDaoMock);
        long fee = billingService.calculateFeeCharge(UserGroup.BillingGroup.ACCUMULATIVE, 2500l);
        assertEquals(fee,100);
    }

    @Test
    public void calculateFeeCharge3() throws Exception {
        List<FeeCharge> feeCharges = new ArrayList<>(2);
        createFeeChargeList1(feeCharges, 0, 1000l, 0, 1,2);
        reset(feeChargeDaoMock);
        expect(feeChargeDaoMock.findFeeChargeByBillingGroup(UserGroup.BillingGroup.ACCUMULATIVE, 1500l)).andReturn(feeCharges);
        replay(feeChargeDaoMock);
        long fee = billingService.calculateFeeCharge(UserGroup.BillingGroup.ACCUMULATIVE, 1500l);
        assertEquals(fee,25);
    }

    @Test
    public void calculateFeeCharge4() throws Exception {
        List<FeeCharge> feeCharges = new ArrayList<>(1);
        createFeeChargeList1(feeCharges, 0, 1000l, 0, 1,1);
        reset(feeChargeDaoMock);
        expect(feeChargeDaoMock.findFeeChargeByBillingGroup(UserGroup.BillingGroup.ACCUMULATIVE, 500l)).andReturn(feeCharges);
        replay(feeChargeDaoMock);
        long fee = billingService.calculateFeeCharge(UserGroup.BillingGroup.ACCUMULATIVE, 500l);
        assertEquals(fee,0);
    }

    private void createFeeChargeList1(List<FeeCharge> charges, long floor, Long ceil, int percent, int order,int maxSize) {
        FeeCharge feeCharge = new FeeCharge();
        feeCharge.setFloorAmount(floor);
        feeCharge.setCeilAmount(ceil);
        feeCharge.setPercent(percent);
        feeCharge.setOrder(order);
        feeCharge.setBillingGroup(UserGroup.BillingGroup.ACCUMULATIVE);
        charges.add(feeCharge);
        if (charges.size() == maxSize) {
            charges.get(maxSize-1).setCeilAmount(null);
            return;
        }
        createFeeChargeList1(charges, floor+1000,ceil+1000,percent+5,order+1,maxSize );
    }
}
