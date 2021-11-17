package com.osama.repositoryController;

import com.osama.demorest.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class RepositoryController {

    private Connection connection;
    private List<Student> students = new ArrayList<>();
    public RepositoryController() {
        String url = "jdbc:mysql://localhost:3306/registration";
        String password = "root@krt";
        String user = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAll() {
        try {
            String sql = "SELECT * FROM registration.students";
            Statement statement = connection.createStatement();
           ResultSet resultSet =  statement.executeQuery(sql);

           while (resultSet.next()){
               Student student = new Student();
               int id = resultSet.getInt(1);
               String name = resultSet.getString(2);
               String mark = resultSet.getString(3);
               System.out.println(id);
               System.out.println(name);
               System.out.println(mark);

               student.setId(id);
               student.setName(name);
               student.setMark(mark);
               System.out.println(student.toString());
               students.add(student);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student getById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        Student student = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                student = new Student();
                int studentId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String mark = resultSet.getString(3);
                student.setId(studentId);
                student.setName(name);
                student.setMark(mark);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void CreateStudent(Student student) {

        String sql = "INSERT INTO students (NAME,MARK) VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getMark());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        students.add(student);
    }

    public void updateStudent(Student student){
        String sql = "UPDATE students SET NAME = ?,MARK = ? WHERE ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getMark());
            preparedStatement.setInt(3,student.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id){
        String sql = "DELETE FROM students WHERE ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
