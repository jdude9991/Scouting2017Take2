import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

@SuppressWarnings("all") 
public class RadioButtonGroup extends JPanel{
	JRadioButton but1;
	JRadioButton but2;
	JRadioButton but3;
	ButtonGroup bgroup;
	
	RadioButtonGroup(String l1, String l2, String l3){
		but1 = new JRadioButton(l1);
		but2 = new JRadioButton(l2);
		but3 = new JRadioButton(l3);
		bgroup = new ButtonGroup();
		bgroup.add(but1);
		bgroup.add(but2);
		bgroup.add(but3);
		but1.setSelected(true);
		
		setLayout(new GridLayout(3,2));
		add(but1);
		add(but2);
		add(but3);
		setBorder(new LineBorder(Color.black));
	}
	
	public void reset(){
		but1.setSelected(true);
		but2.setSelected(false);
		but3.setSelected(false);
	}
	
	public String getRawData(){
		String rawData = "";
		if(but1.isSelected()){rawData = ""+1;}
		else if(but2.isSelected()){rawData = ""+2;}
		else if(but3.isSelected()){rawData = ""+3;}
		return rawData;
	}
}
