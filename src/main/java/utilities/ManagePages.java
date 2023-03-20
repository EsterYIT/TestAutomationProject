package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.conduit.*;
import pageObjects.conduit.MainPage;
import pageObjects.teamapp.*;

public class ManagePages extends Base{

    public static void initConduit()
    {
        conduitMain = PageFactory.initElements(driver, MainPage.class);
        conduitHeadMenu = PageFactory.initElements(driver, HeadMenuPage.class);
        gitHubPageNavigation = PageFactory.initElements(driver, NavigateGitHubPage.class);
        conduitSignIn = PageFactory.initElements(driver, SignInPage.class);
        conduitSignUp = PageFactory.initElements(driver, SignUpPage.class);
        conduitUserHeadPage = PageFactory.initElements(driver, UserHeadPage.class);
        conduitUserHomePage = PageFactory.initElements(driver, UserHomePage.class);
        newPostPage = PageFactory.initElements(driver, NewPostPage.class);
        settingsPage = PageFactory.initElements(driver, SettingsPage.class);
        userProfile = PageFactory.initElements(driver, UserProfilePage.class);
        mainArticles = PageFactory.initElements(driver, MainArticlesPage.class);
        postComment = PageFactory.initElements(driver, PostCommentPage.class);
        usersToFollow = PageFactory.initElements(driver, UsersToFollowPage.class);
        navigateActive = PageFactory.initElements(driver, NavigateActiveBase.class);
        publishedArticleMain = PageFactory.initElements(driver, PublishedArticleMainPage.class);
        publishedArticleHead = PageFactory.initElements(driver, PublishedArticleHeadPage.class);
        postCommentBase = PageFactory.initElements(driver, PostCommentBasePage.class);
    }

    public static void initNotepad()
    {
        notepadMain = PageFactory.initElements(driver, pageObjects.notepad.MainPage.class);
    }

    public static void initTeamApp()
    {
        teamAppMain = new pageObjects.teamapp.MainPage(mobileDriver);
        newTeamMain = new CreateNewTeamPage(mobileDriver);
        newTeamDetailsMain = new NewTeamDetailsPage(mobileDriver);
        drawerMain = new DrawerMain(mobileDriver);
        editProfileActivity = new EditProfileActivity(mobileDriver);
        loginPage = new LoginPage(mobileDriver);
        overViewPage = new OverViewPage(mobileDriver);
    }

    public static void initTodoList()
    {
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
        drawerMainTodo = PageFactory.initElements(driver, pageObjects.todo.DrawerMain.class);
    }
}
