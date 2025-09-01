package orange.utilites;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;

public class ScreenshotUtilities {

    // Wait until page is fully loaded
    private static void waitForPageLoad(WebDriver driver) {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
            .until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    // Capture Full Page Screenshot with timestamp
    public static String capturescreen(WebDriver driver, String testName) throws IOException {
        waitForPageLoad(driver); // Ensure page fully loaded

        // Timestamp for uniqueness
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String projectPath = System.getProperty("user.dir");
        String screenPath = projectPath + "\\src\\test\\resources\\Orangehrm_Screenshots\\"
                            + testName + "_" + timestamp + ".png";

        // Use AShot for full page screenshot
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);

        File destFile = new File(screenPath);
        ImageIO.write(screenshot.getImage(), "PNG", destFile);

        return screenPath;
    }
}