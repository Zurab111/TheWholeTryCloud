package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.an.E;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FilesPage extends BasePage {

    public FilesPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']//a")
    public List<WebElement> allModuleElements;

    public void allModuleOptionSelection(List<WebElement> allMainElements, String particularModule) {
        for (WebElement element : allModuleElements) {
            if (element.getAttribute("aria-label").equals(particularModule)) {
                element.click();
                break;
            }
        }
    }

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public WebElement actionButton;


    @FindBy(xpath = "//div[@class='fileActionsMenu popovermenu bubble open menu']//span")
    public List<WebElement> dropDownElements;

    public void dropDownElementsSelection(String particularElement) {
        for (WebElement each : dropDownElements) {
            if (each.getText().equals(particularElement))
                each.click();
            break;

        }
    }

    @FindBy(xpath = "//ul[@class='with-icon']/li/a")
    public List<WebElement> filePageModuleOptions;


    public void leftModuleOptionsSelection(String particularElement) {
        for (WebElement each : filePageModuleOptions) {
            if (each.getText().equals(particularElement)) {
                each.click();
                break;
            }
        }
    }

    @FindBy(xpath = "//td[@class='filename']")
    public WebElement addedFile;


    public boolean verifyItem() {
        if (!addedFile.isDisplayed()) {
            return false;
        }
        return true;
    }


    //------------------US4 TC2
    @FindBy(xpath = "//th[@id='headerSelection']")
    public WebElement mainCheckBox;

    //
    //label[contains(@for,'select-files')]/../input
    @FindBy(xpath = "(//tbody[@id='fileList']/tr/td//label)/../input")
    public List<WebElement> allCheckBoxes;

    public void assertCheckBoxesSelected() {
        for (WebElement each : allCheckBoxes) {
            Assert.assertTrue(each.isSelected());
        }
    }


    //-----------------US6 TC1

    @FindBy(xpath = "//div[@class='icon-starred']")
    public WebElement verifyNoFavoriteFiles;

    public boolean verifyNoFavorites() {

        if (verifyNoFavoriteFiles.getAttribute("class").equals("icon-starred")) {
            return true;
        }
        return false;
    }

    // -----------US6 TC2


    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement addIcon;


    @FindBy(xpath = "//input[@type ='file']")
    public WebElement uploadButton;


    @FindBy(xpath = "//tbody[@id='fileList']/tr")
    public List<WebElement> listOfUploadedFiles;


    public List<String> allUploadedFileTextNames() {
        List<String> listNames = new ArrayList<>();

        for (WebElement each : listOfUploadedFiles) {
            listNames.add(each.getAttribute("data-file"));
        }
        return listNames;
    }


    //--------------------US7 TC1
    @FindBy(xpath = "//span[.='New folder']")
    public WebElement addNewFolderBtn;


    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement inputBoxForFolderName;


    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement createNewFolderSubmitBtn;

    public boolean verifyUploadedFolder() {
        boolean result = false;
        for (String each : allUploadedFileTextNames()) {
            if (each.contains("Hello World")) {
                result = true;
            }
        }
        return result;
    }
}