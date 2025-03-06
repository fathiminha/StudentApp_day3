package com.example.demo.Controller;

import com.example.demo.model.*; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/app")
public class Myapp {

    List<Student> students = new ArrayList<>(); 

    public Myapp() {
        Student Bob = new Student("2020ict01", "Bob Merly", 23, "IT", 3.2);
        Student Ann = new Student("2020ict02", "Ann", 25, "IT", 3.4);
        Student Sri = new Student("2020ict03", "Sri Ram", 22, "CS", 3.1);

        students.add(Bob);
        students.add(Ann);
        students.add(Sri);
    }

    @GetMapping("/Students")
    public List<Student> getStudent() {
        return students;
    }
    
    // Find a student from the list by regNo
    @GetMapping("/Student/{id}")
    public Student getStudent(@PathVariable("id") String regNo) {
    	for(Student student : students) {
    		if(student.getRegNo().equals(regNo)) {
    			return student;
    		}
    	}
    	return null;
    }
}
