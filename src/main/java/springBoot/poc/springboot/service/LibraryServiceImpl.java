package springBoot.poc.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.poc.springboot.entity.Library;
import springBoot.poc.springboot.entity.Student;
import springBoot.poc.springboot.respository.LibraryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    /**
     * get the all list of book
     * @return findAll
     */
    public List<Library> getAllLibraryList() {
        return libraryRepository.findAll();
    }

    /**
     * @param id
     * get the list of book by id
     * @return findById
     */
    @Override
    public Optional<Library> getBookById(long id) {
        return libraryRepository.findById(id);
    }

    //add a new library to the table

    /**
     * @param library
     * add a new library to the table
     */
    @Override
    public void addBook(Library library) {
        libraryRepository.save(library);
    }
}
