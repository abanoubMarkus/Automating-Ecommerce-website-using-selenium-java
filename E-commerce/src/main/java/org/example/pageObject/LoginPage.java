package org.example.pageObject;

import Abstract_component.AbstractComponent;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    //add userName
    @FindBy(id="userEmail")
    public WebElement UserName;
    //add password
    @FindBy(id = "userPassword")
    public WebElement pass;
    //click on login
    @FindBy(id ="login")
    public WebElement loginButton;

    @FindBy(id = "toast-container")
    public  WebElement confirmation;







       public void LoginToApp(String username, String password){

        UserName.sendKeys(username);
        pass.sendKeys(password);
        loginButton.click();

    }

    public void ValidAssertions(){
           WaitForElementToBeLocated(By.xpath("//div[@id='toast-container']"));
           Assert.assertEquals(confirmation.getText(), "Login Successfully");

    }

    public void InValidAssertions(){
        WaitForElementToBeLocated(By.xpath("//div[@id='toast-container']"));
        Assert.assertEquals(confirmation.getText(), "Incorrect email or password.");

    }


    //creating method to go to URL
    public void go_to(){
        //go to URl
        driver.get("https://rahulshettyacademy.com/client/");
    }





}
