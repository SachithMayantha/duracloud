/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 *     http://duracloud.org/license/
 */
package org.duracloud.reportdata.storage;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author: Bill Branan
 * Date: 6/2/11
 */
@XmlRootElement
public class StorageReportInfo extends StorageReportBase {

    private String status;
    private long startTime;
    private long currentCount;
    private long finalCount;
    private long completionTime;
    private long estimatedCompletionTime;
    private long nextScheduledStartTime;

    public StorageReportInfo() {
        this.schemaVersion = SCHEMA_VERSION;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(long currentCount) {
        this.currentCount = currentCount;
    }

    public long getFinalCount() {
        return finalCount;
    }

    public void setFinalCount(long finalCount) {
        this.finalCount = finalCount;
    }

    public long getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(long completionTime) {
        this.completionTime = completionTime;
    }

    public long getEstimatedCompletionTime() {
        return estimatedCompletionTime;
    }

    public void setEstimatedCompletionTime(long estimatedCompletionTime) {
        this.estimatedCompletionTime = estimatedCompletionTime;
    }

    public long getNextScheduledStartTime() {
        return nextScheduledStartTime;
    }

    public void setNextScheduledStartTime(long nextScheduledStartTime) {
        this.nextScheduledStartTime = nextScheduledStartTime;
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

        StorageReportInfo that = (StorageReportInfo) o;

        if (completionTime != that.completionTime) {
            return false;
        }
        if (currentCount != that.currentCount) {
            return false;
        }
        if (estimatedCompletionTime != that.estimatedCompletionTime) {
            return false;
        }
        if (finalCount != that.finalCount) {
            return false;
        }
        if (nextScheduledStartTime != that.nextScheduledStartTime) {
            return false;
        }
        if (startTime != that.startTime) {
            return false;
        }
        if (status != null ? !status.equals(that.status) :
            that.status != null) {
            return false;
        }

        return true;
    }

    /*
     * Generated by IntelliJ
     */
    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (int) (startTime ^ (startTime >>> 32));
        result = 31 * result + (int) (currentCount ^ (currentCount >>> 32));
        result = 31 * result + (int) (finalCount ^ (finalCount >>> 32));
        result = 31 * result + (int) (completionTime ^ (completionTime >>> 32));
        result = 31 * result +
            (int) (estimatedCompletionTime ^ (estimatedCompletionTime >>> 32));
        result = 31 * result +
            (int) (nextScheduledStartTime ^ (nextScheduledStartTime >>> 32));
        return result;
    }

}