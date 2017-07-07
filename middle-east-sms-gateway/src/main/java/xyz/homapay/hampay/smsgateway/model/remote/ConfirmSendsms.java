/**
 * ConfirmSendsms.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class ConfirmSendsms implements java.io.Serializable {
    private java.lang.String cCommand;

    private int nId;

    private int nTable;

    private int nTypeaccept;

    private int nUserid;

    public ConfirmSendsms() {
    }

    public ConfirmSendsms(
            java.lang.String cCommand,
            int nId,
            int nTable,
            int nTypeaccept,
            int nUserid) {
        this.cCommand = cCommand;
        this.nId = nId;
        this.nTable = nTable;
        this.nTypeaccept = nTypeaccept;
        this.nUserid = nUserid;
    }


    /**
     * Gets the cCommand value for this ConfirmSendsms.
     * 
     * @return cCommand
     */
    public java.lang.String getCCommand() {
        return cCommand;
    }


    /**
     * Sets the cCommand value for this ConfirmSendsms.
     * 
     * @param cCommand
     */
    public void setCCommand(java.lang.String cCommand) {
        this.cCommand = cCommand;
    }


    /**
     * Gets the nId value for this ConfirmSendsms.
     * 
     * @return nId
     */
    public int getNId() {
        return nId;
    }


    /**
     * Sets the nId value for this ConfirmSendsms.
     * 
     * @param nId
     */
    public void setNId(int nId) {
        this.nId = nId;
    }


    /**
     * Gets the nTable value for this ConfirmSendsms.
     * 
     * @return nTable
     */
    public int getNTable() {
        return nTable;
    }


    /**
     * Sets the nTable value for this ConfirmSendsms.
     * 
     * @param nTable
     */
    public void setNTable(int nTable) {
        this.nTable = nTable;
    }


    /**
     * Gets the nTypeaccept value for this ConfirmSendsms.
     * 
     * @return nTypeaccept
     */
    public int getNTypeaccept() {
        return nTypeaccept;
    }


    /**
     * Sets the nTypeaccept value for this ConfirmSendsms.
     * 
     * @param nTypeaccept
     */
    public void setNTypeaccept(int nTypeaccept) {
        this.nTypeaccept = nTypeaccept;
    }


    /**
     * Gets the nUserid value for this ConfirmSendsms.
     * 
     * @return nUserid
     */
    public int getNUserid() {
        return nUserid;
    }


    /**
     * Sets the nUserid value for this ConfirmSendsms.
     * 
     * @param nUserid
     */
    public void setNUserid(int nUserid) {
        this.nUserid = nUserid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConfirmSendsms)) return false;
        ConfirmSendsms other = (ConfirmSendsms) obj;
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
                this.nId == other.getNId() &&
                this.nTable == other.getNTable() &&
                this.nTypeaccept == other.getNTypeaccept() &&
                this.nUserid == other.getNUserid();
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
        _hashCode += getNId();
        _hashCode += getNTable();
        _hashCode += getNTypeaccept();
        _hashCode += getNUserid();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(ConfirmSendsms.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ConfirmSendsms"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CCommand");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cCommand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NTable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nTable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NTypeaccept");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nTypeaccept"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUserid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nUserid"));
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
