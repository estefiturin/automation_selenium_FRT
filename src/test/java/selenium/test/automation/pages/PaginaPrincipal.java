package selenium.test.automation.pages;

public class PaginaPrincipal extends BasePage{

    private String searchButton = "//a[@class='sc-hHftZz fCaYAt'][normalize-space()='Entrar']";

    private String sectionLink = "//a[normalize-space()='%s' and @href]";

    private String selectPlanLink = "//a[normalize-space()='Elegir Plan' and @href]";

    public PaginaPrincipal() {
        super(driver);    
    }

    // Método para navegar www.freerangetesters.com
    public void navigateToFreeRangeTesters() {
        navigateTo("https://www.freerangetesters.com");
    
    }

    public void clickOnSectionNavigationBar(String section) {
        //Reemplaza el marcador de posición en sectionLink con el nombre
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);
    }

    public void clickOnElegirPlan() {
        clickElement(selectPlanLink);
    }



    
    
    
}
