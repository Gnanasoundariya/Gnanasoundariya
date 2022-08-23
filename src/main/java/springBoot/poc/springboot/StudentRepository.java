package springBoot.poc.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBoot.poc.springboot.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
