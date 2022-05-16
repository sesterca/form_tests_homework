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

        System.getProperty("browser");
        System.getProperty("browserSize");
        String remote = System.getProperty("remoteAddress");

        String login = config.login();
        String password = config.password();

        String remoteAddress = "https://" + login + ":" + password + remote;

//        Configuration.browserSize = "1920x1080";
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
