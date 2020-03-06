
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
static IOSDriver <IOSElement> driver;
public static IOSDriver<IOSElement> Capabilities( String AppName) throws IOException, MalformedURLException {
    // here connect to properties file
    FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"/src/test/java/gloabl.properties");//create general path
    Properties pro = new Properties ();
    pro.load(file);

    File AppDire = new File ("app");
    File app = new File(AppDire, (String) pro.get(AppName));
    String device = (String)pro.get("device");
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
