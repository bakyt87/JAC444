package student;

import java.io.*;
import java.util.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.io.IOException;
import javax.swing.JOptionPane;


public class StudentObjectOutputStream {
	
	private static ObjectOutputStream output;
	
	public static void main(String[] args) throws IOException {
	
		Student student=new Student();
	String question=
		JOptionPane.showInputDialog("Do you want to enter student data or read student data? ");
	
	if(question.equals("read")) {
		System.out.println("Ok lets read");
	}
	try {
       output =  new ObjectOutputStream(Files.newOutputStream(Paths.get("student.txt")));// create the file if it does not exist
       }catch (IOException err) {
    	   System.err.println("Failed to open the file");
       }

        Student student = new Student();           //calling default constructor
        Scanner input = new Scanner(System.in);   // Create a Scanner object
		
		// getting student information
    try {
	    System.out.print("Enter student ID: ");
	   
	    while (!input.hasNextInt()){  // validate student ID 
	        System.out.println("That's not a number! Please Enter it again");
	        input.next();
	        System.out.print("Enter student ID: ");
	    }
	    student.setStdID(input.nextInt());
	  
	    }catch(InputMismatchException err) {
        	System.out.println("Entered wrong type");
        	
        }
	     
	    System.out.print("Enter student's first name: ");
	    student.setFirstName(input.next());
	    
	    
	    System.out.print("Enter student's last name: ");
	    student.setLastName(input.next());
	    
	    System.out.print("Enter a course name: ");
	    student.setCourses(input.next());
	    
	    String answer="Y";
	   try {
		while(answer.toUpperCase().equals("Y")) 
		{
		       System.out.print("Would you like to add course ( Y or N )? ");
		   answer= input.next();
		   if(answer.toUpperCase().equals("Y")) {
		       System.out.print("Enter a course name: ");
		   student.setCourses(input.next());
		   }
		   else if(answer.toUpperCase().equals("N")) 
		        {
			   System.out.println("\nThank you for entering the information");
		        }
		 }
	      }catch(Throwable err) {
	    	System.err.println("Wrong answer");
	    }
	   output.writeObject(student);
	   if(input!=null) { 
			  input.close(); // closing file
		  }   

		}
	
	}*/