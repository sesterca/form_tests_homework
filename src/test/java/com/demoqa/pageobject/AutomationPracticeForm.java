package com.demoqa.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.testdata.FakerTestData;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AutomationPracticeForm {

    public static final String FORM_PAGE = "https://demoqa.com/automation-practice-form";

    //locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement femaleRadio = $(byText("Female"));
    SelenideElement phoneInput = $("#userNumber");
    SelenideElement birthdayInput = $("#dateOfBirthInput");
    SelenideElement yearDropDownList = $("[class=react-datepicker__year-select]");
    SelenideElement monthDropDownList = $("[class=react-datepicker__month-select]");
    SelenideElement dayElement = $(byText("1"));
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement readingRadio = $(byText("Reading"));
    SelenideElement uploadPictureButton = $("#uploadPicture");
    SelenideElement addressTextArea = $("#currentAddress");
    SelenideElement stateDropDownList = $("#state");
    SelenideElement stateElement = $("#react-select-3-option-2");
    SelenideElement cityDropDownList = $("#city");
    SelenideElement cityElement = $("#react-select-4-option-0");
    SelenideElement submitButton = $("#submit");
    public SelenideElement registrationTable = $(".table-responsive");

    //methods
    public AutomationPracticeForm setName(String studentFirstName, String studentLastName){
        firstNameInput.setValue(studentFirstName);
        lastNameInput.setValue(studentLastName);
        return Selenide.page(AutomationPracticeForm.class);
    }
    public AutomationPracticeForm setEmail(String studentEmail){
        emailInput.setValue(studentEmail);
        return Selenide.page(AutomationPracticeForm.class);
    }
    public AutomationPracticeForm setFemale(){
        femaleRadio.click();
        return Selenide.page(AutomationPracticeForm.class);
    }
    public AutomationPracticeForm setPhone(String studentPhoneNumber){
        phoneInput.setValue(studentPhoneNumber);
        return Selenide.page(AutomationPracticeForm.class);
    }
    public AutomationPracticeForm setBirthday(){
        birthdayInput.click();
        yearDropDownList.selectOption("1991");
        monthDropDownList.selectOption("March");
        dayElement.click();
        return Selenide.page(AutomationPracticeForm.class);
    }
    public AutomationPracticeForm setSubject(){
        subjectsInput.setValue("History").pressEnter();
        return Selenide.page(AutomationPracticeForm.class);
    }
    public AutomationPracticeForm setReadingHobby(){
        readingRadio.click();
        return Selenide.page(AutomationPracticeForm.class);
    }
    public AutomationPracticeForm uploadPicture(){
        uploadPictureButton.uploadFromClasspath("picture.png");
        return Selenide.page(AutomationPracticeForm.class);
    }
    public AutomationPracticeForm setAddress(String studentAddress){
        addressTextArea.setValue(studentAddress);
        return Selenide.page(AutomationPracticeForm.class);
    }
    public AutomationPracticeForm setState(){
        stateDropDownList.click();
        stateElement.click();
        return Selenide.page(AutomationPracticeForm.class);
    }
    public AutomationPracticeForm setCity(){
        cityDropDownList.click();
        cityElement.click();
        return Selenide.page(AutomationPracticeForm.class);
    }
    public AutomationPracticeForm submit(){
        submitButton.click();
        return Selenide.page(AutomationPracticeForm.class);
    }
}
