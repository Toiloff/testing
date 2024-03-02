package org.example;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Main {
    public static void main(String[] args) {
    }

    public static String runSelenide() {
        open("https://www.selenium.dev/selenium/web/web-form.html");
        $(By.name("my-text")).setValue("Selenide!");
        $(By.cssSelector("button")).click();

        return $(By.id("message")).text();
    }
}