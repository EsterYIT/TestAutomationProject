package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base{

    /*
    ##################################################
    Method Name: getData
    Method Description: This method get the data from xml configuration file
    Method Parameters: String
    Method Return: String
    #################################################
    */
    public static String getData(String name)
    {
        File XMLFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;

        try{
            XMLFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(XMLFile);
            doc.getDocumentElement().normalize();
        }catch (Exception e) {
            System.out.println("Error in reading XML file: " + e);
        }
        finally {
            return doc.getElementsByTagName(name).item(0).getTextContent();
        }
    }

    private static void initBrowser(String browserType)
    {
        if(browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if(browserType.equalsIgnoreCase("firefox"))
            driver = initFireFoxDriver();
        else if(browserType.equalsIgnoreCase("ie"))
            driver = initIeDriver();
        else
            throw new RuntimeException("Invalid browser type");

        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("Url"));
        ManagePages.initConduit();
        action = new Actions(driver);
    }

    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFireFoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIeDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) throws MalformedURLException {
        platform = PlatformName;
        if(platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if(platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else if(platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if(platform.equalsIgnoreCase("electron"))
            initElectron();
        else if(platform.equalsIgnoreCase("api"))
            initApi();
        else
            throw new RuntimeException("Invalid platform name");
        softAssert = new SoftAssert();
        screen = new Screen();

        ManageDB.openConnection(getData("DBUrl"),getData("DBUsername"),getData("DBPassword"));
    }

    public static void initApi() {
        RestAssured.baseURI = getData("urlApi");
        httpRequest = RestAssured.given().auth().oauth2(getData("token"));
    }

    public static void initElectron() {

        System.setProperty("webdriver.chrome.driver",getData("electronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("electronAppPath"));
        dc.setCapability("chromeOptions",opt);
        dc.setBrowserName("chrome");
        opt.merge(dc);
        driver = new ChromeDriver(opt);
        ManagePages.initTodoList();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")),TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
    }

    private void initMobile() {
        dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        }catch (Exception e){
            System.out.println("Cannot connect to appium server, see details: " + e);
        }
        ManagePages.initTeamApp();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
    }

    private void initDesktop() throws MalformedURLException {
        dc.setCapability("app", getData("appSignature"));
        driver = new WindowsDriver(new URL(getData("desktopUrl")),dc);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        ManagePages.initNotepad();
        action = new Actions(driver);
    }

    @AfterClass
    public void closeSession()
    {
        ManageDB.closeConnection();
        if(!platform.equalsIgnoreCase("api"))
        {
            if (!platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }

    @AfterMethod
    public void afterMethod()
    {
        if(platform.equalsIgnoreCase("web"))
            driver.get(getData("Url"));
        else if (platform.equalsIgnoreCase("desktop"))
            notepadMain.getField_edit().clear();
        else if(platform.equalsIgnoreCase("electron")) {
            ElectronFlows.emptyList();
        }
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        if(!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
