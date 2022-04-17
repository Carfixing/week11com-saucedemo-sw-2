package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid(){
        //find the username field element
        WebElement userField1 = driver.findElement(By.id("user-name"));
        //sending username  to username field element
        userField1.sendKeys("standard_user");

        //find the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        //sending password to password field element
        passwordField.sendKeys("secret_sauce");

        //Click on Login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //Verify the text “PRODUCTS”
        WebElement secureArea = driver.findElement(By.className("title"));
        System.out.println(secureArea.getText());
        Assert.assertEquals("Incorrect Login detail", "PRODUCTS", secureArea.getText());
    }

     @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
         //find the username field element
         WebElement userField1 = driver.findElement(By.id("user-name"));
         //sending username  to username field element
         userField1.sendKeys("standard_user");

         //find the password field element
         WebElement passwordField = driver.findElement(By.name("password"));
         //sending password to password field element
         passwordField.sendKeys("secret_sauce");

         //Click on Login button
         WebElement loginButton = driver.findElement(By.id("login-button"));
         loginButton.click();

         //Verify the text “PRODUCTS”
         WebElement secureArea = driver.findElement(By.className("title"));
         System.out.println(secureArea.getText());
         Assert.assertEquals("Incorrect Login detail", "PRODUCTS", secureArea.getText());

         //* Verify that six products are displayed on page
        List<WebElement> verifydisplaylist = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']\n"));
         System.out.println("Item display  : "  +  verifydisplaylist.size());

         for(WebElement itemcount : verifydisplaylist){
             System.out.println("Total number of item display  : " + itemcount);
         }
     }

}
