package Presentation;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Enroll extends JFrame {
    private JButton ok=new JButton("OK");
    private JTextField materie=new JTextField(8);
    public Enroll(JTable t){
        JPanel panel=new JPanel();
        JLabel l1=new JLabel("Introduceti materie");
        panel.add(l1);
        panel.add(materie);
        panel.add(ok);
        JScrollPane scroll=new JScrollPane(t);
        panel.add(scroll);
        this.setTitle("Enroll materie");
        this.add(panel);
        this.setSize(500,300);
        this.setVisible(true);
    }

    public String getMaterie(){
        return materie.getText();
    }
    public void enrollListener(ActionListener mal){
        ok.addActionListener(mal);
    }
    public void showMessage(String s){
        JOptionPane.showMessageDialog(this,s);
    }

}
