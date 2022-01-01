package com.pb.shatalov.hw12;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Contact {
    private String name;
    private LocalDate dateOfBirth;
    private List<String> phoneNumbers;
    private String address;
    private LocalDate changeTime;

    public Contact() {
    }

    public Contact(String name, LocalDate dateOfBirth, List<String> phoneNumbers,
                   String address, LocalDate changeTime) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumbers = phoneNumbers;
        this.address = address;
        this.changeTime = changeTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(LocalDate changeTime) {
        this.changeTime = changeTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(dateOfBirth, contact.dateOfBirth)
                && Objects.equals(phoneNumbers, contact.phoneNumbers) && Objects.equals(address, contact.address)
                && Objects.equals(changeTime, contact.changeTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, phoneNumbers, address, changeTime);
    }
}
