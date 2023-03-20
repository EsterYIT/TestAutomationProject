package sanity;

import extentions.UIVerifications;
import extentions.WaitTimeUnit;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import java.sql.SQLException;

@Listeners(utilities.Listeners.class)
public class ConduitWebDB extends CommonOps {

    @Test(description = "Test01 - Login to grafana with DB credentials")
    @Description("This test login  with DB credentials and verifies user name")
    public void test01_loginDBAndVerifyUsername() throws SQLException {
        WebFlows.signInFromDB();
        WaitTimeUnit.twoSecondWait();
        int size = conduitUserHeadPage.getList_headPage().size();
        WebElement username = conduitUserHeadPage.getList_headPage().get(size-1);
        UIVerifications.verifyTextInText(username.getText(),"liron");
    }
}
