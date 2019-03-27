package Presentation;
import javax.swing.*;
import java.util.List;
public class CreateJTableNote extends JFrame {


    public JTable creare(List<String> note,List<String> profesori) {
        int col = 4;
        String[] coloane = new String[col];
        String[][] matrice = new String[profesori.size()][col];
        coloane[0] = "Profesor";
        coloane[1] = "Materie";
        coloane[2]="DateExam";
        coloane[3]="Note";
        int j = 0;
        for (int i = 0; i < profesori.size(); i++){
            String[] prof = profesori.get(i).split("@");
            matrice[i][0] = prof[0];
            matrice[i][1] = prof[1];
            String[] n=note.get(i).split("@");
            matrice[i][2]=n[1];
            matrice[i][3]=n[0];
        }


        JTable tabela=new JTable(matrice,coloane);
        return tabela;
    }
}

