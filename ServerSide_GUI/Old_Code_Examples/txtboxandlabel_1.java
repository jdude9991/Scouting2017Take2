import java.awt.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;


public class txtboxandlabel extends JPanel
{
  private JLabel labelLabel;
  private JTextField textbox;
  txtboxandlabel(String label, int txtbox)
  {
    this.setLayout(new GridLayout(1,2));
    labelLabel= new JLabel(label);
    textbox=new JTextField(txtbox);
    this.add(labelLabel);
    this.add(textbox);
  }
  
  public String getRawData()
  {
    String temp= textbox.getText();
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
    
  public void reset(){
textbox.setText("");
}
    public void setEditable(boolean editable){
  textbox.setEditable(editable);
  }  
    public void setText(String text){
    textbox.setText(text);
    }
}