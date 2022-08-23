package springBoot.poc.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> getAllListStudent() {
        return studentService.getAllListStudent();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Integer id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}
