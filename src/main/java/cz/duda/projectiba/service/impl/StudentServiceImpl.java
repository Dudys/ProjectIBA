package cz.duda.projectiba.service.impl;

import cz.duda.projectiba.model.Student;
import cz.duda.projectiba.dto.StudentCreateDTO;
import cz.duda.projectiba.service.StudentService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Class implements methods of interface StudentService
 *
 * @author Jan Duda
 */
public class StudentServiceImpl implements StudentService {

    private List<Student> students;
    private long idCounter;

    private Mapper mapper = new DozerBeanMapper();

    public StudentServiceImpl(){
        students = new ArrayList<Student>();
        idCounter = 1;
    }

    @Override
    public long createStudent(StudentCreateDTO student){
        if(student == null){
            throw new IllegalArgumentException("Input student cannot be null!");
        }

        Student newStudent = mapper.map(student, Student.class);
        newStudent.setId(idCounter);
        newStudent.setBirthdate(student.getBirthdate());
        idCounter++;
        students.add(newStudent);

        return newStudent.getId();
    }

    @Override
    public void removeStudent(Student student){
        if(student == null){
            throw new IllegalArgumentException("Input student cannot be null");
        }
        students.remove(student);
    }

    @Override
    public boolean updateStudent(Student student){
        boolean updated = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()){
                students.remove(i);
                updated = students.add(student);
            }
        }

        return updated;
    }

    @Override
    public List<Student> getAllStudents(){
        return Collections.unmodifiableList(students);
    }

    @Override
    public Student findById(long id){
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getId() == id){
                return students.get(i);
            }
        }
        return null;
    }

}
