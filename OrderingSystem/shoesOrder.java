import javax.swing.*;  
import java.awt.event.*;  

public class shoesOrder{
    JLabel l;
    JCheckBox c1;
    JCheckBox c2;
    JButton b;
    shoesOrder(){
        JFrame f = new JFrame("Ordering system");
        
        l = new JLabel("Pick your shoes below");
        l.setBounds(50,50,300,20);  
        
        c1 = new JCheckBox("Converse");
        c1.setBounds(100,100,150,20);  
        c2 = new JCheckBox("Sporting Shoes");
        c2.setBounds(100,150,150,20);  
        
        b = new JButton("Order");
        b.setBounds(40, 250, 150, 40);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int amt = 0;
                String msg = "Orders selected: \n";
                if(c1.isSelected()){
                    amt+= 30;
                    msg+="Coverse: $30\n";
                }
                if(c2.isSelected()){
                    amt+= 55;
                    msg+="Sports Shoes: $55\n";
                }
                msg+= "----------\n";
                JOptionPane.showMessageDialog(null,msg+"Total: $"+amt); 
        
            }
            
        });
        
        f.add(l); f.add(c1); f.add(c2); f.add(b);
        f.setSize(450,450);
        f.setLayout(null);
        f.setVisible(true);
        
    }
    
    public static void main(String[] args){
        new shoesOrder();
    }

}