package Presentation;
import javax.swing.*;
import java.awt.event.ActionListener;

public class UpdateNota extends JFrame {
    private JButton update=new JButton("ok");
    private JTextField nota=new JTextField(12);
    private JTextField idStudent=new JTextField(10);
    private JTextField dataExam=new JTextField(8);

    public UpdateNota(){
        JPanel panel=new JPanel();
        panel. setLayout (new BoxLayout (panel, BoxLayout . Y_AXIS ));
        JPanel p1=new JPanel();
        JLabel l1=new JLabel("nota");
        JLabel l2=new JLabel("idStudent");
        JLabel l3=new JLabel("DataExamen");
        p1.add(l1);
        p1.add(nota);
        JPanel p2=new JPanel();
        p2.add(l2);
        p2.add(idStudent);
        JPanel p3=new JPanel();
        p3.add(l3);
        p3.add(dataExam);
        panel.add(p2);
        panel.add(p1);
        panel.add(p3);
        panel.add(update);
        this.add(panel);
        this.setSize(200,200);
        this.setVisible(true);
    }

    public String getNota(){
        return nota.getText();
    }

    public String getDataExamen(){return dataExam.getText();}

    public void showMessage(String s){
        JOptionPane.showMessageDialog(this,s);
    }

    public String getIdStudent(){
        return idStudent.getText();
    }

    public void updateListener(ActionListener mal){
        update.addActionListener(mal);
    }
}
