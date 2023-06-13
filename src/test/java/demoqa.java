import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class demoqa {

    //https://demoqa.com/automation-practice-form
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = System.getProperty("base_url", "https://demoqa.com/automation-practice-form");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        open("");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    @Test
    @DisplayName("Only open page")
    void openPageTest() {
        Selenide.closeWindow();;
    }

    @Test
    @DisplayName("Fill field")
    void fillFieldTest() {
        $("#firstName").setValue("firstName");
        $("#lastName").setValue("lastName");
        $("input#userEmail").setValue("userEmail@userEmail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("2142354635");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1995");
//        $(".react-datepicker__year-select").$(byText("1995")).click(); // alternative way
        $(".react-datepicker__month-select").selectOption("June");
//        $(".react-datepicker__month-select").$(byText("June")).click(); //alternative way
        $(".react-datepicker__day.react-datepicker__day--019").click();

        $(".subjects-auto-complete__control").click();
        $(".subjects-auto-complete__control").press("Arts").pressEnter();

    }


}

