package DAO;

import Connection.ConnectionFactory;
import Model.Student;
import Model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO extends AbstractDAO<Teacher> {
    public Teacher teacherCurent(String nume) {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Teacher> lista=new ArrayList<Teacher>();
        ResultSet resultSet = null;
        String query = "Select * from teacher where name=?";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,nume);
            resultSet = statement.executeQuery();
            lista.addAll(this.createObjects(resultSet));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista.get(0);
    }
    public List<String> getProfesoriStudent(int idS){
        Connection connection = null;
        PreparedStatement statement = null;
        List<String> lista=new ArrayList<String>();
        ResultSet resultSet = null;
        String query = "Select teacher.name,teacher.coursename from teacher,course where " +
                "course.idstudent=? and course.idteacher=teacher.idteacher";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,idS);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                String rez=resultSet.getString(1)+"@"+resultSet.getString(2);
                lista.add(rez);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public int id(String s){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int rezultat=0;
        String query ="Select idteacher from teacher where coursename=?";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,s);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                 rezultat=resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }
}
