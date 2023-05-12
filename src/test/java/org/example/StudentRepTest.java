package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepTest extends TestCase {
    @Test
    void addValidStudent() throws ValidationException {
        Student student = new Student("Cosmin", "Teglas", Gender.M, LocalDate.of(1999, 03, 01), "199123321123");
        StudentRep studentRep = new StudentRep();
        studentRep.addStudent(student);
        assertTrue(studentRep.studentList.contains(student));
    }

    @Test
    void addInvalidValidStudent() throws ValidationException {
        Student student = new Student("Cosmin", "Teglas", Gender.M, LocalDate.of(1733, 03, 01), "199123321123");
        StudentRep studentRep = new StudentRep();
        studentRep.addStudent(student);
        assertTrue(studentRep.studentList.contains(student));
    }

    @Test
    void deleteStudentByCnpInvalid() throws ValidationException {
        Student student = new Student("Cosmin", "Teglas", Gender.M, LocalDate.of(1999, 03, 01), "1991233211asd3");
        StudentRep studentRep = new StudentRep();
        studentRep.addStudent(student);
        studentRep.deleteStudentByCNP("1991233211asd3");
        assertTrue(studentRep.studentList.contains(student));
    }

    @Test
    void retriveStudentsByAgeInvalid() throws ValidationException {
        Student student1 = new Student("Florin", "Teglas", Gender.M, LocalDate.of(1733, 03, 01), "19912332113");
        Student student2 = new Student("Cosmin", "Pop", Gender.M, LocalDate.of(2001, 03, 01), "19912332113");
        StudentRep studentRep = new StudentRep();
        studentRep.addStudent(student1);
        studentRep.addStudent(student2);
        List<Student> studentsSpecificAge = studentRep.retrieveStudentsByAge(20);
        assertTrue(studentsSpecificAge.contains(student1));
        assertTrue(studentsSpecificAge.contains(student2));
    }
}