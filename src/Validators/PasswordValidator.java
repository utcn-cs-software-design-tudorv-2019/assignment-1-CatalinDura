package Validators;
import Model.Student;

public class PasswordValidator implements Validator<Student> {

    @Override
    public int validate(Student c){
        if(c.getPassword().length()<3) return 1;
        else return 0;
    }
}
