package sanity;

import extentions.UIVerifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;


@Listeners(utilities.Listeners.class)
public class ApiGithub extends CommonOps {

    @Test(description = "Test01 - Verify Repo Name")
    @Description("Verifies the name of the repository in the second place")
    public void test01_verifyGetCommand()
    {
        UIVerifications.verifyTextInText(ApiFlows.getTeamProperty("name[2]"),"TestAutomation");
    }

    @Test(description = "Test02 - Verify Repo Is Created")
    @Description("This test adds new repository to Github and verifies it")
    public void test02_verifyPostCommand()
    {
        ApiFlows.postNewRepo("Hello-World","My First Repo From Rest Api Using Rest Assured");
        UIVerifications.verifyTextInText(ApiFlows.getTeamProperty("name[0]"),"Hello-World");
    }

    @Test(description = "Test03 - Update Repo And Verify")
    @Description("This test updates repository data in Github and verifies it")
    public void test03_verifyPutCommand()
    {
        String repoNameToUpdate = ApiFlows.getTeamProperty("name[0]");
        ApiFlows.updateRepoData("Hello-World-Updated",repoNameToUpdate);
        UIVerifications.verifyTextInText(ApiFlows.getTeamProperty("name[0]"),"Hello-World-Updated");
    }

    @Test(description = "Test04 - Verify DELETE Status Code = 204")
    @Description("Verifies the return status code of DELETE command")
    public void test04_verifyDeleteCommand()
    {
        ApiFlows.deleteRepo();
        UIVerifications.verifyNumber(response.getStatusCode(),204);
    }
}
