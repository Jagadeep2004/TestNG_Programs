package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class ScreenshotUtility {

    public static void capture(String fileName) {

        try {

            File src = ((TakesScreenshot)
                    BaseClass.driver)
                    .getScreenshotAs(OutputType.FILE);

            File dest = new File(
            "screenshots/" + fileName + ".png");

            FileUtils.copyFile(src, dest);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}