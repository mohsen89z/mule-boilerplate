/**
 * ActivateCentral.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class ActivateCentral implements java.io.Serializable {
    private java.lang.String cUSername;

    private java.lang.String cPassword;

    private java.lang.String cDomainname;

    private java.lang.String cSerial;

    public ActivateCentral() {
    }

    public ActivateCentral(
            java.lang.String cUSername,
            java.lang.String cPassword,
            java.lang.String cDomainname,
            java.lang.String cSerial) {
        this.cUSername = cUSername;
        this.cPassword = cPassword;
        this.cDomainname = cDomainname;
        this.cSerial = cSerial;
    }


    /**
     * Gets the cUSername value for this ActivateCentral.
     * 
     * @return cUSername
     */
    public java.lang.String getCUSername() {
        return cUSername;
    }


    /**
     * Sets the cUSername value for this ActivateCentral.
     * 
     * @param cUSername
     */
    public void setCUSername(java.lang.String cUSername) {
        this.cUSername = cUSername;
    }


    /**
     * Gets the cPassword value for this ActivateCentral.
     * 
     * @return cPassword
     */
    public java.lang.String getCPassword() {
        return cPassword;
    }


    /**
     * Sets the cPassword value for this ActivateCentral.
     * 
     * @param cPassword
     */
    public void setCPassword(java.lang.String cPassword) {
        this.cPassword = cPassword;
    }


    /**
     * Gets the cDomainname value for this ActivateCentral.
     * 
     * @return cDomainname
     */
    public java.lang.String getCDomainname() {
        return cDomainname;
    }


    /**
     * Sets the cDomainname value for this ActivateCentral.
     * 
     * @param cDomainname
     */
    public void setCDomainname(java.lang.String cDomainname) {
        this.cDomainname = cDomainname;
    }


    /**
     * Gets the cSerial value for this ActivateCentral.
     * 
     * @return cSerial
     */
    public java.lang.String getCSerial() {
        return cSerial;
    }


    /**
     * Sets the cSerial value for this ActivateCentral.
     * 
     * @param cSerial
     */
    public void setCSerial(java.lang.String cSerial) {
        this.cSerial = cSerial;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ActivateCentral)) return false;
        ActivateCentral other = (ActivateCentral) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.cUSername == null && other.getCUSername() == null) ||
                        (this.cUSername != null &&
                                this.cUSername.equals(other.getCUSername()))) &&
                ((this.cPassword == null && other.getCPassword() == null) ||
                        (this.cPassword != null &&
                                this.cPassword.equals(other.getCPassword()))) &&
                ((this.cDomainname == null && other.getCDomainname() == null) ||
                        (this.cDomainname != null &&
                                this.cDomainname.equals(other.getCDomainname()))) &&
                ((this.cSerial == null && other.getCSerial() == null) ||
                        (this.cSerial != null &&
                                this.cSerial.equals(other.getCSerial())));
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
        if (getCUSername() != null) {
            _hashCode += getCUSername().hashCode();
        }
        if (getCPassword() != null) {
            _hashCode += getCPassword().hashCode();
        }
        if (getCDomainname() != null) {
            _hashCode += getCDomainname().hashCode();
        }
        if (getCSerial() != null) {
            _hashCode += getCSerial().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(ActivateCentral.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ActivateCentral"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CUSername");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cUSername"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CPassword");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cPassword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CDomainname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cDomainname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CSerial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cSerial"));
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
