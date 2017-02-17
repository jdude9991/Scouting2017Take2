import java.awt.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class teamqueryframe extends JFrame implements ActionListener
{
Container c;  

txtboxandlabel teamNum = new txtboxandlabel("team Number: ", 4);
txtboxandlabel avgTotes = new txtboxandlabel("Adverage Totes: ", 3);
txtboxandlabel advlitter = new txtboxandlabel("Adverage Litter: ", 3);
txtboxandlabel advcontain = new txtboxandlabel("Adverage Containers: ", 3);
txtboxandlabel maxtotesheight = new txtboxandlabel("Max Totes Height: ", 3);
txtboxandlabel maxcontainheight = new txtboxandlabel("Max Container Height: ", 3);
txtboxandlabel driveteam = new txtboxandlabel("Drive Team: ", 12);
txtboxandlabel autoposition = new txtboxandlabel("Auto Position: ", 3);
txtboxandlabel percentinautozone = new txtboxandlabel("Percent Totes in Auto Zone: ", 3);
txtboxandlabel advtotesinautozone = new txtboxandlabel("Adverage Totes in Auto: ", 3);
txtboxandlabel advtotesstackedinauto = new txtboxandlabel("Adverage Totes Stacked in Auto: ", 3);
txtboxandlabel advcontaininauto = new txtboxandlabel("Max Container Height: ", 3);
txtboxandlabel listofproblems = new txtboxandlabel("Max Container Height: ", 3);
txtboxandlabel matchnum = new txtboxandlabel("Max Container Height: ", 3);
dropdownandlabel dropdown;
String[] commentsString;
JButton query = new JButton("Get Comments");

teamqueryframe(String[][] commentsQuery, ResultSet rs)
{
c = getContentPane(); 

dropdown = new dropdownandlabel("Comments: ", commentsQuery[0]);
commentsString = commentsQuery[1];
  
teamNum.setEditable(false);
avgTotes.setEditable(false); 
advlitter.setEditable(false);
advcontain.setEditable(false);
maxtotesheight.setEditable(false);
maxcontainheight.setEditable(false);
driveteam.setEditable(false);
autoposition.setEditable(false);
percentinautozone.setEditable(false);
advtotesinautozone.setEditable(false);
advtotesstackedinauto.setEditable(false);
advcontaininauto.setEditable(false);
listofproblems.setEditable(false);
matchnum.setEditable(false);

try{
  if(rs.next())
{teamNum.setText(rs.getString(1));
avgTotes.setText(rs.getString(2)); 
advlitter.setText(rs.getString(3));
advcontain.setText(rs.getString(4));
maxtotesheight.setText(rs.getString(5));
maxcontainheight.setText(rs.getString(6));
driveteam.setText(rs.getString(7));
autoposition.setText(rs.getString(8));
percentinautozone.setText(rs.getString(9));
advtotesinautozone.setText(rs.getString(10));
advtotesstackedinauto.setText(rs.getString(11));
advcontaininauto.setText(rs.getString(12));
listofproblems.setText(rs.getString(13));
matchnum.setText(rs.getString(14));
  }
}catch(Exception ex){}
  
query.addActionListener(this);

c.setLayout(new GridLayout(2,8));
c.add(teamNum);
c.add(avgTotes);
c.add(advlitter);
c.add(advcontain);
c.add(maxtotesheight);
c.add(maxcontainheight);
c.add(driveteam);
c.add(autoposition);
c.add(percentinautozone);
c.add(advtotesinautozone);
c.add(advtotesstackedinauto);
c.add(advcontaininauto);
c.add(listofproblems);
c.add(matchnum);
c.add(dropdown);
c.add(query);

}
public void actionPerformed(ActionEvent e){
  JOptionPane.showMessageDialog(new JFrame(), commentsString[dropdown.getSelectedIndex()]);  
}
  
}  