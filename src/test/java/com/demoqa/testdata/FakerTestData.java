package com.demoqa.testdata;

import com.demoqa.FormatDateMethod;
import com.github.javafaker.Faker;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FakerTestData implements FormatDateMethod {
    Faker faker = new Faker(new Locale("en-US"));

    public FakerTestData() {
    }

    public Map<String, String> generateMap() {
        String firstName = this.faker.name().firstName();
        String lastName = this.faker.name().lastName();
        String email = this.faker.internet().emailAddress();
        String phoneNumber = this.faker.phoneNumber().subscriberNumber(10);
        Date birthday = this.faker.date().birthday();

        String month = FormatDateMethod.formatBDayMonth(birthday);
        String day = FormatDateMethod.formatBDayDay(birthday);
        String year = FormatDateMethod.formatBDayYear(birthday);

        String address = this.faker.address().secondaryAddress();
        Map<String, String> studentMap = new HashMap();
        studentMap.put("Student firstName", firstName);
        studentMap.put("Student lastName", lastName);
        studentMap.put("Student Email", email);
        studentMap.put("Mobile", phoneNumber);
        studentMap.put("Birthday day", day);
        studentMap.put("Birthday month", month);
        studentMap.put("Birthday year", year);
        studentMap.put("Address", address);
        return studentMap;
    }
}
