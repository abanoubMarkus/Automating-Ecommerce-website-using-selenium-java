package org.example.pageObject;

import Abstract_component.AbstractComponent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Cart extends AbstractComponent {
    WebDriver driver;
    public Cart(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//*[@class='btn btn-custom']//label")
    public WebElement goToCart;

    @FindBy(xpath = "//*[@class='cartSection']")
    public List<WebElement> cartProducts;

    public void GoToCart()  {
        WaitForElementToDisappear(By.xpath("//ngx-spinner"));
        goToCart.click();
    }













}
