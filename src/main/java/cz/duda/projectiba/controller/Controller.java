package cz.duda.projectiba.controller;

import cz.duda.projectiba.model.Student;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by Jan Duda on 6/11/2016.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/controller")
public class Controller {

    @RequestMapping(method = RequestMethod.GET)
    public String showStudent(Model model){

        return "index";
    }

    @RequestMapping(value = "/student/new", method = RequestMethod.GET)
    public String newStudent(Model model){
        model.addAttribute("newStudent", new Student());
        return "/student/new";
    }

    @RequestMapping(value = "/student/new", method = RequestMethod.POST)
    public String createStudent(Model model,
                                @ModelAttribute("newStudent") Student student){

        model.addAttribute("student", student);
        return "index";
    }

}
