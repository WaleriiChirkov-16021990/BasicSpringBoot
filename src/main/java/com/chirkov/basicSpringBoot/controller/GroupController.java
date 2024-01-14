package com.chirkov.basicSpringBoot.controller;

import com.chirkov.basicSpringBoot.StudentService;
import com.chirkov.basicSpringBoot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    private final StudentService service;

    @Autowired
    public GroupController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{groupName}/student")
    public List<Student> getStudentByGroupName(@PathVariable String groupName) {
        return service.getStudentByGroup(groupName);
    }
}
