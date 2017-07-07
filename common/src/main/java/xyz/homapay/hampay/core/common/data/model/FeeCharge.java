package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Transient;

/**
 * Created by sima on 10/18/15.
 * sima.ahmadvand@gmail.com
 */
@Entity(value = "fee_charge", noClassnameStored = true)
public class FeeCharge extends BaseEntity {

    private UserGroup.BillingGroup billingGroup;
    private Long floorAmount;
    private Long ceilAmount;
    private Integer percent;
    private Integer order;

    public UserGroup.BillingGroup getBillingGroup() {
        return billingGroup;
    }

    public void setBillingGroup(UserGroup.BillingGroup billingGroup) {
        this.billingGroup = billingGroup;
    }

    public Long getFloorAmount() {
        return floorAmount;
    }

    public void setFloorAmount(Long floorAmount) {
        this.floorAmount = floorAmount;
    }

    public Long getCeilAmount() {
        return ceilAmount;
    }

    public void setCeilAmount(Long ceilAmount) {
        this.ceilAmount = ceilAmount;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

}
