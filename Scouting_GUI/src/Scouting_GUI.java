import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

@SuppressWarnings("all")
public class Scouting_GUI extends JFrame {
	//Main Pane
	//top
	JPanel stuff;
	TopBar top;
	//mid
	MidPanel midpan;
	//south
	JButton submit;
	JButton reset;
	
	PrintWriter writer;
	String teamNumber = "0000";
	String matchNumber = "00";
	
	int individualCont = 0;
	
	Scouting_GUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Robotics Team 3044 Scouting Sheet 2017 (Draft)");
		addItems();
		pack();
		setVisible(true);
	}
	
	private void addItems(){
		stuff = new JPanel();
		//top
		top = new TopBar();
		//mid
		midpan = new MidPanel();
		//south
		JPanel temp = new JPanel();
		submit = new JButton("Submit");
		reset = new JButton("Reset");
		reset.addActionListener(new Action());
		submit.addActionListener(new Action());
		
		temp.setLayout(new FlowLayout());
		temp.add(submit);
		temp.add(reset);
		
		stuff.setLayout(new BorderLayout());
		stuff.add(top, BorderLayout.NORTH);
		stuff.add(midpan, BorderLayout.CENTER);
		stuff.add(temp, BorderLayout.SOUTH);
		
		add(stuff);
	}
	
	class Action implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(reset)){
			int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset?", "RESET", JOptionPane.YES_NO_OPTION);
	        if (reply == JOptionPane.YES_OPTION)
	        {
			top.reset();
			midpan.reset();
		    }
		}
		else if (e.getSource().equals(submit)){
			//submit
	 		int replyS = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit?", "SUBMIT", JOptionPane.YES_NO_OPTION);
		      if (replyS == JOptionPane.YES_OPTION){
		          try{
		              teamNumber = new DecimalFormat("0000").format(Integer.parseInt(top.teamBox.getText()));
		              matchNumber = new DecimalFormat("00").format(Integer.parseInt(top.matchBox.getText()));
		              writer = new PrintWriter("toUpdate//"+teamNumber + matchNumber + ".sct2017" );
		              writer.print(top.getRawData() + midpan.getRawData());
		              writer.close();
		             }
		           catch(Exception ex){ex.printStackTrace();}
		           }
		         }
		}
	}
	
	public static void main(String[] args){
		new Scouting_GUI();
	}
}
