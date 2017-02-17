import java.awt.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;


public class dropdownandlabel extends JPanel
{
  private JLabel labelLabel;
  private JComboBox comboGeneric;
  dropdownandlabel(String label,  String[] comboGenericArray)
  {
    this.setLayout(new GridLayout(2,1));
    labelLabel= new JLabel(label);
    comboGeneric= new JComboBox(comboGenericArray);
    this.add(labelLabel);
    this.add(comboGeneric);
  }
  public String getRawData(){

    return ""+ comboGeneric.getSelectedIndex();                       
                           
}
  public void reset()
  {
  comboGeneric.setSelectedIndex(0);
  }
  
  public int getSelectedIndex()
  {
  return comboGeneric.getSelectedIndex(); 
  }

}