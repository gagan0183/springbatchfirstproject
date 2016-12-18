package com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class FirstBatch implements Tasklet {

	private static final Logger LOGGER = LoggerFactory.getLogger(FirstBatch.class.getPackage().getName());

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		LOGGER.info("first batch job is executing");
		return RepeatStatus.FINISHED;
	}
}
