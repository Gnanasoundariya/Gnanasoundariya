package springBoot.poc.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBoot.poc.springboot.service.StudentService;
import springBoot.poc.springboot.entity.Student;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * Using get mapping to get the all student list
     * @return getStudentList
     */
    @GetMapping
    public Map<String,Object> getStudentList() {
        return studentService.getStudentList();
    }

    /**
     * @param student
     * @param id
     * Using put mapping to update the student by id
     */
    @PutMapping("/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable long id) {
         studentService.updateStudent(student, id);
    }

    @PostMapping("/")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }

    /**
     * @param id
     * Using get mapping to get the details by student id
     * @return getStudentListById
     */
    @GetMapping("/{id}")
    public Map<String,Object> getStudentById(@PathVariable("id") long id) {
        return studentService.getStudentListById(id);
    }

    /**
     * @param bookName
     * Using get mapping to search the book name in the student list
     * @return searchByBookName
     */
    @GetMapping("student-search/{bookName}")
    public Map<String,Object> searchByBookName(@PathVariable("bookName") String bookName) {
        return studentService.searchByBookName(bookName);
    }


}
