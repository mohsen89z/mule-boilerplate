/**
 * MoneybacktoUser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class MoneybacktoUser implements java.io.Serializable {
    private java.lang.String cCommand;

    private int nservice;

    private int nSmsServerid;

    public MoneybacktoUser() {
    }

    public MoneybacktoUser(
            java.lang.String cCommand,
            int nservice,
            int nSmsServerid) {
        this.cCommand = cCommand;
        this.nservice = nservice;
        this.nSmsServerid = nSmsServerid;
    }


    /**
     * Gets the cCommand value for this MoneybacktoUser.
     * 
     * @return cCommand
     */
    public java.lang.String getCCommand() {
        return cCommand;
    }


    /**
     * Sets the cCommand value for this MoneybacktoUser.
     * 
     * @param cCommand
     */
    public void setCCommand(java.lang.String cCommand) {
        this.cCommand = cCommand;
    }


    /**
     * Gets the nservice value for this MoneybacktoUser.
     * 
     * @return nservice
     */
    public int getNservice() {
        return nservice;
    }


    /**
     * Sets the nservice value for this MoneybacktoUser.
     * 
     * @param nservice
     */
    public void setNservice(int nservice) {
        this.nservice = nservice;
    }


    /**
     * Gets the nSmsServerid value for this MoneybacktoUser.
     * 
     * @return nSmsServerid
     */
    public int getNSmsServerid() {
        return nSmsServerid;
    }


    /**
     * Sets the nSmsServerid value for this MoneybacktoUser.
     * 
     * @param nSmsServerid
     */
    public void setNSmsServerid(int nSmsServerid) {
        this.nSmsServerid = nSmsServerid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MoneybacktoUser)) return false;
        MoneybacktoUser other = (MoneybacktoUser) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.cCommand == null && other.getCCommand() == null) ||
                        (this.cCommand != null &&
                                this.cCommand.equals(other.getCCommand()))) &&
                this.nservice == other.getNservice() &&
                this.nSmsServerid == other.getNSmsServerid();
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
        if (getCCommand() != null) {
            _hashCode += getCCommand().hashCode();
        }
        _hashCode += getNservice();
        _hashCode += getNSmsServerid();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(MoneybacktoUser.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">MoneybacktoUser"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CCommand");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cCommand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nservice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nservice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NSmsServerid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nSmsServerid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
