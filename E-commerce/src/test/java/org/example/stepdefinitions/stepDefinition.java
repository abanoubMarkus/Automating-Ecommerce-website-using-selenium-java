package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.AddToCart;
import org.example.pageObject.Cart;
import org.example.pageObject.CheckOut;
import org.example.pageObject.LoginPage;
import org.example.testComponent.BaseTests;
import org.openqa.selenium.By;

public class stepDefinition extends BaseTests {

    Cart objCart = new Cart(driver);
    AddToCart Ad = new AddToCart(driver);
    LoginPage objLogin = new LoginPage(driver);
    CheckOut CheckOutObj = new CheckOut(driver);



    @Given("I landed on Ecommerce page")
    public void landed(){
        objLogin.go_to();
    }

    @Given("^logged in with (.+) and password (.+)$")
    public void LogG(String username , String password){
        objLogin.LoginToApp(username, password);
    }

    @When("^i add product (.+)$")
    public void addProductG(String pro){
        Ad.addItemWithForLoops(pro);
    }

    @And("^check out (.+)$")
    public void checkAnd(){

        org.testng.Assert.assertEquals(Integer.parseInt(Ad.cart.getText()), 1);
        objCart.GoToCart();
        objCart.WaitForElementToBeLocated(By.xpath("//*[@class='cartSection']"));
        CheckOutObj.goToCheckOut();
        CheckOutObj.Select_country("Egypt");


    }


    @Then("message is displayed")
    public void conff(){
        CheckOutObj.finish();
    }

}
