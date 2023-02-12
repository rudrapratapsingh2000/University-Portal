package com.UniversityEventManagement.Model;

import lombok.*;

import javax.management.ConstructorParameters;
import java.beans.ConstructorProperties;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {
    private int student_Id;
    private String first_name;
    private String last_name;
    private int age;
    private String department;

}
