package springBoot.poc.springboot.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import springBoot.poc.springboot.entity.Library;
import springBoot.poc.springboot.entity.Student;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
