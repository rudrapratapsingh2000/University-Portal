package com.UniversityEventManagement.Controller;

import com.UniversityEventManagement.Model.StudentModel;
import com.UniversityEventManagement.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-app")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/findAll-api")
    public List<StudentModel> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/findbyId-api/number/{number}")
    public  StudentModel findStudentById(@PathVariable int number){
        return studentService.getStudentById(number);
    }

    @PostMapping("/add-api")
        public void addStudent(@RequestBody StudentModel studentModel){
        studentService.addStudent(studentModel);
        }
@PutMapping("/update-api/number/{number}")
    public  void updateStudent(@PathVariable int number, @RequestBody StudentModel studentModel){
        studentService.updateStudent(number,studentModel);
}

@DeleteMapping("/delete-api/number/{number}")
    public void deleteStudent(@PathVariable int number){
        studentService.deleteStudent(number);
}
}
