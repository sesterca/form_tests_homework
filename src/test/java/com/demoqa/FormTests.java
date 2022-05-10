package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.pageobject.AutomationPracticeForm;
import com.demoqa.testdata.FakerTestData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTests {

    private FakerTestData student;
    public String studentFirstName;
    public String studentLastName;
    public String studentEmail;
    public String male;
    public String phoneNumber;
    public String hobby;
    public String subject;
    public String studentAddress;
    public String dayOfBirthday;
    public String monthOfBirthday;
    public String yearOfBirthday;
    public String state;
    public String city;
    public String fileName;


    @BeforeEach
    public void setUp(){
        Configuration.browserSize = "1920x1080";
        student = new FakerTestData();
        Map<String, String> studentMap = student.generateMap(); 
        studentFirstName = studentMap.get("Student firstName");
        studentLastName = studentMap.get("Student lastName");
        studentEmail = studentMap.get("Student Email");
        male = studentMap.get("Male");
        phoneNumber = studentMap.get("Mobile");
        fileName = "picture.png";
        hobby = studentMap.get("Hobbie");
        subject = studentMap.get("Subject");
        studentAddress = studentMap.get("Address");
        state = studentMap.get("State");
        city = studentMap.get("City");
        dayOfBirthday = studentMap.get("Birthday day");
        monthOfBirthday = studentMap.get("Birthday month");
        yearOfBirthday = studentMap.get("Birthday year");
    }

    @Tag("execute")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Student's successful registration")
    @Test
    public void automaticPracticeFormPageObjectTest(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        AutomationPracticeForm automationPracticeForm = open(AutomationPracticeForm.FORM_PAGE, AutomationPracticeForm.class)
                .setName(studentFirstName, studentLastName)
                .setEmail(studentEmail)
                .setMale(male)
                .setPhone(phoneNumber)
                .setBirthday(dayOfBirthday, monthOfBirthday, yearOfBirthday)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(fileName)
                .setAddress(studentAddress)
                .setState(state)
                .setCity(city)
                .submit();
        Assertions.assertTrue(automationPracticeForm.isStudentRegistered(
                studentFirstName,
                studentLastName,
                studentEmail,
                phoneNumber,
                male,
                hobby,
                subject,
                studentAddress,
                state,
                city,
                dayOfBirthday,
                monthOfBirthday,
                yearOfBirthday));
    }

    @Disabled
    @Test
    public void automaticPracticeFormTest(){
        $("#firstName").setValue("Maria");
        $("#lastName").setValue("Osipova");
        $("#userEmail").setValue("maria@mail.ru");
        $(byText("Female")).click();
        $("#userNumber").setValue("89098080504");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__year-select]").selectOption("1991");
        $("[class=react-datepicker__month-select]").selectOption("January");
        $(byText("1")).click();
        $("#subjectsInput").setValue("History").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("picture.png");
        $("#currentAddress").setValue("Colorado st, 15");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible, Duration.ofSeconds(6000)).shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Student Name Maria Osipova\n" +
                        "Student Email maria@mail.ru\n" +
                        "Gender Female\n" +
                        "Mobile 89098080504\n" +
                        "Date of Birth 01 March,1991\n" +
                        "Subjects History\n" +
                        "Hobbies Reading\n" +
                        "Picture picture.png\n" +
                        "Colorado st, 15\n" +
                        "State and City Haryana Karnal"));
    }
}
