package com.koreait.exam.batch_25_06.job.helloWorld;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class HelloWorldJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    // job : 여러개의 step들로 구성

    @Bean
    public Job helloWorldJob() {
        return jobBuilderFactory.get("helloWorldJob")
//                .incrementer(new RunIdIncrementer()) // 강제로 매번 다른 ID를 부여 -> 파라미터
                .start(helloWorldStep1())
                .next(helloWorldStep2())
                .build();
    }

    @Bean
    @JobScope
    public Step helloWorldStep1() {
        return stepBuilderFactory
                .get("helloWorldStep1")
                .tasklet(helloWorldTasklet1())
                .build();
    }

    @Bean
    @StepScope
    public Tasklet helloWorldTasklet1() {
        return (contribution, chunkContext) -> {
            System.out.println("헬로월드!!!1111");
            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    @JobScope
    public Step helloWorldStep2() {
        return stepBuilderFactory
                .get("helloWorldStep2")
                .tasklet(helloWorldTasklet2())
                .build();
    }

    @Bean
    @StepScope
    public Tasklet helloWorldTasklet2() {
        return (contribution, chunkContext) -> {
            System.out.println("헬로월드!!!2222");

//            if(true){
//                throw new Exception("실패 : 헬로 월드 태스클릿 2 실패");
//            }

            return RepeatStatus.FINISHED;
        };
    }
}
