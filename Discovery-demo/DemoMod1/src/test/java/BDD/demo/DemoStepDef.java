package BDD.demo;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@CucumberContextConfiguration
public class DemoStepDef {

    RestTemplate restTemplate = new RestTemplate();
    String responseRes;
    @Given("^The application is running$")
    public void the_application_is_running() throws Throwable {
        final ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/actuator/health", String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @When("^the user hit /ping api$")
    public void the_user_hit_ping_api() throws Throwable {
        final ResponseEntity<String> res = restTemplate.getForEntity("http://localhost:8080/ping", String.class);
        responseRes = res.getBody();

    }

    @Then("^he will get the result \"([^\"]*)\"$")
    public void he_will_get_the_result(String arg1) throws Throwable {
        Assert.assertEquals(arg1, responseRes);

    }
}



