package com.task.sms.service;

import java.util.List;

import com.task.sms.entity.Student;

public interface StudentService {
	
	 Student createStudent(Student Student);
	 Student updateStudent(Student Student, Integer id);
	 void deleteStudent(Integer id);
	 List<Student> viewAllStudents();
	
	

}
