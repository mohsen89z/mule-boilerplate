package xyz.homapay.hampay.core.common.data.dto;

/**
 * Created by sima on 7/6/15.
 */
public enum SupportedBanks {
    TEJARAT("18"), MIDDLE_EAST("78");
    private String code;

    SupportedBanks(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
