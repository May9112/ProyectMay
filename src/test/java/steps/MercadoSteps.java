package steps;


import Pages.MercadoPage;
import camiseta.Camiseta;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class MercadoSteps {
    MercadoPage mercado = new MercadoPage();
   // private String fileName= "camisetaML";
   // private String sheetName= "camiseta";


    @Given("^Navegar a mercado libre$")
    public void navigateToMercado() {
        mercado.navigateToMercadoLibre();
    }

    @Then("^Ingresar criterio de busqueda$")
    public void enterSearchCriteria() {
       mercado.enterSearchCriteria("camiseta");
       mercado.enterSearchButton();
    }


    @And("^Seleccionar todos los  item$")
    public void seleccionarTodosLosItem() {
        mercado.selectAllItemPage();
    }

   /* @And("Exportar informacion")
    public void ExportInfo() {

    }
    */
}
