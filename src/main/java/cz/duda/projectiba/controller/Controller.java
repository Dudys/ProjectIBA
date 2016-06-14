package cz.duda.projectiba.controller;

import cz.duda.projectiba.model.Student;
import cz.duda.projectiba.dto.StudentCreateDTO;
import cz.duda.projectiba.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Controller for administrating students.
 *
 * @author Jan Duda
 */
@org.springframework.stereotype.Controller
@RequestMapping("/student")
public class Controller {

    final static Logger log = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public String showStudent(Model model){
        log.info("All students");
        model.addAttribute("students", studentService.getAllStudents());
        return "student/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newStudent(Model model){
        log.info("new student");
        model.addAttribute("newStudent", new StudentCreateDTO());
        return "student/new";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createStudent(Model model,
                                @Valid @ModelAttribute("newStudent") StudentCreateDTO student,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                UriComponentsBuilder uriBuilder){
        log.info("createStudent(newStudent={})", student);

        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.error("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
                log.error("FieldError: {}", fe);
            }
            return "student/new";
        }

        long id = studentService.createStudent(student);

        redirectAttributes.addFlashAttribute("alert_success", "Student with " + id + " was created");
        return "redirect:" + uriBuilder.path("/student/detail/{id}").buildAndExpand(id).encode().toUriString();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable long id,
                         Model model) {

        Student student = studentService.findById(id);
        if (student == null) {
            return "redirect:/";
        }
        model.addAttribute("updateStudent", student);
        return "student/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateTrip(@Valid @ModelAttribute("updateStudent") Student student,
                             BindingResult bindingResult,
                             Model model,
                             RedirectAttributes redirectAttributes,
                             UriComponentsBuilder uriBuilder) {

        log.error("update(StudentUpdate={})", student);

        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.error("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
                log.error("FieldError: {}", fe);
            }
            return "student/update";
        }

        studentService.updateStudent(student);

        redirectAttributes.addFlashAttribute(
                "alert_success", "Student " + student.getId() + " was updated"
        );
        return "redirect:" + uriBuilder.path("/student/detail/{id}").buildAndExpand(student.getId()).encode().toUriString();
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detailStudent(@PathVariable("id") long id,
                                Model model) {

        log.error("Detail of student with " + id);
        Student student = studentService.findById(id);
        if (student == null) {
            return "redirect:/";
        }
        model.addAttribute("student", student);
        return "/student/detail";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteStudent(@PathVariable long id,
                           UriComponentsBuilder uriBuilder,
                           RedirectAttributes redirectAttributes) {

        Student student = studentService.findById(id);

        studentService.removeStudent(student);
        log.debug("deleteStudent({})", id);

        redirectAttributes.addFlashAttribute("alert_success", "Student \"" + student.getFirstname() + " " + student.getLastname() + "\" was deleted.");
        return "redirect:" + uriBuilder.path("/student").toUriString();
    }

}
