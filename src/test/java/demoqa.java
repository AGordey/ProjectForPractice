import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class demoqa {

    //https://demoqa.com/automation-practice-form
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = System.getProperty("base_url", "https://demoqa.com/automation-practice-form");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
    }

    @Test
    @DisplayName("Only open page")
    void openPageTest() {
        open("");
        assert (3 < 5);
    }

    @Test
    @DisplayName("Fill field")
    void fillFieldTest() {
        open("");
        $("#firstName").setValue("firstName");
        $("#lastName").setValue("lastName");
        $("input#userEmail").setValue("userEmail@userEmail.com");
        $("#gender-radio-3").click();


    }


}

