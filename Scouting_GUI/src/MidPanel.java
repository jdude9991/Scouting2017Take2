import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("all")
public class MidPanel extends JPanel{
	GridBagConstraints gbc = new GridBagConstraints();
	JPanel autoInfo;
	RadioButtonGroup startPos;
	JCheckBox crossBase;
	JCheckBox gearsInAuto;
	TxtBoxAndLabelButtons successfulShotsHighGoalAuto;
	TxtBoxAndLabelButtons successfulShotsLowGoalAuto;
	RadioButtonGroup shotDistanceLowA;
	RadioButtonGroup shotDistanceHighA;
	JPanel teleInfo;
	TxtBoxAndLabelButtons gearsInTele;
	TxtBoxAndLabelButtons successfulShotsHighGoalTele;
	TxtBoxAndLabelButtons successfulShotsLowGoalTele;
	RadioButtonGroup shotDistanceLowT;
	RadioButtonGroup shotDistanceHighT;
	JCheckBox climb;
	JPanel commPan;
	JPanel issues;
	JLabel issuesLabel;
	JTextArea issuesArea;
	JPanel comments;
	JLabel commentsLabel;
	JTextArea commentsArea;
	
	boolean gearAutoSelected;
	int lgFuelA = 0;
	
	MidPanel() {
		buildPanel();
	}
	
