package com.JavaConsoleRestaurant.Client;

import java.time.LocalDate;

public class Client {

    private String ID;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String contactPhoneNumber;
    private Status status;
    private double totalSpent;

    public Client(String ID, String firstName, String lastName, LocalDate dateOfBirth, String contactPhoneNumber){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public Status getStatus() {
        return status;
    }

    public double getTotalSpent() {
        return totalSpent;
    }
}
