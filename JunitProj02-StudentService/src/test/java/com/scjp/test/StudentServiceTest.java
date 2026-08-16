package com.scjp.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.scjp.code.Student;
import com.scjp.code.service.StudentService;
import com.scjp.exception.StudentNotFoundException;

public class StudentServiceTest {
	StudentService studentService = new StudentService();

	@Disabled("Disabled until bug #70 is fixed")
	@Test
	public void getStudentTest() {
		// Student student = new Student(101, "Sateesh", "IT");
		List<Student> listOfStudent = studentService.geStudents();
		// studentService.addStudent(student);
		boolean actualResult = listOfStudent.isEmpty();
		// assertTrue(actualResult);
		// assertTrue(()->actualResult);
		// assertTrue(actualResult, "List of students is empty");
		// assertTrue(()->actualResult, "List of students is empty");
		// assertTrue(actualResult, ()-> "List of students is empty");
		assertTrue(() -> actualResult, () -> "List of students is empty");
	}

	@Disabled("Disabled until bug #70 is fixed")
	@Test
	public void getStudentsTestUsingAssertFalse() {
		Student student = new Student(101, "Sateesh", "IT");
		List<Student> listOfStudent = studentService.geStudents();
		// studentService.addStudent(student);
		boolean actualResult = listOfStudent.isEmpty();
		// assertFalse(actualResult);
		// assertFalse(actualResult,"Student list should not be empty!");
		// assertFalse(()->actualResult);
		// assertFalse(()->actualResult,"Student list should not be empty!");
		// assertFalse(actualResult, ()->"Student list should not be empty!");
		assertFalse(() -> actualResult, () -> "Student list should not be empty!");

	}

	@Disabled
	@Test
	public void getStudentByIdTestAssertNull() {

		Student student = new Student(101, "Sateesh", "IT");
		studentService.addStudent(student);
		Student aactualObject = studentService.getStudentById(101);
		// assertNull(aactualObject);
		// assertNull(aactualObject, "Student is null!");
		assertNull(aactualObject, () -> "Student is not null!");
	}

	@Disabled
	@Test
	public void getStudentByIdTestUsingAssertEquals() {
		Student student = new Student(111, "Rajesh", "Developer");
		Student student2 = new Student(112, "Rahul", "Developer");
		studentService.addStudent(student2);
		Student actualObject = studentService.getStudentById(112);
		// assertEquals(112, actualObject.getId());
		// assertEquals(112, actualObject.getId(),"Student Id is not equal");
		assertEquals(111, actualObject.getId(), () -> "Student Id is not equal");

	}

	@Disabled
	@Test
	public void getStudentByIdTestUsingAssertNotEquals() {
		Student student = new Student(111, "Rajesh", "Developer");
		Student studen2 = new Student(112, "Rahul", "Developer");
		studentService.addStudent(student);
		Student actualObject = studentService.getStudentById(112);
		// assertNotEquals(112, actualObject.getId());
		// assertNotEquals("Rahul", actualObject.getName());
		// assertNotEquals(111, actualObject.getId(),"Student id is equal");
		// assertNotEquals("Ram", actualObject.getName(),()->"Student id is equal");
		assertNotEquals(student, studen2);

	}

	@Disabled
	@Test
	public void getStudentByDeparmentTestAsserArrayEquals() {
		Student student = new Student(1, "Raju", "Science");
		Student student2 = new Student(2, "Mahendra", "CS");
		Student student3 = new Student(3, "Prasanjit", "CS");
		studentService.addStudent(student);
		studentService.addStudent(student2);
		studentService.addStudent(student3);
		String[] actualArray = studentService.getStudentNameByDepartment("CS");
		String[] expectedArray = { "Mahendra", "Prasanjit" };
		// assertArrayEquals(expectedArray, actualArray);
		// assertArrayEquals(expectedArray, actualArray,"Student names are not equal");
		assertArrayEquals(expectedArray, actualArray, () -> "Student names are not equal");

		Integer[] actualStudId = studentService.getStudentIdByDepartment("CS");
		Integer[] expectStudId = { 1, 3 };
		// assertArrayEquals(expectStudId, actualStudId);
		// assertArrayEquals(expectStudId, actualStudId,"Student Id are not same");
		assertArrayEquals(expectStudId, actualStudId, () -> "Student Id are not same");

	}

	@Disabled
	@Test
	public void getStudentNameListByDeparmentAssertIterableEquals() {
		Student student = new Student(1, "Rhodi", "Art");
		Student student2 = new Student(2, "Modi", "IT");
		Student student3 = new Student(3, "Sonu", "IT");
		Student student4 = new Student(4, "Ritesh", "IT");
		studentService.addStudent(student);
		studentService.addStudent(student2);
		studentService.addStudent(student3);
		studentService.addStudent(student4);

		List<String> actualStudentNameList = studentService.getStudentNameListByDepartment("IT");
		List<String> expectedStudentNameList = Arrays.asList("rodi", "Sonu", "Ritesh");
		// assertIterableEquals(expectedStudentNameList, actualStudentNameList);
		
		// assertIterableEquals(expectedStudentNameList, actualStudentNameList,"Student
		
		// assertIterableEquals(expectedStudentNameList,
		
		// actualStudentNameList,()->"Student name List is not Equal");

		List<Integer> actualStudentIdList = studentService.getStudentIdListByDepartment("IT");
		List<Integer> expectedStudentIdList = Arrays.asList(1, 3, 4);

		// assertIterableEquals(expectedStudentIdList, actualStudentIdList);
		
		// assertIterableEquals(expectedStudentIdList, actualStudentIdList,"Student Id
		
		// List is not Equal");
		assertIterableEquals(expectedStudentIdList, actualStudentIdList, () -> "Student Id List is not Equal");

	}
	
	@Test
	public void getStudentNameTestAssertThrow() {
		Student student = new Student(1, "Rhodi", "Art");
		Student student2 = new Student(2, "Modi", "IT");
		Student student3 = new Student(3, "Sonu", "IT");
		Student student4 = new Student(4, "Ritesh", "IT");
		studentService.addStudent(student);
		studentService.addStudent(student2);
		studentService.addStudent(student3);
		studentService.addStudent(student4);
		//assertThrows(StudentNotFoundException.class, ()->{studentService.getStudentByName("Ronu");});
		//assertThrows(NullPointerException.class, ()->{studentService.getStudentByName("Ronu");});
		/*
		 * assertThrows(StudentNotFoundException.class,
		 * ()->{studentService.getStudentByName("Sonu")
		 * ;},"StudentNotFoundException should be thrown. But, it wasn't");
		 * 
		 */
		
		/*
		 * assertThrows(NullPointerException.class,
		 * ()->{studentService.getStudentByName("Janu")
		 * ;},()->"StudentNotFoundException should be thrown. But, it wasn't");
		 */
	}
}
