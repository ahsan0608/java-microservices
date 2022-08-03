package com.ahsan.notification;

import com.ahsan.rmq.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.ahsan.notification",
                "com.ahsan.rmq",
        }
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class,args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
          RabbitMQMessageProducer producer,
          NotificationConfig notificationConfig
    ){
        return args -> {
            producer.publish(
                    new Person("ahsan","ahsan@gmail.com"),
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRoutingKey());

        };
    }

    record Person(String name, String email){}
}
