package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

/**
 * @author Siavash Mahmoudpour
 */
@Entity(value = "devices", noClassnameStored = true)
public class UserDevice extends BaseEntity {

    @Reference
    private User user;
    private String deviceId;
    private String imei;
    private String installationToken;
    private boolean isActive;
    private Date activationDate;
    private String imsi;
    private String simcardSerial;
    private String deviceModel;
    private String deviceAPI;
    private String osVersion;
    private String displaySize;
    private String manufacture;
    private String brand;
    private String cpu_abi;
    private String networkOperatorName;
    private String displayMetrics;
    private String simState;
    private String appNames;
    private String androidId;
    private String locale;
    private String userLocation;
    private String macAddress;
    private String appVersion;
    private String registrationId;
    private OSName osName;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getInstallationToken() {
        return installationToken;
    }

    public void setInstallationToken(String installationToken) {
        this.installationToken = installationToken;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getSimcardSerial() {
        return simcardSerial;
    }

    public void setSimcardSerial(String simcardSerial) {
        this.simcardSerial = simcardSerial;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceAPI() {
        return deviceAPI;
    }

    public void setDeviceAPI(String deviceAPI) {
        this.deviceAPI = deviceAPI;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpu_abi() {
        return cpu_abi;
    }

    public void setCpu_abi(String cpu_abi) {
        this.cpu_abi = cpu_abi;
    }

    public String getNetworkOperatorName() {
        return networkOperatorName;
    }

    public void setNetworkOperatorName(String networkOperatorName) {
        this.networkOperatorName = networkOperatorName;
    }

    public String getDisplayMetrics() {
        return displayMetrics;
    }

    public void setDisplayMetrics(String displayMetrics) {
        this.displayMetrics = displayMetrics;
    }

    public String getSimState() {
        return simState;
    }

    public void setSimState(String simState) {
        this.simState = simState;
    }

    public String getAppNames() {
        return appNames;
    }

    public void setAppNames(String appNames) {
        this.appNames = appNames;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public OSName getOsName() {
        return osName;
    }

    public void setOsName(OSName osName) {
        this.osName = osName;
    }
}
