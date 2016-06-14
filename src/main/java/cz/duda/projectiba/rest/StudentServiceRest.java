package cz.duda.projectiba.rest;

import cz.duda.projectiba.dto.StudentCreateDTO;
import cz.duda.projectiba.model.Student;
import cz.duda.projectiba.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Jan Duda
 */
@Path("/students")
@Component
public class StudentServiceRest {

    @Autowired
    StudentService studentService;

    /**
     * Method returns student with input id
     *
     * @param id id of student to be found
     * @return student with input id
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student findById(@PathParam("id") long id){
        return studentService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    /**
     * Method creates a new student.
     *
     * @param s student to be created
     * @return created student
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student createStudent(StudentCreateDTO s){
        return studentService.findById(studentService.createStudent(s));
    }

    /**
     * Method updates input student.
     *
     * @param s student to be updated
     * @return updated student
     */
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Student updateStudent(Student s){
        studentService.updateStudent(s);
        return studentService.findById(s.getId());
    }

    /**
     * Method deletes student with input id.
     *
     * @param id id of student to be deleted
     */
    @DELETE
    @Path("/delete/{id}")
    public void deleteStudent(@PathParam("id") long id){
        studentService.removeStudent(studentService.findById(id));
    }

}
