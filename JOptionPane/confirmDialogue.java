
/**
 * small application showing the use of JOptionPane
 *
 * @author (Adarsha Poudel)
 * @version (1.0)
 */
import javax.swing.*;  
import java.awt.event.*;  
public class confirmDialogue extends WindowAdapter
{
    JFrame f;
    JOptionPane p;
    confirmDialogue(){
        f= new JFrame();
        f.addWindowListener(this);
        f.setSize(200,200);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    /*
     * sets the default Close Operation to EXIT_ON_CLOSE
     */
    public void windowClosing(WindowEvent e) {  
        int a=JOptionPane.showConfirmDialog(f,"Are you sure?");  
        if(a==JOptionPane.YES_OPTION){  
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        }  
    }  
     
    public static void main(String[] args){
        new confirmDialogue();
    }
    
}
