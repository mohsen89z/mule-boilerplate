/**
 * Matchgraph.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class Matchgraph implements java.io.Serializable {
    private java.lang.String cDomainname;

    private java.lang.String cUsername;

    private java.lang.String cpassword;

    private int nmatchid;

    public Matchgraph() {
    }

    public Matchgraph(
            java.lang.String cDomainname,
            java.lang.String cUsername,
            java.lang.String cpassword,
            int nmatchid) {
        this.cDomainname = cDomainname;
        this.cUsername = cUsername;
        this.cpassword = cpassword;
        this.nmatchid = nmatchid;
    }


    /**
     * Gets the cDomainname value for this Matchgraph.
     * 
     * @return cDomainname
     */
    public java.lang.String getCDomainname() {
        return cDomainname;
    }


    /**
     * Sets the cDomainname value for this Matchgraph.
     * 
     * @param cDomainname
     */
    public void setCDomainname(java.lang.String cDomainname) {
        this.cDomainname = cDomainname;
    }


    /**
     * Gets the cUsername value for this Matchgraph.
     * 
     * @return cUsername
     */
    public java.lang.String getCUsername() {
        return cUsername;
    }


    /**
     * Sets the cUsername value for this Matchgraph.
     * 
     * @param cUsername
     */
    public void setCUsername(java.lang.String cUsername) {
        this.cUsername = cUsername;
    }


    /**
     * Gets the cpassword value for this Matchgraph.
     * 
     * @return cpassword
     */
    public java.lang.String getCpassword() {
        return cpassword;
    }


    /**
     * Sets the cpassword value for this Matchgraph.
     * 
     * @param cpassword
     */
    public void setCpassword(java.lang.String cpassword) {
        this.cpassword = cpassword;
    }


    /**
     * Gets the nmatchid value for this Matchgraph.
     * 
     * @return nmatchid
     */
    public int getNmatchid() {
        return nmatchid;
    }


    /**
     * Sets the nmatchid value for this Matchgraph.
     * 
     * @param nmatchid
     */
    public void setNmatchid(int nmatchid) {
        this.nmatchid = nmatchid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Matchgraph)) return false;
        Matchgraph other = (Matchgraph) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.cDomainname == null && other.getCDomainname() == null) ||
                        (this.cDomainname != null &&
                                this.cDomainname.equals(other.getCDomainname()))) &&
                ((this.cUsername == null && other.getCUsername() == null) ||
                        (this.cUsername != null &&
                                this.cUsername.equals(other.getCUsername()))) &&
                ((this.cpassword == null && other.getCpassword() == null) ||
                        (this.cpassword != null &&
                                this.cpassword.equals(other.getCpassword()))) &&
                this.nmatchid == other.getNmatchid();
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
        if (getCDomainname() != null) {
            _hashCode += getCDomainname().hashCode();
        }
        if (getCUsername() != null) {
            _hashCode += getCUsername().hashCode();
        }
        if (getCpassword() != null) {
            _hashCode += getCpassword().hashCode();
        }
        _hashCode += getNmatchid();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(Matchgraph.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Matchgraph"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CDomainname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cDomainname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CUsername");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cUsername"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpassword");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cpassword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmatchid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nmatchid"));
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
