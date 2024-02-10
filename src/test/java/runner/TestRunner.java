//package runner;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
//
//@RunWith(Cucumber.class) // Tells JUnit to run tests with Cucumber
//@CucumberOptions(
//        features = "src/test/resources/features", // Path to the feature files
//        glue = {"hooks","stepdefinitions"},
//        tags = "@SmokeTest", // Optional: Specify tags to include or exclude tests
//        plugin = {
//                "pretty", // Makes the console output more readable
//                "html:target/cucumber-reports.html", // Generates an HTML report in the specified directory
//                "json:target/cucumber.json", // Generates a JSON report (useful for further processing, like in Jenkins)
//                "junit:target/junit-xml-report.xml" // Generates a JUnit XML report
//        },
//        monochrome = true, // Makes the console output more readable
//        //strict = true, // Treats undefined and pending steps as errors
//        dryRun = false // Set to true to check if all feature file steps have corresponding step definitions without actually running the tests
//)
//
//
//public class TestRunner {
//}

//import org.junit.platform.suite.api.ConfigurationParameter;
//import org.junit.platform.suite.api.IncludeEngines;
//import org.junit.platform.suite.api.SelectClasspathResource;
//import org.junit.platform.suite.api.Suite;
//
//import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
//
//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("com.example")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.example")
//
//public class TestRunner  {
//
//}