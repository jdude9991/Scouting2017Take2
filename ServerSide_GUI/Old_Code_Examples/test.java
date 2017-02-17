import java.awt.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

public class test extends JFrame implements ActionListener
{
  
    
  public static void main(String[] args) {
    //create and instance of this class, and set it to be visable when the program runs. 
    test ex = new test();
    ex.setVisible(true);
  }

test()
  {
    Container c;
    JLabel[][] labelArray= new JLabel[5][20];
    c= getContentPane();
    c.setLayout(new GridLayout(20,5));

    for(int i=0; i<20;i++)
    {
      for(int j=0; j<5;j++)
      {
        labelArray[j][i]=new JLabel("label "+(i*5+j));
        c.add(labelArray[j][i]);
      }
    }
  }
   public void actionPerformed(ActionEvent e){
   }
}