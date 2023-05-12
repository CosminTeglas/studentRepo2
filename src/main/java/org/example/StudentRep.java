package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentRep {
    public List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Student added to repository");
    }

    public void deleteStudentByCNP(String cnp) throws ValidationException {
        for (Iterator<Student> iterator = studentList.iterator(); iterator.hasNext(); ) {
            Student student = iterator.next();
            if (cnp == null || cnp.equals("")) {
                throw new ValidationException("Invalid CNP");
            }
            if (student.getCnp().equals(cnp)) {
                iterator.remove();
                System.out.println("Student " + student.firstName + " " + student.lastName + "was removed from the repo!");
            }
        }
    }

    public List<Student> retrieveStudentsByAge(Integer age) {
        List<Student> studentsByAge = new ArrayList<>();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getAge() == age) {
                studentsByAge.add(studentList.get(i));
            }
        }
        System.out.println("The students with age " + age + " are: ");
        return studentsByAge;
    }
    public void listStudentByLastName() {
        studentList.sort(new LastNameComparator());
        System.out.println("The list of students sorted by last name is: " + studentList);
    }
    public void listStudentByDateOfBirth(){
        studentList.sort(new DateOfBirthComparator());
        System.out.println("The list of students sorted by date of birh is: " + studentList);
    }
}