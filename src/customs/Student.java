package src.customs;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer groupNumber;
    private Integer averageGrade;
    private Integer gradeBookNumber;

    public Student(Integer groupNumber, Integer averageGrade, Integer gradeBookNumber) {
        this.groupNumber = groupNumber;
        this.averageGrade = averageGrade;
        this.gradeBookNumber = gradeBookNumber;
    }
}
