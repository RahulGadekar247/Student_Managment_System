package com.task.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.sms.entity.Student;


public interface StudentRepository extends JpaRepository<Student,Integer>{

}
