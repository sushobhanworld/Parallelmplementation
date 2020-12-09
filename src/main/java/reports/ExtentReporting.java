package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utility.ReadPropertyFile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporting
{
    static ExtentReports extentReports;
    public static ExtentReports SetUpExtentReport()
    {
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date= new Date();
        String formattedDate= simpleDateFormat.format(date);

        String reportPath= System.getProperty("user.dir")+"/Reports/ExecutionReport_"+formattedDate+".html";

        ExtentSparkReporter extentSparkReporter= new ExtentSparkReporter(reportPath);
        extentReports= new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("Automation Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("Application Report");

        extentReports.setSystemInfo("Executed on Environment: ", ReadPropertyFile.ReadFile("url"));
        extentReports.setSystemInfo("Executed on Browser: ",  ReadPropertyFile.ReadFile("browser"));
        extentReports.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
        extentReports.setSystemInfo("Executed by User: ", System.getProperty("user.name"));

        return extentReports;
    }
}
