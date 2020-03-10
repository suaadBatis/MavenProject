import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;

public class utilities {
    IOSDriver <IOSElement> driver;
    public utilities(IOSDriver <IOSElement> driver){
     this.driver = driver;
    }
    public  void scrollToText(int x, int y, int x1, int y1, int min){
        new TouchAction (driver).press( PointOption.point(x, y)).waitAction( WaitOptions.
          waitOptions( Duration.ofMillis(min))).moveTo(PointOption.point(x1, y1)).release().perform();
    }
    // new TouchAction (driver).press( PointOption.point(10, 500)).waitAction( WaitOptions.
  //    waitOptions( Duration.ofMillis(1000))).moveTo(PointOption.point(100, 80)).release().perform();
}
