package cz.duda.projectiba.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Jan Duda on 6/11/2016.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/controller")
public class Controller {

    @RequestMapping(method = RequestMethod.GET)
    public String getX(String x,
                       Model model){

        if (x != null){
            try {
                int intX = Integer.parseInt(x);
                model.addAttribute("x", intX);
            } catch (NumberFormatException ex) {
                model.addAttribute("error", "Wrong format of param x, x should be integer!");
            }
        } else {
            model.addAttribute("x", 1);
        }
        return "index";
    }
}
