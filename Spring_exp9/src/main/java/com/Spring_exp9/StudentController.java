package com.Spring_exp9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/Student")

@RestController
@RequestMapping("/Student")
public class StudentController {

	 @Autowired
	    StudentRepository repository;

	    @PostMapping("/Student")
	    public Student addStudent(@RequestBody Student student) {
	        return repository.save(student);
	    }


    
    // GET - Get all students

//    @GetMapping
//    public List<Student> getAllStudents() {
//        return repository.findAll();
//    }


    // GET - Get student by ID

//    @GetMapping("/{id}")
//    public Student getStudent(@PathVariable int id) {
//        return repository.findById(id).orElse(null);
//    }


    // PUT - Update student

//    @PutMapping("/{id}")
//    public Student updateStudent(@PathVariable int id,
//                                 @RequestBody Student student) {
//
//        student.setId(id);
//        return repository.save(student);
//    }


    // DELETE - Delete student

//    @DeleteMapping("/{id}")
//    public String deleteStudent(@PathVariable int id) {
//
//        repository.deleteById(id);
//
//        return "Student deleted successfully";
//    }
    

}