package dev.gxsoft.blogrestjpa;

import com.sun.istack.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BlogRestJpaApplication {


    public static void main(String[] args) {
        SpringApplication.run(BlogRestJpaApplication.class, args);

        log.info("test");
    }

}
