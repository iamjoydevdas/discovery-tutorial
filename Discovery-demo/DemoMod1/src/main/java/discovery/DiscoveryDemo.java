package discovery;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCaching
@EnableEurekaClient
@OpenAPIDefinition(info = @Info(title = "Discovery API Tutorial", version = "1.0", description = "Discovery tutorial for new joiners"))
@SpringBootApplication
public class DiscoveryDemo {

    public static void main(String[] args) {

        SpringApplication.run(DiscoveryDemo.class, args);
        System.out.println("Hello World");
    }
}
