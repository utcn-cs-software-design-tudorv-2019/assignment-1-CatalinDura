package Business;
import DAO.StudentDAO;
import Model.Student;
import Validators.*;

import java.util.ArrayList;
import java.util.List;

public class StudentBusiness {
    private Student studentLogat;
    private Student inserat;
    EmailValidator e=new EmailValidator();
    PasswordValidator p=new PasswordValidator();
    VarstaValidator v=new VarstaValidator();
    private StudentDAO student;
    public StudentBusiness(){
        student=new StudentDAO();
    }

    public int insertStudent(){
        int sum=0;
        sum=e.validate(inserat)+p.validate(inserat)+v.validate(inserat);
        if(sum==0) {
            student.inserare(inserat);
            return 0;
        }
        else{
            throw new IllegalArgumentException("Argument Invalid la inserareupdate student");
        }
    }

    public void deleteStudent(int id){
        student.delete(id);
    }
    public int updateStudent(int id) {
        int sum = 0;
        sum = e.validate(studentLogat) + p.validate(studentLogat) + v.validate(studentLogat);
        if (sum == 0) {
            student.update(studentLogat,id);
            return 0;
        } else  throw new IllegalArgumentException("Argument Invalid la inserareupdate student");
    }
    public List<Student> afisareStudenti(){
        List<Student> lista=new ArrayList<Student>();
        lista.addAll(student.findAll());
        return lista;
    }

    public String toString(){
        return studentLogat.toString();
    }

    public String Password(String nume){
        String s=student.checkPassword(nume);
        return s;
    }

    public List<Student> studentiProfesor(int idProf){
        List<Student> rez=new ArrayList<Student>();
        rez.addAll(student.studentiProf(idProf));
        return rez;
    }
    public void setStudentLogat(String nume){
        studentLogat=student.studentCurent(nume);
    }
    public void studentInserat(int id,String nume,int varsta,String email,String parola){
        inserat=new Student(id,nume,varsta,email,parola);
    }
    public Student studentLogat(){
        return studentLogat;
    }

    public int getIdStudentLogat(){
        return studentLogat.getIdStudent();
    }
    public int getVarstaStudentLogat(){
        return studentLogat.getAge();
    }
    public String getEmailStudentLogat(){
        return studentLogat.getEmail();
    }
    public String getNumeStudentLogat(){
        return studentLogat.getName();
    }
    public String getParolaStudentLogat(){
        return studentLogat.getPassword();
    }
    public void setVarstaStudentLogat(int v){studentLogat.setAge(v);
    }
    public void setEmailStudentLogat(String e){
        studentLogat.setEmail(e);
    }
    public void setParolaStudentLogat(String p){
        studentLogat.setPassword(p);
    }
    public void setNumeStudentLogat(String n){
        studentLogat.setName(n);
    }

}
