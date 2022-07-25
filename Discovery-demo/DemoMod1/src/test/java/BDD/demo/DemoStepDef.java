package BDD.demo;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoStepDef {

    @Given("^The application is running$")
    public void the_application_is_running() throws Throwable {
        throw new PendingException();
    }

    @When("^the user hit /ping api$")
    public void the_user_hit_ping_api() throws Throwable {
        throw new PendingException();
    }

    @Then("^he will get the result \"([^\"]*)\"$")
    public void he_will_get_the_result(String arg1) throws Throwable {
        throw new PendingException();
    }



}
