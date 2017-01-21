/**
 * InteractionPair.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tabula.drugs.utils.interactionApi.beans;

import java.util.Arrays;

public class InteractionPair implements java.io.Serializable {
    private Description description;

    private java.lang.Object[] interactionConcept;

    private Severity severity;

    public InteractionPair() {
    }

    public InteractionPair(
            Description description,
            java.lang.Object[] interactionConcept,
            Severity severity) {
        this.description = description;
        this.interactionConcept = interactionConcept;
        this.severity = severity;
    }


    /**
     * Gets the description value for this InteractionPair.
     *
     * @return description
     */
    public Description getDescription() {
        return description;
    }


    /**
     * Sets the description value for this InteractionPair.
     *
     * @param description
     */
    public void setDescription(Description description) {
        this.description = description;
    }


    /**
     * Gets the interactionConcept value for this InteractionPair.
     *
     * @return interactionConcept
     */
    public java.lang.Object[] getInteractionConcept() {
        return interactionConcept;
    }


    /**
     * Sets the interactionConcept value for this InteractionPair.
     *
     * @param interactionConcept
     */
    public void setInteractionConcept(java.lang.Object[] interactionConcept) {
        this.interactionConcept = interactionConcept;
    }


    /**
     * Gets the severity value for this InteractionPair.
     *
     * @return severity
     */
    public Severity getSeverity() {
        return severity;
    }


    /**
     * Sets the severity value for this InteractionPair.
     *
     * @param severity
     */
    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InteractionPair)) return false;
        InteractionPair other = (InteractionPair) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.description == null && other.getDescription() == null) ||
                        (this.description != null &&
                                this.description.equals(other.getDescription()))) &&
                ((this.interactionConcept == null && other.getInteractionConcept() == null) ||
                        (this.interactionConcept != null &&
                                java.util.Arrays.equals(this.interactionConcept, other.getInteractionConcept()))) &&
                ((this.severity == null && other.getSeverity() == null) ||
                        (this.severity != null &&
                                this.severity.equals(other.getSeverity())));
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getInteractionConcept() != null) {
            for (int i = 0;
                 i < java.lang.reflect.Array.getLength(getInteractionConcept());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInteractionConcept(), i);
                if (obj != null &&
                        !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSeverity() != null) {
            _hashCode += getSeverity().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(InteractionPair.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "InteractionPair"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "Description"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interactionConcept");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interactionConcept"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("severity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "severity"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "Severity"));
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
        return "InteractionPair{" +
                "severity=" + severity +
                ", description=" + description +
                ", interactionConcept=" + Arrays.toString(interactionConcept) +
                '}';
    }
}
