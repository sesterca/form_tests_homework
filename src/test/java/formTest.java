import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class formTest {
    @BeforeEach
    public void setUp(){
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void automaticPracticeFormTest(){
        open("https://demoqa.com/automation-practice-form");
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
        $(byText("Karnal"));
        $("#submit").click();
//        Selenide.sleep(6000);
        $("#example-modal-sizes-title-lg").shouldBe(visible, Duration.ofSeconds(6000)).shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Student Name Maria Osipova\n" +
                        "Student Email maria@mail.ru\n" +
                        "Gender Female\n" +
                        "Mobile 8909808050\n" +
                        "Date of Birth 01 January,1991\n" +
                        "Subjects History\n" +
                        "Hobbies Reading\n" +
                        "Picture picture.png\n" +
                        "Address Colorado st, 15\n" +
                        "State and City Haryana Karnal"));
    }
}
