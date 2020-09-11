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

public class Interface extends JFrame{
	
	    private final JLabel readWriteQuestion;
		private final JButton enterJButton;
		private final JButton readJButton;
		private static Interface output;
	
		public Interface() {
			
		  
			super("Choose one");
			
			setLayout(new FlowLayout());
			
			enterJButton = new JButton("Enter data");
			readJButton = new JButton("Read data");
			
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
		private class ButtonHandler implements ActionListener
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			if(e.getActionCommand().equals("Enter data")) {
				
				dispose();
				
				 InputTextField textField = new InputTextField();
			      textField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      textField.setSize(350, 300); 
			      textField.setVisible(true); 
			     
				
			}
			else if(e.getActionCommand().equals("Read data")){
				dispose();
				
				OutputTextField textField = new OutputTextField();
			      textField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      textField.setSize(350, 300); 
			      textField.setVisible(true); 
			}
				
			}
		
		
		}	
		 public static void main(String[] args)
		   { 
			 Interface frame = new Interface(); 
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      frame.setSize(300, 200); 
		      frame.setVisible(true); 
		      
		      
		     
		      
		    
	}
		
		
	}


