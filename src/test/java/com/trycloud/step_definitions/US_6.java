package com.trycloud.step_definitions;

import com.fasterxml.jackson.core.format.DataFormatDetector;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_6 {

    FilesPage filesPage = new FilesPage();

    @When("the users click action-icon from any file on the page to remove")
    public void the_users_click_action_icon_from_any_file_on_the_page_to_remove() {
        filesPage.actionButton.click();
    }

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        filesPage.verifyNoFavorites();
    }


    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        filesPage.addIcon.click();
    }

    String verifyUploadedFileName = "";
    String uploadedFile = "Screen_Shot.png";

    @When("users uploads file with the upload file option")
    public void users_uploads_file_with_the_upload_file_option() {

        verifyUploadedFileName = uploadedFile;
        BrowserUtils.sleep(2);
        filesPage.uploadButton.sendKeys("/Users/zura/Desktop/" + uploadedFile);
    }

    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        BrowserUtils.sleep(3);
        Driver.getDriver().navigate().refresh();
        Assert.assertTrue(filesPage.allUploadedFileTextNames().contains(uploadedFile));

    }
}