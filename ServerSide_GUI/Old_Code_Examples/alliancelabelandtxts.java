import java.awt.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;


public class alliancelabelandtxts extends JPanel
{
  private JLabel allianceLabel;
  private JTextField allie1;
  private JTextField allie2;
  alliancelabelandtxts(String label)
  {
    this.setLayout(new GridLayout(3,1));
    allianceLabel= new JLabel(label);
    allie1=new JTextField(4);
    allie2=new JTextField(4);
    this.add(allianceLabel);
    this.add(allie1);
    this.add(allie2);
  }
  
  public String getRawData()
  {
    return allie1.getText() +";"+ allie2.getText();
  }
  public void reset()
  {
  allie1.setText("");
  allie2.setText(""); 
  }
}