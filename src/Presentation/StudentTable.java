package Presentation;
import javax.swing.*;

public class StudentTable extends JFrame{
    private JTable tabel;
    public StudentTable(JTable t){
        tabel=t;
        JScrollPane scroll=new JScrollPane(tabel);
        this.setTitle("Students table");
        this.add(scroll);
        this.setSize(450,150);
        this.setVisible(true);
    }
}

