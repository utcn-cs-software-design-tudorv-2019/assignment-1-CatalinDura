package Model;

public class Course {
    private int idCourse;
    private int idStudent;
    private int idTeacher;
    private String dateexam;
    private String grade;

    public Course(int idCourse, int idStudent, int idTeacher, String dateexam, String grade) {
        this.idStudent = idStudent;
        this.idTeacher = idTeacher;
        this.dateexam = dateexam;
        this.grade = grade;
    }
    public Course(){}

    public Course(int idcourse,int idStudent, int idTeacher, String grade) {
        this.idCourse=idcourse;
        this.idStudent = idStudent;
        this.idTeacher = idTeacher;
        this.dateexam = "--";
        this.grade = grade;
    }


    public Course(int idstudent,int idteacher){
        idStudent=idstudent;
        idTeacher=idteacher;
        dateexam="-";
        grade="-";
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getDateexam() {
        return dateexam;
    }

    public void setDateexam(String dateexam) {
        this.dateexam = dateexam;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
