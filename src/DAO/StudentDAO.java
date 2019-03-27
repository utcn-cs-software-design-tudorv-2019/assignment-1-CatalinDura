package DAO;

import Connection.ConnectionFactory;
import Model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends AbstractDAO<Student> {
    public List<Student> studentiProf(int idProf){
        List<Student> lista=new ArrayList<Student>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder query1=new StringBuilder();
        query1.append("Select student.*");
        query1.append(" from student,course where course.idteacher=? and course.idstudent=student.idstudent");
        String s=query1.toString();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(s);
            statement.setInt(1,idProf);
            resultSet = statement.executeQuery();
            lista.addAll(createObjects(resultSet));
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return lista;
    }
    public Student studentCurent(String nume) {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Student> lista=new ArrayList<Student>();
        ResultSet resultSet = null;
        String query = "Select * from student where name=?";
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
}
