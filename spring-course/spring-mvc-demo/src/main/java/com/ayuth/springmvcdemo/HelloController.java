package com.ayuth.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "main-menu";
    }

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the messsage
        String result = "Yo! " + theName;

        // add the message to model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam("studentName") String theName,
            Model model) {

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the messsage
        String result = "Hey My Friend from v3! " + theName;

        // add the message to model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
