package cz.duda.projectiba;

import cz.duda.projectiba.dto.StudentCreateDTO;
import cz.duda.projectiba.model.Student;
import cz.duda.projectiba.service.StudentService;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;

import static org.junit.Assert.*;

/**
 * Tests for class StudentServiceDbImpl.
 *
 * @author Jan Duda
 */
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class StudentServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private StudentService studentService;

    private StudentCreateDTO student1;
    private StudentCreateDTO student2;

    @Before
    public void setUp() throws Exception{

        student1 = new StudentCreateDTO();
        student1.setFirstname("Jan");
        student1.setLastname("Duda");
        student1.setBirthdate(new LocalDate(1991, 10, 29));
        student1.setSex(true);

        student2 = new StudentCreateDTO();
        student2.setFirstname("Jakub");
        student2.setLastname("Kuba");
        student2.setBirthdate(new LocalDate(1992, 4, 7));
        student2.setSex(true);
    }

    @Test
    public void testGetAllStudents(){

        long id1 = studentService.createStudent(student1);
        long id2 = studentService.createStudent(student2);

        assertEquals(studentService.findById(id1).getFirstname(), student1.getFirstname());
        assertEquals(studentService.findById(id1).getLastname(), student1.getLastname());
        assertEquals(studentService.findById(id1).getBirthdate(), student1.getBirthdate());
        assertEquals(studentService.findById(id1).isSex(), student1.isSex());

        assertEquals(studentService.findById(id2).getFirstname(), student2.getFirstname());
        assertEquals(studentService.findById(id2).getLastname(), student2.getLastname());
        assertEquals(studentService.findById(id2).getBirthdate(), student2.getBirthdate());
        assertEquals(studentService.findById(id2).isSex(), student2.isSex());

        assertTrue(studentService.getAllStudents().size() == 2);
    }

    @Test
    public void testCreateStudent(){

        long id = studentService.createStudent(student1);
        Student s = studentService.findById(id);

        assertEquals(id, 1);
        assertEquals(studentService.getAllStudents().size(), 1);
        assertEquals(s.getFirstname(), "Jan");
        assertEquals(s.getLastname(), "Duda");
        assertEquals(s.getBirthdate(), new LocalDate(1991, 10, 29));
        assertTrue(s.isSex());
        assertTrue(studentService.getAllStudents().contains(s));
    }

    @Test
    public void testDeleteStudent(){

        long id = studentService.createStudent(student1);
        Student s = studentService.findById(id);
        studentService.removeStudent(s);
        assertTrue(studentService.getAllStudents().size() == 0);
    }

    @Test
    public void testUpdateStudent(){

        long id = studentService.createStudent(student1);
        Student s = studentService.findById(id);

        s.setFirstname("Petr");

        studentService.updateStudent(s);

        assertEquals(studentService.findById(id).getFirstname(), "Petr");
        assertEquals(studentService.findById(id).getLastname(), "Duda");
        assertEquals(studentService.findById(id).getBirthdate(), new LocalDate(1991, 10, 29));
        assertTrue(studentService.findById(id).isSex());
        assertTrue(studentService.getAllStudents().size() == 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNullStudent(){
        StudentCreateDTO student = null;
        studentService.createStudent(student);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testCreateStudentWithNullFirstName(){
        student1.setFirstname(null);
        studentService.createStudent(student1);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testCreateStudentWithoutFirstName(){
        student1.setFirstname("");
        studentService.createStudent(student1);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testCreateStudentWithNullLastName(){
        student1.setLastname(null);
        studentService.createStudent(student1);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testCreateStudentWithoutLastName(){
        student1.setLastname("");
        studentService.createStudent(student1);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testCreateStudentWithFutureBirthDate(){
        student1.setBirthdate(new LocalDate(2020, 1, 1));
        studentService.createStudent(student1);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testCreateStudentWithNullBirthDate(){
        student1.setBirthdate(null);
        studentService.createStudent(student1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNullStudent(){
        studentService.updateStudent(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNullStudent(){
        studentService.removeStudent(null);
    }

    @Test
    public void testFindStudentWithNotExistingId(){
        studentService.createStudent(student1);
        studentService.createStudent(student2);

        Student s = studentService.findById(10L);

        assertNull(s);
    }
}
