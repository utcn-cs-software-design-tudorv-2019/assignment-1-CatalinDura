package Business;

import java.util.List;
import java.util.ArrayList;
import Validators.NotaValidator;
import DAO.*;
import Model.*;

public class CourseBusiness {
    private CourseDAO course;
    private Course inserat;

    private NotaValidator n;
    public CourseBusiness(){
        course=new CourseDAO();
        n=new NotaValidator();
    }
    public int getIdClasa(int idS,int idP){
        if (course.getClasa(idS,idP)==null) return 0;
        else return course.getClasa(idS,idP).getIdCourse();
    }

    public int updateNota(int id,String nota,String data){
        if(!nota.equals("")) inserat.setGrade(nota);
        if(!data.equals("")) inserat.setDateexam(data);
        if(n.validate(inserat)==1)  throw new IllegalArgumentException("Argument Invalid la update nota student");
        else {
            course.update(inserat,id);
            return 0;
        }
    }

    public List<String> noteDateProfesorStudent(int idProf,String field){
        List<String> rez=new ArrayList<String>();
        rez.addAll(course.noteDateById(idProf,field));
        return rez;
    }
    public int insert(){
            course.inserare(inserat);
            return 0;
    }
    public void deleteByIdStudent(int id){
        course.delteByIdStudent(id);
    }

    public void setInserat(int idstudent,int idprofesor){
        if (course.getClasa(idstudent,idprofesor)==null) inserat=new Course(idstudent,idprofesor);
        else inserat=course.getClasa(idstudent,idprofesor);
    }
}
