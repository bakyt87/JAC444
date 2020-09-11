package student;

public class Student implements Comparable<Student>{
	private String firstName;
	private String lastName;
	private double grade;
	private String department;
	
	// 4 args constructor
	public Student(String fistName, String lastName, double grade, String department) {
		super();
		this.firstName = fistName;
		this.lastName = lastName;
		this.grade = grade;
		this.department = department;
	}
    
	//setters & getters
	
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
	public String getName() {
		return firstName +' '+ lastName;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public boolean equals(Object obj) {
	        return super.equals(obj);
	}

	@Override
	public String toString() {
		return  String.format("%-15s", firstName) + String.format("%-15s", lastName) + String.format("%-10s", grade)+ String.format("%-10s", department);
	}
	
	@Override  // implements Comparable class method compareTo()
	public int compareTo(Student other) {
		double gradeCmp = other.getGrade();
		return (int)(Math.round(this.grade - gradeCmp));
	}

}
