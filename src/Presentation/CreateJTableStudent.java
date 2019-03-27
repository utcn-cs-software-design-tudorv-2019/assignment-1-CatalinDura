package Presentation;
import javax.swing.*;
import java.util.List;

public class CreateJTableStudent extends JFrame {


    public JTable creare(List<Object> objects,List<String> note) {
        int col=0;
        col=objects.get(0).getClass().getDeclaredFields().length+2;
        String[] coloane=new String[col];
        int i=0;
        String[][] matrice=new String[objects.size()][col];
        for(java.lang.reflect.Field field : objects.get(0).getClass().getDeclaredFields()) {
            coloane[i]=field.getName();
            i=i+1;
        }
        coloane[i]="DataExamen";
        coloane[i+1]="Nota";
        i=0;
        int j=0;
        for(Object t:objects) {
            j=0;
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
        i=0;
        for(String x:note){
            String[] rez=x.split("@");
            matrice[i][j+1]=rez[0];
            matrice[i][j]=rez[1];
            i=i+1;
        }
        i=0;

        JTable tabela=new JTable(matrice,coloane);
        return tabela;
    }
}

