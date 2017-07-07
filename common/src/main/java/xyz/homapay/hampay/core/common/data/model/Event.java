package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Entity;

/**
 * Created by sima on 8/16/15.
 */
@Entity(value = "events", noClassnameStored = true)
public class Event extends BaseEntity {

    private String name;
    private String description;
    private boolean status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
