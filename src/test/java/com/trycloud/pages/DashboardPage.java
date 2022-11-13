package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage extends BasePage{



@FindBy(xpath = "//ul[@id='appmenu']/li")
    public List<WebElement> allMoules;


    public List<String> mainModulesText(){
        List<String> modulesText=new ArrayList<>();
        for (int i = 0; i < allMoules.size()-1; i++) {
            BrowserUtils.hover(allMoules.get(i));
            BrowserUtils.sleep(3);
            modulesText.add(allMoules.get(i).getText());

            }
        return modulesText;
        }



}
