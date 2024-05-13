package org.example.Tests;

import org.example.pageObject.LoginPage;
import org.example.testComponent.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class LoginTest extends BaseTests {

    WebDriver driver = InitializeBrowser();
    LoginPage objLogin = new LoginPage(driver);


    public void ValidLogin(){
        objLogin.go_to();
        objLogin.LoginToApp("abanoub@gmail.com","Abanoub123#");

        //objLogin.ValidAssertions();
        //System.out.println(objLogin.confirmation.getText());

    }


    public void InValidLogin(){
        objLogin.go_to();
        objLogin.LoginToApp("abanoub@gmail.com","Abanosssub123#");
        //objLogin.InValidAssertions();
        //System.out.println(objLogin.confirmation.getText());

    }


}
