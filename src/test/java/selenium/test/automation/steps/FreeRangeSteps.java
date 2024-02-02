package selenium.test.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import selenium.test.automation.pages.PaginaCursos;
import selenium.test.automation.pages.PaginaFundamentosTesting;
import selenium.test.automation.pages.PaginaPrincipal;
import selenium.test.automation.pages.PaginaRegistro;

import java.util.Arrays;
import java.util.List;

public class FreeRangeSteps {

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaFundamentosTesting fundamentosPage = new PaginaFundamentosTesting();

    PaginaRegistro registroPage = new PaginaRegistro();

    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to a {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @And("select Introduccion al Testing")
    public void navigateToIntro() {
        cursosPage.clickFundamentosTestingLink();
        fundamentosPage.clickIntroduccionTestingLink();
    }

    @When("I select Elegir Plan")
    public void navigateToElegirPlan() {
        landingPage.clickOnElegirPlan();
    }

    @Then("I can validate the options in the checkout page")
    public void validateCheckoutPlans() {
        List<String> lista = registroPage.returnPlanDropdownValues();

        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 11 productos",
                "Academia: $176 / año • 11 productos", "Free: Gratis • 1 producto");

        Assert.assertEquals(listaEsperada, lista);

    }

}