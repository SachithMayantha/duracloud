/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 *     http://duracloud.org/license/
 */
package org.duracloud.serviceconfig;

import org.duracloud.common.xml.SchemaGenerator;
import org.junit.Test;

/**
 * @author: Bill Branan
 * Date: 7/14/11
 */
public class SchemaGeneratorTest {

    @Test
    public void testGenerateSchema() throws Exception {
        String fileName = ServiceReportBase.SCHEMA_NAME;
        SchemaGenerator generator = new SchemaGenerator(fileName);
        generator.generateSchema(ServiceReportList.class);
    }

}
