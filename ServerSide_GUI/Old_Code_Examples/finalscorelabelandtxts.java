import java.awt.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;


public class finalscorelabelandtxts extends JPanel
{
  private JLabel redLabel;
  private JLabel blueLabel;
  private JTextField redscore;
  private JTextField bluescore;
  finalscorelabelandtxts(String labelx, String labely)
  {
    this.setLayout(new GridLayout(2,2));
    redLabel= new JLabel(labelx);
    blueLabel= new JLabel(labely);
    redscore=new JTextField(3);
    bluescore=new JTextField(3);
    this.add(redLabel);
    this.add(blueLabel);
    this.add(redscore);
    this.add(bluescore);
  }
  
  public String getRawData()
  {
    return redscore.getText() +";"+ bluescore.getText();
  }
  public void reset(){
    redscore.setText("");
    bluescore.setText("");
  }
}