package org.example.Tests;

import Abstract_component.AbstractComponent;
import org.example.pageObject.AddToCart;
import org.example.pageObject.Cart;
import org.example.pageObject.LoginPage;
import org.example.testComponent.BaseTests;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CartTest extends BaseTests {

    WebDriver driver = InitializeBrowser();
    Cart objCart = new Cart(driver);
    AddToCart Ad = new AddToCart(driver);
    LoginPage objLogin = new LoginPage(driver);


    @Test
    public void addedToCart(){
        objLogin.go_to();
        objLogin.LoginToApp("abanoub@gmail.com", "Abanoub123#");
        Ad.addItemWithStreams("ADIDAS ORIGINAL");
        org.testng.Assert.assertEquals(Integer.parseInt(Ad.cart.getText()), 1);
        objCart.GoToCart();
        objCart.WaitForElementToBeLocated(By.xpath("//*[@class='cartSection']"));

        Boolean added_to_cart =  objCart.cartProducts.stream().
                anyMatch(i ->i.getText().contains("ADIDAS ORIGINAL"));
        Assert.assertEquals(added_to_cart, Boolean.TRUE);
    }










}
