/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 *     http://duracloud.org/license/
 */
package org.duracloud.s3task;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient;
import com.amazonaws.services.s3.AmazonS3Client;
import org.duracloud.s3storage.S3ProviderUtil;
import org.duracloud.s3storage.S3StorageProvider;
import org.duracloud.s3task.hadoop.DescribeHadoopJobTaskRunner;
import org.duracloud.s3task.hadoop.RunHadoopJobTaskRunner;
import org.duracloud.s3task.hadoop.StopHadoopJobTaskRunner;
import org.duracloud.s3task.storage.SetReducedStorageTaskRunner;
import org.duracloud.s3task.storage.SetStandardStorageTaskRunner;
import org.duracloud.s3task.streaming.DeleteStreamingTaskRunner;
import org.duracloud.s3task.streaming.DisableStreamingTaskRunner;
import org.duracloud.s3task.streaming.EnableStreamingTaskRunner;
import org.duracloud.storage.error.UnsupportedTaskException;
import org.duracloud.storage.provider.TaskProvider;
import org.duracloud.storage.provider.TaskRunner;
import org.jets3t.service.CloudFrontService;
import org.jets3t.service.S3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles tasks specific to content stored in Amazon S3 
 *
 * @author: Bill Branan
 * Date: May 20, 2010
 */
public class S3TaskProvider implements TaskProvider {

    private final Logger log = LoggerFactory.getLogger(S3TaskProvider.class);

    private List<TaskRunner> taskList = new ArrayList<TaskRunner>();

    public S3TaskProvider(String accessKey, String secretKey) {
        S3Service s3Service =
            S3ProviderUtil.getS3Service(accessKey, secretKey);
        S3StorageProvider s3Provider =
            new S3StorageProvider(accessKey, secretKey);
        CloudFrontService cfService =
            S3ProviderUtil.getCloudFrontService(accessKey, secretKey);

        AWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3Client s3Client = new AmazonS3Client(awsCreds);
        AmazonElasticMapReduceClient emrClient =
            new AmazonElasticMapReduceClient(awsCreds);

        taskList.add(new NoopTaskRunner());
        taskList.add(new EnableStreamingTaskRunner(s3Provider,
                                                   s3Service,
                                                   cfService));
        taskList.add(new DisableStreamingTaskRunner(s3Provider,
                                                    s3Service,
                                                    cfService));
        taskList.add(new DeleteStreamingTaskRunner(s3Provider,
                                                   s3Service,
                                                   cfService));
        taskList.add(new RunHadoopJobTaskRunner(s3Provider,
                                                s3Client,
                                                emrClient));
        taskList.add(new DescribeHadoopJobTaskRunner(emrClient));
        taskList.add(new StopHadoopJobTaskRunner(emrClient));
        taskList.add(new SetStandardStorageTaskRunner(s3Provider, s3Client));
        taskList.add(new SetReducedStorageTaskRunner(s3Provider, s3Client));
    }

    public List<String> getSupportedTasks() {
        log.debug("getSupportedTasks()");

        List<String> supportedTasks = new ArrayList<String>();
        for(TaskRunner runner : taskList) {
            supportedTasks.add(runner.getName());
        }
        return supportedTasks;
    }

    public String performTask(String taskName, String taskParameters) {
        log.debug("performTask(" + taskName + ", " + taskParameters + ")");

        for(TaskRunner runner : taskList) {
            if(runner.getName().equals(taskName)) {
                return runner.performTask(taskParameters);
            }
        }
        throw new UnsupportedTaskException(taskName);
    }
    
}
