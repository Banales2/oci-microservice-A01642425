package com.example.oci_microservice.controller;
import com.example.oci_microservice.model.Student;
import com.example.oci_microservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/students")
public class UserController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
    return studentService.createStudent(student);
    }
    @GetMapping
    public List<Student> getAllStudents() {
    return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
    Optional<Student> student = studentService.getStudentById(id);
    return student.map(ResponseEntity::ok).orElseGet(() ->
    ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student
    studentDetails) {
    Student updatedStudent = studentService.updateStudent(id, studentDetails);
    return updatedStudent != null ? ResponseEntity.ok(updatedStudent) :
    ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
    return studentService.deleteStudent(id) ? ResponseEntity.noContent().build() :
    ResponseEntity.notFound().build();
    }
}
