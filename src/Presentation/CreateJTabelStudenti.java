package Presentation;
import javax.swing.*;
import java.util.List;

public class CreateJTabelStudenti extends JFrame {


    public JTable creare(List<Object> objects) {
        int col=0;
        col=objects.get(0).getClass().getDeclaredFields().length;
        String[] coloane=new String[col];
        int i=0;
        String[][] matrice=new String[objects.size()][col];
        for(java.lang.reflect.Field field : objects.get(0).getClass().getDeclaredFields()) {
            coloane[i]=field.getName();
            i=i+1;
        }
        i=0;
        for(Object t:objects) {
            int j=0;
            for(java.lang.reflect.Field field:t.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object aux=field.get(t);
                    matrice[i][j]=aux.toString();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                j=j+1;
            }
            i=i+1;
        }
        JTable tabela=new JTable(matrice,coloane);
        return tabela;
    }
}

