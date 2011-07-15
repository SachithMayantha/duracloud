/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 *     http://duracloud.org/license/
 */
package org.duracloud.servicemonitor;

import org.duracloud.serviceapi.aop.DeployMessage;
import org.duracloud.serviceapi.aop.ServiceMessage;

/**
 * This interface consumes JMS messages on service deployment and begins
 * monitoring the status of the deployed service for completion.
 * Once the service is complete, this monitor triggers the action of collecting
 * the service details to be recorded in a summary report.
 *
 * @author Andrew Woods
 *         Date: 6/17/11
 */
public interface ServiceMonitor {

    /**
     * This method initializes the ServiceMonitor.
     *
     * @param summaryDirectory used within this class
     * @param summarizer       used within this class
     */
    public void initialize(ServiceSummaryDirectory summaryDirectory,
                           ServiceSummarizer summarizer);

    /**
     * This method consumes messages on the deployment of any service.
     *
     * @param message detailing service that has been deployed
     */
    public void onDeploy(DeployMessage message);

    /**
     * This method consumes messages on the un-deployment of any service.
     *
     * @param message detailing service that has been un-deployed
     */
    public void onUndeploy(ServiceMessage message);

    /**
     * This method consumes messages on the update of any service configuration.
     *
     * @param message detailing service that has been updated
     */
    public void onUpdateConfig(ServiceMessage message);

    /**
     * This method performs clean-up of threads managed by this class.
     */
    public void dispose();

}