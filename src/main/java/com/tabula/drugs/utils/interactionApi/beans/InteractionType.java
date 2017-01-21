/**
 * InteractionType.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tabula.drugs.utils.interactionApi.beans;

import java.util.Arrays;

public class InteractionType implements java.io.Serializable {
    private Comment comment;

    private java.lang.Object[] interactionPair;

    private MinConceptItem minConceptItem;

    public InteractionType() {
    }

    public InteractionType(
            Comment comment,
            java.lang.Object[] interactionPair,
            MinConceptItem minConceptItem) {
        this.comment = comment;
        this.interactionPair = interactionPair;
        this.minConceptItem = minConceptItem;
    }


    /**
     * Gets the comment value for this InteractionType.
     *
     * @return comment
     */
    public Comment getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this InteractionType.
     *
     * @param comment
     */
    public void setComment(Comment comment) {
        this.comment = comment;
    }


    /**
     * Gets the interactionPair value for this InteractionType.
     *
     * @return interactionPair
     */
    public java.lang.Object[] getInteractionPair() {
        return interactionPair;
    }


    /**
     * Sets the interactionPair value for this InteractionType.
     *
     * @param interactionPair
     */
    public void setInteractionPair(java.lang.Object[] interactionPair) {
        this.interactionPair = interactionPair;
    }


    /**
     * Gets the minConceptItem value for this InteractionType.
     *
     * @return minConceptItem
     */
    public MinConceptItem getMinConceptItem() {
        return minConceptItem;
    }


    /**
     * Sets the minConceptItem value for this InteractionType.
     *
     * @param minConceptItem
     */
    public void setMinConceptItem(MinConceptItem minConceptItem) {
        this.minConceptItem = minConceptItem;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InteractionType)) return false;
        InteractionType other = (InteractionType) obj;
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
                ((this.minConceptItem == null && other.getMinConceptItem() == null) ||
                        (this.minConceptItem != null &&
                                this.minConceptItem.equals(other.getMinConceptItem())));
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
        if (getMinConceptItem() != null) {
            _hashCode += getMinConceptItem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(InteractionType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "InteractionType"));
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
        elemField.setFieldName("minConceptItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "minConceptItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "MinConceptItem"));
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
        return "InteractionType{" +
                "comment=" + comment +
                ", interactionPair=" + Arrays.toString(interactionPair) +
                ", minConceptItem=" + minConceptItem +
                '}';
    }
}
