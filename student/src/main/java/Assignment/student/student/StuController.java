package Assignment.student.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StuController {
    @Autowired
    StuService stuService;

    @RequestMapping(value = "/student/{id}" , method = RequestMethod.GET)
    public Student get(@RequestParam("id") Long id){
        return stuService.get(id);
    }

    @RequestMapping(value = "/student/getbyname/{name}" , method = RequestMethod.GET)
    public Student getbyname(@RequestParam("name") String name){
        return stuService.getbyname(name);
    }

    @RequestMapping(value = "/student/" , method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        return stuService.save(student);
    }


    @RequestMapping(value = "/student/{id}" , method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") Long id){
        return stuService.delete(id);
    }

    @RequestMapping(value = "/student/" , method = RequestMethod.PUT)
    public Student put(@RequestBody Student student){
        return stuService.put(student);
    }

}
