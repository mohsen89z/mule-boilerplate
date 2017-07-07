/**
 * ForgetPassword.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class ForgetPassword implements java.io.Serializable {
    private java.lang.String cDomainname;

    private java.lang.String cUsername;

    private java.lang.String cMobileno;

    public ForgetPassword() {
    }

    public ForgetPassword(
            java.lang.String cDomainname,
            java.lang.String cUsername,
            java.lang.String cMobileno) {
        this.cDomainname = cDomainname;
        this.cUsername = cUsername;
        this.cMobileno = cMobileno;
    }


    /**
     * Gets the cDomainname value for this ForgetPassword.
     * 
     * @return cDomainname
     */
    public java.lang.String getCDomainname() {
        return cDomainname;
    }


    /**
     * Sets the cDomainname value for this ForgetPassword.
     * 
     * @param cDomainname
     */
    public void setCDomainname(java.lang.String cDomainname) {
        this.cDomainname = cDomainname;
    }


    /**
     * Gets the cUsername value for this ForgetPassword.
     * 
     * @return cUsername
     */
    public java.lang.String getCUsername() {
        return cUsername;
    }


    /**
     * Sets the cUsername value for this ForgetPassword.
     * 
     * @param cUsername
     */
    public void setCUsername(java.lang.String cUsername) {
        this.cUsername = cUsername;
    }


    /**
     * Gets the cMobileno value for this ForgetPassword.
     * 
     * @return cMobileno
     */
    public java.lang.String getCMobileno() {
        return cMobileno;
    }


    /**
     * Sets the cMobileno value for this ForgetPassword.
     * 
     * @param cMobileno
     */
    public void setCMobileno(java.lang.String cMobileno) {
        this.cMobileno = cMobileno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ForgetPassword)) return false;
        ForgetPassword other = (ForgetPassword) obj;
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
                ((this.cMobileno == null && other.getCMobileno() == null) ||
                        (this.cMobileno != null &&
                                this.cMobileno.equals(other.getCMobileno())));
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
        if (getCMobileno() != null) {
            _hashCode += getCMobileno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(ForgetPassword.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ForgetPassword"));
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
        elemField.setFieldName("CMobileno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cMobileno"));
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
