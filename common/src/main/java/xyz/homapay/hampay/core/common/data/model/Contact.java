package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Embedded;

/**
 * @author Siavash Mahmoudpour
 */

@Embedded
public class Contact {
    private String displayName;
    private String cellNumber;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

}
