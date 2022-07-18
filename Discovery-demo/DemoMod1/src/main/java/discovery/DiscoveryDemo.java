package discovery;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Discovery APi", version = "1.0", description = "Discovery tutorial"))
@SpringBootApplication
public class DiscoveryDemo {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryDemo.class, args);
        System.out.println("Hello World");
    }
}
