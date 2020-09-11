package student;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static java.nio.file.StandardOpenOption.APPEND;


public class InputTextField extends JFrame{
	  private final JTextField studentID; // text field with set size
	   private final JTextField firstName; 
	   private final JTextField lastName; 
	   private final JTextField course; 
	   private final JLabel q1;
	   private final JLabel q2;
	   private final JLabel q3;
	   private final JLabel q4;
	   private final JButton save;
	   
	   private static ObjectOutputStream output;
	   
	   public InputTextField() {
		   
	   super("Enter student information");
	   setLayout(new FlowLayout());
	   // labels and text fields 
	   q1 = new JLabel("Enter ID", SwingConstants.LEFT);
	   add(q1);
	   studentID = new JTextField(30);
	   add(studentID);
	   
	   q2 = new JLabel("Enter first name", SwingConstants.LEFT);
	   add(q2);
	   firstName = new JTextField(30);
	   add(firstName);
	   
	   q3 = new JLabel("Enter last name", SwingConstants.LEFT);
	   add(q3);
	   lastName= new JTextField(30);
	   add(lastName);
	   
	   q4 = new JLabel("Enter courses", SwingConstants.LEFT);
	   add(q4);
	   course= new JTextField(30);
	   add(course);
	   
	   save = new JButton("SAVE");
	   add(save);
	   
	   TextFieldHandler textHandler = new TextFieldHandler();
	   TextFieldHandler  saveHandler = new TextFieldHandler();
	   save.addActionListener(saveHandler);
	   
	   try {
	   output =  new ObjectOutputStream(Files.newOutputStream(Paths.get("student.txt")));// create the file if it does not exist
       }catch (IOException err) {
    	   System.err.println("Failed to open the file");
       }
	   
	   
}      // inner class for handling text fields and save button
	   private class TextFieldHandler implements ActionListener
	   {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Student student = new Student();
	         
	         if(e.getActionCommand().equals("SAVE")) 
	         
	        //validating, all fields must be filled
	         if(studentID.getText().equals(""))
	        	 JOptionPane.showMessageDialog(null, "You must enter student ID"); 
	         else if(firstName.getText().equals(""))
	        	 JOptionPane.showMessageDialog(null, "You must enter student's first name"); 
	         else if(lastName.getText().equals(""))
	        	 JOptionPane.showMessageDialog(null, "You must enter student's last name"); 
	         else if(course.getText().equals(""))
	        	 JOptionPane.showMessageDialog(null, "You must enter student's course name"); 
	         else
	        // setting input
	         student.setStdID(Integer.parseInt(studentID.getText()));
	         student.setFirstName(firstName.getText());
	         student.setLastName(lastName.getText());
	         student.setCourses(course.getText());
	           JOptionPane.showMessageDialog(null,"The information has been saved successfully!");  
	         dispose(); // close the window

	         
	         try {
				output.writeObject(student);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
	  	  
	    }
	}
	   
}