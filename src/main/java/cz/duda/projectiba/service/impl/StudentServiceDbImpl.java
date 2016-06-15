package cz.duda.projectiba.service.impl;

import cz.duda.projectiba.controller.Controller;
import cz.duda.projectiba.model.Student;
import cz.duda.projectiba.dto.StudentCreateDTO;
import cz.duda.projectiba.service.StudentService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Class implements methods of interface StudentService and stores data in database.
 *
 * @author Jan Duda
 */
@Transactional
@Repository
public class StudentServiceDbImpl implements StudentService {

    private final static Logger log = LoggerFactory.getLogger(StudentServiceDbImpl.class);

    @PersistenceContext
    private EntityManager em;

    private Mapper mapper = new DozerBeanMapper();

    @Override
    public long createStudent(StudentCreateDTO student) {
        if(student == null){
            throw new IllegalArgumentException("Input student cannot be null!");
        }
        log.debug("creating new student={}", student);

        Student s = mapper.map(student, Student.class);
        s.setBirthdate(student.getBirthdate());
        em.persist(s);
        return s.getId();
    }

    @Override
    public void removeStudent(Student student) {
        if(student == null){
            throw new IllegalArgumentException("Input student cannot be null");
        }
        log.debug("removing student with id = " + student.getId());

        em.remove(em.contains(student) ? student : em.merge(student));
    }

    @Override
    public boolean updateStudent(Student student) {
        if(student == null){
            throw new IllegalArgumentException("Input student cannot be null");
        }
        log.debug("updating student={}", student);
        return em.merge(student) != null;
    }

    @Override
    public List<Student> getAllStudents() {
        log.debug("getting all students");
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(long id) {
        log.debug("looking for student with id = " + id);
        return em.find(Student.class, id);
    }
}