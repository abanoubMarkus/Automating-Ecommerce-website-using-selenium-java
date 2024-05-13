package org.example.Tests;

import Abstract_component.AbstractComponent;
import org.example.pageObject.AddToCart;
import org.example.pageObject.LoginPage;
import org.example.testComponent.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTests {

    WebDriver driver = InitializeBrowser();

    AddToCart Ad = new AddToCart(driver);
    LoginPage objLogin = new LoginPage(driver);


    public void AddWithAxis(){
        objLogin.go_to();
        objLogin.LoginToApp("abanoub@gmail.com", "Abanoub123#");
        Ad.addItemWithAXIS();
        Assert.assertEquals(Integer.parseInt(Ad.cart.getText()), 2);

    }



    public void AddWithStreams(){
        objLogin.go_to();
        objLogin.LoginToApp("abanoub@gmail.com", "Abanoub123#");
        Ad.addItemWithStreams("ADIDAS ORIGINAL");
        Assert.assertEquals(Integer.parseInt(Ad.cart.getText()), 1);

    }


    public void AddWithForLoops(){
        objLogin.go_to();
        objLogin.LoginToApp("abanoub@gmail.com", "Abanoub123#");
        Ad.addItemWithForLoops("ADIDAS ORIGINAL");
        Ad.addItemWithForLoops("IPHONE 13 PRO");
    }


    public void dd(){
        objLogin.go_to();
        objLogin.LoginToApp("abanoub@gmail.com", "Abanoub123#");
        AddWithStreams();
        Ad.Logout();
    }









     }












