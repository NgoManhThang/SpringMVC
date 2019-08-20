package thangnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import thangnm.dto.TStudentInformation;
import thangnm.dto.TTeacherInformation;
import thangnm.service.StudentInformationService;

import java.util.List;

@Controller
public class HelloWorldController {

    @Autowired
    private StudentInformationService studentInformationService;

    @RequestMapping(value = "/")
    public String init(){
        return "init";
    }

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/language")
    public String language(){
        return "language";
    }

    @RequestMapping(value = "/student/list")
    public String findAll(Model model){
        List<TStudentInformation> list = studentInformationService.findAll();
        model.addAttribute("listData", list);
        return "student";
    }

    @RequestMapping(value = "/teacher/list")
    public String findAllTeacher(Model model){
        List<TTeacherInformation> list = studentInformationService.findAllTeacher();
        model.addAttribute("listData", list);
        return "teacher";
    }
}
