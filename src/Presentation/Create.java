package Presentation;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Create extends JFrame {
    private JButton creare=new JButton("Creare");
    private JLabel id=new JLabel("id");
    private JLabel nume=new JLabel("nume");
    private JLabel varsta=new JLabel("varsta");
    private JLabel email=new JLabel("email");
    private JLabel parola1=new JLabel("parola");
    private JLabel parola2=new JLabel("parola");
    private JTextField idText=new JTextField(15);
    private JTextField numeText=new JTextField(15);
    private JTextField varstaText=new JTextField(15);
    private JTextField emailText=new JTextField(15);
    private JPasswordField parola1Text=new JPasswordField(15);
    private JPasswordField parola2Text=new JPasswordField(15);

    public Create(){
        JPanel panel=new JPanel();
        panel. setLayout (new BoxLayout (panel, BoxLayout . Y_AXIS ));
        JPanel p1=new JPanel();
        p1.add(id);
        p1.add(idText);
        JPanel p2=new JPanel();
        p2.add(nume);
        p2.add(numeText);
        JPanel p3=new JPanel();
        p3.add(varsta);
        p3.add(varstaText);
        JPanel p4=new JPanel();
        p4.add(email);
        p4.add(emailText);
        JPanel p5=new JPanel();
        p5.add(parola1);
        p5.add(parola1Text);
        JPanel p6=new JPanel();
        p6.add(parola2);
        p6.add(parola2Text);
        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        panel.add(p4);
        panel.add(p5);
        panel.add(p6);
        panel.add(creare);
        this.setTitle("Creare student");
        this.add(panel);
        this.setSize(300,300);
        this.setVisible(true);
    }
    public String getId(){
        return idText.getText();
    }

    public String getNume(){
        return numeText.getText();
    }

    public String getVarsta(){
        return varstaText.getText();
    }

    public String getEmail(){
        return emailText.getText();
    }

    public String getParola1(){
        return parola1Text.getText();
    }

    public String getParola2(){
        return parola2Text.getText();
    }

    public void setParola1(){
        parola1Text.setText("");
    }

    public void setParola2(){
        parola2Text.setText("");
    }

    public void creareListener(ActionListener mal){
        creare.addActionListener(mal);
    }
    public void showMessage(String s){
        JOptionPane.showMessageDialog(this,s);
    }
}
