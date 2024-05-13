package org.example.pageObject;

import Abstract_component.AbstractComponent;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddToCart extends AbstractComponent {
    WebDriver driver;
    public AddToCart(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }


    @FindBy(xpath = "//*[contains(text(),'ADIDAS ORIGINAL')]//parent::h5//parent::div//button[2]")
    public WebElement firstItemWithAXIS;

    @FindBy(xpath = "//*[contains(text(),'IPHONE 13 PRO')]//parent::h5//parent::div//button[2]")
    public WebElement secondItemWithAXIS;

    @FindBy(css = ".mb-3")
    public List<WebElement> products;

    @FindBy(xpath = "//*[contains(text(),'Cart')]//label")
    public WebElement cart;

    @FindBy(xpath = "//*[contains(text(),'Sign Out')]")
    public WebElement Signout;



    public void Logout(){
        WaitForElementToBeClickable(By.xpath("//*[contains(text(),'Sign Out')]"));
        Signout.click();

    }




    //add to cart function
    public void addItemWithAXIS(){
        WaitForElementToBeClickable(By.cssSelector(".mb-3"));
        firstItemWithAXIS.click();
        WaitForElementToBeLocated(By.xpath("//ngx-spinner"));
        WaitForElementToDisappear(By.xpath("//*[@id='toast-container']"));
        secondItemWithAXIS.click();
        WaitForElementToDisappear(By.xpath("//ngx-spinner"));

    }


    //add items using Streams
    public void addItemWithStreams(String item){

        WaitForElementToBeClickable(By.cssSelector(".mb-3"));
        WebElement product = products.stream().filter(i -> i.findElement(By.cssSelector("b")).
                getText().equals(item)).findFirst().orElse(null);
        assert product != null;
        product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        WaitForElementToDisappear(By.xpath("//ngx-spinner"));


    }



    public void addItemWithForLoops(String item){
        WaitForElementToBeClickable(By.cssSelector(".mb-3"));
        for(WebElement product : products){

            String name = product.findElement(By.cssSelector("b")).getText();
            System.out.println(name);
            if(name.equals(item)){
                System.out.println(name);
                product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
                WaitForElementToBeLocated(By.xpath("//ngx-spinner"));
            }
            break;

        }


    }

















}
