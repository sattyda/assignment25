package com.example.student.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    StudentService studentService;


    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    Principal principal;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String index(HttpSession session){
        System.out.println(session.getAttribute("name"));
        return "index";
    }


    @GetMapping("/register")
    public String register(Principal principal){
        if(principal != null){
            return "redirect:/home";
        }
        return "register";
    }

    @RequestMapping(value = "/home" , method = RequestMethod.GET)
    public String home(Principal principal, HttpSession httpSession){
        setupSession( httpSession, principal );
        System.out.println(principal.getName());
        httpSession.setAttribute("name" , "Sattyda");
        return "home";
    }

    private void setupSession(HttpSession httpSession, Principal principal) {
        if(httpSession.getAttribute("userLoggedIn") == null ){
            studentService.setSession(httpSession , principal);
        }
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String registerSave(Student student , HttpSession session , HttpServletRequest request , Principal principal) throws ServletException {
        System.out.println(student.getUsername());
        student.setPassword( bCryptPasswordEncoder.encode( student.getPassword() ));


        studentService.save( student );/////  ==== 5

        request.login(student.getUsername() , student.getPassword());

        return "redirect:/home";
    }

    private void authenticateUserAndSetSession(Student user, HttpServletRequest request) {
        String username = user.getUsername();
        String password = user.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        // generate session if one doesn't exist
        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));

        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContext securityContext = SecurityContextHolder.getContext();

        securityContext.setAuthentication(authenticatedUser);

        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT" , securityContext);
    }

    // smtp :::::::
}
