/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 *     http://duracloud.org/license/
 */
package org.duracloud.serviceconfig;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author: Bill Branan
 * Date: 7/14/11
 */
public class ServiceReportBase {

    public static final String SCHEMA_NAME = "service-report.xsd";
    public static final String SCHEMA_VERSION = "1.0";

    protected String schemaVersion;

    public String getSchemaVersion() {
        return schemaVersion;
    }

    @XmlAttribute(required = true)
    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

}
