package Validators;
import Model.Student;

public class VarstaValidator implements Validator<Student> {
    @Override
    public int validate(Student student) {
        if (student.getAge()>18 && student.getAge()<50) return 0;
        else return 1;
    }
}

