


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;



public class FirstClass {


public class ScrolDwon extends base {
    @Test
    public void start () throws IOException {
        IOSDriver <IOSElement> driver = Capabilities ("Application");
        ScrolDownPageObject PageObject = new ScrolDownPageObject (driver);
        PageObject.Scrol1.click();
        Assert.assertTrue(PageObject.Scrol2.isDisplayed());

    }
    @AfterClass
    public void teardown () {
        if (driver != null) {
            driver.quit ();
        }
    }
 }
}
