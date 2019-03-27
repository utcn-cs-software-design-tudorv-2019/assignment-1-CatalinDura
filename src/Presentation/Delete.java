package Presentation;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Delete extends JFrame {
    private JButton delete=new JButton("OK");
    private JTextField id=new JTextField(5);
    public Delete(){
        JPanel panel=new JPanel();
        JLabel l1=new JLabel("Introduceti id student:");
        panel.add(l1);
        panel.add(id);
        panel.add(delete);
        this.setTitle("Delete student");
        this.add(panel);
        this.setSize(200,120);
        this.setVisible(true);
    }

    public String getId(){
        return id.getText();
    }
    public void deleteListener(ActionListener mal){
        delete.addActionListener(mal);
    }
    public void showMessage(String s){
        JOptionPane.showMessageDialog(this,s);
    }

}
