package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SeleniumGridTest {

    public static void main(String[] args) {
        WebDriver driver = null;
        WebDriverWait wait = null;

        try {
            // Configura las capacidades del navegador
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("firefox"); // O "firefox", etc.

            // Configura la URL del Hub
            URL hubUrl = new URL("http://localhost:4444/wd/hub");

            // Crea una instancia del RemoteWebDriver apuntando al Hub
            driver = new RemoteWebDriver(hubUrl, capabilities);
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Realiza las acciones con el driver
            driver.get("https://www.google.com");

            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium");
            searchBox.submit();

            // Espera explícita para asegurar que el título contiene "Selenium"
            wait.until(ExpectedConditions.titleContains("Selenium"));

            // Verifica que el título de la página contenga "Selenium"
            if (driver.getTitle().contains("Selenium")) {
                System.out.println("Test Passed: Title contains 'Selenium'");
            } else {
                System.out.println("Test Failed: Title does not contain 'Selenium'");
            }

            // Verifica que los resultados contienen el texto esperado
            WebElement results = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
            if (results.getText().contains("Selenium")) {
                System.out.println("Test Passed: Results contain 'Selenium'");
            } else {
                System.out.println("Test Failed: Results do not contain 'Selenium'");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
