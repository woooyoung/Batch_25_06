package com.koreait.exam.batch_25_06;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableBatchProcessing
@EnableJpaAuditing
public class Batch2506Application  {

    public static void main(String[] args) {
        SpringApplication.run(Batch2506Application.class, args);
    }

}
