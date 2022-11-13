package com.trycloud.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserUtils {


    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception happened in sleep method");
        }
    }

//public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){
//
//    Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
//
//    for (String eachWindow : allWindowHandles) {
//        // syntax will switch each windows and drivers will be able
//       Driver.getDriver().switchTo().window(eachWindow);
//       if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
//           break;
//       }
//    }
//    String actualTitle = Driver.getDriver().getTitle();
//    Assert.assertTrue("Title verification failed!", actualTitle.contains(expectedTitle));

//}


    //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle


    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());

        //  Assert.assertEquals(actualTitle, expectedTitle);
    }


    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }


}
