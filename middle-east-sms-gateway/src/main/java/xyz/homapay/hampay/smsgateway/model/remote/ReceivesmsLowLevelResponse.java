/**
 * ReceivesmsLowLevelResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class ReceivesmsLowLevelResponse implements java.io.Serializable {
    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aBody;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aMobileno;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong aMessageid;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aReceivedate;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString afromnumber;

    public ReceivesmsLowLevelResponse() {
    }

    public ReceivesmsLowLevelResponse(
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aBody,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aMobileno,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong aMessageid,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aReceivedate,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString afromnumber) {
        this.aBody = aBody;
        this.aMobileno = aMobileno;
        this.aMessageid = aMessageid;
        this.aReceivedate = aReceivedate;
        this.afromnumber = afromnumber;
    }


    /**
     * Gets the aBody value for this ReceivesmsLowLevelResponse.
     * 
     * @return aBody
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getABody() {
        return aBody;
    }


    /**
     * Sets the aBody value for this ReceivesmsLowLevelResponse.
     * 
     * @param aBody
     */
    public void setABody(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aBody) {
        this.aBody = aBody;
    }


    /**
     * Gets the aMobileno value for this ReceivesmsLowLevelResponse.
     * 
     * @return aMobileno
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getAMobileno() {
        return aMobileno;
    }


    /**
     * Sets the aMobileno value for this ReceivesmsLowLevelResponse.
     * 
     * @param aMobileno
     */
    public void setAMobileno(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aMobileno) {
        this.aMobileno = aMobileno;
    }


    /**
     * Gets the aMessageid value for this ReceivesmsLowLevelResponse.
     * 
     * @return aMessageid
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong getAMessageid() {
        return aMessageid;
    }


    /**
     * Sets the aMessageid value for this ReceivesmsLowLevelResponse.
     * 
     * @param aMessageid
     */
    public void setAMessageid(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong aMessageid) {
        this.aMessageid = aMessageid;
    }


    /**
     * Gets the aReceivedate value for this ReceivesmsLowLevelResponse.
     * 
     * @return aReceivedate
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getAReceivedate() {
        return aReceivedate;
    }


    /**
     * Sets the aReceivedate value for this ReceivesmsLowLevelResponse.
     * 
     * @param aReceivedate
     */
    public void setAReceivedate(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aReceivedate) {
        this.aReceivedate = aReceivedate;
    }


    /**
     * Gets the afromnumber value for this ReceivesmsLowLevelResponse.
     * 
     * @return afromnumber
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getAfromnumber() {
        return afromnumber;
    }


    /**
     * Sets the afromnumber value for this ReceivesmsLowLevelResponse.
     * 
     * @param afromnumber
     */
    public void setAfromnumber(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString afromnumber) {
        this.afromnumber = afromnumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReceivesmsLowLevelResponse)) return false;
        ReceivesmsLowLevelResponse other = (ReceivesmsLowLevelResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.aBody == null && other.getABody() == null) ||
                        (this.aBody != null &&
                                this.aBody.equals(other.getABody()))) &&
                ((this.aMobileno == null && other.getAMobileno() == null) ||
                        (this.aMobileno != null &&
                                this.aMobileno.equals(other.getAMobileno()))) &&
                ((this.aMessageid == null && other.getAMessageid() == null) ||
                        (this.aMessageid != null &&
                                this.aMessageid.equals(other.getAMessageid()))) &&
                ((this.aReceivedate == null && other.getAReceivedate() == null) ||
                        (this.aReceivedate != null &&
                                this.aReceivedate.equals(other.getAReceivedate()))) &&
                ((this.afromnumber == null && other.getAfromnumber() == null) ||
                        (this.afromnumber != null &&
                                this.afromnumber.equals(other.getAfromnumber())));
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
        if (getABody() != null) {
            _hashCode += getABody().hashCode();
        }
        if (getAMobileno() != null) {
            _hashCode += getAMobileno().hashCode();
        }
        if (getAMessageid() != null) {
            _hashCode += getAMessageid().hashCode();
        }
        if (getAReceivedate() != null) {
            _hashCode += getAReceivedate().hashCode();
        }
        if (getAfromnumber() != null) {
            _hashCode += getAfromnumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(ReceivesmsLowLevelResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ReceivesmsLowLevelResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ABody");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aBody"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AMobileno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aMobileno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AMessageid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aMessageid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfLong"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AReceivedate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aReceivedate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("afromnumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "afromnumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfString"));
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
