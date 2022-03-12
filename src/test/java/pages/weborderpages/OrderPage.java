package pages.weborderpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "ConfirmAddressID")
    private WebElement deliveryOption;

    @FindBy(xpath = "//label[@class='custom-control-label']")
    private WebElement groupOrderBox;

    @FindBy(id ="getAddressNextButton")
    private WebElement nexButton;



    public void getDeliveryOption(String option){
        BrowserUtils.selectBy(deliveryOption,option,"text");
    }
    public void clickGroupOrder(){
        groupOrderBox.click();
    }
    public void clickNextButton(){
        nexButton.click();
    }
}
