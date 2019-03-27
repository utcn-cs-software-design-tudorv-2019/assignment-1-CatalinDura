package DAO;

import Connection.ConnectionFactory;
import Model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Course;

public class CourseDAO extends AbstractDAO<Course> {


    public Course getClasa(int idS,int idP) {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Course> lista=new ArrayList<Course>();
        ResultSet resultSet = null;
        String query = "Select * from course where idstudent=? and idteacher=?";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,idS);
            statement.setInt(2,idP);
            resultSet = statement.executeQuery();
            lista.addAll(this.createObjects(resultSet));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (lista.size()>0)
            return lista.get(0);
        else return null;
    }

    public String queryById(String nume){
        StringBuilder x=new StringBuilder();
        x.append("Select grade,dateexam from course where ");
        x.append(nume);
        x.append("=? order by idstudent");
        return x.toString();
    }

    public void delteByIdStudent(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = "Delete from course where idstudent=?";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public List<String> noteDateById(int id,String field ){
        List<String> rez=new ArrayList<String>();
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet result=null;
        String query=queryById(field);
        String nota="";
        try{
            connection= ConnectionFactory.getConnection();
            statement=connection.prepareStatement(query);
            statement.setInt(1,id);
            result=statement.executeQuery();
            while(result.next()){
                nota=result.getString(1)+"@"+result.getString(2);
                rez.add(nota);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return rez;
    }
}
