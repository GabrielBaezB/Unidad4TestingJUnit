package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumJenkTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        try {
            // Configura el RemoteWebDriver para conectarse al Selenium Grid
            ChromeOptions options = new ChromeOptions();
            // Configura las opciones del navegador aquí si es necesario

            // Reemplaza <selenium-grid-url> con la URL de tu Selenium Grid
            driver = new RemoteWebDriver(new URL("http://172.20.10.3:4444/wd/hub"), options);
            
            // Inicializa WebDriverWait
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGoogleSearch() {
        // Abre Google
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        // Espera explícita para asegurar que el título de la página contiene "Selenium"
        wait.until(ExpectedConditions.titleContains("Selenium"));

        // Verifica que el título de la página contenga "Selenium"
        assertTrue(driver.getTitle().contains("Selenium"), "El título de la página debería contener 'Selenium'");

        // Verifica que los resultados contienen el texto esperado
        WebElement results = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
        assertTrue(results.getText().contains("Selenium"), "Los resultados de la búsqueda deberían contener 'Selenium'");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
