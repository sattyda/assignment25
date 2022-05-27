package com.example.student.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.nio.file.OpenOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudnetRepo studnetRepo;

    public void save(Student student) {
        studnetRepo.save(student);
    }

    public void setSession(HttpSession httpSession, Principal principal) {

        List<Student> ops = studnetRepo.findAllByUsername(principal.getName());

        if(!ops.isEmpty()){
            httpSession.setAttribute("email" , ops.get(0).getEmail() );
        } else {
            System.out.println("System Error");
        }
    }
}
////  slf4j
