package Presentation;
import javax.swing.*;
import java.awt.event.ActionListener;

public class StudentView extends JFrame {
    private JButton profil=new JButton("Vezi profil");
    private JButton stergeCont=new JButton("Sterge Cont");
    private JButton updateProfil=new JButton("Update Cont");
    private JButton veziNote=new JButton("Vezi note");
    private JButton enroll=new JButton("Enroll class");
    private JButton logout=new JButton("Logout");

    public StudentView(){
        JPanel panel=new JPanel();
        panel.add(profil);
        panel.add(stergeCont);
        panel.add(updateProfil);
        panel.add(veziNote);
        panel.add(enroll);
        panel.add(logout);
        this.add(panel);
        this.setSize(200,200);
        this.setVisible(true);
    }
    public void profilListener(ActionListener mal){
        profil.addActionListener(mal);
    }
    public void stergeProfilListener(ActionListener mal){
        stergeCont.addActionListener(mal);
    }
    public void showMessage(String m){
        JOptionPane.showMessageDialog(this,m);
    }
    public void updateProfilListener(ActionListener mal){updateProfil.addActionListener(mal);}
    public void veziNoteListener(ActionListener mal){veziNote.addActionListener(mal);}
    public void enrollListener(ActionListener mal){enroll.addActionListener(mal);}
    public void logoutListener(ActionListener mal){logout.addActionListener(mal);}
}
