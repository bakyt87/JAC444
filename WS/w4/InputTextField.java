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
	   output =  new ObjectOutputStream(Files.newOutputStream(Paths.get("student.txt"), APPEND));// create the file if it does not exist
       }catch (IOException err) {
    	   System.err.println("Failed to open the file");
       }
	   
	   
}
	   private class TextFieldHandler implements ActionListener
	   {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Student student = new Student();
	         
	         if(e.getActionCommand().equals("SAVE")) 
	         
	        dispose(); //close the window
	         student.setStdID(Integer.parseInt(studentID.getText()));
	         student.setFirstName(firstName.getText());
	         student.setLastName(lastName.getText());
	         student.setCourses(course.getText());
	         
	         System.out.println(student.getCourses());
	         System.out.println(student.getFirstName());
	         System.out.println(student.getLastName());
	         
	         try {
				output.writeObject(student);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	  	  
	         
		}
	   
}
	   
}
