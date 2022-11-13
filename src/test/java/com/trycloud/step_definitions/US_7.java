package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_7 {
    FilesPage filesPage = new FilesPage();

    @When("user clicks the add icon on the top")
    public void user_clicks_the_add_icon_on_the_top() {
        filesPage.addIcon.click();
    }

    @When("user click \"new folder”")
    public void user_click_new_folder() {
        BrowserUtils.sleep(1);
        filesPage.addNewFolderBtn.click();
    }

    String folderName = "Hello World";
    Faker faker = new Faker();

    @When("user write a folder name")
    public void user_write_a_folder_name() {
        BrowserUtils.sleep(1);
        filesPage.inputBoxForFolderName.sendKeys(faker.bothify("Hello World-####"));
    }

    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        BrowserUtils.sleep(1);
        filesPage.createNewFolderSubmitBtn.click();
    }
    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(3);
      Assert.assertTrue(filesPage.verifyUploadedFolder());
    }

    @When("user choose a folder from the page")
    public void user_choose_a_folder_from_the_page() {

    }
    @When("the user uploads a file with the upload file option")
    public void the_user_uploads_a_file_with_the_upload_file_option() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




}

