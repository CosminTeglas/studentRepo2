package org.example;

import java.time.LocalDate;

/**
 * Student repository
 * addStudent
 * deleteStudent
 * retrive all students with age X
 * for each student age must be calculated (age is not a number, age is negative)
 * list students and order by last name or birth date (any imput is empty)
 */
public class App {
    public static void main(String[] args) {
        Student student1 = null;
        try {
            student1 = new Student("Cosmin", "Teglas", Gender.M, LocalDate.of(1999, 03, 01), "1998391233213");

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        Student student2 = null;
        try {
            student2 = new Student("Alexandra", "Pandrea", Gender.F, LocalDate.of(1998, 11, 05), "2985391733213");

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        Student student3 = null;
        try {
            student3 = new Student("Florin", "Teglas", Gender.M, LocalDate.of(1995, 12, 31), "1958395236217");

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        StudentRep studentRep = new StudentRep();

        studentRep.addStudent(student1);
        studentRep.addStudent(student2);
        studentRep.addStudent(student3);

        studentRep.listStudentByLastName();

        try {
            studentRep.deleteStudentByCNP("1958395236217");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        studentRep.listStudentByDateOfBirth();
    }
}