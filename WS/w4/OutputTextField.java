package student;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class OutputTextField extends JFrame{
	   private final JTextField studentID; // text field with set size
	   private final JTextField firstName; 
	   private final JTextField lastName; 
	   private final JTextField course; 
	   private final JLabel line1;
	   private final JLabel line2;
	   private final JLabel line3;
	   private final JLabel line4;
	   private static ObjectInputStream input;
	   
	
	   
	   public OutputTextField(){
		   
		super("Student information");  
		 studentID = new JTextField(30);
		   firstName = new JTextField(30);
		   lastName= new JTextField(30);
		   course= new JTextField(30);
		line1 = new JLabel("Student ID", SwingConstants.LEFT);
		 line2 = new JLabel("Student first name", SwingConstants.LEFT);
		 line3 = new JLabel("Student last name", SwingConstants.LEFT);
		 line4 = new JLabel("Student courses", SwingConstants.LEFT);
		 
		 setLayout(new FlowLayout());
		 studentID.setEditable(false);
		 add(line1);
		 add(studentID);
		   add(line2);
			 
		
		   firstName.setEditable(false);
		   add(firstName);
		   
		  
		   add(line3);
		   
		   lastName.setEditable(false);
		  
		   add(lastName);
		   
		   
		   add(line4);
		   
		   course.setEditable(false);
		
		   add(course);
	  
	   try {  //open the file
			  input =  new ObjectInputStream(Files.newInputStream(Paths.get("student.txt")));
			  }catch (IOException err) {
			   System.err.println("Failed to open the file");
			  }

	   try {
		   Student student  = (Student) input.readObject(); //read the file
				System.out.println(student.getStdID()+" "+ student.getFirstName()+" "+
						student.getLastName()+" "+student.getCourses());
				   studentID.setText(student.getStdID()+"");
				   firstName.setText(student.getFirstName());
				   lastName.setText(student.getLastName());
				   course.setText(student.getCourses().toString());
	   
	  
	   
	  

	 
	   }catch (Throwable e) {
				System.err.println(e);
		      }
	   
	   }
	
	}

