package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.conduit.*;
import pageObjects.teamapp.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Base {

    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;
    protected static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    protected static Date date = new Date();

    //Web
    protected static WebDriver driver;

    //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;


    //Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;


    //pages objects - web
    protected static pageObjects.conduit.MainPage conduitMain;
    protected static HeadMenuPage conduitHeadMenu;
    protected static NavigateGitHubPage gitHubPageNavigation;
    protected static SignInPage conduitSignIn;
    protected static SignUpPage conduitSignUp;
    protected static UserHeadPage conduitUserHeadPage;
    protected static UserHomePage conduitUserHomePage;
    protected static NewPostPage newPostPage;
    protected static SettingsPage  settingsPage;
    protected static UserProfilePage userProfile;
    protected static MainArticlesPage mainArticles;
    protected static PostCommentPage postComment;
    protected static UsersToFollowPage usersToFollow;
    protected static NavigateActiveBase navigateActive;
    protected static PublishedArticleMainPage publishedArticleMain;
    protected static PublishedArticleHeadPage publishedArticleHead;
    protected static PostCommentBasePage postCommentBase;


    //page objects - Desktop
    protected static pageObjects.notepad.MainPage notepadMain;


    //page objects = Mobile
    protected static pageObjects.teamapp.MainPage teamAppMain;
    protected static CreateNewTeamPage newTeamMain;
    protected static NewTeamDetailsPage newTeamDetailsMain;
    protected static DrawerMain drawerMain;
    protected static EditProfileActivity editProfileActivity;
    protected static LoginPage loginPage;
    protected static OverViewPage overViewPage;

    //page objects - Electron
    protected static pageObjects.todo.MainPage todoMain;
    protected static pageObjects.todo.DrawerMain drawerMainTodo;



}
