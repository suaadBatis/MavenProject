
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


class FirstClass {
  public class ScrolDwon extends base {
  /*  @BeforeTest
      public void killAllNodes() throws IOException, InterruptedException
      {
          //taskkill /F /IM node.exe
          Runtime.getRuntime ().exec("/usr/bin/killall -KILL node");
          Thread.sleep(3000);

      }*/


    @Test
    public void start () throws IOException, InterruptedException {
        service = startServer();
        IOSDriver <IOSElement> driver = Capabilities ("Application");
        ScrolDownPageObject PageObject = new ScrolDownPageObject (driver);
        PageObject.getScrol1().click();
        Assert.assertTrue(PageObject.Scrol2.isDisplayed());
        utilities u= new utilities (driver);
        u.scrollToText (10,500,100,80,1000);
        service.stop();

    }
 }
}
