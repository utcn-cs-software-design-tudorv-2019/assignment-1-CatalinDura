package DAO;

import Connection.ConnectionFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<T> {

    private Class<T> type;

    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    private String createSelectQuery(){
        StringBuilder query=new StringBuilder();
        query.append("Select * from ");
        query.append(type.getSimpleName());
        return query.toString();
    }

    private String createSelectQueryByName(){
        StringBuilder query=new StringBuilder();
        query.append("Select password from ");
        query.append(type.getSimpleName());
        query.append(" where name=?");
        return query.toString();
    }

    private String createSelectQueryBy(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + "=?");
        return sb.toString();
    }

    private String createSelectField(String field){
        StringBuilder sb=new StringBuilder();
        sb.append("Select ");
        sb.append(field);
        sb.append(" from ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    private String createUpdateQuery(String field){
        StringBuilder query=new StringBuilder();
        query.append("Update ");
        query.append(type.getSimpleName());
        query.append(" set ");
        for(Field f:type.getDeclaredFields()){
            query.append(f.getName()+"=?,");
        }
        query.deleteCharAt(query.length()-1);
        query.append(" where " +field+ "=?");
        return query.toString();
    }
    private String createDeleteQuery(String field){
        StringBuilder query=new StringBuilder();
        query.append("Delete from ");
        query.append(type.getSimpleName());
        query.append(" where "+field+"=?");
        return query.toString();
    }
    private String createInsertQuery() {
        StringBuilder query = new StringBuilder();
        query.append("Insert into ");
        query.append(type.getSimpleName() + "(");
        for (Field f : type.getDeclaredFields()) {
            query.append(f.getName() + ",");
        }
        query.deleteCharAt(query.length() - 1);
        query.append(") values(");
        for (Field f : type.getDeclaredFields()) {
            query.append("?,");
        }
        query.deleteCharAt(query.length() - 1);
        query.append(")");
        return query.toString();
    }

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQueryBy((type.getDeclaredFields()[0].getName()));
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public List<T> findAll() {
        List<T> lista=new ArrayList<T>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            lista.addAll(createObjects(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return lista;
    }

    public List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();

        try {
            while (resultSet.next()) {
                T instance = type.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    Object value = resultSet.getObject(field.getName());
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }


    public String checkPassword(String nume){
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet result=null;
        String query=createSelectQueryByName();
        String parola="";
        try{
            connection= ConnectionFactory.getConnection();
            statement=connection.prepareStatement(query);
            statement.setString(1,nume);
            result=statement.executeQuery();
            while(result.next()){
                parola=result.getString("password");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return parola;
    }

    public List<String> selectByField(String nume){
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet result=null;
        String  query=createSelectField(nume);
        String aux;
        List<String> rezultat=new ArrayList<String>();
        try{
            connection= ConnectionFactory.getConnection();
            statement=connection.prepareStatement(query);
            result=statement.executeQuery();
            while(result.next()){
                aux=result.getString(1);
                rezultat.add(aux);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rezultat;
    }

    public int  inserare(T t){
        Connection connection=null;
        PreparedStatement statement=null;
        String query=this.createInsertQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int i = 1;
            for (Field f : type.getDeclaredFields()) {
                f.setAccessible(true);
                Object inserat = f.get(t);
                statement.setString(i, inserat.toString());
                i = i + 1;
            }
            statement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(IllegalAccessException e){
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return 1;
    }

    public void delete(int id){
        Connection connection=null;
        PreparedStatement statement=null;
        String query=this.createDeleteQuery(type.getDeclaredFields()[0].getName());
        try{
            connection= ConnectionFactory.getConnection();
            statement=connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    public T update(T t,int id) {
        Connection connection=null;
        PreparedStatement statement=null;
        String query=createUpdateQuery((type.getDeclaredFields()[0].getName()));
        try {
            connection= ConnectionFactory.getConnection();
            statement=connection.prepareStatement(query);
            int i=1;
            for(Field field:type.getDeclaredFields()) {
                field.setAccessible(true);
                Object inserat=field.get(t);
                statement.setString(i,inserat.toString());
                i=i+1;
            }
            statement.setInt(i, id);
            statement.executeUpdate();
            return t;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
}

