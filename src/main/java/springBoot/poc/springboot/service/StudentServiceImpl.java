package springBoot.poc.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springBoot.poc.springboot.entity.Student;
import springBoot.poc.springboot.respository.LibraryRepository;
import springBoot.poc.springboot.respository.StudentRepository;
import springBoot.poc.springboot.service.StudentService;

import java.util.*;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    /**
     * map the list and get the student data from Query
     * @return studentList
     */
    @Override
    public Map<String,Object> getStudentList() {
       List<Object> studentList = new ArrayList<>();
        Map<String,Object> map1=new HashMap<>();
        List<Object[]> studentLists =   studentRepository.findAllStudentList();
        for(Object[] object:studentLists){
            Map<String,Object> map=new HashMap<>();
            map.put("id",object[0]);
            map.put("libraryId",object[1]);
            map.put("firstName",object[2]);
            map.put("lastName",object[3]);
            map.put("department",object[4]);
            map.put("bookName",object[5]);
            studentList.add(map);
        }
        LOGGER.info("Get all the student list of Record "+studentList.size());
        map1.put("studentList", studentList);
        return map1;
    }

    /**
     * @param student
     * add a new student to the table
     */
    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    /**
     * @param id
     * delete the student data by id
     */
    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    /**
     * @param student
     * @param id
     * update the student data by id
     */
    @Override
    public void updateStudent(Student student, long id) {
        student.setId(id);
        studentRepository.save(student);

    }

    /**
     * @param id
     *  map the list and get the student data by id using query
     */
    @Override
    public Map<String,Object> getStudentListById(long id) {
        List<Object> studentListId = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        List<Object[]> studentListsId = studentRepository.findByStudentId(id);
        for (Object[] object : studentListsId) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", object[0]);
            map.put("libraryId", object[1]);
            map.put("firstName", object[2]);
            map.put("lastName", object[3]);
            map.put("department", object[4]);
            map.put("bookName", object[5]);
            studentListId.add(map);
        }
        LOGGER.info("Get Student list by Id "+studentListId.size());
        map1.put("studentListId", studentListId);
        return map1;
    }

    /**
     * @param bookName
     * map the list to search the book name from query
     * @return searchByBook
     */
    @Override
    public Map<String,Object>  searchByBookName(String bookName) {
        List<Object> searchByBook = new ArrayList<>();
        Map<String,Object> map1=new HashMap<>();
        List<Object[]> searchByBookName = studentRepository.searchByBookName(bookName);
            for (Object[] object : searchByBookName) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", object[0]);
                map.put("libraryId", object[1]);
                map.put("firstName", object[2]);
                map.put("lastName", object[3]);
                map.put("department", object[4]);
                map.put("bookName", object[5]);
                searchByBook.add(map);
            }
        LOGGER.info("Search Book Name of Record "+searchByBook.size());
        map1.put("searchByBook", searchByBook);
        return map1;
    }




}
