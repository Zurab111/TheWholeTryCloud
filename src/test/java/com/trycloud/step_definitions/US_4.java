package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_4 {

    FilesPage filesPage = new FilesPage();

    @Then("verify the page title is \"Files - Trycloud QA.”")
    public void verify_the_page_title_is_files_trycloud_qa() {

        Assert.assertEquals("Files - Trycloud QA", Driver.getDriver().getTitle());
    }

    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
filesPage.mainCheckBox.click();
    }

    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
filesPage.assertCheckBoxesSelected();
    }

}
