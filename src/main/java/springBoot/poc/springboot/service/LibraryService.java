package springBoot.poc.springboot.service;

import springBoot.poc.springboot.entity.Library;
import springBoot.poc.springboot.entity.Student;

import java.util.List;
import java.util.Optional;

public interface LibraryService {
    List<Library> getAllLibraryList();

    Optional<Library> getBookById(long id);

    void addBook(Library library);

}
