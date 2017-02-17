import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("all") 
public class TxtBoxAndLabelButtons extends JPanel{
	JLabel label;
	JTextField field;
	JButton inc;
	JButton dec;
	int x = 0;
	
	TxtBoxAndLabelButtons(String lab, int size){
		label = new JLabel(lab);
		field = new JTextField(size);
		field.setText("0");
 		inc = new JButton("+");
		dec = new JButton("-");
		
		setLayout(new GridLayout(1,4));
		add(label);
		add(field);
		add(inc);
		add(dec);
		
		inc.addActionListener(new ActionList());
		dec.addActionListener(new ActionList());
	}


   class ActionList implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(inc)){
			 try{
		       x = Integer.parseInt(field.getText());
		       }catch(Exception ex){x=0;}
		       x = x + 1;
		       field.setText(""+x);
		}
		else if(e.getSource().equals(dec)){
			 try{
		         x = Integer.parseInt(field.getText());
		         }catch(Exception ex){x=0;}
		         x = x - 1;
			if (x<0)
				x=0;
		         field.setText(""+x);
	  }	
	}
  }
   public String getRawData(){
	   try{
		    x = Integer.parseInt(field.getText());
		    }catch(Exception ex){x=0;}
		    if (x<0){x=0;}
		    field.setText(""+x);
		    return field.getText();
   }
   
   public void reset(){
	   field.setText(String.valueOf(0));
   }
}
