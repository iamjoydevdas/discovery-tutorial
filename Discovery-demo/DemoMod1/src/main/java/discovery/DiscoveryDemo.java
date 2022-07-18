package discovery;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "User API", version = "1.0", description = "User Management Api"))
@SpringBootApplication
public class DiscoveryDemo {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryDemo.class, args);
        System.out.println("Hello World");
    }
}
