package com.chirkov.basicSpringBoot;

import com.chirkov.basicSpringBoot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StudentService {

    private final List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
        this.students.add(new Student(1, "John", "Principal"));
        this.students.add(new Student(2, "Will", "Principal"));
        this.students.add(new Student(3, "Sapfir", "Principal"));
        this.students.add(new Student(4, "Muhammad", "Principal"));
        this.students.add(new Student(5, "Oleg", "Master"));
        this.students.add(new Student(6, "Alex", "Master"));
        this.students.add(new Student(7, "Romano", "Major"));
        this.students.add(new Student(8, "Tutanh", "Major"));
        this.students.add(new Student(9, "Mustang", "Major"));
        this.students.add(new Student(10, "Collem", "Major"));
        this.students.add(new Student(11, "Max", "Major"));
        this.students.add(new Student(12, "Dash", "Major"));
        this.students.add(new Student(13, "David", "Base"));
        this.students.add(new Student(14, "Johnson", "Base"));
        this.students.add(new Student(15, "Babble", "Base"));
    }

    public List<Student> getStudentList() throws RuntimeException {
        Optional<List<Student>> list = Optional.of(students);
        return list.orElseThrow(() -> new RuntimeException("Could not find students"));
    }

    public Student getStudentById(int id) throws RuntimeException {
        Optional<Student> findStudent = Optional.empty();
        for (Student student : students) {
            if (student.getId() == id) {
                findStudent = Optional.of(student);
            }
        }
        return findStudent.orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public List<Student> getStudentByName(String name) throws RuntimeException {
        Optional<List<Student>> findStudent = Optional.of(students.stream().filter(student -> student.getName().startsWith(name)).collect(Collectors.toList()));
        return findStudent.orElseThrow(() -> new RuntimeException("Student not found for start with " + name));
    }

    public boolean saveStudent(Student student) throws RuntimeException {
        if (student != null && students != null) {
            return students.add(student);
        } else {
            throw new RuntimeException("Student: " + student + " not saved.");
        }
    }

    public Student deleteStudent(int id) throws RuntimeException {
        Student findStudents;
        if (id >= 0 && students != null) {
            findStudents = students.stream().filter(student -> student.getId() == id).findFirst()
                    .orElseThrow(() -> new RuntimeException("Student for id = " + id + ", not found!"));
        } else {
            throw new RuntimeException("Student for id=" + id + "not removed! Bad request.");
        }
        students.remove(findStudents);
        return findStudents;
    }

    public List<Student> getStudentByGroup(String groupName) throws RuntimeException {
        if (!groupName.isEmpty() && !students.isEmpty()) {
            return Optional.of(students.stream().filter(students1 ->
                    students1.getGroupName().equalsIgnoreCase(groupName)).toList()).orElseThrow(() ->
                    new RuntimeException("Student for Group: " + groupName + " not found!"));
        }
        throw new RuntimeException("Student for Group: " + groupName + "not found!");

    }
}
