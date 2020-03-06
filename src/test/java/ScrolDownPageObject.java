import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class ScrolDownPageObject {

  public ScrolDownPageObject ( IOSDriver <IOSElement> driver ) {


      PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
  }

     @iOSXCUITFindBy(accessibility = "Alert Views")
     private IOSElement Scrol1;

    @iOSXCUITFindBy(xpath= "//XCUIElementTypeStaticText[@name=\"Alert Views\"]")
   public IOSElement  Scrol2;

    public IOSElement getScrol1(){
        return Scrol1;
    }


}
