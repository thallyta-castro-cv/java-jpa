package com.thallyta.relationship.repositories.inheritance;

import com.thallyta.relationship.models.daos.DAO;
import com.thallyta.relationship.models.inheritance.ScholarshipStudent;
import com.thallyta.relationship.models.inheritance.Student;

public class NewStudent {

    public static void main(String[] args) {

        DAO<Student> studentDAO = new DAO<>();

        Student student1 = new Student(123L, "João");
        ScholarshipStudent student2 = new ScholarshipStudent(345L, "Maria", 1000);

        studentDAO.includeAtomic(student1);
        studentDAO.includeAtomic(student2);

        studentDAO.close();
    }
}
