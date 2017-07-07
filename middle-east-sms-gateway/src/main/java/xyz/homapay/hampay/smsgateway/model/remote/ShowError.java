/**
 * ShowError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class ShowError implements java.io.Serializable {
    private java.lang.String cErrorCode;

    private java.lang.String cLanShow;

    public ShowError() {
    }

    public ShowError(
            java.lang.String cErrorCode,
            java.lang.String cLanShow) {
        this.cErrorCode = cErrorCode;
        this.cLanShow = cLanShow;
    }


    /**
     * Gets the cErrorCode value for this ShowError.
     * 
     * @return cErrorCode
     */
    public java.lang.String getCErrorCode() {
        return cErrorCode;
    }


    /**
     * Sets the cErrorCode value for this ShowError.
     * 
     * @param cErrorCode
     */
    public void setCErrorCode(java.lang.String cErrorCode) {
        this.cErrorCode = cErrorCode;
    }


    /**
     * Gets the cLanShow value for this ShowError.
     * 
     * @return cLanShow
     */
    public java.lang.String getCLanShow() {
        return cLanShow;
    }


    /**
     * Sets the cLanShow value for this ShowError.
     * 
     * @param cLanShow
     */
    public void setCLanShow(java.lang.String cLanShow) {
        this.cLanShow = cLanShow;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ShowError)) return false;
        ShowError other = (ShowError) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.cErrorCode == null && other.getCErrorCode() == null) ||
                        (this.cErrorCode != null &&
                                this.cErrorCode.equals(other.getCErrorCode()))) &&
                ((this.cLanShow == null && other.getCLanShow() == null) ||
                        (this.cLanShow != null &&
                                this.cLanShow.equals(other.getCLanShow())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCErrorCode() != null) {
            _hashCode += getCErrorCode().hashCode();
        }
        if (getCLanShow() != null) {
            _hashCode += getCLanShow().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(ShowError.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ShowError"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CErrorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cErrorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CLanShow");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cLanShow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new org.apache.axis.encoding.ser.BeanSerializer(
                        _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new org.apache.axis.encoding.ser.BeanDeserializer(
                        _javaType, _xmlType, typeDesc);
    }

}
