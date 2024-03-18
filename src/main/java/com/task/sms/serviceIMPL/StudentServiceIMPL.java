package com.task.sms.serviceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.sms.entity.Student;
import com.task.sms.repository.StudentRepository;
import com.task.sms.service.StudentService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceIMPL implements StudentService{
	
	@Autowired
	private StudentRepository sr;

	@Override
	public Student createStudent(Student Student) {
		return sr.save(Student);
	}

	@Override
	public Student updateStudent(Student Student, Integer id) {
		Optional<Student> optionalStudent = sr.findById(id);
		 if (optionalStudent.isPresent()) {
		        Student existingStudent = optionalStudent.get();
		        existingStudent.setRollNumber(Student.getRollNumber());
		        existingStudent.setFirstName(Student.getFirstName());
		        existingStudent.setLastName(Student.getLastName());
		        existingStudent.setPhoneNumber(Student.getPhoneNumber());
		        existingStudent.setEmailId(Student.getEmailId());
		        existingStudent.setSectionName(Student.getSectionName());
		        existingStudent.setAddress(Student.getAddress());
		        
		        return sr.save(existingStudent);
		    } else {
		        throw new EntityNotFoundException("Student Roll_Number is not found with id " + id);
		    }
	}

	@Override
	public void deleteStudent(Integer id) {
		 Optional<Student> optionalStudent = sr.findById(id);
		    if (optionalStudent.isPresent()) {
		        Student existingVintageCar = optionalStudent.get();
		        sr.delete(existingVintageCar);
		    } else {
		        throw new EntityNotFoundException("Student is not found with id " + id);
		    }
		
	}

	@Override
	public List<Student> viewAllStudents() {
		return sr.findAll();
	}

}
