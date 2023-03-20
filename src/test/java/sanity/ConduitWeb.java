package sanity;

import extentions.UIVerifications;
import jdk.jfr.Description;
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

    @Test(description = "Test02 - Verify Logout")
    @Description("Verifies the logout")
    public void test02_verifyLogout()
    {
        WebFlows.signIn(getData("userName"),getData("password"));
        WebFlows.logout();
        UIVerifications.verifyTextElement(conduitMain.getTxt_subtitle(),"A place to share your knowledge.");
    }

    @Test(description = "Test03 - Verify Follow Button")
    @Description("Verifies that follow button is clicked")
    public void test03_verifyFollow()
    {
        WebFlows.signIn(getData("userName"),getData("password"));
        WebFlows.follow();
        UIVerifications.verifyFollowOrUnfollowElement(usersToFollow.getBtn_unFollow(), "Unfollow");
    }

    @Test(description = "Test04 - Verify Unfollow Button")
    @Description("Verifies that unfollow button is clicked")
    public void test04_verifyUnFollow()
    {
        WebFlows.signIn(getData("userName"),getData("password"));
        WebFlows.Unfollow();
        UIVerifications.verifyFollowOrUnfollowElement(usersToFollow.getBtn_follow(), "Follow");
    }

    @Test(description = "Test05 - Verify Written A Comment")
    @Description("Verifies comment has been written")
    public void test05_verifyCommentIsWritten() throws InterruptedException {
        WebFlows.signIn(getData("userName"),getData("password"));
        int commentListSize = WebFlows.writeComment("Test");
        UIVerifications.verifyNumberOfComments(postComment.getComments_list(),commentListSize+1);
    }

    @Test(description = "Test06 - Verify Deleted Comment")
    @Description("Verifies comment has been deleted")
    public void test06_verifyCommentDeleted() throws InterruptedException {
        WebFlows.signIn(getData("userName"),getData("password"));
        int commentListSize = WebFlows.deleteComment();
        UIVerifications.verifyNumberOfComments(postComment.getComments_list(),commentListSize-1);
    }

    @Test(description = "Test07 - Verify Click On An Image")
    @Description("This test verifies click on image using sikuli tool, and move to the requested page")
    public void test07_verifyImageWasClicked() throws FindFailed {
        WebFlows.visualElement("PageTwenty");
        UIVerifications.verifyAClickOnVisualElement("20");
    }

    @Test(description = "Test08 - Verify Popular Tags")
    @Description("This test verifies the default Popular Tags are displayed (using soft assertion)")
    public void test08_verifyPopularTags()
    {
        UIVerifications.visibilityOfElements(conduitMain.getPopular_tags());
    }
}
