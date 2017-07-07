package xyz.homapay.hampay.core.common.data.dto;

/**
 * Created by Ebrahim Pasbani.
 */
public class IdpUserValidity {
    private String uid;
    private Boolean valid;
    private String realm;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }
}
