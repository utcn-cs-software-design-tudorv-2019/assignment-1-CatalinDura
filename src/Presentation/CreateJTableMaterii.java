package Presentation;

import javax.swing.*;
import java.util.List;

public class CreateJTableMaterii extends JFrame {


    public JTable creare(List<String> materii) {
        int col = 1;
        String[] coloane = new String[col];
        String[][] matrice = new String[materii.size()][col];
        coloane[0] = "Materie";
        int j = 0;
        for (int i = 0; i < materii.size(); i++){
            matrice[i][0]=materii.get(i);
        }


        JTable tabela=new JTable(matrice,coloane);
        return tabela;
    }
}

