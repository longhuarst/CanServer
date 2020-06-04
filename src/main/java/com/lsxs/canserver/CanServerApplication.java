package com.lsxs.canserver;


import com.lsxs.canserver.jna.Can;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaAuditing
public class CanServerApplication {


    @Bean
    public Can can(){
        return new Can();
    }


    public static void main(String[] args) {
        SpringApplication.run(CanServerApplication.class, args);
    }

}
