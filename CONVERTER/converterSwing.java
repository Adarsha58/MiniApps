/**
 * This application converts the value 
 * from one unit to 
 * another.
 * @author (Adarsha Poudel)
 * @version (1.0)
 */
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  

public class converterSwing extends Frame implements ActionListener{  
   private JLabel input, to, output;
   private JTextField inputTF;
   private JComboBox fromBox, toBox;
   private JButton convert;   
   
   /*
    * default constructor
    * initializes default layout for the application
    */
   converterSwing(){
       JFrame f= new JFrame ("Converter Application");//creating instance of a frame for the application
       
       input = new JLabel("INPUT");
       input.setFont(new Font("Serif", Font.PLAIN, 20));
       input.setBounds(0,200,200,100);
       
       inputTF= new JTextField();
       inputTF.setBounds(300,200,400,100);
       
       /*
        * elements for two JComboBoxes 
        */
       final String[] UnitFrom = {"kg" , "g" , "lb"};
       final String[] UnitTo = {"kg" , "g" , "lb"};
       
       fromBox = new JComboBox(UnitFrom);
       fromBox.setBounds(200,400,200,100);
       
       to= new JLabel("to");
       to.setFont(new Font("Serif", Font.PLAIN, 20));
       to.setBounds(450,400,100,100);
       
       toBox= new JComboBox(UnitTo);
       toBox.setBounds(600,400,200,100);
     
       convert= new JButton(new ImageIcon("button_convert.png"));
       convert.setBounds(200,600,600,100);
       convert.addActionListener(this);
       
       output= new JLabel();
       output.setFont(new Font("Serif", Font.PLAIN, 40));
       output.setBounds(350,800,400,100);
       
       f.add(input); f.add(inputTF); f.add(fromBox); f.add(to); f.add(toBox); f.add(convert); f.add(output); //adds components to the frame
       f.setSize(1000, 1000);//1000 width 1000 height
       f.setLayout(null);//using no layout manager
       f.setVisible(true);//making the frame visible
    }
    
    /*
     * sets the action when convert button is pressed
     */
    public void actionPerformed(ActionEvent e){
        String from = fromBox.getItemAt(fromBox.getSelectedIndex()) + "";
        String to = toBox.getItemAt(toBox.getSelectedIndex()) + "";
       
        double convertedOutput = 0;
        if(from.equals(to)) convertedOutput= Integer.parseInt(inputTF.getText()); //no conversion needed if the output input is same as the input unit
        if(from.equals("kg") && to.equals("g"))   convertedOutput= FromKgToG(inputTF.getText()); //converts from kilogram to gram
        if(from.equals("g") && to.equals("kg"))   convertedOutput= FromGToKg(inputTF.getText()); //converts from gram to kilogram
        if(from.equals("kg") && to.equals("lb"))  convertedOutput= FromKgToPounds(inputTF.getText()); //converts from kilogram to pound
        if(from.equals("lb") && to.equals("kg"))  convertedOutput= FromPoundsToKg(inputTF.getText()); //converts from pound to kilogram
        if(from.equals("g") && to.equals("lb"))   convertedOutput= FromGToKg(FromKgToPounds(inputTF.getText())+""); //converts from gram to pound
        if(from.equals("lb") && to.equals("g"))   convertedOutput= FromKgToG(FromPoundsToKg(inputTF.getText())+""); //converts from pound to gram
        
        output.setText(inputTF.getText()+ " "+ from + " = "+ convertedOutput+ " "+ to); // sets ouput format; 1 kg = 1000 g
    }
    
    /*
     * converts from kilogram to gram
     */
    double FromKgToG(String TF){
        double toBeConverted= Integer.parseInt(TF);
        return toBeConverted*1000; 
    }
    
    /*
     * converts from gram to kilogram
     */
    double FromGToKg(String TF){
        double toBeConverted= Integer.parseInt(TF);
        return toBeConverted/1000; 
    }
    
    /*
     * converts from kilogram to pound
     */
    double FromKgToPounds(String TF){
        double toBeConverted= Integer.parseInt(TF);
        return toBeConverted*2.20462262; 
    }
    
    /*
     * converts from pound to kilogram
     */
     double FromPoundsToKg(String TF){
        double toBeConverted= Integer.parseInt(TF);
        return toBeConverted/2.20462262; 
    }
    
    /*
     * main runnable method
     */
    public static void main(String[] args){
        new converterSwing(); 
    }
}
