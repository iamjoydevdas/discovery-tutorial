package discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class NewMod implements CommandLineRunner {

    @Autowired
    private IDemoAPi iDemoAPi;

    public static void main(String[] args) {
        SpringApplication.run(NewMod.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(iDemoAPi.ping().getBody());
    }
}
