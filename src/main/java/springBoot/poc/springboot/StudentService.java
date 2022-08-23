package springBoot.poc.springboot;

import org.springframework.http.ResponseEntity;
import springBoot.poc.springboot.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllListStudent();

    Optional<Student> getStudentById(Integer id);

    void addStudent(Student student);

    void deleteStudent(Integer id);
}
