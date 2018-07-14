package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HomePage;
import framework.LoginPage;
import org.testng.Assert;

/**
 * Created by nawazahmed on 7/13/18.
 */
public class LoginSD {

    HomePage homePage= new HomePage();
    LoginPage loginPage= new LoginPage();

    @Given("^User is on the Threely login page$")
    public void imOnTheLogInPage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Threely Starter Template",
                "Page Titile is not mathced");
    }

    @When ("^I enter username as (.+) and password as (.+)$")
    public void enterTextToTextField(String email, String password){

        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
    }

    @And("^I click on submit button$")
    public void clickOnSubmitButton(){
        loginPage.clickSubmitButton();
    }

    @Then("^I verify logout button is displayed$")
    public void verifyLogOutButton(){
        homePage.clickAccountLogo();
        Assert.assertTrue(homePage.isVisibleLogoutTab(), "Logout tab is missing");
    }


}
