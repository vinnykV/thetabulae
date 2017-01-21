/**
 * FullInteractionType.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tabula.drugs.utils.interactionApi.beans;

import java.util.Arrays;

public class FullInteractionType implements java.io.Serializable {
    private Comment comment;

    private java.lang.Object[] interactionPair;

    private java.lang.Object[] minConcept;

    public FullInteractionType() {
    }

    public FullInteractionType(
            Comment comment,
            java.lang.Object[] interactionPair,
            java.lang.Object[] minConcept) {
        this.comment = comment;
        this.interactionPair = interactionPair;
        this.minConcept = minConcept;
    }


    /**
     * Gets the comment value for this FullInteractionType.
     *
     * @return comment
     */
    public Comment getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this FullInteractionType.
     *
     * @param comment
     */
    public void setComment(Comment comment) {
        this.comment = comment;
    }


    /**
     * Gets the interactionPair value for this FullInteractionType.
     *
     * @return interactionPair
     */
    public java.lang.Object[] getInteractionPair() {
        return interactionPair;
    }


    /**
     * Sets the interactionPair value for this FullInteractionType.
     *
     * @param interactionPair
     */
    public void setInteractionPair(java.lang.Object[] interactionPair) {
        this.interactionPair = interactionPair;
    }


    /**
     * Gets the minConcept value for this FullInteractionType.
     *
     * @return minConcept
     */
    public java.lang.Object[] getMinConcept() {
        return minConcept;
    }


    /**
     * Sets the minConcept value for this FullInteractionType.
     *
     * @param minConcept
     */
    public void setMinConcept(java.lang.Object[] minConcept) {
        this.minConcept = minConcept;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FullInteractionType)) return false;
        FullInteractionType other = (FullInteractionType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.comment == null && other.getComment() == null) ||
                        (this.comment != null &&
                                this.comment.equals(other.getComment()))) &&
                ((this.interactionPair == null && other.getInteractionPair() == null) ||
                        (this.interactionPair != null &&
                                java.util.Arrays.equals(this.interactionPair, other.getInteractionPair()))) &&
                ((this.minConcept == null && other.getMinConcept() == null) ||
                        (this.minConcept != null &&
                                java.util.Arrays.equals(this.minConcept, other.getMinConcept())));
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
        if (getComment() != null) {
            _hashCode += getComment().hashCode();
        }
        if (getInteractionPair() != null) {
            for (int i = 0;
                 i < java.lang.reflect.Array.getLength(getInteractionPair());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInteractionPair(), i);
                if (obj != null &&
                        !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMinConcept() != null) {
            for (int i = 0;
                 i < java.lang.reflect.Array.getLength(getMinConcept());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMinConcept(), i);
                if (obj != null &&
                        !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(FullInteractionType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "FullInteractionType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comment"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "Comment"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interactionPair");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interactionPair"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minConcept");
        elemField.setXmlName(new javax.xml.namespace.QName("", "minConcept"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
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
        return "FullInteractionType{" +
                "comment=" + comment +
                ", interactionPair=" + Arrays.toString(interactionPair) +
                ", minConcept=" + Arrays.toString(minConcept) +
                '}';
    }
}
