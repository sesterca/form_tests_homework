package com.demoqa.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    public static final String FORM_PAGE = "https://demoqa.com/automation-practice-form";

    //locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement phoneInput = $("#userNumber");
    SelenideElement birthdayInput = $("#dateOfBirthInput");
    SelenideElement yearDropDownList = $("[class=react-datepicker__year-select]");
    SelenideElement monthDropDownList = $("[class=react-datepicker__month-select]");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement uploadPictureButton = $("#uploadPicture");
    SelenideElement addressTextArea = $("#currentAddress");
    SelenideElement stateDropDownList = $("#state");
    SelenideElement cityDropDownList = $("#city");
    SelenideElement submitButton = $("#submit");
    public SelenideElement registrationTable = $(".table-responsive");

    public SelenideElement tableName = $(byTagAndText("td","Student Name")).sibling(0);
    public SelenideElement tableEmail = $(byTagAndText("td","Student Email")).sibling(0);
    public SelenideElement tableGender = $(byTagAndText("td","Gender")).sibling(0);
    public SelenideElement tableMobile = $(byTagAndText("td","Mobile")).sibling(0);
    public SelenideElement tableDateOfBirth = $(byTagAndText("td","Date of Birth")).sibling(0);
    public SelenideElement tableSubjects = $(byTagAndText("td","Subjects")).sibling(0);
    public SelenideElement tableHobbies = $(byTagAndText("td","Hobbies")).sibling(0);
    public SelenideElement tablePicture = $(byTagAndText("td","Picture")).sibling(0);
    public SelenideElement tableAddress = $(byTagAndText("td","Address")).sibling(0);
    public SelenideElement tableStateAndCity = $(byTagAndText("td","State and City")).sibling(0);

    //methods
    @Step("Set student's full name")
    public AutomationPracticeForm setName(String studentFirstName, String studentLastName){
        firstNameInput.setValue(studentFirstName);
        lastNameInput.setValue(studentLastName);
        return Selenide.page(AutomationPracticeForm.class);
    }
    @Step("Set student's email")
    public AutomationPracticeForm setEmail(String studentEmail){
        emailInput.setValue(studentEmail);
        return Selenide.page(AutomationPracticeForm.class);
    }
    @Step("Set student's male")
    public AutomationPracticeForm setMale(String male){
        $x("//div[input[@name='gender']]//label[text()='"+male+"']").click();
        return Selenide.page(AutomationPracticeForm.class);
    }
    @Step("Set student's phone")
    public AutomationPracticeForm setPhone(String phoneNumber){
        phoneInput.setValue(phoneNumber);
        return Selenide.page(AutomationPracticeForm.class);
    }
    public AutomationPracticeForm setDay(String dayOfBirthday){
        $x("//div[@class='react-datepicker__week']//div[text()='"+dayOfBirthday+"']").click();
        return Selenide.page(AutomationPracticeForm.class);
    }
    @Step ("Set student's birthday")
    public AutomationPracticeForm setBirthday(String dayOfBirthday, String monthOfBirthday, String yearOfBirthday){
        birthdayInput.click();
        yearDropDownList.selectOption(yearOfBirthday);
        monthDropDownList.selectOption(monthOfBirthday);
        setDay(dayOfBirthday);
        return Selenide.page(AutomationPracticeForm.class);
    }
    @Step("Set student's favourite subjects")
    public AutomationPracticeForm setSubject(String subject){
        subjectsInput.setValue(subject).pressEnter();
        return Selenide.page(AutomationPracticeForm.class);
    }
    @Step("Set student's hobby")
    public AutomationPracticeForm setHobby(String hobby){
        $x("//div[input [@type='checkbox']]/label[text()='"+hobby+"']").click();
        return Selenide.page(AutomationPracticeForm.class);
    }
    @Step("Upload picture")
    public AutomationPracticeForm uploadPicture(String fileName){
        uploadPictureButton.uploadFromClasspath(fileName);
        return Selenide.page(AutomationPracticeForm.class);
    }
    @Step("Set student's address")
    public AutomationPracticeForm setAddress(String studentAddress){
        addressTextArea.setValue(studentAddress);
        return Selenide.page(AutomationPracticeForm.class);
    }
    @Step("Set state")
    public AutomationPracticeForm setState(String state){
        stateDropDownList.click();
        $x("//div[contains(text(), '"+state+"')]").click();
        return Selenide.page(AutomationPracticeForm.class);
    }
    @Step("Set city")
    public AutomationPracticeForm setCity(String city){
        cityDropDownList.click();
        $x("//div[contains(text(), '"+city+"')]").click();
        return Selenide.page(AutomationPracticeForm.class);
    }
    @Step("Press Submit-button")
    public AutomationPracticeForm submit(){
        submitButton.click();
        return Selenide.page(AutomationPracticeForm.class);
    }
    public String getRegistrationTable() {
        return registrationTable.getText();
    }
    @Step("Assert student registered")
    public boolean isStudentRegistered(String studentFirstName,
                                       String studentLastName,
                                       String studentEmail,
                                       String phoneNumber,
                                       String male,
                                       String hobby,
                                       String subject,
                                       String studentAddress,
                                       String state,
                                       String city,
                                       String dayOfBirthday,
                                       String monthOfBirthday,
                                       String yearOfBirthday){
        return getRegistrationTable().contains("Student Name " + studentFirstName + " " + studentLastName +
                "\nStudent Email " + studentEmail +
                "\nGender " + male +
                "\nMobile " + phoneNumber +
                "\nDate of Birth " + dayOfBirthday + " " + monthOfBirthday + "," + yearOfBirthday +
                "\nSubjects " + subject +
                "\nHobbies " + hobby +
                "\nPicture picture.png" +
                "\nAddress " + studentAddress +
                "\nState and City " + state + " " + city);
    }
}
