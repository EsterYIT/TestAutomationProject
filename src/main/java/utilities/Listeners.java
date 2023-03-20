package utilities;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listeners extends CommonOps implements ITestListener {
    public void onStart(ITestContext execution) {
        System.out.println("---------------------- Starting Execution ------------------");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("---------------------- Ending Execution ------------------");
    }

    public void onTestStart(ITestResult test) {
        System.out.println("---------------------- Test: " + test.getName() + " Started ------------------");
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("---------------------- Test: " + test.getName() + " Passed ------------------");
        if(!platform.equalsIgnoreCase("api")) {
            // Stop recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            //Delete recorded file
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete())
                System.out.println("File deleted successfully");
            else
                System.out.println("Failed to delete file");
        }
    }

    public void onTestFailure(ITestResult test) {
        System.out.println("---------------------- Test "  + test.getName() + " Failed ------------------");
        if(!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                saveScreenshot(test);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

    public void onTestSkipped(ITestResult test) {
        System.out.println("--------- Skipping Test: " + test.getName() + " -----------");
    }
    public void saveScreenshot(ITestResult test) throws IOException {
            if (!platform.equalsIgnoreCase("mobile")) {
                Allure.getLifecycle().addAttachment(
                        test.getName(), "image/png", "png",
                        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
                );
            } else {
                Allure.getLifecycle().addAttachment(
                        test.getName(), "image/png", "png",
                        ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES)
                );
            }

    }
}

