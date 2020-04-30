package com.example.demo.repositories;

import com.example.demo.models.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class InMemoryStudentRepositoryImpl implements IStudentRepository{
    private List<Student> inMemoryDatabase;

    public InMemoryStudentRepositoryImpl(){
        this.inMemoryDatabase = new ArrayList<Student>(
                Arrays.asList(
/*                        new Student(1, "Nicklas","Frederiksen", new Date(12312), 1234567890),
                        new Student(2, "Bent","Karlsen", new Date(2141241), 2407960591),
                        new Student(3, "Bob","Alicesen",new Date(12424141), 1234567890)*/
                )
        );
    }

    @Override
    public boolean create(Student student) {
        return false;
    }

    @Override
    public Student read(int id) {
        for(Student stu : inMemoryDatabase){
            if(stu.getId() == id){
                return stu;
            }
        }
        return null;
    }

    @Override
    public List<Student> readAll() {
        return inMemoryDatabase;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
