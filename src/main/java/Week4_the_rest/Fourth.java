package Week4_the_rest;

import java.util.ArrayList;

class Student
{
    private int student_id;
    private ArrayList<Double> grades;
    public Student(int student_id){
        this.student_id=student_id;
        this.grades = new ArrayList<>();
    }
    public int getStudent_id(){
        return student_id;
    }
    public void setStudent_id(int student_id){
        this.student_id=student_id;
    }
    private boolean validGrade(double grade){
        return grade >= 0 && grade <= 100;
    }
    public void addGrade(double grade){
        if(validGrade(grade)){
            grades.add(grade);
        }
        else{
            System.out.println("Invalid input.");
        }
    }

    public void displayGrades(){
        System.out.println("Grades for Student with ID " + student_id + ":");
        for(double grade:grades){
            System.out.println(grade);
        }
    }

}
public class Fourth {
    public static void main(String[] args) {
        Student student = new Student(1);
        student.addGrade(88.3);
        student.addGrade(90);
        student.displayGrades();
    }
}
