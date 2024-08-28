package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumJUnitTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        // Configura el driver de Chrome (asegúrate de tener el ChromeDriver en tu PATH)
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        // options.setBinary("/usr/bin/google-chrome-stable");
        // La ubicación del binario de Chrome en tu sistema
        
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10); // Espera explícita de 10 segundos
    }

    @Test
    public void testGoogleSearch() {
        // abre google
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        // Espera explícita para asegurar que los resultados están presentes
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
