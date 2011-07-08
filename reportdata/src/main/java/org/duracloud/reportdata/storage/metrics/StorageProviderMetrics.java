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
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Metrics data structure for storage providers. Contains all of the metrics
 * information about a single storage provider and its storage spaces.
 *
 * @author: Bill Branan
 * Date: 5/12/11
 */
public class StorageProviderMetrics extends Metrics {

    @XmlAttribute(name = "id")
    private String storageProviderId;

    @XmlAttribute(name = "type")
    private String storageProviderType;

    @XmlElementWrapper
    @XmlElement(name = "space")
    private List<SpaceMetrics> spaceMetrics;

    // Required for JAXB
    private StorageProviderMetrics() {
    }

    public StorageProviderMetrics(String storageProviderId,
                                  String storageProviderType,
                                  List<SpaceMetrics> spaceMetrics,
                                  long totalItems,
                                  long totalSize,
                                  List<MimetypeMetrics> mimetypeMetrics) {
        super(totalItems, totalSize, mimetypeMetrics);
        this.storageProviderId = storageProviderId;
        this.storageProviderType = storageProviderType;
        this.spaceMetrics = spaceMetrics;
    }

    public String getStorageProviderId() {
        return storageProviderId;
    }

    public String getStorageProviderType() {
        return storageProviderType;
    }

    public List<SpaceMetrics> getSpaceMetrics() {
        return spaceMetrics;
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

        StorageProviderMetrics that = (StorageProviderMetrics) o;

        if (spaceMetrics != null ? !spaceMetrics.equals(that.spaceMetrics) :
            that.spaceMetrics != null) {
            return false;
        }
        if (storageProviderId != null ? !storageProviderId
            .equals(that.storageProviderId) : that.storageProviderId != null) {
            return false;
        }
        if (storageProviderType != null ? !storageProviderType
            .equals(that.storageProviderType) :
            that.storageProviderType != null) {
            return false;
        }

        return true;
    }

    /*
     * Generated by IntelliJ
     */
    @Override
    public int hashCode() {
        int result =
            storageProviderId != null ? storageProviderId.hashCode() : 0;
        result = 31 * result +
            (storageProviderType != null ? storageProviderType.hashCode() : 0);
        result =
            31 * result + (spaceMetrics != null ? spaceMetrics.hashCode() : 0);
        return result;
    }

}
