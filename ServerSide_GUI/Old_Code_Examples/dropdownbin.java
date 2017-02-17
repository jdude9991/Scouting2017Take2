import java.awt.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;


public class dropdownbin extends JPanel
{
     String[] comboBinArray= 
  {
    "--Container Height--",
    "1",
    "2",
    "3",
    "4",
    "5",
    "6"
  };
  
  private JComboBox dropdownBinBox1=new JComboBox(comboBinArray);
  private JComboBox dropdownBinBox2=new JComboBox(comboBinArray);
  private JComboBox dropdownBinBox3=new JComboBox(comboBinArray);
  private JComboBox dropdownBinBox4=new JComboBox(comboBinArray);
  private JComboBox dropdownBinBox5=new JComboBox(comboBinArray);
  private JComboBox dropdownBinBox6=new JComboBox(comboBinArray);
  private JComboBox dropdownBinBox7=new JComboBox(comboBinArray);
  private JCheckBox litter1= new JCheckBox();
  private JCheckBox litter2= new JCheckBox();
  private JCheckBox litter3= new JCheckBox();
  private JCheckBox litter4= new JCheckBox();
  private JCheckBox litter5= new JCheckBox();
  private JCheckBox litter6= new JCheckBox();
  private JCheckBox litter7= new JCheckBox();
  int numLitter = 0;        
  int max = 0;
  int contribution = 0;
  public int getContribution(){
  getRawData();
    contribution = (dropdownBinBox1.getSelectedIndex() * 4) + 
                   (dropdownBinBox2.getSelectedIndex() * 4) +
                   (dropdownBinBox3.getSelectedIndex() * 4) +
                   (dropdownBinBox4.getSelectedIndex() * 4) +
                   (dropdownBinBox5.getSelectedIndex() * 4) +
                   (dropdownBinBox6.getSelectedIndex() * 4) +
                   (dropdownBinBox7.getSelectedIndex() * 4);   
    
   contribution = contribution + numLitter * 6;

   return contribution;
  }
   
  dropdownbin()
  {
    this.setLayout(new GridLayout(8,2));
    this.add(new JLabel("Container Height"));
    this.add(new JLabel("Litter"));
    this.add(dropdownBinBox1);
    this.add(litter1);
    this.add(dropdownBinBox2);
    this.add(litter2);
    this.add(dropdownBinBox3);
    this.add(litter3);
    this.add(dropdownBinBox4);
    this.add(litter4);
    this.add(dropdownBinBox5);
    this.add(litter5);
    this.add(dropdownBinBox6);
    this.add(litter6);
    this.add(dropdownBinBox7);
    this.add(litter7);
    
  }
    public String getRawData()
    {
     numLitter = 0;
     if(litter1.isSelected()){
       numLitter = numLitter + 1;
    }
     if(litter2.isSelected()){
       numLitter = numLitter + 1;
    }
     if(litter3.isSelected()){
       numLitter = numLitter + 1;
    }
     if(litter4.isSelected()){
       numLitter = numLitter + 1;
    }
     if(litter5.isSelected()){
       numLitter = numLitter + 1;
    }
     if(litter6.isSelected()){
       numLitter = numLitter + 1;
    }
     if(litter7.isSelected()){
       numLitter = numLitter + 1;
    }
    max = dropdownBinBox1.getSelectedIndex();
   
    if(dropdownBinBox2.getSelectedIndex() > max){
    
    max = dropdownBinBox2.getSelectedIndex();
    }
    
     if(dropdownBinBox3.getSelectedIndex() > max){
       
       max = dropdownBinBox3.getSelectedIndex();
    }
     
     if(dropdownBinBox4.getSelectedIndex() > max){
       
       max = dropdownBinBox4.getSelectedIndex();
    }
     if(dropdownBinBox5.getSelectedIndex() > max){
       
       max = dropdownBinBox5.getSelectedIndex();
    }
     if(dropdownBinBox6.getSelectedIndex() > max){
       
       max = dropdownBinBox6.getSelectedIndex();
    }
     if(dropdownBinBox7.getSelectedIndex() > max){
       
       max = dropdownBinBox7.getSelectedIndex();
    }
     return ""+ numLitter +";"+ max;
    }
  public void reset()
  {
  dropdownBinBox1.setSelectedIndex(0);
  dropdownBinBox2.setSelectedIndex(0);
  dropdownBinBox3.setSelectedIndex(0);
  dropdownBinBox4.setSelectedIndex(0);
  dropdownBinBox5.setSelectedIndex(0);
  dropdownBinBox6.setSelectedIndex(0);
  dropdownBinBox7.setSelectedIndex(0);
  
  litter1.setSelected(false);
  litter2.setSelected(false);
  litter3.setSelected(false);
  litter4.setSelected(false);
  litter5.setSelected(false);
  litter6.setSelected(false);
  litter7.setSelected(false);
}
  }