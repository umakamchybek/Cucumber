package stepDefinitions.webordersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.weborderpages.CreateGroupOrderPage;
import pages.weborderpages.LoginPage;
import pages.weborderpages.OrderPage;
import utils.ConfigReader;
import utils.DriverHelper;


public class OrderSteps {

    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);
    OrderPage orderPage = new OrderPage(driver);
    CreateGroupOrderPage createGroupOrderPage=new CreateGroupOrderPage(driver);
    @Given("the user is on weborder homepage")
    public void the_user_is_on_weborder_homepage() {
        driver.navigate().to(ConfigReader.readProperty("weborderurl"));
        loginPage.Login(ConfigReader.readProperty("weborderusername"),ConfigReader.readProperty("weborderpassword"));

    }

    @When("the user selects {string} option")
    public void the_user_selects_option(String deliveryOption) {
        orderPage.getDeliveryOption(deliveryOption);


    }

    @When("the user is on the groupOrderPage")
    public void the_user_is_on_the_group_order_page() {
        orderPage.clickGroupOrder();
        orderPage.clickNextButton();

        Assert.assertEquals(driver.getTitle(),"Create Group Order - Weborder");

    }

    @When("the user sends invitees note {string}")
    public void the_user_sends_invitees_note(String inviteNote) {
        createGroupOrderPage.sendInviteNote(inviteNote);


    }

    @When("the user sends invite list {string} and {string}")
    public void the_user_sends_invite_list_and(String email1, String email2) {
        createGroupOrderPage.sendInviteList(email1+","+email2);

    }

    @Then("the user validates the {string} adress")
    public void the_user_validates_the_adress(String expectedAdress) {

        Assert.assertTrue(createGroupOrderPage.getOfficeAdress().contains(expectedAdress));
    }

    @Then("the user validates {string} text")
    public void the_user_validates_text(String expectedText)throws InterruptedException {
        createGroupOrderPage.clickCreateGroupButton();
        Assert.assertEquals(createGroupOrderPage.getHeaderText(),expectedText);

    }

    @Then("the user validates total participants is {int}")
    public void the_user_validates_total_participants_is(int expectedParticipants) {

        Assert.assertEquals(createGroupOrderPage.getParticipants(),expectedParticipants);
    }
}
