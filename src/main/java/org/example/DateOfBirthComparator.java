package org.example;

import java.util.Comparator;

public class DateOfBirthComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.dateOfBirth.compareTo(s2.dateOfBirth);
    }
}
