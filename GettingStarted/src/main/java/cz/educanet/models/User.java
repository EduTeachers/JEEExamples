package cz.educanet.models;

public class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Gender gender;

    public User(String firstName, String lastName, String email, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }
}
