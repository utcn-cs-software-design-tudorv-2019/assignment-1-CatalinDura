package Validators;
import Model.Course;

public class NotaValidator implements Validator<Course> {

    @Override
    public int validate(Course c){
        if(c.getGrade().equals("-")) return 0;
        int nota=Integer.parseInt(c.getGrade());
        if(nota>0 && nota <11) return 0;
        else return 1;
    }
}
