package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        runSelenium();
    }

    public static String runSelenium() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String siteName = driver.getTitle();

        System.out.println(siteName);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));

        String formText = message.getText();
        System.out.println(formText);

        driver.quit();

        return formText;
    }
}