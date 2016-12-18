package com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class SpringbatchApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbatchApplication.class.getPackage().getName());

	public static void main(String[] args) {
		// SpringApplication.run(SpringbatchApplication.class, args);

		String[] springConfig = { "firstBatch.xml" };
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(springConfig);
		JobLauncher jobLauncher = (JobLauncher) applicationContext.getBean("jobLauncher");
		Job job = (Job) applicationContext.getBean("firstBatchJob");
		try {
			JobExecution execution = jobLauncher.run(job, new JobParameters());
			LOGGER.info("Exit status : " + execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (applicationContext != null) {
				applicationContext = null;
			}
		}
		LOGGER.info("done");
	}
}
