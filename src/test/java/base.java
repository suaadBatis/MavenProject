import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
static IOSDriver <IOSElement> driver;
public AppiumDriverLocalService service;
@BeforeClass
public void killAllNodes() throws IOException, InterruptedException
{
    //taskkill /F /IM node.exe
    Runtime.getRuntime ().exec("/usr/bin/killall -KILL node");
    Thread.sleep(3000);

}
 public AppiumDriverLocalService startServer(){
    boolean flag=	checkIfServerIsRuning(4723);
    if(!flag)
    {
        service = AppiumDriverLocalService.buildDefaultService ();
        service.start ();
    }
    return service;
 }
  public static boolean checkIfServerIsRuning(int port) {

    boolean isServerRunning = false;
    ServerSocket serverSocket;
    try {
        serverSocket = new ServerSocket(port);

        serverSocket.close();
    } catch (IOException e) {
        //If control comes here, then it means that the port is in use
        isServerRunning = true;
    } finally {
        serverSocket = null;
    }
    return isServerRunning;
 }
//android only
 public static void startEmulator() throws IOException, InterruptedException {
     Runtime.getRuntime ().exec(System.getProperty("user.dir")+"src/test/java/startEmulator.bat");
     Thread.sleep (1000);
 }
 public static IOSDriver<IOSElement> Capabilities( String AppName) throws IOException, MalformedURLException, InterruptedException {

     // here connect to properties file
     FileInputStream file = new FileInputStream (System.getProperty ("user.dir") + "/src/test/java/gloabl.properties");//create general path
     Properties pro = new Properties ();
     pro.load (file);
     File AppDire = new File ("app");
     File app = new File (AppDire, (String) pro.get (AppName));
     String device = (String) pro.get ("device");
     if (device.contains ("emulator"))
     {
         startEmulator ();
     }
    String platform = (String)pro.get("platform");
    String version = (String)pro.get("version");
    String udid = (String)pro.get("udid");
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
    desiredCapabilities.setCapability ("app", app.getAbsolutePath ());
    desiredCapabilities.setCapability ("deviceName",device );
    desiredCapabilities.setCapability ("platformName", platform);
    desiredCapabilities.setCapability ("platformVersion", version);
    desiredCapabilities.setCapability ("udid", udid);
    desiredCapabilities.setCapability( MobileCapabilityType.TAKES_SCREENSHOT, "true");
    desiredCapabilities.setCapability("automationName", "XCUITest");
    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
    URL remoteUrl = new URL ("http://localhost:4723/wd/hub");
    driver = new IOSDriver (remoteUrl, desiredCapabilities);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
    // bundel id com.example.apple-samplecode.UICatalog
 }


}

