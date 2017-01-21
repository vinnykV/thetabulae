/**
 * FullInteractionTypeGroup.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tabula.drugs.utils.interactionApi.beans;

import java.util.Arrays;

public class FullInteractionTypeGroup implements java.io.Serializable {
    private java.lang.Object[] fullInteractionType;

    private SourceDisclaimer sourceDisclaimer;

    private SourceName sourceName;

    public FullInteractionTypeGroup() {
    }

    public FullInteractionTypeGroup(
            java.lang.Object[] fullInteractionType,
            SourceDisclaimer sourceDisclaimer,
            SourceName sourceName) {
        this.fullInteractionType = fullInteractionType;
        this.sourceDisclaimer = sourceDisclaimer;
        this.sourceName = sourceName;
    }


    /**
     * Gets the fullInteractionType value for this FullInteractionTypeGroup.
     *
     * @return fullInteractionType
     */
    public java.lang.Object[] getFullInteractionType() {
        return fullInteractionType;
    }


    /**
     * Sets the fullInteractionType value for this FullInteractionTypeGroup.
     *
     * @param fullInteractionType
     */
    public void setFullInteractionType(java.lang.Object[] fullInteractionType) {
        this.fullInteractionType = fullInteractionType;
    }


    /**
     * Gets the sourceDisclaimer value for this FullInteractionTypeGroup.
     *
     * @return sourceDisclaimer
     */
    public SourceDisclaimer getSourceDisclaimer() {
        return sourceDisclaimer;
    }


    /**
     * Sets the sourceDisclaimer value for this FullInteractionTypeGroup.
     *
     * @param sourceDisclaimer
     */
    public void setSourceDisclaimer(SourceDisclaimer sourceDisclaimer) {
        this.sourceDisclaimer = sourceDisclaimer;
    }


    /**
     * Gets the sourceName value for this FullInteractionTypeGroup.
     *
     * @return sourceName
     */
    public SourceName getSourceName() {
        return sourceName;
    }


    /**
     * Sets the sourceName value for this FullInteractionTypeGroup.
     *
     * @param sourceName
     */
    public void setSourceName(SourceName sourceName) {
        this.sourceName = sourceName;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FullInteractionTypeGroup)) return false;
        FullInteractionTypeGroup other = (FullInteractionTypeGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.fullInteractionType == null && other.getFullInteractionType() == null) ||
                        (this.fullInteractionType != null &&
                                java.util.Arrays.equals(this.fullInteractionType, other.getFullInteractionType()))) &&
                ((this.sourceDisclaimer == null && other.getSourceDisclaimer() == null) ||
                        (this.sourceDisclaimer != null &&
                                this.sourceDisclaimer.equals(other.getSourceDisclaimer()))) &&
                ((this.sourceName == null && other.getSourceName() == null) ||
                        (this.sourceName != null &&
                                this.sourceName.equals(other.getSourceName())));
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
        if (getFullInteractionType() != null) {
            for (int i = 0;
                 i < java.lang.reflect.Array.getLength(getFullInteractionType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFullInteractionType(), i);
                if (obj != null &&
                        !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSourceDisclaimer() != null) {
            _hashCode += getSourceDisclaimer().hashCode();
        }
        if (getSourceName() != null) {
            _hashCode += getSourceName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(FullInteractionTypeGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "FullInteractionTypeGroup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullInteractionType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fullInteractionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceDisclaimer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sourceDisclaimer"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "SourceDisclaimer"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sourceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "SourceName"));
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

    @Override
    public String toString() {
        return "FullInteractionTypeGroup{" +
                "sourceName=" + sourceName +
                ", fullInteractionType=" + Arrays.toString(fullInteractionType) +
                ", sourceDisclaimer=" + sourceDisclaimer +
                '}';
    }
}
