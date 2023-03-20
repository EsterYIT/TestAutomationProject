package workflows;

import extentions.DBActions;
import extentions.UIActions;
import extentions.WaitTimeUnit;
import io.qameta.allure.Step;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class WebFlows extends CommonOps {

    @Step("Business Flow: Sign In")
    public static void signIn(String email, String pass)
    {
        UIActions.click(conduitHeadMenu.getTxt_SignIn());
        UIActions.updateText(conduitSignIn.getField_signInEmail(), email);
        UIActions.updateText(conduitSignIn.getField_signInPassword(), pass);
        UIActions.click(conduitSignIn.getBtn_signIn());
    }

    @Step("Business Flow: Login From DB")
    public static void signInFromDB() throws SQLException {
        String query = "select email, password from users where id=2";
        List<String> cred = DBActions.getCredentials(query);

        UIActions.click(conduitHeadMenu.getTxt_SignIn());
        UIActions.updateText(conduitSignIn.getField_signInEmail(), cred.get(0));
        UIActions.updateText(conduitSignIn.getField_signInPassword(), cred.get(1));
        UIActions.click(conduitSignIn.getBtn_signIn());

//        for(String key: cred.keySet()){
//            UIActions.updateText(conduitSignIn.getField_signInEmail(), key);
//            UIActions.updateText(conduitSignIn.getField_signInPassword(), cred.get(key));
//            UIActions.click(conduitSignIn.getBtn_signIn());
//            WaitTimeUnit.threeSecondWait();
//        }
    }

    @Step("Business Flow: Sign Up")
    public static void signUp(String username,String email, String pass)
    {
        UIActions.click(conduitHeadMenu.getTxt_SignUp());
        UIActions.updateText(conduitSignUp.getField_signUpUsername(), username);
        UIActions.updateText(conduitSignUp.getField_signUpEmail(), email);
        UIActions.updateText(conduitSignUp.getField_signUpPassword(), pass);
        UIActions.click(conduitSignUp.getBtn_signUp());
    }

    @Step("Business Flow: Logout")
    public static void logout()
    {
        UIActions.click(conduitUserHeadPage.getTxt_settings());
        UIActions.javaScriptExecutor(settingsPage.getBtn_logout());
        UIActions.click(settingsPage.getBtn_logout());
    }

    @Step("Business Flow: Follow")
    public static void follow()
    {
        UIActions.click(conduitUserHomePage.getNav_globalFeed());
        UIActions.click(conduitUserHomePage.getTxt_articleAuthor().get(0));
        UIActions.click(usersToFollow.getBtn_follow());
    }

    @Step("Business Flow: Unfollow")
    public static void Unfollow()
    {
        UIActions.click(conduitUserHomePage.getNav_globalFeed());
        WaitTimeUnit.Five00_MilliSecondWait();
        UIActions.click(conduitUserHomePage.getTxt_articleAuthor().get(0));
        UIActions.click(usersToFollow.getBtn_unFollow());
    }

    @Step("Business Flow: Write Comment")
    public static int writeComment(String comment) {

        WaitTimeUnit.twoSecondWait();
        UIActions.click(conduitUserHomePage.getPopular_tags().get(0));
        UIActions.click(conduitUserHomePage.getTxt_articles().get(0));

        int commentListSize=postComment.getComments_list().size();
        UIActions.updateText(postComment.getField_comment(), comment);
        UIActions.click(postComment.getBtn_postComment());
        WaitTimeUnit.Five00_MilliSecondWait();
        driver.navigate().refresh();

        return commentListSize;
    }

    @Step("Business Flow: Delete Comment")
    public static int deleteComment() {

        WaitTimeUnit.twoSecondWait();
        UIActions.click(conduitUserHomePage.getPopular_tags().get(0));
        UIActions.click(conduitUserHomePage.getTxt_articles().get(0));

        int commentListSize = postComment.getComments_list().size();
        UIActions.javaScriptExecutor(postComment.getDelete_comment());
        UIActions.click(postComment.getDelete_comment());
        WaitTimeUnit.Five00_MilliSecondWait();
        driver.navigate().refresh();

        return commentListSize;
    }
    @Step("Verify Element Visually")
    public static void visualElement(String expectedImgName) throws FindFailed {
        WebFlows.logout();
        WaitTimeUnit.threeSecondWait();
        driver.navigate().refresh();
        UIActions.javaScriptExecutor(conduitMain.getNav_pages().get(19));
        screen.click(getData("ImageRepo") + expectedImgName + ".PNG");
        WaitTimeUnit.twoSecondWait();
    }
}
