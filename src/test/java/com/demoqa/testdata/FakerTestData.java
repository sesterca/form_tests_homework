package com.demoqa.testdata;

import com.github.javafaker.Faker;

import java.util.*;

public class FakerTestData implements FormatDateMethod {
    Faker faker = new Faker(new Locale("en-US"));

    public FakerTestData() {
    }
    private String getRandomMale() {
        String [] male = new String[3];
        male [0] = "Male";
        male [1] = "Female";
        male [2] = "Other";
        Random rnd = new Random();
        return male[rnd.nextInt(male.length)];
    }
    private String getRandomHobbie(){
        String [] hobbies = new String[3];
        hobbies [0] = "Sports";
        hobbies [1] = "Reading";
        hobbies [2] = "Music";
        Random rnd = new Random();
        return hobbies[rnd.nextInt(hobbies.length)];
    }
    private String getRandomSubject(){
        String [] subjects = new String[13];
        subjects [0] = "English";
        subjects [1] = "Chemistry";
        subjects [2] = "Computer Science";
        subjects [3] = "Commerce";
        subjects [4] = "Social Studies";
        subjects [5] = "Arts";
        subjects [6] = "History";
        subjects [7] = "Accounting";
        subjects [8] = "Maths";
        subjects [9] = "Physics";
        subjects [10] = "Biology";
        subjects [11] = "Hindi";
        subjects [12] = "Civics";
        Random rnd = new Random();
        return subjects[rnd.nextInt(subjects.length)];
    }
    private String getRandomState(){
        String [] states = new String[4];
        states [0] = "NCR";
        states [1] = "Uttar Pradesh";
        states [2] = "Haryana";
        states [3] = "Rajasthan";
        Random rnd = new Random();
        return states[rnd.nextInt(states.length)];
    }

    private String getRandomCity(String state){
        if (state == "NCR"){
            String [] cities = new String[3];
            cities [0] = "Delhi";
            cities [1] = "Gurgaon";
            cities [2] = "Noida";
            Random rnd = new Random();
            return cities[rnd.nextInt(cities.length)];
        } else if (state == "Uttar Pradesh"){
            String [] cities = new String[3];
            cities [0] = "Agra";
            cities [1] = "Lucknow";
            cities [2] = "Merrut";
            Random rnd = new Random();
            return cities[rnd.nextInt(cities.length)];
        } else if (state == "Haryana"){
            String [] cities = new String[2];
            cities [0] = "Karnal";
            cities [1] = "Panipat";
            Random rnd = new Random();
            return cities[rnd.nextInt(cities.length)];
        } else {String [] cities = new String[2];
            cities [0] = "Jaipur";
            cities [1] ="Jaiselmer";
            Random rnd = new Random();
            return cities[rnd.nextInt(cities.length)];
        }
    }

    public Map<String, String> generateMap() {
        String firstName = this.faker.name().firstName();
        String lastName = this.faker.name().lastName();
        String email = this.faker.internet().emailAddress();
        String phoneNumber = this.faker.phoneNumber().subscriberNumber(10);
        String address = this.faker.address().secondaryAddress();

        Date birthday = this.faker.date().birthday();
        String month = FormatDateMethod.formatBDayMonth(birthday);
        String day = FormatDateMethod.formatBDayDay(birthday);
        String year = FormatDateMethod.formatBDayYear(birthday);

        String state = getRandomState();

        Map<String, String> studentMap = new HashMap();
        studentMap.put("Student firstName", firstName);
        studentMap.put("Student lastName", lastName);
        studentMap.put("Student Email", email);
        studentMap.put("Male", getRandomMale());
        studentMap.put("Mobile", phoneNumber);
        studentMap.put("Birthday day", day);
        studentMap.put("Birthday month", month);
        studentMap.put("Birthday year", year);
        studentMap.put("Hobbie", getRandomHobbie());
        studentMap.put("Subject", getRandomSubject());
        studentMap.put("Address", address);
        studentMap.put("State", state);
        studentMap.put("City", getRandomCity(state));
        return studentMap;
    }
}
