package studentdatabase.studentdatabase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import studentdatabase.studentdatabase.models.Student;
import studentdatabase.studentdatabase.models.StudentRepository;

@Controller
public class StudentsController {
    @Autowired
    private StudentRepository studentRepo;

    //main page redirection to the database page
    @GetMapping("/")
    public String mainPage(Model model) {
        return "redirect:/students/view";
    }

    //showing the student database
    @GetMapping("/students/view")
    public String getAllStudents(Model model) {
        System.out.println("Getting all students");
        //get all students from database
        List<Student> students = studentRepo.findAll();
        //end of database call
        model.addAttribute("students", students);
        return "students/showAll";
    }

    //adding a student to the database
    @GetMapping("/students/add")
    public String addStudent(Model model) {
        Student student1 = new Student();
        model.addAttribute("student", student1);
        return "students/add.html";
    }

    //saving the student to the database after submitting the add form
    @PostMapping("/students/view")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentRepo.save(student);
        return "redirect:/students/view";
    }

    //taking the user to the update form after clicking update button
    @GetMapping("/students/update/{id}")
    public String updateStudent(@PathVariable int id, Model model) {
        model.addAttribute("student", studentRepo.findById(id).get());
        return "students/update";
    }

    //saving the updated student to the database after submitting the update form
    @PostMapping("/students/{id}")
    public String saveUpdatedStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model model) {
        Student student2 = studentRepo.findById(id).get();
        student2.setSid(id);
        student2.setName(student.getName());
        student2.setWeight(student.getWeight());
        student2.setHeight(student.getHeight());
        student2.setHairColor(student.getHairColor());
        student2.setGpa(student.getGpa());
        
        studentRepo.save(student2);
        return "redirect:/students/view";
    }

    //taking the user to the compare form after clicking "compare students" button
    @GetMapping("/students/compare")
    public String compareStudents(Model model) {
        //get all students from database
        List<Student> students = studentRepo.findAll();
        //end of database call
        model.addAttribute("students", students);
        return "students/compare";
    }
    
    //deleting a student from the database on pressing "Delete" button
    @GetMapping("/students/delete/{id1}")
    public String deleteStudent(@PathVariable int id1, Model model) {
        studentRepo.deleteById(id1);
        return "redirect:/students/view";
    }
}
