package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JButton login=new JButton("Login");
    private JLabel  nume=new JLabel("Nume");
    private JLabel parola=new JLabel("Parola");
    private JPasswordField textParola=new JPasswordField(15);
    private JTextField textNume=new JTextField(15);
    private JButton create=new JButton("Creare Cont");
    private JRadioButton profesor=new JRadioButton("Profesor");
    private JRadioButton student=new JRadioButton("Student");
    public Login(){
        JPanel panel=new JPanel();
        panel. setLayout (new BoxLayout (panel, BoxLayout . Y_AXIS ));
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(nume);
        p1.add(textNume);
        p1.add(parola);
        p1.add(textParola);
        p1.add(login);
        p1.add(create);
        p1.add(profesor);
        p1.add(student);
        panel.add(p1);
        this.setTitle("Login");
        this.add(panel);
        this.setSize(260,200);
        this.setVisible(true);
    }
    public String getParola(){
        return textParola.getText();
    }
    public String getNume(){
        return textNume.getText();
    }
    public void setTextParola(){
        textParola.setText("");
    }
    public void setTextNume(){textNume.setText("");}
    public void setRadio(){ student.setSelected(false);
        profesor.setSelected(false);}

    public String getOptiune(){
        if (profesor.isSelected()) return "Profesor";
        if(student.isSelected()) return "Student";
        return "";
    }

    public void showMessage(String s){
        JOptionPane.showMessageDialog(this,s);
    }

    public void loginActionListener(ActionListener mal){
        login.addActionListener(mal);
    }
    public void createActionListener(ActionListener mal){
        create.addActionListener(mal);
    }

}
