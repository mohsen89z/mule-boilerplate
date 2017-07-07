package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;

import java.util.Date;

/**
 * Created by sima on 10/16/15.
 * sima.ahmadvand@gmail.com
 */
@Entity(value = "user_group", noClassnameStored = true)
public class UserGroup extends BaseEntity {

    public enum BillingGroup {
        FLAT, ACCUMULATIVE
    }

    private String groupName;
    private BillingGroup billingGroup;
    private Date creationDate;
    @Property("default")
    private boolean defaultGroup;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public BillingGroup getBillingGroup() {
        return billingGroup;
    }

    public void setBillingGroup(BillingGroup billingGroup) {
        this.billingGroup = billingGroup;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isDefaultGroup() {
        return defaultGroup;
    }

    public void setDefaultGroup(boolean defaultGroup) {
        this.defaultGroup = defaultGroup;
    }
}
