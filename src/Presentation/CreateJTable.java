package Presentation;
import javax.swing.*;

public class CreateJTable extends JFrame {

    public JTable creare(int id,String nume,int varsta,String email,String parola) {
        int col = 5;
        String[] coloane = new String[col];
        String[][] matrice = new String[1][col];
        coloane[0] = "id";
        coloane[1]="nume";
        coloane[2]="varsta";
        coloane[3]="email";
        coloane[4]="parola";
        matrice[0][0]=""+id;
        matrice[0][1]=nume;
        matrice[0][2]=""+varsta;
        matrice[0][3]=email;
        matrice[0][4]=parola;


        JTable tabela=new JTable(matrice,coloane);
        return tabela;
    }
}

