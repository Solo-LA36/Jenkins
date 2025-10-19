package tests.pageobjectmodel;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;

public class TestData {
    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String mobileNumber = faker.number().digits(10);
    public String[] birthday = generateBirthday();
    public String subjects = faker.options().option("Math", "Physics", "Chemistry", "English");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String uploadFile = "Photo.png";
    public String address = faker.address().fullAddress();
    public String[] stateAndCity = generateStateAndCity();

    public String expectedFullName = firstName + " " + lastName;
    public String expectedBirthday = birthday[0] + " " + birthday[1] + "," + birthday[2];
    public String expectedStateAndCity = stateAndCity[0] + " " + stateAndCity[1];

    private String[] generateBirthday() {
        LocalDate birthDate = faker.date().birthday(18, 65).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();


        String month = birthDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        return new String[]{
                String.valueOf(birthDate.getDayOfMonth()),
                month,
                String.valueOf(birthDate.getYear())
        };
    }

    private String[] generateStateAndCity() {
        Map<String, String[]> stateCities = Map.of(
                "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
                "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
                "Haryana", new String[]{"Karnal", "Panipat"},
                "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
        );

        String state = faker.options().option(stateCities.keySet().toArray(new String[0]));
        String city = faker.options().option(stateCities.get(state));

        return new String[]{state, city};
    }
}