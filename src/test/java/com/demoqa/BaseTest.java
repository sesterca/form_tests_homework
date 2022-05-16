package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attachments;
import com.demoqa.helpers.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {

    @BeforeAll
    static void config(){

        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        SelenideLogger.addListener("allure", new AllureSelenide());

        String login = config.login();
        String password = config.password();

        String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        String browser = System.getProperty("browser", "chrome");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String server = System.getProperty("server", "selenoid.autotests.cloud");
        String remoteAddress = "https://" + login + ":" + password + "@" + server + "/wd/hub";

        Configuration.baseUrl = baseUrl;
        Configuration.browser = browser;
        Configuration.browserSize = browserSize;
        Configuration.remote = remoteAddress;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments(){
        Attachments.screenshotAs("Screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
    }
}

//https://user1:1234@selenoid.autotests.cloud/wd/hub
//https://selenoid.autotests.cloud/video/
