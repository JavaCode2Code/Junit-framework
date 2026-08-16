package com.scjp.code.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.scjp.code.Student;
import com.scjp.exception.StudentNotFoundException;

public class StudentService {
	private List<Student> stuList = new ArrayList<>();

	public List<Student> geStudents() {
		return this.stuList;
	}

	public void addStudent(Student student) {
		this.stuList.add(student);
	}

	public Student getStudentById(int id) {
		return stuList.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
	}

	public String[] getStudentNameByDepartment(String department) {
		return stuList.stream().filter(st -> st.getDepartment().equals(department)).map(Student::getName)
				.toArray(String[]::new);
	}
	public Integer[] getStudentIdByDepartment(String department) {
		return stuList.stream().filter(stud->stud.getDepartment().equals(department))
				.map(Student::getId).toArray(Integer[]::new);
		
	}
	public List<String> getStudentNameListByDepartment(String department) {
		return stuList.stream().filter(stud->stud.getDepartment().
				equals(department)).map(Student::getName).collect(Collectors.toList());
	}
	public List<Integer> getStudentIdListByDepartment(String deparment){
		return stuList.stream().filter(stud->stud.getDepartment().equals(deparment)).
				map(Student::getId).collect(Collectors.toList());
	}
	public Student getStudentByName(String name) {
		return stuList.stream().filter(stu->stu.getName().equals(name)).findFirst()
		.orElseThrow(()-> new  StudentNotFoundException("Student is not found with name "+name));
	}
}
