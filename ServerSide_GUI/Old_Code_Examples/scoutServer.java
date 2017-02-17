import java.io.*;
import java.awt.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;

public class scoutServer extends JFrame implements ActionListener 
{
   
  public static void main(String[] args) {
    //create and instance of this class, and set it to be visable when the program runs. 
    scoutServer ex = new scoutServer();
    ex.setVisible(true);
    }
  BufferedReader file;
  Container c;
  
  String insertBase = "INSERT INTO scouting_info(team_number,";
  String filePathBase;
  String[] filesToUpdate;  
  String read;
  String whereCondition;  
  
  //north
  String teamquerystring;
  JPanel north = new JPanel();
  txtboxandlabel teamNumber = new txtboxandlabel("Team Number: ", 4);
  JButton teamQuery = new JButton("Query");
  
 //mid
  String queryfilter;
  JPanel mid = new JPanel();
  String[] sort = {
  "--Sort--",
  "Avg Totes",
  "Avg Totes Auto",
  "Avg Container",
  "Avg Containers Auto",
  "Avg Totes Stacked Auto",
  "Avg Litter"
  };
  dropdownandlabel dropdownfilter = new dropdownandlabel("Sort By", sort);
  JButton filterquery = new JButton("Query");
  
  JPanel check = new JPanel();
  labelandcheck excessiveFouls = new labelandcheck("Excessive Fouls");
  labelandcheck flippedBot = new labelandcheck("Flipped Robot");
  labelandcheck brokenDown = new labelandcheck("Broken Down");
  labelandcheck notOpp = new labelandcheck("Not Operational");  
  labelandcheck buriedUnderTotes = new labelandcheck("Buried under Totes");  
  labelandcheck stuckField = new labelandcheck("Stuck on Field");
  labelandcheck stuckRobot = new labelandcheck("Something stuck in robot");
  labelandcheck connect = new labelandcheck("Connection Issues");
  labelandcheck other = new labelandcheck("Other");
  
  JButton update = new JButton("Update Database");
  JPanel midnorth = new JPanel();
  
  
  
  scoutServer(){
  c = getContentPane();
  c.setLayout(new BorderLayout());
  north.setLayout(new FlowLayout());
  mid.setLayout(new BorderLayout());
  check.setLayout(new GridLayout(9,1));
  
  check.add(excessiveFouls);
  check.add(flippedBot);
  check.add(brokenDown);
  check.add(notOpp);
  check.add(buriedUnderTotes);
  check.add(stuckField);
  check.add(stuckRobot);
  check.add(connect);
  check.add(other);
  
  midnorth.add(dropdownfilter);
  midnorth.add(filterquery);
  mid.add(check,BorderLayout.CENTER);
  mid.add(midnorth,BorderLayout.NORTH);
          
  north.add(teamNumber);
  north.add(teamQuery);
  
  c.add(north,BorderLayout.NORTH);
  c.add(mid,BorderLayout.CENTER);
  c.add(update,BorderLayout.SOUTH);
  
  filterquery.addActionListener(this);
  teamQuery.addActionListener(this);
  update.addActionListener(this);
  
  }
  public void actionPerformed(ActionEvent e){
    if(e.getSource()==teamQuery){
    teamquerystring = "select"+
      " team_number,"+
      " avg(totes_stacked_tele),"+
      " avg(num_litt),"+
      " avg(contain_max_height),"+
      " avg(totes_stacked_auto_zone),"+
      " avg(contain_max_height),"+
      " driveteam,"+
      " auto_start,"+
      //"(totes_auto_zone)/(totes_auto_zone)+(totes_stacked_auto_zone)+(totes_stacked_tele),"+
      " avg(totes_auto_zone),"+
      " avg(totes_stacked_auto_zone),"+
      " avg(bins_auto_zone),"+
      " problem_dropdown1,"+
      " problem_dropdown2,"+
      " match_number,"+
    " FROM scouting_data WHERE team_number = "+ teamNumber.getRawData() +" GROUP BY team_number;"; 
    }  
    
    else if(e.getSource()==filterquery){
    
   whereCondition = "";
      
      if (excessiveFouls.getSelected())
      {
        whereCondition= whereCondition + "NOT Problems1 = 1 OR NOT Problems2 = 1 OR ";
      }
      if (flippedBot.getSelected())
      {
        whereCondition= whereCondition + "NOT Problems1 = 2 OR NOT Problems2 = 2 OR ";
      }
      if (brokenDown.getSelected())
      { 
        whereCondition= whereCondition + "NOT Problems1 = 3 OR NOT Problems2 = 3 OR ";
      }
      if (notOpp.getSelected())
      {
        whereCondition= whereCondition + "NOT Problems1 = 4 OR NOT Problems2 = 4 OR ";
      }
      if (buriedUnderTotes.getSelected())
      {
        whereCondition= whereCondition + "NOT Problems1 = 5 OR NOT Problems2 = 5 OR ";
      }
      if (stuckField.getSelected())
      {
        whereCondition= whereCondition + "NOT Problems1 = 6 OR NOT Problems2 = 6 OR ";
      }
      if (stuckRobot.getSelected())
      {
        whereCondition= whereCondition + "NOT Problems1 = 7 OR NOT Problems2 = 7 OR ";
      }
      if (connect.getSelected())
      {
        whereCondition= whereCondition + "NOT Problems1 = 8 OR NOT Problems2 = 8 OR ";
      }
        if (other.getSelected())
      {
        whereCondition= whereCondition + "NOT Problems1 = 9 OR NOT Problems2 = 9 OR ";
      }

      if(!whereCondition.equals("")){
      whereCondition=whereCondition.substring(0,whereCondition.length() - 3);
      }
    System.out.println(whereCondition);
    
    queryfilter = "select"+
      " team_number,"+
      " avg(totes_stacked_tele),"+
      " avg(totes_auto_zone),"+
      " avg(contain_max_height),"+
      " avg(bins_auto_zone),"+
      " avg(totes_stacked_auto_zone),"+
      " avg(num_litt),"+
      " avg(contibutions)"+
      " from scouting_info group by team_number Where "+ whereCondition +" order by "+(dropdownfilter.getSelectedIndex()+1)+" Desc limit 20;";
    System.out.println(queryfilter);
    }   
    
    else if(e.getSource()==update){  
      try{
        filePathBase = new File("").getAbsolutePath()+"\\toUpdate";
        filesToUpdate = new File(filePathBase).list();
        for(int i=0; i<filesToUpdate.length; i++){
          if(filesToUpdate[i].substring(filesToUpdate[i].length()-6).equals(".scout")){
            file =new BufferedReader(new FileReader(new File(filePathBase+"\\"+filesToUpdate[i])));
            read = file.readLine();
            file.close();
            new File(filePathBase+"\\"+filesToUpdate[i]).renameTo(new File("done\\"+filesToUpdate[i]));
            System.out.println(read);
            read=read.replace(';',',');
          }

        }     
        
      }catch(Exception ex){
      ex.printStackTrace();
      }
    }  
  }
  
}