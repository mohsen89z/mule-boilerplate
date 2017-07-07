/**
 * GetSms.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class GetSms implements java.io.Serializable {
    private java.lang.String cFrom;

    private java.lang.String cTo;

    private java.lang.String cText;

    private java.lang.String cEnterRed_Date;

    private java.lang.String cStatus;

    private java.lang.String cMessageId;

    public GetSms() {
    }

    public GetSms(
            java.lang.String cFrom,
            java.lang.String cTo,
            java.lang.String cText,
            java.lang.String cEnterRed_Date,
            java.lang.String cStatus,
            java.lang.String cMessageId) {
        this.cFrom = cFrom;
        this.cTo = cTo;
        this.cText = cText;
        this.cEnterRed_Date = cEnterRed_Date;
        this.cStatus = cStatus;
        this.cMessageId = cMessageId;
    }


    /**
     * Gets the cFrom value for this GetSms.
     * 
     * @return cFrom
     */
    public java.lang.String getCFrom() {
        return cFrom;
    }


    /**
     * Sets the cFrom value for this GetSms.
     * 
     * @param cFrom
     */
    public void setCFrom(java.lang.String cFrom) {
        this.cFrom = cFrom;
    }


    /**
     * Gets the cTo value for this GetSms.
     * 
     * @return cTo
     */
    public java.lang.String getCTo() {
        return cTo;
    }


    /**
     * Sets the cTo value for this GetSms.
     * 
     * @param cTo
     */
    public void setCTo(java.lang.String cTo) {
        this.cTo = cTo;
    }


    /**
     * Gets the cText value for this GetSms.
     * 
     * @return cText
     */
    public java.lang.String getCText() {
        return cText;
    }


    /**
     * Sets the cText value for this GetSms.
     * 
     * @param cText
     */
    public void setCText(java.lang.String cText) {
        this.cText = cText;
    }


    /**
     * Gets the cEnterRed_Date value for this GetSms.
     * 
     * @return cEnterRed_Date
     */
    public java.lang.String getCEnterRed_Date() {
        return cEnterRed_Date;
    }


    /**
     * Sets the cEnterRed_Date value for this GetSms.
     * 
     * @param cEnterRed_Date
     */
    public void setCEnterRed_Date(java.lang.String cEnterRed_Date) {
        this.cEnterRed_Date = cEnterRed_Date;
    }


    /**
     * Gets the cStatus value for this GetSms.
     * 
     * @return cStatus
     */
    public java.lang.String getCStatus() {
        return cStatus;
    }


    /**
     * Sets the cStatus value for this GetSms.
     * 
     * @param cStatus
     */
    public void setCStatus(java.lang.String cStatus) {
        this.cStatus = cStatus;
    }


    /**
     * Gets the cMessageId value for this GetSms.
     * 
     * @return cMessageId
     */
    public java.lang.String getCMessageId() {
        return cMessageId;
    }


    /**
     * Sets the cMessageId value for this GetSms.
     * 
     * @param cMessageId
     */
    public void setCMessageId(java.lang.String cMessageId) {
        this.cMessageId = cMessageId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSms)) return false;
        GetSms other = (GetSms) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.cFrom == null && other.getCFrom() == null) ||
                        (this.cFrom != null &&
                                this.cFrom.equals(other.getCFrom()))) &&
                ((this.cTo == null && other.getCTo() == null) ||
                        (this.cTo != null &&
                                this.cTo.equals(other.getCTo()))) &&
                ((this.cText == null && other.getCText() == null) ||
                        (this.cText != null &&
                                this.cText.equals(other.getCText()))) &&
                ((this.cEnterRed_Date == null && other.getCEnterRed_Date() == null) ||
                        (this.cEnterRed_Date != null &&
                                this.cEnterRed_Date.equals(other.getCEnterRed_Date()))) &&
                ((this.cStatus == null && other.getCStatus() == null) ||
                        (this.cStatus != null &&
                                this.cStatus.equals(other.getCStatus()))) &&
                ((this.cMessageId == null && other.getCMessageId() == null) ||
                        (this.cMessageId != null &&
                                this.cMessageId.equals(other.getCMessageId())));
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
        if (getCFrom() != null) {
            _hashCode += getCFrom().hashCode();
        }
        if (getCTo() != null) {
            _hashCode += getCTo().hashCode();
        }
        if (getCText() != null) {
            _hashCode += getCText().hashCode();
        }
        if (getCEnterRed_Date() != null) {
            _hashCode += getCEnterRed_Date().hashCode();
        }
        if (getCStatus() != null) {
            _hashCode += getCStatus().hashCode();
        }
        if (getCMessageId() != null) {
            _hashCode += getCMessageId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(GetSms.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetSms"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CEnterRed_Date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cEnterRed_Date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CMessageId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cMessageId"));
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
