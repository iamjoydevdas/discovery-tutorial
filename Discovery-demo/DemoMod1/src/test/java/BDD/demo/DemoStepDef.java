package BDD.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@CucumberContextConfiguration
public class DemoStepDef {

    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    String pingOutput;

    @Given("^The application is running$")
    public void the_application_is_running() throws Throwable {
        final ResponseEntity<Object> response = restTemplate.getForEntity("http://localhost:8080/actuator/health", Object.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @When("^the user hit /ping api$")
    public void the_user_hit_ping_api() throws Throwable {

        final ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8080/ping", HttpMethod.GET, null, String.class);
        pingOutput = exchange.getBody();

    }

    @Then("^he will get the result \"([^\"]*)\"$")
    public void he_will_get_the_result(String arg1) throws Throwable {
        Assert.assertEquals(pingOutput, arg1);
    }
}



