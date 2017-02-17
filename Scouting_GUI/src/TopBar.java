import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

@SuppressWarnings("all") 
public class TopBar extends JPanel {
	JPanel namePan;
	JTextField nameBox;
	JPanel teamPan;
	JTextField teamBox;
	JPanel matchPan;
	JTextField matchBox;
	JPanel alliancePan;
	JRadioButton allianceRed;
	JRadioButton allianceBlue;
	ButtonGroup allianceColor;
	JPanel allianceScorePan;
	JTextField scoreBox;
	JPanel rpPan;
	JTextField rpBox;
	
	TopBar(){
		buildTopPanel();
	}

	private void buildTopPanel() {
		//name
		namePan = new JPanel();
		nameBox = new JTextField(30);
		
		namePan.setLayout(new FlowLayout());
		namePan.add(nameBox);
		namePan.setBorder(new TitledBorder("Name"));
		
		//teamNum
		teamPan = new JPanel();
		teamBox = new JTextField(4);
		
		teamPan.setLayout(new FlowLayout());
		teamPan.add(teamBox);
		teamPan.setBorder(new TitledBorder("Team Number"));
		
		//matchNum
		matchPan = new JPanel();
		matchBox = new JTextField(3);
		
		matchPan.setLayout(new FlowLayout());
		matchPan.add(matchBox);
		matchPan.setBorder(new TitledBorder("Match Number"));
		
		//allianceColor
		alliancePan = new JPanel();
		allianceRed = new JRadioButton("Red");
		allianceBlue = new JRadioButton("Blue");
		allianceColor = new ButtonGroup();
		
		allianceColor.add(allianceBlue);
		allianceColor.add(allianceRed);
		
		allianceRed.setSelected(true);
		allianceBlue.setSelected(false);
		
		alliancePan.setLayout(new GridLayout(1,2));
		alliancePan.add(allianceRed);
		alliancePan.add(allianceBlue);
		alliancePan.setBorder(new TitledBorder("Alliance Color"));
		
		//Alliance Score
		allianceScorePan = new JPanel();
		scoreBox = new JTextField(4);
		
		allianceScorePan.setLayout(new FlowLayout());
		allianceScorePan.add(scoreBox);
		allianceScorePan.setBorder(new TitledBorder("Alliance Score"));
		
		//RP
		rpPan = new JPanel();
		rpBox = new JTextField(1);
		
		rpPan.setLayout(new FlowLayout());
		rpPan.add(rpBox);
		rpPan.setBorder(new TitledBorder("RP"));
	
		this.setLayout(new GridLayout(2,3));
		this.add(namePan);
		this.add(teamPan);
		this.add(matchPan);
		this.add(alliancePan);
		this.add(allianceScorePan);
		this.add(rpPan);
	}
	
	public void reset(){
		nameBox.setText("");
		teamBox.setText("");
		matchBox.setText("");
		allianceRed.setSelected(true);
		allianceBlue.setSelected(false);
		scoreBox.setText("");
		rpBox.setText("");
	}
	
	public String getRawData(){
		String topBarData = "";
		String x = "";
		
		if(allianceRed.isSelected()){
			x = "R";
		}
		else if(allianceBlue.isSelected()){
			x = "B";
		}
		
		topBarData = "Name;\"" + nameBox.getText() + "\"\n" +
		             "TeamNumber;" + teamBox.getText() + "\n" +
		             "MatchNumber;" + matchBox.getText() + "\n" +
		             "AllianceColor;\"" + x + "\"\n" +
		             "AllianceScore;" + scoreBox.getText() + "\n" +
		             "RPEarned;" + rpBox.getText() + "\n";
		
		return topBarData;
	}
}
