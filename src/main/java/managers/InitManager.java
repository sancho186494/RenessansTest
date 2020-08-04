package managers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static utils.PropertyConstants.*;

public class InitManager {
    private static PropertyManager properties;

    public static void initFramework() {
        properties = PropertyManager.initProperties();

        SelenideLogger.addListener(
                properties.getProperty(LISTENER_NAME),
                new AllureSelenide().
                screenshots(Boolean.parseBoolean(properties.getProperty(MAKE_SCREENSHOTS))).
                savePageSource(Boolean.parseBoolean(properties.getProperty(SAVE_PAGE_SOURCE))).
                includeSelenideSteps(Boolean.parseBoolean(properties.getProperty(INCLUDE_SELENIDE_STEPS))));

        Configuration.startMaximized = Boolean.parseBoolean(properties.getProperty(START_MAXIMIZED));
        Selenide.open(properties.getProperty(TARGET_URL));
    }
}
