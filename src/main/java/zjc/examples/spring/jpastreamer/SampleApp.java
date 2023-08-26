package zjc.examples.spring.jpastreamer;

import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// @SpringBootApplication(scanBasePackages={"zjc.examples.spring.jpastreamer"})
@SpringBootApplication
public class SampleApp {

    public static void main(String[] args) {
        SpringApplication.run(SampleApp.class, args);
    }

    @Bean
    JPAStreamer jpaStreamer(EntityManagerFactory entityManagerFactory) {
        return JPAStreamer.createJPAStreamerBuilder(entityManagerFactory).build();
    }

}
