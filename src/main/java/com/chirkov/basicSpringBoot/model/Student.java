package com.chirkov.basicSpringBoot.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * 2. Создать Класс Student c полями: идентификатор, имя, имя группы
 */
@Component
@Scope("prototype")
@Getter
@Setter
public class Student {
    private int id;
    private String name;
    private String groupName;

    public Student(String name, String groupName) {
        this.name = name;
        this.groupName = groupName;
    }

    public Student(int id, String name, String groupName) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
