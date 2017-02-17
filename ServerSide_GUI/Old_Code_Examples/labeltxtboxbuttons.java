import java.awt.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;


public class labeltxtboxbuttons extends JPanel implements ActionListener
{
  private JLabel labelLabel;
  private JTextField textBox;
  private JButton buttonadd;
  private JButton buttonsubtract;
  int x= 0;
  labeltxtboxbuttons(String label)
  {
    this.setLayout(new FlowLayout());
    labelLabel=new JLabel(label);
    textBox=new JTextField(3);
    buttonadd=new JButton("+");
    buttonsubtract=new JButton("-");
    this.add(labelLabel);
    this.add(textBox);
    this.add(buttonadd);
    this.add(buttonsubtract);
    buttonadd.addActionListener(this);
    buttonsubtract.addActionListener(this); 
  }
    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource()==buttonadd)
       {
         try{
         x = Integer.parseInt(textBox.getText());
         }catch(Exception ex){x=0;}
         x = x + 1;
         textBox.setText(""+x);
       }
       
       else if(e.getSource()==buttonsubtract)
       {
         try{
         x = Integer.parseInt(textBox.getText());
         }catch(Exception ex){x=0;}
         x = x - 1;
         textBox.setText(""+x);
       }
    }
  public String getRawData()
  {
    try{
    x = Integer.parseInt(textBox.getText());
    }catch(Exception ex){x=0;}
    if (x<0){
    x=0;
    }
    textBox.setText(""+x);
    return textBox.getText();
}
  public void reset(){
  textBox.setText("");
  }


}
