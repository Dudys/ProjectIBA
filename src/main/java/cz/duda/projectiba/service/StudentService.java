package cz.duda.projectiba.service;

import cz.duda.projectiba.model.Student;
import cz.duda.projectiba.dto.StudentCreateDTO;

import java.util.List;

/**
 * Interface for persistence operations for entity Student
 *
 * @author Jan Duda
 */
public interface StudentService {

    /**
     * Method creates a new student in database
     *
     * @param student student to be created
     */
    long createStudent(StudentCreateDTO student);

    /**
     * Method deletes a student with input id from database
     *
     * @param student student to be deleted
     */
    void removeStudent(Student student);

    /**
     * Method updates student in database
     *
     * @param student updated student
     */
    boolean updateStudent(Student student);

    /**
     * Method returns all student in database
     *
     * @return all students in database
     */
    List<Student> getAllStudents();

    /**
     * Method returns student with input id
     *
     * @param id id of student to be found
     * @return student with input id
     */
    Student findById(long id);
}
