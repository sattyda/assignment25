package Assignment.depaterment.dapartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DepService {

    @Autowired
    DepRepo depRepo;


    public Department get(Long id) {
       return depRepo.findById(id).orElse(null);
    }


    public Department getbyname(String name) {
        List<Department> list = depRepo.findByName(name);
        if(list.isEmpty()){
            Department d = new Department();
            d.setName(name);
            return d;
        } else {
            return list.get(0);
        }
    }

    public Department save(Department department) {
        depRepo.save(department);
        return department;
    }

    public Department put(Department department) {
        depRepo.save(department);
        return department;
    }

    public String delete(Long id) {
        depRepo.deleteAllById(Arrays.asList(id));
        return "deleted";
    }
}
