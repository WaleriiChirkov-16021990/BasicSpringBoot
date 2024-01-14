package com.chirkov.basicSpringBoot.controller;

import com.chirkov.basicSpringBoot.StudentService;
import com.chirkov.basicSpringBoot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * 3.1 GET /student/{id} - получить студента по ID
 * 3.2 GET /student - получить всех студентов
 * 3.3 GET /student/search?name='studentName' - получить список студентов, чье имя содержит подстроку studentName
 * 3.4 GET /group/{groupName}/student - получить всех студентов группы
 * 3.5 POST /student - создать студента (принимает JSON) (отладиться можно с помощью Postman)
 * 3.6 DELETE /student/{id} - удалить студента
 * 4. При старте приложения, в программе должно быть создано 5-10 студентов.
 */

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> findAll() {
        return service.getStudentList();
    }


    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return service.getStudentById(id);
    }

    @GetMapping("/search")
    public List<Student> searchStudentStartWithName(@RequestParam String name) {
        return service.getStudentByName(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.deleteStudent(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> saveStudent(@RequestBody Student student) {
        service.saveStudent(student);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
