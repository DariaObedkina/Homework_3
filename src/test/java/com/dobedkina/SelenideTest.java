package com.dobedkina;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @BeforeAll
    static void setUp() {
        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        Configuration.startMaximized = true;
    }

    @Test
    void checkIfSelenideWikiHasJunit5CodeExamples() {
        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        //Откройте страницу SoftAssertions
        $(".js-wiki-more-pages-link").click();
        $(byText("SoftAssertions")).click();

        //Проверьте что внутри есть пример кода для JUnit5
        $("#wiki-content").shouldHave(Condition.text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));

    }
}

