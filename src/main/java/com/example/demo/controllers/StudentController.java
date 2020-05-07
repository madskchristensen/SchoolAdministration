package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.repositories.IStudentRepository;
import com.example.demo.repositories.StudentRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController{

    private IStudentRepository studentRepository;

    public StudentController() {
        studentRepository = new StudentRepositoryImpl();
    }

    @GetMapping("/")
    public String index(){
        // Student student = new Student(1,"hejehej","Lotte", 1533, 10, 10,1234567890);
        // studentRepository.update(student);
        // studentRepository.create(new Student(50,"dadadada","rqrqrq", 2010, 10, 10,1234567890));
        return "index";
    }

    //Very simple prototype of GET-request with parameter
    //https://www.baeldung.com/spring-request-param
    //TODO Direct to detailed view of student
    @GetMapping("/student")
    public String getStudentByParameter(@RequestParam int id, Model model) {
        Student student = studentRepository.read(id);
        model.addAttribute("student", student);
        return "/student/detail";
    }

    @GetMapping("/courses")
    public String courses() {

        return "courses";
    }

    @GetMapping("/students")
    public String studentOverview(Model model) {
        model.addAttribute("students", studentRepository.readAll());
        return "students";
    }

    // create student method
    @GetMapping("/student/create")
    public String createStudentShow(){
        return "/student/create";
    }

    @PostMapping("/student/createDo")
    public String studentInput(@ModelAttribute Student student) {
        studentRepository.create(student);

        return "redirect:/students";
    }

    @GetMapping("/student/edit")
    public String studentEditShow(@RequestParam int id, Model model) {
        model.addAttribute("student", studentRepository.read(id));
        System.out.println(studentRepository.read(id));

        return "/student/edit";
    }

    @PostMapping("/student/editDo")
    public String studentEdit(@ModelAttribute Student student) {
        studentRepository.update(student);
        System.out.println(student);

        return "redirect:/students";
    }

    // delete student method
    @GetMapping("/student/delete")
    public String delete(@RequestParam int id, Model model){
        Student student = studentRepository.read(id);
        model.addAttribute("student", student);
        return "/student/delete";
    }

    @PostMapping("/student/deleteDo")
    public String deleteDo(@ModelAttribute Student student){
        System.out.println(student + "has been deleted");
        studentRepository.delete(student.getId());
        return "redirect:/students";
    }

    @PostMapping("/student/deleteNo")
    public String deleteNo(@ModelAttribute Student student){
        System.out.println(student + "has NOT been deleted");
        return "redirect:/students";
    }

    // edit student method
}