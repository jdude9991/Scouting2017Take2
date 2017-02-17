import java.awt.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;


public class teamcolorandchecks extends JPanel
{
  private JLabel teamcolorLabel;
  private JRadioButton check1red;
  private JRadioButton check2blue;
  private ButtonGroup teamColorGroup= new ButtonGroup();
  teamcolorandchecks(String label)
  {
    this.setLayout(new FlowLayout());
    teamcolorLabel= new JLabel(label);
    check1red= new JRadioButton();
    check2blue= new JRadioButton();    
    check1red.setBackground(Color.red);
    check2blue.setBackground(Color.blue);
    teamColorGroup.add(check1red);
    teamColorGroup.add(check2blue);
    this.add(teamcolorLabel);
    this.add(check1red);
    this.add(check2blue);
  }
  
  public String getRawData()
  {
    if(check1red.isSelected())
    {
      return "red";
  }
   else if(check2blue.isSelected())
   {
     return "blue";
}
  else
  {
    return "error";
  }
  }
public void reset(){
  teamColorGroup.clearSelection();
  } 

}