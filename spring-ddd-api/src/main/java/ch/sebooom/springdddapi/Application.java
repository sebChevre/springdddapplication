package ch.sebooom.springdddapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@SpringBootApplication(scanBasePackages =
        {"ch.sebooom.springdddapplication","ch.sebooom.springdddspi","ch.sebooom.springdddapi"})

public class Application {



    public static void main(String[] args) {

        SpringApplication.run(Application.class);
    }



}
