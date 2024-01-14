package com.example.springwebapistart.controller;

import com.example.springwebapistart.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @GetMapping
    public Student getStudent()
    {
      return new Student(101, "Rajesh", "Kumar");

    }

    @GetMapping("family")
    public List<Student> getFamily()
    {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Rajesh", "Kumar"));
        students.add(new Student(2, "Kavita", "Kumari"));
        students.add(new Student(3, "Vihaan", "Kumar"));
        students.add(new Student(4, "Gyanvi", "Yadav"));

        return students;
    }

    @GetMapping("/{id}/{fname}/{lname}")
    public Student getStudentPathVariable(@PathVariable("id") int id, @PathVariable("fname") String fname , @PathVariable("lname") String lname)
    {
        return new Student(id, fname, lname);

    }

    @GetMapping("/search")
    public Student getStudentRequestParam(@RequestParam int id, @RequestParam String fname , @RequestParam String lname)
    {
        return new Student(id, fname, lname);

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void Create(@RequestBody Student student)
    {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody Student student)
    {
        System.out.println("This is STUDENT update Request");
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
    }

    @DeleteMapping("delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@RequestBody Student student)
    {
        System.out.println("This is STUDENT delete Request");
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
    }
}
