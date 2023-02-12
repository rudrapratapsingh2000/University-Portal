package com.UniversityEventManagement.Service;

import com.UniversityEventManagement.Model.StudentModel;
import org.springframework.stereotype.Service;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private static List<StudentModel> students=new ArrayList<>();
    static{
        students.add(new StudentModel(1001,"Rudra","Pratap",22,"C.S.E"));
        students.add(new StudentModel(1002,"Hrishi","Raj",23,"I.T"));
        students.add(new StudentModel(1003,"Anup","Kumar",24,"M.E"));
        students.add(new StudentModel(1004,"Tej","Pratap",18,"C.E"));
        students.add(new StudentModel(1005,"Sanjay","Kumar",25,"E.E"));
        students.add(new StudentModel(1006,"Mahesh","Kumar",18,"E.C"));
        students.add(new StudentModel(1007,"Chand","Yadav",26,"B.T"));
    }
    public void addStudent(StudentModel studentModel){
        students.add(studentModel);
    }

    public static List<StudentModel> getAllStudents() {
        return students;
    }
    public StudentModel getStudentById(int number){
        Predicate<? super StudentModel> predicate=studentModel -> studentModel.getStudent_Id()==number;
        StudentModel studentModel=students.stream().filter(predicate).findFirst().get();
                return studentModel;
    }
    public void updateStudent(int number,StudentModel newStudentModel){
        StudentModel studentModel=getStudentById(number);
        studentModel.setStudent_Id(newStudentModel.getStudent_Id());
        studentModel.setFirst_name(newStudentModel.getFirst_name());
        studentModel.setLast_name(newStudentModel.getLast_name());
        studentModel.setAge(newStudentModel.getAge());
        studentModel.setDepartment(newStudentModel.getDepartment());
    }
    public void deleteStudent(int number){
        Predicate<? super StudentModel> predicate=studentModel -> studentModel.getStudent_Id() ==number;
        students.removeIf(predicate);
    }

}
