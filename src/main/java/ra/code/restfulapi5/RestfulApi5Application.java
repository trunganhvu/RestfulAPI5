package ra.code.restfulapi5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RestfulApi5Application {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApi5Application.class, args);
    }

}
