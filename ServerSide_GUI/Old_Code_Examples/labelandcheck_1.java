import java.awt.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;


public class labelandcheck extends JPanel
{
  private JLabel xlabel;
  private JCheckBox checkbox;
  labelandcheck(String label)
  {
    this.setLayout(new FlowLayout());
    xlabel= new JLabel(label);
    checkbox= new JCheckBox();
    this.add(xlabel);
    this.add(checkbox);
  }
  
  public String getRawData()
  {
    return ""+ checkbox.isSelected();
  }
  public void reset(){
    checkbox.setSelected(false);    
}
}