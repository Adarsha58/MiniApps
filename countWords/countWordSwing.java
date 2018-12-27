
/**
 * demonstrates the use of JComponent: JTextArea to 
 * count words written in a text box
 * by the user
 * @author (Adarsha Poudel)
 * @version (1.0)
 */
import javax.swing.*;  
import java.awt.*; 
import java.awt.event.*;  

public class countWordSwing extends Frame implements ActionListener
{
    private JLabel output;
    private JTextArea area;
    countWordSwing(){
        JFrame f = new JFrame();
        
        output = new JLabel();
        output.setBounds(50,25,250,30);  
        output.setFont(new Font("Serif", Font.PLAIN, 20));
        
        area = new JTextArea();
        area.setBounds(20,75,250,200); 
        area.setLineWrap(true);
        area.setFont(new Font("Serif", Font.PLAIN, 20));
        
        JButton count = new JButton("COUNT");
        count.setFont(new Font("Serif", Font.PLAIN, 20));
        count.setBounds(100,300,120,30);  
        count.addActionListener(this);
        
        
        f.add(area); f.add(count); f.add(output);
        f.setSize(450,450);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    int wordCounter(String s){
        s.trim();
        s.replace(".", "");
        return s.split(" ").length;
    }
    
    int characterCounter(String s){
        return s.length();
    }
    
    public void actionPerformed(ActionEvent e){
        output.setText("Words= "+ wordCounter(area.getText()) + "  Character: " + characterCounter(area.getText()));
    }
    
    public static void main(String[] args){
        new countWordSwing();
    }
    
}
