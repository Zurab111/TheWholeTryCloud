package com.trycloud.step_definitions;

import com.trycloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {




    public void setupScenario(){
        System.out.println(" 1 Setting up browser using cucumber @Before each scenario");
    }


    @After
    public void teardownScenario(Scenario scenario){  // passing scenario arumment
        // We will implement taking screenshot in this method

        if (scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());

        }

Driver.closeDriver();
    }
}
