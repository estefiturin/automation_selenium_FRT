package selenium.test.automation.pages;

public class PaginaFundamentosTesting extends BasePage{

    private String introduccionLink = "//a[normalize-space()='Introducción al Testing de Software' and @href]";

    public PaginaFundamentosTesting() {
        super(driver);
    }

    public void clickIntroduccionTestingLink() {
        clickElement(introduccionLink);
    }


}
