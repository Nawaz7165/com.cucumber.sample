package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nawazahmed on 7/13/18.
 */
public class HomePage extends BasePage{

    private By accountLogo   =By.xpath("//a[@role='button']//img[@class='img-circle']");
    private By logOutTab     =By.xpath("//a[contains(text(),'Logout')]");
    private By topSearchBox  =By.xpath("//input[@id='aa-search-input']");
    private By _1stSearchItem=By.xpath("//*[@class='aa-dataset-1']");
    private By posts         =By.xpath("//*[@class='container section']//*[@class='col-md-3']");
    private By pricetag      =By.xpath("//h3/.");
    private By postTitle     =By.xpath("//h4/.");
    private By images        =By.xpath("//h4/.");



    public boolean isVisibleAccountLogo(){
        return isDisplayed(accountLogo);
    }

    public void clickAccountLogo(){
        clickOn(accountLogo);
    }

    public boolean isVisibleLogoutTab(){
        return isDisplayed(logOutTab);
    }

    public void write_ios_topSearchBox(String text){
        sendText(topSearchBox, text);
    }

    public String get_1stSearchItem(){
        return getTextFromElement(_1stSearchItem);
    }

    public int numberOfPosts(){
        List li=findElementAsList(posts);
        ArrayList aL= new ArrayList<>(li);
        int numOfPosts= aL.size();
        return numOfPosts;

    }

    public int numberOfPriceTags(){
        List <WebElement>priceTagList= findElementAsList(pricetag);
        ArrayList <WebElement> al= new ArrayList (priceTagList);
        ArrayList <String> newAl= new ArrayList();
        String s=null;
        for (int i=0; i<al.size(); i++){
            s= al.get(i).getText();
            if (s.length()>=2){
                newAl.add(s);
            }

        }

        return newAl.size();
    }

    public int numberOfTites(){
        List <WebElement>postTitles= findElementAsList(postTitle);
        ArrayList <WebElement> al= new ArrayList (postTitles);
        ArrayList <String> newAl= new ArrayList();
        String s=null;
        for (int i=0; i<al.size(); i++){
            s= al.get(i).getText();
            if (s.length()>=1){
                newAl.add(s);
            }

        }
        return newAl.size();
    }

    public int numberOfImages(){
        List <WebElement>itemImage= findElementAsList(images);
        ArrayList <WebElement> al= new ArrayList (itemImage);

        for (int i=0; i<al.size(); i++) {
        }
        return al.size();
    }




}













