package org.example.pageObject;

import Abstract_component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOut extends AbstractComponent {
    WebDriver driver;
    public CheckOut(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }




    @FindBy(xpath = "//button[contains(text(),'Checkout')]")
    public WebElement CheckOutButton;

    @FindBy(xpath = "//*[@placeholder='Select Country']")
    public WebElement SelectCountry;

    @FindBy(xpath = "//button//*[@class='ng-star-inserted']")
    public List<WebElement> suggestion;

    @FindBy(xpath = "//*[contains(text(),'Place Order ')]")
    public WebElement placeOrder;

    @FindBy(xpath = "//*[@class='hero-primary']")
    public WebElement confirmationMessage;

    public void finish(){
        Actions a = new Actions(driver);
        a.click(placeOrder).build().perform();
        WaitForElementToBeLocated(By.xpath("//*[@class='hero-primary']"));
        String conf = confirmationMessage.getText();
        System.out.println(conf);

    }






    public void Select_country(String country){
        Actions a = new Actions(driver);
        a.sendKeys(SelectCountry,country).build().perform();
        WaitForElementToBeLocated(By.xpath("//*[@class='ta-results list-group ng-star-inserted']"));
        for(WebElement i : suggestion){
            if(i.getText().equals(country)){
                i.click();
                break;
            }
        }

    }



    public void goToCheckOut(){
        Actions a = new Actions(driver);
        a.moveToElement(CheckOutButton).click().perform();
    }












}
