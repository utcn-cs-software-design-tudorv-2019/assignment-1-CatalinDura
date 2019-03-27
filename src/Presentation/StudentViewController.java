package Presentation;

import Business.CourseBusiness;
import Business.StudentBusiness;
import Business.TeacherBusiness;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentViewController {
    private Login login;
    private Create updateProfil;
    private CourseBusiness course=new CourseBusiness();
    private StudentBusiness student;
    private TeacherBusiness teacher=new TeacherBusiness();
    private Enroll enrollView;
    private StudentView studentView;

    public StudentViewController(StudentBusiness x,Login l){
        student=x;
        login=l;
        studentView=new StudentView();
        studentView.profilListener(new profilListener());
        studentView.stergeProfilListener(new stergeProfilListener());
        studentView.updateProfilListener((new updateProfilListener()));
        studentView.veziNoteListener(new veziNoteListener());
        studentView.enrollListener(new enrollListener());
        studentView.logoutListener(new logoutStudentListener());
    }

    class logoutStudentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            studentView.setVisible(false);
            login.setVisible(true);
            login.setTextNume();
            login.setTextParola();
            login.setRadio();
        }
    }

    class enrollListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            List<String> materii=new ArrayList<String>();
            materii.addAll(teacher.materiiDisponibile());
            CreateJTableMaterii tabelMaterii=new CreateJTableMaterii();
            enrollView=new Enroll(tabelMaterii.creare(materii));
            enrollView.enrollListener(new enrollMaterieListener());
        }
    }

    class enrollMaterieListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String materie=enrollView.getMaterie();
            int idprofesor=teacher.idTeacher(materie);
            if(course.getIdClasa(student.getIdStudentLogat(),idprofesor)==0) {
                System.out.println(course.toString());
                course.setInserat(student.getIdStudentLogat(), idprofesor);
                course.insert();
                enrollView.showMessage("Enroll reusit la materie" + materie);
                enrollView.setVisible(false);
            }
            else{
                enrollView.showMessage("Sunteti deja inscris la aceasta materie");
            }
        }
    }


    class veziNoteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            List<String> note=new ArrayList<String>();
            note.addAll(course.noteDateProfesorStudent(student.getIdStudentLogat(),"idstudent"));
            List<String> profesori=new ArrayList<String>();
            profesori.addAll(teacher.profesoriStudent(student.getIdStudentLogat()));
            CreateJTableNote rezultat=new CreateJTableNote();
            StudentTable afisare=new StudentTable(rezultat.creare(note,profesori));
        }
    }

    class updateProfilListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            updateProfil=new Create();
            updateProfil.creareListener(new updateProfil());

        }
    }

    class updateProfil implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String nume = updateProfil.getNume();
            String varsta=updateProfil.getVarsta();
            String email = updateProfil.getEmail();
            String parola1 = updateProfil.getParola1();
            String parola2 = updateProfil.getParola2();
            if(!varsta.equals(""))
                student.setVarstaStudentLogat(Integer.parseInt(varsta));
            if(!nume.equals(""))
                student.setNumeStudentLogat(nume);
            if(!email.equals(""))
                student.setEmailStudentLogat(email);
            if(!parola1.equals("")&& parola1.equals(parola2))
                student.setParolaStudentLogat(parola1);
            int verificare=student.updateStudent(student.getIdStudentLogat());
            if(verificare==0) {
                updateProfil.showMessage("Profil actualizat!");
                updateProfil.setVisible(false);
            }
            else updateProfil.showMessage("Date de actualizare incorecte");
        }

    }

    class stergeProfilListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            course.deleteByIdStudent(student.getIdStudentLogat());
            student.deleteStudent(student.getIdStudentLogat());
            studentView.showMessage("Cont sters cu succes!");
            studentView.setVisible(false);
            login.setTextParola();
            login.setVisible(true);

        }
    }

    class profilListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            CreateJTable jtabela=new CreateJTable();
            StudentTable t=new StudentTable(jtabela.creare(student.getIdStudentLogat(),
                    student.getNumeStudentLogat(),student.getVarstaStudentLogat(),
                    student.getEmailStudentLogat(),student.getParolaStudentLogat()));

        }
    }
}
