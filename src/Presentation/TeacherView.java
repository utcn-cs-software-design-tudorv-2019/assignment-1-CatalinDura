package Presentation;
import javax.swing.*;
import java.awt.event.ActionListener;

public class TeacherView extends JFrame {
    private JButton creareNota=new JButton("update nota/data");
    private JButton deleteNota=new JButton("stergere nota");
    private JButton listStudenti=new JButton("lista studenti");
    private JButton listaStudentiMaterie=new JButton("Stundetii Mei");
    private JButton logout=new JButton("Logout");

    public TeacherView(){
        JPanel panel=new JPanel();

        panel.add(creareNota);
        panel.add(deleteNota);
        panel.add(listaStudentiMaterie);
        panel.add(listStudenti);
        panel.add(logout);
        this.setTitle("Teacher view");
        this.add(panel);
        this.setSize(200,200);
        this.setVisible(true);
    }

    public void listListener(ActionListener mal){
        listStudenti.addActionListener(mal);
    }
    public void listaStudentiMaterieListener(ActionListener mal){listaStudentiMaterie.addActionListener(mal);}
    public void creareNota(ActionListener mal){
        creareNota.addActionListener(mal);
    }
    public void deleteNota(ActionListener mal){
        deleteNota.addActionListener(mal);
    }
    public void logoutTeacher(ActionListener mal){logout.addActionListener(mal);}
}
