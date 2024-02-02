package selenium.test.automation.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import selenium.test.automation.pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", // Directorio de nuestros archivos .feature
        glue = "selenium/test/automation/steps", // Paquete donde tenemos nuestras clases definiendo los steps
        plugin = { "pretty", "html:target/cucumber-reports" },
        tags = "@Navigation")

public class TestRunner {

        @AfterClass
        public static void cleanDriver() {
                BasePage.closeBrowser();
        }

}
