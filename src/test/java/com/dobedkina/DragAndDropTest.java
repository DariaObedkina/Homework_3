package com.dobedkina;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class DragAndDropTest {
    @BeforeAll
    static void setUp() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        Configuration.startMaximized = true;
    }

    @Test
    void dragAndDropTest() {
        //перетащить элемент А на место В
        $("#column-a").dragAndDropTo($("#column-b"));

        //проверить, что заголовки элементов поменялись местами
        $("#column-a header").shouldHave(Condition.text("B"));
        $("#column-b header").shouldHave(Condition.text("A"));
    }
}