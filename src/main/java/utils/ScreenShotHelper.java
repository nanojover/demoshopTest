package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenShotHelper {
    public static void takeScreenShot(WebDriver driver) {
        try
        {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
