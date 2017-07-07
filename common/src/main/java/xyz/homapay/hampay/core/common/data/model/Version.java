package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Entity;

import java.util.Date;

/**
 * Created by sima on 9/27/15.
 * sima.ahmadvand@gmail.com
 */
@Entity(value = "version", noClassnameStored = true)
public class Version extends BaseEntity {
    private String name;
    private OSName os;
    private Date dateTime;
    private boolean current;
    private boolean applied;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OSName getOs() {
        return os;
    }

    public void setOs(OSName os) {
        this.os = os;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public boolean isApplied() {
        return applied;
    }

    public void setApplied(boolean applied) {
        this.applied = applied;
    }

}
