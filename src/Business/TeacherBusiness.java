package Business;

import Model.Teacher;
import DAO.TeacherDAO;

import java.util.ArrayList;
import java.util.List;

public class TeacherBusiness  {

    private Teacher teacherLogat;
    private TeacherDAO teacher;
    public TeacherBusiness(){
        teacher=new TeacherDAO();
    }

    public String Password(String nume) {
        String s = teacher.checkPassword(nume);
        return s;
    }

    public List<String> profesoriStudent(int id){
        List<String> rez=new ArrayList<String>();
        rez.addAll(teacher.getProfesoriStudent(id));
        return rez;
    }

    public List<String> materiiDisponibile(){
        List<String> rezultat=new ArrayList<String>();
        rezultat.addAll(teacher.selectByField("coursename"));
        return rezultat;
    }


    public int idTeacher(String materie){
        return teacher.id(materie);
    }
    public void setTeacherLogat(String nume){
        teacherLogat=teacher.teacherCurent(nume);
    }
    public int getIdTeacherLogat(){
        return teacherLogat.getIdTeacher();
    }
    public String toString(){
       return teacherLogat.toString();
    }
}
