import java.awt.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;


public class txtareaandlabel extends JPanel
{
  private JLabel labelLabel;
  private JTextArea textarea;
 txtareaandlabel(String label, int txtareax, int txtareay)
  {
    this.setLayout(new BorderLayout());
    labelLabel= new JLabel(label);
    textarea=new JTextArea(txtareax,txtareay);
    this.add(labelLabel, BorderLayout.NORTH);
    this.add(textarea, BorderLayout.CENTER);
  }
  
  public String getRawData()  {
    
      {
    String temp= textarea.getText();
    if(temp.equals(""))
    {
    temp="notprovided";
    }
    else
    {
      if(temp.indexOf(';')!= -1)
      {
       temp.replace(';',' ');
      }
      
      if(temp.indexOf(',') != -1)
           {
             temp.replace(',',' ');
           }            
         }

      
    return temp;
    
  }
  
}
  public void reset(){
  textarea.setText("");
  }

  
}