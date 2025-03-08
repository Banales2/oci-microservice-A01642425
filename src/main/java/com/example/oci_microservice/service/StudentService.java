package com.example.oci_microservice.service;
import com.example.oci_microservice.model.Student;
import com.example.oci_microservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student createStudent(Student student) {
    return studentRepository.save(student);
    }
    public List<Student> getAllStudents() {
    return studentRepository.findAll();
    }
    public Optional<Student> getStudentById(Long id) {
    return studentRepository.findById(id);
    }
    public Student updateStudent(Long id, Student studentDetails) {
        return studentRepository.findById(id).map(student -> {
        student.setFirst_name(studentDetails.getFirst_name());
        student.setLast_name(studentDetails.getLast_name());
        student.setEmail(studentDetails.getEmail());
        return studentRepository.save(student);
    }).orElse(null);
    }
    public boolean deleteStudent(Long id) {
    if (studentRepository.existsById(id)) {
        studentRepository.deleteById(id);
    return true;
    }
    return false;
    }
}