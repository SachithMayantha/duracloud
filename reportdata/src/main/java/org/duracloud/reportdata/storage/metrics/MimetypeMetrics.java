/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 *     http://duracloud.org/license/
 */
package org.duracloud.reportdata.storage.metrics;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author: Bill Branan
 * Date: 5/12/11
 */
public class MimetypeMetrics {

    @XmlAttribute(name = "name")
    private String mimetype;

    @XmlElement
    private long totalItems;

    @XmlElement
    private long totalSize;

    // Required for JAXB
    private MimetypeMetrics() {
    }

    public MimetypeMetrics(String mimetype, long totalItems, long totalSize) {
        this.mimetype = mimetype;
        this.totalItems = totalItems;
        this.totalSize = totalSize;
    }

    public String getMimetype() {
        return mimetype;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public long getTotalSize() {
        return totalSize;
    }

    /*
     * Generated by IntelliJ
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MimetypeMetrics that = (MimetypeMetrics) o;

        if (totalItems != that.totalItems) {
            return false;
        }
        if (totalSize != that.totalSize) {
            return false;
        }
        if (mimetype != null ? !mimetype.equals(that.mimetype) :
            that.mimetype != null) {
            return false;
        }

        return true;
    }

    /*
     * Generated by IntelliJ
     */
    @Override
    public int hashCode() {
        int result = mimetype != null ? mimetype.hashCode() : 0;
        result = 31 * result + (int) (totalItems ^ (totalItems >>> 32));
        result = 31 * result + (int) (totalSize ^ (totalSize >>> 32));
        return result;
    }

}