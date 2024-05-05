package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.DuplicateJobException;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class BatchConfig extends DefaultBatchConfiguration {

    @Bean
    public Job testJob(JobRepository jobRepository,PlatformTransactionManager transactionManager) throws DuplicateJobException {
       Job job = new JobBuilder("testJob",jobRepository)
               .start(testStep(jobRepository,transactionManager))
               .build();
       return job;
    }

    public Step testStep(JobRepository jobRepository,PlatformTransactionManager transactionManager){
        Step step = new StepBuilder("testStep",jobRepository)
                .tasklet(newTasklet(),transactionManager)
                .build();
        return step;
    }

    public Tasklet newTasklet(){
        return ((contribution, chunkContext) -> {
              System.out.println("======== batch Tasklet ========");
              return RepeatStatus.FINISHED;
        });
    }
}