package cz.duda.projectiba.controller;

import cz.duda.projectiba.model.Student;
import org.joda.time.LocalDate;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jan Duda on 6/11/2016.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/controller")
public class Controller {

    final static Logger log = LoggerFactory.getLogger(Controller.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showStudent(Model model){
        log.info("Main page");

        return "index";
    }

    @RequestMapping(value = "/student/new", method = RequestMethod.GET)
    public String newStudent(Model model){
        log.info("new student");
        model.addAttribute("newStudent", new Student());
        return "/student/new";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(value = "/student/new", method = RequestMethod.POST)
    public String createStudent(Model model,
                                @Valid @ModelAttribute("newStudent") Student student,
                                BindingResult bindingResult){
        log.info("createStudent(newStudent={})", student);

        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.error("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
                log.error("FieldError: {}", fe);
            }
            return "/student/new";
        }

        model.addAttribute("student", student);
        return "index";
    }

}
