/**
 * CheckRealDelivey2000.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class CheckRealDelivey2000 implements java.io.Serializable {
    private java.lang.String cCommand;

    private java.lang.String csmsserver;

    private boolean ldelegate;

    public CheckRealDelivey2000() {
    }

    public CheckRealDelivey2000(
            java.lang.String cCommand,
            java.lang.String csmsserver,
            boolean ldelegate) {
        this.cCommand = cCommand;
        this.csmsserver = csmsserver;
        this.ldelegate = ldelegate;
    }


    /**
     * Gets the cCommand value for this CheckRealDelivey2000.
     * 
     * @return cCommand
     */
    public java.lang.String getCCommand() {
        return cCommand;
    }


    /**
     * Sets the cCommand value for this CheckRealDelivey2000.
     * 
     * @param cCommand
     */
    public void setCCommand(java.lang.String cCommand) {
        this.cCommand = cCommand;
    }


    /**
     * Gets the csmsserver value for this CheckRealDelivey2000.
     * 
     * @return csmsserver
     */
    public java.lang.String getCsmsserver() {
        return csmsserver;
    }


    /**
     * Sets the csmsserver value for this CheckRealDelivey2000.
     * 
     * @param csmsserver
     */
    public void setCsmsserver(java.lang.String csmsserver) {
        this.csmsserver = csmsserver;
    }


    /**
     * Gets the ldelegate value for this CheckRealDelivey2000.
     * 
     * @return ldelegate
     */
    public boolean isLdelegate() {
        return ldelegate;
    }


    /**
     * Sets the ldelegate value for this CheckRealDelivey2000.
     * 
     * @param ldelegate
     */
    public void setLdelegate(boolean ldelegate) {
        this.ldelegate = ldelegate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckRealDelivey2000)) return false;
        CheckRealDelivey2000 other = (CheckRealDelivey2000) obj;
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
                ((this.csmsserver == null && other.getCsmsserver() == null) ||
                        (this.csmsserver != null &&
                                this.csmsserver.equals(other.getCsmsserver()))) &&
                this.ldelegate == other.isLdelegate();
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
        if (getCsmsserver() != null) {
            _hashCode += getCsmsserver().hashCode();
        }
        _hashCode += (isLdelegate() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(CheckRealDelivey2000.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">CheckRealDelivey2000"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CCommand");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cCommand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csmsserver");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "csmsserver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ldelegate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ldelegate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
