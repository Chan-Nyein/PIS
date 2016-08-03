

package java_program;

import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class Main {


    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Windows UI is not compitalbe.","UI Error",JOptionPane.ERROR_MESSAGE);
        }
        StartUp s=new StartUp();
        s.setVisible(true);
        s.prograss();
    }

}