	private void buildPanel(){
		//auto
		autoInfo = new JPanel();
		startPos = new RadioButtonGroup("Retrieval Zone", "Center", "Key");
		startPos.setBorder(new TitledBorder("Starting Zone"));
		crossBase = new JCheckBox("Cross Base");
		gearsInAuto = new JCheckBox("Does it Place Gear?");
		successfulShotsHighGoalAuto = new TxtBoxAndLabelButtons("Number of Shots in High Goal", 4);
		successfulShotsLowGoalAuto = new TxtBoxAndLabelButtons("Number of Shots in Low Goal", 4);
		shotDistanceHighA = new RadioButtonGroup("Short", "Medium", "Large");
		shotDistanceLowA = new RadioButtonGroup("Short", "Medium", "Large");
		
		autoInfo.setLayout(new GridBagLayout());
		autoInfo.setBorder(new TitledBorder("Autonomous"));
		JPanel bar = new JPanel();
		bar.setLayout(new FlowLayout());
		bar.add(startPos);
		bar.add(crossBase);
		bar.add(gearsInAuto);
		gearsInAuto.setBorder(new TitledBorder("Gears"));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0;
		autoInfo.add(bar);
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridBagLayout());
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0;
		pan1.add(successfulShotsLowGoalAuto, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		pan1.add(shotDistanceLowA,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 10;
		pan1.add(successfulShotsHighGoalAuto, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 15;
		pan1.add(shotDistanceHighA, gbc);
		
		pan1.setBorder(new TitledBorder("Shooting"));
		
		gbc.gridx = 0;
		gbc.gridy = 100;
		autoInfo.add(pan1,gbc);
		
		//tele
		teleInfo = new JPanel();
		gearsInTele = new TxtBoxAndLabelButtons("Number of Gears", 4);
		successfulShotsHighGoalTele = new TxtBoxAndLabelButtons("Number of Shots in High Goal", 4);
		successfulShotsLowGoalTele = new TxtBoxAndLabelButtons("Number of Shots in Low Goal", 4);
		shotDistanceHighT = new RadioButtonGroup("Short", "Medium", "Large");
		shotDistanceLowT = new RadioButtonGroup("Short", "Medium", "Large");
		climb = new JCheckBox("Did the bot climb?");
		
		teleInfo.setLayout(new GridBagLayout());
		teleInfo.setBorder(new TitledBorder("Teleop"));
		JPanel teleGearClimb = new JPanel();
		teleGearClimb.setLayout(new FlowLayout());
		teleGearClimb.add(gearsInTele);
		teleGearClimb.add(climb);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		teleInfo.add(teleGearClimb, gbc);
		
		gearsInTele.setBorder(new TitledBorder("Gears"));
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridBagLayout());
		pan2.setBorder(new TitledBorder("Shooter"));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		pan2.add(successfulShotsLowGoalTele,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		pan2.add(shotDistanceLowT,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 10;
		pan2.add(successfulShotsHighGoalTele,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 15;
		pan2.add(shotDistanceHighT,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 80;
		teleInfo.add(pan2,gbc);
		
		
		//comments
		commPan = new JPanel();
		issues = new JPanel();
		issuesLabel = new JLabel("Issues the Bot Ran Into:");
		issuesArea = new JTextArea(10,50);
		issuesArea.setLineWrap(true);
		issuesArea.setWrapStyleWord(true);
		
		issues.setLayout(new GridBagLayout());
		issuesArea.setBorder(new LineBorder(Color.BLACK));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0;
		issues.add(issuesLabel,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		issues.add(issuesArea,gbc);
		
		comments = new JPanel();
		commentsLabel = new JLabel("Other Comments");
		commentsArea = new JTextArea(10,50);
		commentsArea.setLineWrap(true);
		commentsArea.setWrapStyleWord(true);
		
		comments.setLayout(new GridBagLayout());
		commentsArea.setBorder(new LineBorder(Color.BLACK));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		comments.add(commentsLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		comments.add(commentsArea, gbc);
		
		commPan.setLayout(new GridLayout(1,2));
		commPan.setBorder(new TitledBorder("Comments:"));
		commPan.add(issues);
		commPan.add(comments);
		
		JPanel foo = new JPanel();
		foo.setLayout(new GridLayout(1,2));
		foo.add(autoInfo);
		foo.add(teleInfo);
		
		setLayout(new BorderLayout());
		add(foo, BorderLayout.CENTER);
		add(commPan, BorderLayout.SOUTH);
	}
	
	public void reset() {
		startPos.reset();
		crossBase.setSelected(false);
		gearsInAuto.setSelected(false);
		successfulShotsHighGoalAuto.reset();
		successfulShotsLowGoalAuto.reset();
		shotDistanceLowA.reset();
		shotDistanceHighA.reset();
		gearsInTele.reset();
		successfulShotsHighGoalTele.reset();
		successfulShotsLowGoalTele.reset();
		shotDistanceLowT.reset();
		shotDistanceHighT.reset();
		climb.setSelected(false);
		issuesArea.setText("");
		commentsArea.setText("");
	}
	
	public String getRawData(){
		//Sets Start Point
		String start = "";
		if(startPos.getRawData() == ""+1) {start = "\"Retrieval Zone\"";}
		else if(startPos.getRawData() == ""+2) {start = "\"Center\"";}
		else if(startPos.getRawData() == ""+3) {start = "\"Key\"";}
		else {start = "\"Error\"";}
		
		//Sets Cross Data
		String cross = "";
		if(crossBase.isSelected()) {cross = "\"Yes\"";}
		else {cross = "\"No\"";}
		
		//Sets Gears in Auto
		String gear = "";
		if(gearsInAuto.isSelected()) {gear = "\"Yes\"";}
		else {gear = "\"No\"";}
		
		//sets Low Goal Shot Distance Data
		String shotDistLowGoalA = "";
		if(shotDistanceLowA.getRawData() == ""+1) {shotDistLowGoalA = "\"Small\"";}
		else if(shotDistanceLowA.getRawData() == ""+2) {shotDistLowGoalA = "\"Medium\"";}
		else if(shotDistanceLowA.getRawData() == ""+3) {shotDistLowGoalA = "\"Large\"";}
		else {shotDistLowGoalA = "\"Error\"";}
		
		//sets High Goal Shot Distance Data
		String shotDistHighGoalA = "";
		if(shotDistanceHighA.getRawData() == ""+1) {shotDistHighGoalA = "\"Small\"";}
		else if(shotDistanceHighA.getRawData() == ""+2) {shotDistHighGoalA = "\"Medium\"";}
		else if(shotDistanceHighA.getRawData() == ""+3) {shotDistHighGoalA = "\"Large\"";}
		else {shotDistHighGoalA = "\"Error\"";}
		
		//sets High Goal Shot Distance Data
		String shotDistLowGoalT = "";
		if(shotDistanceLowT.getRawData() == ""+1) {shotDistLowGoalT = "\"Small\"";}
		else if(shotDistanceLowT.getRawData() == ""+2) {shotDistLowGoalT = "\"Medium\"";}
		else if(shotDistanceLowT.getRawData() == ""+3) {shotDistLowGoalT = "\"Large\"";}		
		else {shotDistLowGoalT = "\"Error\"";}
		
		//sets High Goal Shot Distance Data
		String shotDistHighGoalT = "";
		if(shotDistanceLowT.getRawData() == ""+1) {shotDistHighGoalT = "\"Small\"";}
		else if(shotDistanceLowT.getRawData() == ""+2) {shotDistHighGoalT = "\"Medium\"";}
		else if(shotDistanceLowT.getRawData() == ""+3) {shotDistHighGoalT = "\"Large\"";}
		else {shotDistHighGoalA = "\"Error\"";}
		
		//sets climb data
		String climbData = "";
		if(climb.isSelected()){climbData = "\"Yes\"";}
		else{climbData = "\"No\"";}
		
		String rawData = "";
		rawData = "StartPos;" + start + "\n" +
		          "CrossBase;" + cross + "\n" +
		          "GearsInAuto;" + gear+ "\n" + 
		          "SShotsLowGoalA;" + successfulShotsLowGoalAuto.getRawData() + "\n" + 
		          "ShotDistanceLowGoalA;" + shotDistLowGoalA + "\n" +
		          "SShotsHighGoalA;" + successfulShotsHighGoalAuto.getRawData() + "\n" + 
		          "ShotDistanceHighGoalA;" + shotDistHighGoalA + "\n" +
		          "GearsInTele;" + gearsInTele.getRawData() + "\n" +
		          "SShotsLowGoalTele;" + successfulShotsLowGoalTele.getRawData() + "\n" +
		          "ShotDistanceLowGoalT;" + shotDistLowGoalT + "\n" + 
		          "SShotHighGoalT;" + successfulShotsHighGoalTele.getRawData() + "\n" +
		          "ShotDistanceHighGoalT;" + shotDistHighGoalT + "\n" + 
		          "Climb;" + climbData + "\n" +
		          "Issues;" + "\"" + issuesArea.getText() + "\"\n" +
		          "Comm;" + "\"" + commentsArea.getText() + "\"\n" + autoCalc() + teleCalc();
		return rawData;
	}
	
	private String autoCalc(){
		int hgFuelA = Integer.parseInt(successfulShotsHighGoalAuto.getRawData());
		lgFuelA = Integer.parseInt(successfulShotsLowGoalAuto.getRawData());
		int crossScore = 0;
		
		if(crossBase.isSelected()){crossScore = 5;}
		else {crossScore = 0;}
		if(gearsInAuto.isSelected()){gearAutoSelected = true;}
		else {gearAutoSelected = false;}
		
		int autoScore = crossScore + (int)hgFuelA + (int)(lgFuelA/3);
		
		return "AutoScore;" + autoScore + "\n";
		 
	}
	
	private String teleCalc(){
		int hgFuelT = 0;
		if(Integer.parseInt(successfulShotsHighGoalTele.getRawData())>=3){
			hgFuelT = Integer.parseInt(successfulShotsHighGoalTele.getRawData());	
		}
		else {
			hgFuelT = 0;
		}
		int lgFuelT = 0;
		if(Integer.parseInt(successfulShotsLowGoalTele.getRawData()) >=9){
			lgFuelT = Integer.parseInt(successfulShotsLowGoalTele.getRawData());	
		}
		else {
			lgFuelT = 0;
		}
		
		int climbScore = 0;
		int gearScore = 0;
		
		if(climb.isSelected()){climbScore = 50;}
		else{climbScore = 0;}
		
		if(gearAutoSelected){
			if(Integer.parseInt(gearsInTele.getRawData()) <= 1){
				gearScore = 60;
			}
			else if(Integer.parseInt(gearsInTele.getRawData()) >=3 && Integer.parseInt(gearsInTele.getRawData()) < 5){
				gearScore = 60 + 40;
			}
			else if(Integer.parseInt(gearsInTele.getRawData()) >= 5 && Integer.parseInt(gearsInTele.getRawData()) < 11){
				gearScore = 60 + 40 + 40;
			}
			else if(Integer.parseInt(gearsInTele.getRawData()) >= 11) {
				gearScore = 60 + 40 + 40 + 40;
			}
		}
		else {
			if(Integer.parseInt(gearsInTele.getRawData()) <= 2){
				gearScore = 40;
			}
			else if(Integer.parseInt(gearsInTele.getRawData()) >=4 && Integer.parseInt(gearsInTele.getRawData()) < 6){
				gearScore = 40 + 40;
			}
			else if(Integer.parseInt(gearsInTele.getRawData()) >= 6 && Integer.parseInt(gearsInTele.getRawData()) < 12){
				gearScore = 40 + 40 + 40;
			}
			else if(Integer.parseInt(gearsInTele.getRawData()) >= 12) {
				gearScore = 40 + 40 + 40 + 40;
			}
		}
		
		int teleScore = (int)(hgFuelT/3) + (int)(lgFuelT/9) + gearScore + climbScore;
		
		return "TeleScore;" + teleScore + "\n";
	}
}
