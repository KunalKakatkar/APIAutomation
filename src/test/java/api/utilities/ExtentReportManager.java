package api.utilities;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports extent;

    public static ExtentReports getReportObject() {

        if (extent == null) {

            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss")
                    .format(new Date());

            String reportPath = System.getProperty("user.dir")
                    + "/Reports/APIReport_" + timeStamp + ".html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName("API Automation Report");

            sparkReporter.config()
                    .setDocumentTitle("Rest Assured Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Tester", "Kunal");
            extent.setSystemInfo("Framework", "Rest Assured");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}