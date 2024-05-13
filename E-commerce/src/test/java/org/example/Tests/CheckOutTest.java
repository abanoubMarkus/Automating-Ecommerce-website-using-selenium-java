package org.example.Tests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;


import Abstract_component.AbstractComponent;
import org.example.pageObject.AddToCart;
import org.example.pageObject.Cart;
import org.example.pageObject.CheckOut;
import org.example.pageObject.LoginPage;
import org.example.testComponent.BaseTests;
import org.example.testComponent.Reports;
import org.example.testComponent.Retry;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class CheckOutTest extends BaseTests {


    Cart objCart = new Cart(driver);
    AddToCart Ad = new AddToCart(driver);
    LoginPage objLogin = new LoginPage(driver);
    CheckOut CheckOutObj = new CheckOut(driver);







    @Test(retryAnalyzer = Retry.class)
    public void submitOrderWithStreams(){



        objLogin.go_to();
        objLogin.LoginToApp("abanoub@gmail.com", "Abanoub123#");
        Ad.addItemWithStreams("ADIDAS ORIGINAL");
        org.testng.Assert.assertEquals(Integer.parseInt(Ad.cart.getText()), 1);
        objCart.GoToCart();
        objCart.WaitForElementToBeLocated(By.xpath("//*[@class='cartSection']"));

        Boolean added_to_cart =  objCart.cartProducts.stream().
                anyMatch(i ->i.getText().contains("ADIDAS ORIGINAL"));
        Assert.assertEquals(added_to_cart, Boolean.TRUE);
        CheckOutObj.goToCheckOut();
        CheckOutObj.Select_country("Egypt");
        CheckOutObj.finish();

    }


    @Test(retryAnalyzer = Retry.class)
    public void submitOrderWithAxis() {



        objLogin.go_to();
        objLogin.LoginToApp("abanoub@gmail.com", "Abanoub123#");
        Ad.addItemWithAXIS();
        org.testng.Assert.assertEquals(Integer.parseInt(Ad.cart.getText()), 2);
        objCart.GoToCart();
        objCart.WaitForElementToBeLocated(By.xpath("//*[@class='cartSection']"));

        Boolean added_to_cart =  objCart.cartProducts.stream().
                anyMatch(i ->i.getText().contains("ADIDAS ORIGINAL"));
        Assert.assertEquals(added_to_cart, Boolean.TRUE);
        Boolean added_to_cart2 =  objCart.cartProducts.stream().
                anyMatch(i ->i.getText().contains("gg"));





        System.out.println(added_to_cart2 );
        System.out.println(added_to_cart );
        if(added_to_cart2 == added_to_cart){
            System.out.println("sssss");

        }
        try {
            Assert.assertEquals(added_to_cart2, Boolean.TRUE);

        }catch (AssertionError e){

            Ad.Logout();
        }




        CheckOutObj.goToCheckOut();
        CheckOutObj.Select_country("Egypt");
        CheckOutObj.finish();



    }









}
