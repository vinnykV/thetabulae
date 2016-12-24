/**
 * MinConcept.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tabula.drugs.utils.interactionApi.beans;

public class MinConcept  implements java.io.Serializable {
    private Name name;

    private Rxcui rxcui;

    private Tty tty;

    public MinConcept() {
    }

    public MinConcept(
           Name name,
           Rxcui rxcui,
           Tty tty) {
           this.name = name;
           this.rxcui = rxcui;
           this.tty = tty;
    }


    /**
     * Gets the name value for this MinConcept.
     * 
     * @return name
     */
    public Name getName() {
        return name;
    }


    /**
     * Sets the name value for this MinConcept.
     * 
     * @param name
     */
    public void setName(Name name) {
        this.name = name;
    }


    /**
     * Gets the rxcui value for this MinConcept.
     * 
     * @return rxcui
     */
    public Rxcui getRxcui() {
        return rxcui;
    }


    /**
     * Sets the rxcui value for this MinConcept.
     * 
     * @param rxcui
     */
    public void setRxcui(Rxcui rxcui) {
        this.rxcui = rxcui;
    }


    /**
     * Gets the tty value for this MinConcept.
     * 
     * @return tty
     */
    public Tty getTty() {
        return tty;
    }


    /**
     * Sets the tty value for this MinConcept.
     * 
     * @param tty
     */
    public void setTty(Tty tty) {
        this.tty = tty;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MinConcept)) return false;
        MinConcept other = (MinConcept) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.rxcui==null && other.getRxcui()==null) || 
             (this.rxcui!=null &&
              this.rxcui.equals(other.getRxcui()))) &&
            ((this.tty==null && other.getTty()==null) || 
             (this.tty!=null &&
              this.tty.equals(other.getTty())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getRxcui() != null) {
            _hashCode += getRxcui().hashCode();
        }
        if (getTty() != null) {
            _hashCode += getTty().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MinConcept.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "MinConcept"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "Name"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rxcui");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rxcui"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "Rxcui"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tty"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "Tty"));
        elemField.setNillable(true);
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
          new  org.apache.axis.encoding.ser.BeanSerializer(
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
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }


    @Override
    public String toString() {
        return "MinConcept{" +
                "tty=" + tty +
                ", name=" + name +
                ", rxcui=" + rxcui +
                '}';
    }
}
