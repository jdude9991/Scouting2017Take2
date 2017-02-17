import java.awt.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class filterframe extends JFrame
{
  Container c;
  
  JTextField[][] fieldarray;
  
filterframe(ResultSet rs)
{
  c = getContentPane(); 

   fieldarray = new JTextField[21][8];
 
  fieldarray[0][0]= new JTextField();
  fieldarray[0][0].setEditable(false);
  fieldarray[0][0].setText("Team Number");
  
  fieldarray[0][1]= new JTextField();
  fieldarray[0][1].setEditable(false);
  fieldarray[0][1].setText("Average Totes");
  
  fieldarray[0][2]= new JTextField();
  fieldarray[0][2].setEditable(false);
  fieldarray[0][2].setText("Averge Totes Auto");

  fieldarray[0][3]= new JTextField();
  fieldarray[0][3].setEditable(false);
  fieldarray[0][3].setText("Average Container");
  
  fieldarray[0][4]= new JTextField();
  fieldarray[0][4].setEditable(false);
  fieldarray[0][4].setText("Average Container Auto");
  
  fieldarray[0][5]= new JTextField();
  fieldarray[0][5].setEditable(false);
  fieldarray[0][5].setText("Average Totes Stacked Auto");
  
  fieldarray[0][6]= new JTextField();
  fieldarray[0][6].setEditable(false);
  fieldarray[0][6].setText("Average Litter");
  
  fieldarray[0][6]= new JTextField();
  fieldarray[0][6].setEditable(false);
  fieldarray[0][6].setText("Average Contribution");
  try{
  for (int row=1; row<21 && rs.next(); row++)
{
for (int col=0; col<8; col++)
{
fieldarray[row][col]= new JTextField();
fieldarray[row][col].setEditable(false);
fieldarray[row][col].setText(rs.getString(col+1));
c.add(fieldarray[row][col]);
}
}
  }catch(Exception ex){}
  c.setLayout(new GridLayout(21,8));
}
}