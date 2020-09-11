package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		
		 Student students[] = {
				 new Student("Jack", "Smith", 50.0, "IT"),
				 new Student("Aaron", "Johnson", 76.0, "IT"),
				 new Student("Maaria", "White", 35.8, "Business"),
		         new Student("John", "White", 47.0, "Media"),
		         new Student("Laney", "White", 62.0, "IT"),
		         new Student("Jack", "Jones", 32.9, "Business"),
		         new Student("Wesley", "Jones", 42.89, "Media")
		 };
        List<Student> studentList = new ArrayList(Arrays.asList(students));
        
        // task 1 to get the whole student list
        
        System.out.println("Task 1:\r\n" + 
        		"Complete Student list:");
        
        studentList.forEach(System.out::println);
        
        // task 2 to get students with grades 50 to 100
        
        System.out.println("\nTask 2:\r\n" + 
        		"Students who got 50.0-100.0 sorted by grade:");
        
        studentList.sort(StudentProcess.GRADE_COMPARATOR);
        StudentProcess.GradesList(studentList, 50, 100).forEach(student ->System.out.println(student.toString()));
        
        // task 3 to get first student with grades 50 to 100
        
        System.out.println("\nTask 3:\r\n" + 
        		"First Student who got 50.0-100.0:\r\n");
        
        System.out.println(StudentProcess.GradesList(studentList, 50, 100).get(0));
        
        //task 4 A) to get students by last and first names in ascending order
        
        System.out.println("\nTask 4:\r\n" + 
        		"Students in ascending order by last name then first:");
        
        StudentProcess.FullNameAsc(studentList).forEach(System.out::println);
        
        //task 4 B) to get students by last and first names in descending order
        
        System.out.println("\nStudents in descending order by last name then first:");

        StudentProcess.FullNameDesc(studentList).forEach(System.out::println);
       
        // task 5 to get students' unique last names
        System.out.println("\nTask 5:\r\n" + 
                "Unique Student last names:");
    
        StudentProcess.UniqueLastName(studentList).forEach(lName ->System.out.println(lName));
        
       // task 6
        System.out.println("\nTask 6:\r\n" + 
        		"Student names in order by last name then first name:");

        StudentProcess.FullNameAsc(studentList).forEach(student->System.out.println(student.getFirstName()+ "   " + student.getLastName()));
        
        // task 7
        System.out.println("\nTask 7:\r\n" + 
        		"Students by department:");
        Map<String, List<Student>> groupList=studentList.stream().collect(Collectors.groupingBy(Student::getDepartment));
   	 
        groupList.forEach((key,value)->{
        	System.out.println(key);
        	value.forEach(student->System.out.println(" "+student));
        });
        
        // task 8
        System.out.println("\nTask 8:\r\n" + 
        		"Count of Students by department:");
        studentList.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()))
        .entrySet().forEach(student->System.out.println(student.getKey() + " has "+ student.getValue()+ " Student(s)"));
	    
	    // task 9
	    System.out.println("\nTask 9:");
	    double sum =studentList.stream().mapToDouble(student->student.getGrade()).sum();
	    System.out.println("Sum of Students' grades:"+ String.format("%.2f",sum));
        
	    //task 10
	    System.out.println("\nTask 10:");
	    studentList.stream().mapToDouble(student->student.getGrade())
	    .average().ifPresent(avg->System.out.println("Average of Students' grades: "+ String.format("%.2f",avg)));
	    
	   }
}
