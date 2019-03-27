package Model;

public class Teacher {
    private int idTeacher;
    private String name;
    private String email;
    private String phoneNumber;
    private String courseName;
    private String password;


    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "idTeacher=" + idTeacher +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", courseName='" + courseName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Teacher(int idTeacher, String name, String email, String phoneNumber, String courseName, String password) {
        this.idTeacher = idTeacher;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.courseName = courseName;
        this.password = password;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}