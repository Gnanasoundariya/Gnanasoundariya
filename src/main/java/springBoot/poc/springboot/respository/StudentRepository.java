package springBoot.poc.springboot.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springBoot.poc.springboot.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT a.id ,b.library_id,a.first_name,a.last_name,a.department,b.book_name FROM library b RIGHT JOIN students a ON b.library_id = a.library_id", nativeQuery = true)
    List<Object[]> findAllStudentList();

    @Query(value = "SELECT a.id ,b.library_id,a.first_name,a.last_name,a.department,b.book_name FROM library b RIGHT JOIN students a ON b.library_id = a.library_id WHERE a.id = ?", nativeQuery = true)
    List<Object[]> findByStudentId(long id);

    @Query(value = "SELECT a.id ,b.library_id,a.first_name,a.last_name,a.department,b.book_name FROM library b RIGHT JOIN students a ON b.library_id = a.library_id WHERE book_name LIKE :bookName%", nativeQuery = true)
    List<Object[]> searchByBookName(String bookName);
}
