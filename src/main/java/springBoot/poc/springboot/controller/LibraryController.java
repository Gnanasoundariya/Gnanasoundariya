package springBoot.poc.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springBoot.poc.springboot.entity.Library;
import springBoot.poc.springboot.entity.Student;
import springBoot.poc.springboot.respository.LibraryRepository;
import springBoot.poc.springboot.service.LibraryService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    /**
     * Get mapping to get all list
     * @return getAllLibraryList
     */
    @GetMapping("")
    public List<Library> getListAllLibraryList() {
        return libraryService.getAllLibraryList();
    }

    /**
     * @param id
     * Get mapping to get book by id
     * @return getBookById
     */
    @GetMapping("/{id}")
    public Optional<Library> getBookById(@PathVariable("id") long id) {
        return libraryService.getBookById(id);
    }

    /**
     * @param library
     * post mapping to post the book name
     */
    @PostMapping("/")
    public void addBook(@RequestBody Library library) {
        libraryService.addBook(library);
    }
}
