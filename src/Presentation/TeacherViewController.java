package Presentation;

import Business.CourseBusiness;
import Business.StudentBusiness;
import Business.TeacherBusiness;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TeacherViewController {
    public TeacherView teacherView;
    private Login login;
    private UpdateNota updateNota;
    private CourseBusiness course=new CourseBusiness();
    private StudentBusiness student=new StudentBusiness();
    private TeacherBusiness teacher;
    private Delete deleteView;

    public TeacherViewController(TeacherBusiness t,Login l){
        teacher=t;
        login=l;
        teacherView=new TeacherView();
        teacherView.listListener(new ListListener());
        teacherView.deleteNota(new deleteNota());
        teacherView.creareNota(new creareNota());
        teacherView.listaStudentiMaterieListener(new ListaStudentiMaterie());
        teacherView.logoutTeacher(new logoutTeacherListener());
    }

    class logoutTeacherListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            teacherView.setVisible(false);
            login.setTextParola();
            login.setTextNume();
            login.setRadio();
            login.setVisible(true);
        }
    }


    class ListaStudentiMaterie implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            List<Object> listaStudenti=new ArrayList<Object>();
            listaStudenti.addAll(student.studentiProfesor(teacher.getIdTeacherLogat()));
            List<String> note=new ArrayList<String>();
            note.addAll(course.noteDateProfesorStudent(teacher.getIdTeacherLogat(),"idteacher"));
            CreateJTableStudent jtabela=new CreateJTableStudent();
            StudentTable t=new StudentTable(jtabela.creare(listaStudenti,note));

        }
    }

    class creareNota implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            updateNota=new UpdateNota();
            updateNota.updateListener(new updateNotaListener());
        }
    }


    class updateNotaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            int idStudent=Integer.parseInt(updateNota.getIdStudent());
            String nota=updateNota.getNota();
            String data=updateNota.getDataExamen();
            int x=course.getIdClasa(idStudent,teacher.getIdTeacherLogat());
            course.setInserat(idStudent,teacher.getIdTeacherLogat());
            int verificare=course.updateNota(x,nota,data);
            if (verificare==0) {
                updateNota.setVisible(false);
                updateNota.showMessage("Nota actualizata");
            }
            else updateNota.showMessage("Nota incorecta");
        }
    }

    class deleteNota implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            deleteView=new Delete();
            deleteView.deleteListener(new deleteListener());
        }
    }
    class deleteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int idS=Integer.parseInt(deleteView.getId());
            int idP=teacher.getIdTeacherLogat();
            course.setInserat(idS,idP);
            int idC=course.getIdClasa(idS,idP);
            int verificare=(course.updateNota(idC,"-","")) ;
            if (verificare==0){
                deleteView.showMessage("Stergere realizata cu succes!");
                deleteView.setVisible(false);
            }
            else{
                deleteView.showMessage("studentul nu a fost gasit");
                deleteView.setVisible(false);
            }
        }
    }

    class ListListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            List<Object> listaStudenti=new ArrayList<Object>();
            listaStudenti.addAll(student.afisareStudenti());
            CreateJTabelStudenti jtabela=new CreateJTabelStudenti();
            StudentTable t=new StudentTable(jtabela.creare(listaStudenti));
        }
    }
}
