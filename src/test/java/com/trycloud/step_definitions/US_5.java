package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US_5 {
    LoginPage loginPage = new LoginPage();
    FilesPage filesPage = new FilesPage();

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {


        Driver.getDriver().get(ConfigurationReader.getProperty("loginURl"));
        loginPage.loginTryCloud(ConfigurationReader.getProperty("user3"), ConfigurationReader.getProperty("password"));
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String filesModule) {
        filesPage.allModuleOptionSelection(filesPage.allModuleElements, filesModule);
    }
    @When("the user clicks action-icon from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        BrowserUtils.sleep(3);
        filesPage.actionButton.click();
    }

    @When("user choose the {string} option")
    public void user_choose_the_option(String addToFavorites) {
        BrowserUtils.sleep(3);

        for (WebElement each: filesPage.dropDownElements) {
           if(each.getText().contains(addToFavorites)){
               BrowserUtils.sleep(3);
               each.click();
               break;
           }
        }
//        System.out.println("filesPage.dropDownElements = " + filesPage.dropDownElements);
//        filesPage.dropDownElementsSelection(addToFavorites);
    }

    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String favoriteButton) {
        BrowserUtils.sleep(3);
        filesPage.leftModuleOptionsSelection(favoriteButton);
    }

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        BrowserUtils.sleep(3);
        Assert.assertTrue(filesPage.addedFile.isDisplayed());
    }
}
