package Presentation;

import Business.StudentBusiness;
import Business.TeacherBusiness;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ControlPresentation {
    private Login login=new Login();
    private StudentBusiness student=new StudentBusiness();
    private TeacherBusiness teacher=new TeacherBusiness();
    private Create createView;
    public ControlPresentation(){
        login.loginActionListener(new LoginListener());
        login.createActionListener(new CreateListener());
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nume = login.getNume();
            String parola = login.getParola();
            String optiune = login.getOptiune();
            if (optiune.equals("")) {
                login.showMessage("nu ati selectat Profesor sau Student!");
            } else {
                if (optiune.equals("Student")) {
                    String verificare = student.Password(nume);
                    if (verificare.equals(parola)) {
                        login.showMessage("Login ca student!");
                        login.setVisible(false);
                        student.setStudentLogat(nume);
                        System.out.println(student.toString());
                        StudentViewController studentController=new StudentViewController(student,login);
                    } else {
                        login.showMessage("Eroare la autentificare");
                        login.setTextParola();
                    }
                } else {
                    String verificare = teacher.Password(nume);
                    if (verificare.equals(parola)) {
                        teacher.setTeacherLogat(nume);
                        System.out.println(teacher.toString());
                        login.showMessage("Login ca profesor!");
                        TeacherViewController teacherView=new TeacherViewController(teacher,login);
                        login.setVisible(false);
                    } else {
                        login.showMessage("Eroare la autentificare");
                        login.setTextParola();
                    }
                }
            }
        }
    }
    class CreateListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            createView=new Create();
            createView.creareListener(new CreareStudentListener());
        }
    }

    class CreareStudentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String i=createView.getId();
            int id=Integer.parseInt(i);
            String nume = createView.getNume();
            int varsta = Integer.parseInt(createView.getVarsta());
            String email = createView.getEmail();
            String parola1 = createView.getParola1();
            String parola2 = createView.getParola2();
            if (parola1.equals(parola2)) {
                student.studentInserat(id,nume,varsta,email,parola1);
                int verificare = student.insertStudent();
                if (verificare == 0){
                    createView.showMessage("Cont crea cu succes!");
                    createView.setVisible(false);
                }
                else createView.showMessage("Eroare creare cont!");

            }
        }
    }

    public static void main(String args[]){
        ControlPresentation x=new ControlPresentation();
    }
}
