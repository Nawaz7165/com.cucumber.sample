package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HomePage;
import framework.SignupPage;
import org.testng.Assert;

/**
 * Created by nawazahmed on 7/13/18.
 */
public class SignupSD {

    private HomePage homePage = new HomePage();
    private SignupPage loginPage = new SignupPage();

    String Email=null;

    @Given("^I am on Registration page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Threely Starter Template", "Invalid Home Page");
    }

    @When("^I enter name as (.+) email as (.+) password as (.+)$")
    public void enterDataIntoTextFields(String userName,String email, String password) {
        loginPage.enterUserName(userName);
        loginPage.enterEmail(email);
        this.Email = email;
        loginPage.enterPassword(password);
    }

    @And("^I click submit button$")
    public void clickSubmitButton() {
        loginPage.submitButton();
    }

    @Then("^I am signed-in as a new user$")
    public void verifySuccessfulLogIn() {
        Assert.assertTrue(homePage.isVisibleAccountLogo());
    }

    @Then("^I verify invalid email address$")
    public void invalidEmail() {
        System.out.println("Testing email : "+ Email);
        try{Assert.assertTrue(loginPage.verifyInvalidLogIn());
        }catch(Exception e){
            System.out.println("Testing email : "+ Email);
            System.out.println(" This should be a bug ! Invalid email address is registered");
            e.printStackTrace();}
    }




}

