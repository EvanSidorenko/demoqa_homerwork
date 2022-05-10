package data;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Faker {
    com.github.javafaker.Faker faker = new com.github.javafaker.Faker(new Locale("en"));

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getUserEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return StringUtils.capitalize(faker.dog().gender());
    }

    public String getUserNumber() {
        return faker.numerify("##########");
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getSubject() {
        return Subjects.values()[new Random().nextInt(Subjects.values().length)].toString();
    }

    public String getState() {
        return States.values()[new Random().nextInt(States.values().length)].toString();
    }
    public String getHobby() {
        return Hobbies.values()[new Random().nextInt(Hobbies.values().length)].toString();
    }
    public LocalDate getDate() {
        return new java.sql.Date(faker.date().birthday().getTime()).toLocalDate();
    }

    public String getCity(String state) {
        switch (state) {
            case "NCR":
                return CitiesNCR.values()[new Random().nextInt(CitiesNCR.values().length)].toString();
            case "Haryana":
                return CitiesHaryana.values()[new Random().nextInt(CitiesHaryana.values().length)].toString();
            case "Rajasthan":
                return CitiesRajasthan.values()[new Random().nextInt(CitiesRajasthan.values().length)].toString();
        }
        return "Delhi";
    }
}