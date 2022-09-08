package springBoot.poc.springboot.service;

import org.springframework.http.ResponseEntity;
import springBoot.poc.springboot.entity.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentService {

    Map<String,Object> getStudentList();

    void addStudent(Student student);

    void updateStudent(Student student, long id);

    void deleteStudent(long id);

    Map<String,Object> getStudentListById(long id);

    Map<String,Object> searchByBookName(String bookName);



}
