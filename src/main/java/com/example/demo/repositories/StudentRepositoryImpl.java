package com.example.demo.repositories;

import com.example.demo.models.Student;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    private Connection conn;

    public StudentRepositoryImpl(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Student student) {
        try {
            PreparedStatement createSingleStudent = conn.prepareStatement("INSERT INTO students " +
                    "(firstname, lastname, enrollmentDate, cpr)" +
                    "VALUES(?, ?, ?, ?)");

            createSingleStudent.setString(1, student.getFirstName());
            createSingleStudent.setString(2, student.getLastName());
            createSingleStudent.setDate(3, java.sql.Date.valueOf(student.getEnrollmentDate()));
            createSingleStudent.setLong(4, student.getCpr());
            createSingleStudent.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public Student read(int id) {
        Student studentToReturn = new Student();
        try {
            PreparedStatement getSingleStudent = conn.prepareStatement("SELECT * FROM students WHERE id = ?");
            getSingleStudent.setInt(1,id);
            ResultSet rs = getSingleStudent.executeQuery();
            while(rs.next()){
                studentToReturn = new Student();
                studentToReturn.setId(rs.getInt(1));
                studentToReturn.setFirstName(rs.getString(2));
                studentToReturn.setLastName(rs.getString(3));
                studentToReturn.setEnrollmentDate(rs.getDate(4).toLocalDate());
                studentToReturn.setCpr(rs.getLong(5));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return studentToReturn;
    }

    @Override
    public List<Student> readAll() {
        List<Student> allStudents = new ArrayList<Student>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student tempStudent = new Student();
                tempStudent.setId(rs.getInt(1));
                tempStudent.setFirstName(rs.getString(2));
                tempStudent.setLastName(rs.getString(3));
                tempStudent.setEnrollmentDate(rs.getDate(4).toLocalDate());
                tempStudent.setCpr(rs.getLong(5));
                allStudents.add(tempStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allStudents;
    }

    @Override
    public boolean update(Student student) {
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE students SET firstname=?, lastname=?,enrollmentDate=?,cpr=? WHERE id=?");
            ps.setString(1,student.getFirstName());
            ps.setString(2,student.getLastName());
            ps.setString(3,student.getEnrollmentDate().toString());
            ps.setLong(4,student.getCpr());
            ps.setInt(5,student.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("den er gal i update");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
