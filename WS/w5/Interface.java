package student;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
// class for letting the user to choose if user wants to read or write data in
public class Interface extends JFrame{
	
	    private final JLabel readWriteQuestion; // label
		private final JButton enterJButton; //buttons
		private final JButton readJButton;
		private static Interface output;
	
		public Interface() { // default constructor
			
		   //  Title of the frame
			super("Choose one");
			
			setLayout(new FlowLayout());
			
			enterJButton = new JButton("Enter data");
			readJButton = new JButton("Read data");
			// label
			readWriteQuestion = new JLabel("Do you want to Enter data or Read data?");
			
			add(readWriteQuestion);
			add(enterJButton);
			add(readJButton);
			
			readWriteQuestion.setVerticalTextPosition(SwingConstants.CENTER);
			
			ButtonHandler readHandler = new ButtonHandler();
			ButtonHandler writeHandler = new ButtonHandler();
			readJButton.addActionListener(readHandler);
			enterJButton.addActionListener(writeHandler);
		}
		
		private class ButtonHandler implements ActionListener  // button handler inner class
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			if(e.getActionCommand().equals("Enter data")) {  // enter new data button
				
				dispose();// close the window
				// open input frame to enter data
				 InputTextField textField = new InputTextField();
			      textField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      textField.setSize(350, 300); 
			      textField.setVisible(true); 
			      
				
			}
			else if(e.getActionCommand().equals("Read data")){  // read data button
				dispose();
				// open to read the data
				OutputTextField textField = new OutputTextField();
			      textField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      textField.setSize(350, 300); 
			      textField.setVisible(true); 
			     }
				
			}
		
		
		}	// main method
		 public static void main(String[] args)
		   { 
			 Interface frame = new Interface(); 
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      frame.setSize(300, 200); 
		      frame.setVisible(true); 
		     
		    }
		
}