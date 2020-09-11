package student;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StudentObjectInputStream {
	
	private static ObjectInputStream input;

	public static void main(String[] args)throws Exception 
	  { 
	  try {  //open the file
		  input =  new ObjectInputStream(Files.newInputStream(Paths.get("student.txt")));
		  }catch (IOException err) {
		   System.err.println("Failed to open the file");
		  }

	  try {
		   Student student  = (Student) input.readObject(); //read the file
				System.out.println(student.getStdID()+" "+ student.getFirstName()+" "+
						student.getLastName()+" "+student.getCourses());
				
     }catch (Throwable e) {
			System.err.println(e);
	      }
	 if(input!=null) {
		  input.close(); //closing file
	  }

} 
}