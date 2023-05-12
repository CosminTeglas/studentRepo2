package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Student {
    String firstName;
    String lastName;
    Gender gender;
    LocalDate dateOfBirth;
    String cnp;

    public Student(String firstName, String lastName, Gender gender, LocalDate dateOfBirth, String cnp) throws ValidationException {
        if (firstName == null || firstName == "") {
            throw new ValidationException("First name is null!");
        }
        this.firstName = firstName;

        if (lastName == null || lastName == "") {
            throw new ValidationException("Last name is null!");
        }
        this.lastName = lastName;
        if (gender == null || gender.equals("")) {
            throw new ValidationException("Gender is null!");
        }
        this.gender = gender;
        if (dateOfBirth == null) {
            throw new ValidationException("Date of birth is null!");
        }
        if (LocalDate.now().getYear() - dateOfBirth.getYear() < 18) {
            throw new ValidationException("Student is below 18!");
        }
        if (dateOfBirth.getYear() < 1900) {
            throw new ValidationException("Date of birth shoud be > 1900!");
        }
        this.dateOfBirth = dateOfBirth;

        if (cnp == null || cnp == "") {
            throw new ValidationException("Student cnp can't be null.");
        }
        if ((cnp.toCharArray().length != 13)) {
            throw new ValidationException("cnp must be of length 13. ");
        }
        if (!cnp.matches("[0-9]+")) {
            throw new ValidationException("The cnp doesn't contains only numbers.");
        }

        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", cnp=" + cnp +
                '}';
    }

    public String getCnp() {
        return cnp;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return period.getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Student student = (Student) o;

        if (!Objects.equals(cnp, student.cnp)) {
            return false;
        }

        return Objects.equals(cnp, student.cnp);
    }
}
