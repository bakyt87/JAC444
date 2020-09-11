package student;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//StudentProcess class to filter students array, converted to List.

public class StudentProcess  {
	
	// returns list with filtered grades
	public static List<Student> GradesList(List<Student> studentList, double lowGrades, double highGrades){
		return studentList.stream().filter(student -> student.getGrade() >= lowGrades && student.getGrade()<=highGrades).collect(Collectors.toList());
	}
	
	//returns list with unique last names
	public static List<String> UniqueLastName(List<Student> studentList){
		return studentList.stream().map(Student::getLastName).distinct().sorted().collect(Collectors.toList());
	}
	
    // returns comparator for grades
	public static Comparator<Student>GRADE_COMPARATOR= (first,second)->(int)(first.getGrade() - second.getGrade());
	
	// returns list with last then first names in ascending order
	public static Stream<Student> FullNameAsc(List<Student>studentList){
         return studentList.stream().sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName));
	};
	// returns list with last then first names in descending order
	public static Stream<Student> FullNameDesc(List<Student>studentList){
		return studentList.stream().sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName).reversed());
	}
	// returns comparator for last names
	public static Comparator<Student> LASTNAME_COMPARATOR =(first, second)->{
		String[] firstLastName = first.getName().split(" ");
		String[] secondLastName = second.getName().split(" ");
		
		return firstLastName[1].compareTo(secondLastName[1]);
	};
	
	// returns comparator for first names
	public static Comparator<Student> FIRSTNAME_COMPARATOR =(first, second)->{
		String[] firstFirstName = first.getName().split(" ");
		String[] secondFirstName = second.getName().split(" ");
		
		return firstFirstName[0].compareTo(secondFirstName[0]);
	};
	

}

	
