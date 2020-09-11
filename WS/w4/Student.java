package student;

import java.io.Serializable;
import java.util.*;
/**
 * class Student 
 * @author bakyt
 *
 */
public class Student implements Serializable {
	
	private long stdID;
	private String firstName;
	private String lastName;
	private ArrayList <String> courses= new ArrayList<String>();
	
	//no default constructor
	public Student() {
		super();
		stdID=0;
		firstName="";
		lastName="";
		courses=new ArrayList<String>();
	}
	
	//4 arguments constructor
	public Student(int stdID, String fistName, String lastName, ArrayList<String> courses) { // 4 argument constructor
		super();
		this.stdID = stdID;
		this.firstName = fistName;
		this.lastName = lastName;
		this.courses = courses;
	}
	
	// getters & setters for all fields
	public long getStdID() {
		return stdID;
	}
	public void setStdID(long l) {
		this.stdID = l;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String fistName) {
		this.firstName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ArrayList<String> getCourses() {
		return courses;
	
	}
	public void setCourses(String courses) {
		this.courses.add(courses);
		
	}
	
}
