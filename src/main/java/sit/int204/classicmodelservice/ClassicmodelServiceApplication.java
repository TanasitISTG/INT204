package sit.int204.classicmodelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import sit.int204.classicmodelservice.properties.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class ClassicmodelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassicmodelServiceApplication.class, args);
    }

}
