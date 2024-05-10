package com.example.springboot.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Student;
import com.example.springboot.repository.StudentRepo;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentRepo studentRepo;
	
	
	@PostMapping("create")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<>(studentRepo.save(student),HttpStatus.CREATED);
		
	}
	
	@GetMapping("allStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<>(studentRepo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("ById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id){
		Optional<Student> student = studentRepo.findById(id);
		if(student.isPresent()) {
			return new ResponseEntity<>(student.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable long id,@RequestBody Student stud){
		Optional<Student> student = studentRepo.findById(id);
		if(student.isPresent()) {
			student.get().setStudentName(stud.getStudentName());
			student.get().setStudentEmail(stud.getStudentEmail());
			student.get().setStudentAddress(stud.getStudentAddress());
			return new ResponseEntity<>(studentRepo.save(student.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable long id){
		Optional<Student> student = studentRepo.findById(id);
		if(student.isPresent()) {
			studentRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
    
}
