package thangnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import thangnm.dto.TStudentInformationDto;
import thangnm.service.StudentInformationService;
import thangnm.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @RequestMapping(value = "/student")
    public String findAll(Model model){
        List<TStudentInformationDto> list = studentInformationService.findAll();
        model.addAttribute("listData", list);
        return "student";
    }

    @RequestMapping(value = "/student/{id}/detail")
    public String findById(@PathVariable("id") String id, Model model){
        TStudentInformationDto data = studentInformationService.findById(id);
        model.addAttribute("data", data);
        return "detail";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveInit( Model model ){
        model.addAttribute("studendInformation", new TStudentInformationDto());
        return "save";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveDo(@ModelAttribute("studendInformation") TStudentInformationDto dto){
        studentInformationService.save(dto);
        return "redirect:/student";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadInit( ){

        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadDo(@RequestParam(name = "file") MultipartFile file){
        try {
            studentInformationService.uploadFile(file);
            return "viewFile";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "upload";
        }
    }

    @RequestMapping(value = "/download-file")
    public void downLoadFile(HttpServletRequest request, HttpServletResponse response){
        String directory = StringUtils.FOLDER_UPLOAD;
        Path path = Paths.get( directory, "ahihi.jpg" );
        if(Files.exists(path) ){
            response.setContentType(StringUtils.CONTENT_TYPE_IMAGE);
            response.addHeader("Content-Disposition", "attachment; filename=bhihi.jpg");
            try {
                Files.copy(path, response.getOutputStream());
                response.getOutputStream().flush();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    // =========================== REST =======================//
    @RequestMapping(value = "/student-rest")
    public @ResponseBody List<TStudentInformationDto>  findAllRest(){
        return studentInformationService.findAll();
    }

    @RequestMapping(value = "/save-rest", method = RequestMethod.POST)
    public @ResponseBody void saveDoRest(@RequestBody TStudentInformationDto dto){
        studentInformationService.save(dto);
    }

}
