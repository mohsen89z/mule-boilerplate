package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Entity;

/**
 * Created by sima on 10/21/15.
 * sima.ahmadvand@gmail.com
 */
@Entity(value = "illegal_apps", noClassnameStored = true)
public class IllegalApp extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
