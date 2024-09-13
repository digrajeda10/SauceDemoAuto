package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void startBrowser() {
        // Inicializa el navegador antes de cada prueba
        DriverManager.getDriver();
    }

    @After
    public void closeBrowser() {
        // Cierra el navegador después de cada prueba
        DriverManager.getDriver().driver.quit();
        DriverManager.instance = null;
    }
}
