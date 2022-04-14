package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.demoqa.pageobject.AutomationPracticeForm;
import com.demoqa.testdata.FakerTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
    public String studentPhoneNumber;
    public String studentAddress;

    @BeforeEach
    public void setUp(){
        Configuration.browserSize = "1920x1080";
        student = new FakerTestData();
        Map<String, String> studentMap = student.generateMap();
        studentFirstName = studentMap.get("Student firstName");
        studentLastName = studentMap.get("Student lastName");
        studentEmail = studentMap.get("Student Email");
        studentPhoneNumber = studentMap.get("Mobile");
        studentAddress = studentMap.get("Address");
    }

    @Test
    public void automaticPracticeFormPageObjectTest(){
        AutomationPracticeForm automationPracticeForm = open(AutomationPracticeForm.FORM_PAGE, AutomationPracticeForm.class)
                .setName(studentFirstName, studentLastName)
                .setEmail(studentEmail)
                .setFemale()
                .setPhone(studentPhoneNumber)
                .setBirthday()
                .setSubject()
                .setReadingHobby()
                .uploadPicture()
                .setAddress(studentAddress)
                .setState()
                .setCity()
                .submit();

        Selenide.sleep(20000);

        automationPracticeForm.registrationTable.shouldHave(
                text("Student Name" + " " + studentFirstName + " " + studentLastName +
                        "\nStudent Email" + " " + studentEmail +
                        "\nGender Female\n" +
                        "Mobile" + " " + studentPhoneNumber +
                        "\nDate of Birth 01 March,1991\n" +
                        "Subjects History\n" +
                        "Hobbies Reading\n" +
                        "Picture picture.png\n" +
                        "Address" + " " + studentAddress +
                        "\nState and City Haryana Karnal"));
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
