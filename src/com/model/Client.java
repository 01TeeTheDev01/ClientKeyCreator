package com.model;

import java.time.LocalDateTime;

public class Client {

    private String firstName, fiddleName, lastName, uniqueKey, formattedYear;
    private char validIndicator;
    private LocalDateTime dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return fiddleName;
    }

    public void setMiddleName(String fiddleName) {
        this.fiddleName = fiddleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getFormattedYear() {
        return formattedYear;
    }

    public void setFormattedYear(String formattedYear) {
        this.formattedYear = formattedYear;
    }

    public char getValidIndicator() {
        return validIndicator;
    }

    public void setValidIndicator(char validIndicator) {
        this.validIndicator = validIndicator;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
