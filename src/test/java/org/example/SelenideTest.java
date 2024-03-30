package org.example;

import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith(TextReportExtension.class)
class SelenideTest {

  @BeforeEach
  public void setUp() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    open();
  }

  @Test
  @Epic("Example flow")
  @Feature("Example selenide")
  @Description("Test that verifies a returned Example Domain from example.com")
  void testExampleDomain() {
    open("https://www.example.com/custom-web-form.html");
    $$("h1").first(1).shouldHave(texts("Example Domain"));
  }
}
