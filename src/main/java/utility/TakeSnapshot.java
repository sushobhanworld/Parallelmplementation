package utility;

import base.TestBase;
import factories.EventFiringFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeSnapshot extends TestBase
{
    public String snap()
    {
        File src= ((TakesScreenshot) EventFiringFactory.GetInstance().getEventFiringFactory()).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date= new Date();
        String formattedDate= simpleDateFormat.format(date);

        String screenshotPath= System.getProperty("user.dir")+"/Reports/Screenshots/Screenshots"+formattedDate+".jpeg";
        File destination= new File(screenshotPath);
        try {
            FileUtils.copyFile(src, destination);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}
