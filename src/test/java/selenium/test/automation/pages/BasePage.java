package selenium.test.automation.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    // instancio objeto driver
    protected static WebDriver driver;
    // paso el driver
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    // instancia del chromedriver cunado ejecuto pruebas
    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // constructor de la base page
    public BasePage(WebDriver driver) {
        BasePage.driver = driver; 
    }
    
    // Método para navegar
    public static void navigateTo(String url) {
        driver.get(url);
    } 

    public static void closeBrowser() {
        driver.quit();
    }

 //-------------------------------Metodos que reutilizare-------------------------
    // Crea objeto WebElement - COLUMNA VERTEBRAL DE MI FRAMEWORK
    private WebElement Find(String locator) {
        // manejo las esperas dentro de es método
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    // Re
    public void clickElement(String locator) {
        Find(locator).click();
    }
    //Re
    public void write(String locator, String keysToSend){
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }

    // ------------------------DROPDOWN's------------------
    public void selectFromDropdownByValue(String locator, String value) {
        // creo instancia de dropdown 
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(value);

    }

    public void selectFromDropdownByIndex(String locator, Integer index) {
        // creo instancia de dropdown 
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex(index);

    }

    public int dropdownSize(String locator) {
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();

        return dropdownOptions.size();
    }

    // Método para devolver todos los valores del dropdown
    public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();

        for (WebElement option : dropdownOptions) {
            values.add(option.getText());
        }

        return values;

    }



}
