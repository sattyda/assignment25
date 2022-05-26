package Assignment.depaterment.dapartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepController {
    @Autowired
    DepService depService;

    @RequestMapping(value = "/department/{id}" , method = RequestMethod.GET)
    public Department get(@RequestParam("id") Long id){
        return depService.get(id);
    }

    @RequestMapping(value = "/department/getbyname/{name}" , method = RequestMethod.GET)
    public Department getbyname(@RequestParam("name") String name){
        return depService.getbyname(name);
    }

    @RequestMapping(value = "/department/" , method = RequestMethod.POST)
    public Department save(@RequestBody Department department){
        return depService.save(department);
    }


    @RequestMapping(value = "/department/{id}" , method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") Long id){
        return depService.delete(id);
    }

    @RequestMapping(value = "/department/" , method = RequestMethod.PUT)
    public Department put(@RequestBody Department department){
        return depService.put(department);
    }

}
