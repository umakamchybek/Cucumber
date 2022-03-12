package stepDefinitions.webordersteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.weborderpages.LoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginPageSteps {
    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);

    @Given("the user navigates to the WebOrder website")
    public void the_user_navigates_to_the_web_order_website() {
        driver.navigate().to(ConfigReader.readProperty("weborderurl"));

    }

    @When("the user provides credentials")
    public void the_user_provides_credentials() {
        loginPage.Login(ConfigReader.readProperty("weborderusername"), ConfigReader.readProperty("weborderpassword"));


    }

    @Then("the user is on the home page")
    public void the_user_is_on_the_home_page() {

        Assert.assertEquals(driver.getTitle(),"ORDER DETAILS - Weborder");
    }

    @When("the user provides correct username and wrong password")
    public void the_user_provides_correct_username_and_wrong_password() {
       loginPage.Login(ConfigReader.readProperty("weborderusername"),"wrongpassword");
    }

    @Then("the user validates the {string} error message")
    public void the_user_validates_the_error_message(String expectedMessage) {
       Assert.assertTrue(loginPage.getErrorMessage(expectedMessage));

//    }
//    @When("the user provides wrong username and wrong password")//hard coding
//    public void the_user_provides_wrong_and_wrong() {
//        loginPage.Login("umakam","umakam123");

    }
    @When("the user provides wrong {string} and wrong {string}")
    public void the_user_provides_wrong_and_wrong(String username, String password) {
        loginPage.Login(username,password);
    }
    @When("the user provides empty username and empty password")
    public void the_user_provides_empty_username_and_empty_password() {
        loginPage.Login("","");

    }
}
