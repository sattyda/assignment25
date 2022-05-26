package Assignment.student.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StuService {

    @Autowired
    StuRepo depRepo;


    public Student get(Long id) {
       return depRepo.findById(id).orElse(null);
    }


    public Student getbyname(String name) {
        List<Student> list = depRepo.findByName(name);
        if(list.isEmpty()){
            Student d = new Student();
            d.setName(name);
            return d;
        } else {
            return list.get(0);
        }
    }

    public Student save(Student department) {
        depRepo.save(department);
        return department;
    }

    public Student put(Student department) {
        depRepo.save(department);
        return department;
    }

    public String delete(Long id) {
        depRepo.deleteAllById(Arrays.asList(id));
        return "deleted";
    }
}
