package Step_Definetion;

import driverfactory.Driver_Factory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Tesco_Search;

public class Tesco_Search_Steps {
    Tesco_Search Tesco = new Tesco_Search(Driver_Factory.getDriver());

    @Given("User must be on Tesco Website")
    public void given_user_must_be_on_tesco_website() {
        // Write code here that turns the phrase above into concrete actions
        Driver_Factory.getDriver().get("https://www.tesco.com/");
        String url=Tesco.URL();
        Assert.assertEquals("https://www.tesco.com/",url);
    }

    @When("User search for {string}  on search bar")
    public void user_search_for_on_search_bar(String string) {
        // Write code here that turns the phrase above into concrete actions
        Tesco.setCookies();
        Tesco.setSearchBar(string);
    }
    @When("User click on Search button")
    public void user_click_on_search_button() {
        // Write code here that turns the phrase above into concrete actions
        Tesco.setSearchbutton();
    }
    @Then("User will able to see the {string} on webpage.")
    public void user_will_able_to_see_the_on_webpage(String string) {
        // Write code here that turns the phrase above into concrete actions
        String ProductActual= Tesco.Title();
        Assert.assertEquals("Productverify","Results for "+ '“' + string + '”',ProductActual);
    }


}
