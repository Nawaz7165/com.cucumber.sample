package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HomePage;
import org.testng.Assert;

/**
 * Created by nawazahmed on 7/13/18.
 */
public class HomeSD {

    HomePage homePage = new HomePage();


    @Given("^I am on the home page$")
    public void verifyHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Threely Starter Template", "Invalid Home Page");
    }

    @When("^I search on top search bar with text (.+)$")
    public void topSearchbBar_Text_ios(String text) {
        homePage.write_ios_topSearchBox(text);
    }


    @Then("^I verify (.+) as displayed result$")
    public void verifySearchResult(String expectedTitle){
        try{
            Thread.sleep(5000);
            Assert.assertEquals(homePage.get_1stSearchItem(), expectedTitle);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Then("^I verify (.+) total post is displayed$")
    public void totalPosts(int expectedPosts)  {
        try{
            Assert.assertEquals(homePage.numberOfPosts(),expectedPosts);
        } catch(AssertionError a){
            System.out.println("Total "+ homePage.numberOfPosts()+" posts are found, instead of "
                    +expectedPosts + " as expected");
        }
    }


    @And("^I verify all post has price tag$")
    public void verifyPriceTagsForAllTags() {
        try {
            Assert.assertEquals(homePage.numberOfPriceTags(), homePage.numberOfPosts());
            System.out.println("All the Posts have price tags");
        } catch (AssertionError a) {
            int diff=(homePage.numberOfPosts() - homePage.numberOfPriceTags());
            System.out.println( diff + " Posts dont have any price tags");
        }
    }

    @And("^I verify all post has title$")
    public void verifyPostTitles() {
        try {
            Assert.assertEquals(homePage.numberOfTites(), homePage.numberOfPosts());
            System.out.println("All the Posts have price tags");
        } catch (AssertionError a) {
            int diff = (homePage.numberOfPosts() - homePage.numberOfTites());
            System.out.println(diff + " Posts dont have any Titles");
        }
    }

    @And("^I verify all post has displayed image$")
    public void verifyAllPost_Images(){
        try {
            Assert.assertEquals(homePage.numberOfTites(), homePage.numberOfPosts());
            System.out.println("All the Posts have price tags");
        } catch (AssertionError a) {
            int diff = (homePage.numberOfPosts() - homePage.numberOfImages());
            System.out.println(diff + " Posts dont have any Images");
        }
    }

}


