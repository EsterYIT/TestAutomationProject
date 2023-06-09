package sanity;

import extentions.UIVerifications;
import io.qameta.allure.Description;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDDT;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class ConduitWeb extends CommonOps {

    @Test(description = "Test01 - Verify Sign In", dataProvider = "data-provider-users" , dataProviderClass = ManageDDT.class)
    @Description("Verifies the sign in header with DDT")
    public void test01_verifySignInHeader(String email, String password)
    {
        WebFlows.signIn(email,password);
        UIVerifications.verifyTextElement(conduitUserHomePage.getNav_yourFeed(),"Your Feed");
    }

    @Test(description = "Test02 - Verify Follow Button")
    @Description("Verifies that follow button is clicked")
    public void test02_verifyFollow()
    {
        WebFlows.signIn(getData("userName"),getData("password"));
        WebFlows.follow();
        UIVerifications.verifyFollowOrUnfollowElement(usersToFollow.getBtn_unFollow(), "Unfollow");
    }

    @Test(description = "Test03 - Verify Unfollow Button")
    @Description("Verifies that unfollow button is clicked")
    public void test03_verifyUnFollow()
    {
        WebFlows.signIn(getData("userName"),getData("password"));
        WebFlows.Unfollow();
        UIVerifications.verifyFollowOrUnfollowElement(usersToFollow.getBtn_follow(), "Follow");
    }

    @Test(description = "Test04 - Verify Written A Comment")
    @Description("Verifies comment has been written")
    public void test04_verifyCommentIsWritten() throws InterruptedException {
        WebFlows.signIn(getData("userName"),getData("password"));
        int commentListSize = WebFlows.writeComment("Test");
        UIVerifications.verifyNumberOfComments(postComment.getComments_list(),commentListSize+1);
    }

    @Test(description = "Test05 - Verify Deleted Comment")
    @Description("Verifies comment has been deleted")
    public void test05_verifyCommentDeleted() throws InterruptedException {
        WebFlows.signIn(getData("userName"),getData("password"));
        int commentListSize = WebFlows.deleteComment();
        UIVerifications.verifyNumberOfComments(postComment.getComments_list(),commentListSize-1);
    }

    @Test(description = "Test06 - Verify Click On An Image")
    @Description("This test verifies click on image using sikuli tool, and move to the requested page")
    public void test06_verifyImageWasClicked() throws FindFailed {
        WebFlows.visualElement("PageTwenty");
        UIVerifications.verifyAClickOnVisualElement("20");
    }

    @Test(description = "Test07 - Verify Popular Tags")
    @Description("This test verifies the default Popular Tags are displayed (using soft assertion)")
    public void test07_verifyPopularTags()
    {
        UIVerifications.visibilityOfElements(conduitMain.getPopular_tags());
    }
}
