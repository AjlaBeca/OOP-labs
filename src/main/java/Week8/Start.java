package Week8;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student {
    private String name;
    private int id;
    private List<Integer> grades;

    public Student(String name, int id, List<Integer> grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public void printInfo() {
        System.out.println("Student Information:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grades: " + grades);
    }
}
class GradeAnalyzer {
    private List<Integer> grades;

    public GradeAnalyzer(List<Integer> grades) {
        this.grades = grades;
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public void printSummary() {
        System.out.println("Grade Summary:");
        System.out.println("Grades: " + grades);
        System.out.println("Average Grade: " + calculateAverageGrade());
    }
}

public class Start {
    public static void main(String[] args) {
        List<Integer> gradeList = Arrays.asList(90, 85, 92, 88, 95);
        GradeAnalyzer gradeAnalyzer = new GradeAnalyzer(gradeList);

        Class<GradeAnalyzer> gradeAnalyzerClass = GradeAnalyzer.class;
        Field[] fields = gradeAnalyzerClass.getDeclaredFields();


        System.out.println("\nField names and values:\n");

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                System.out.println(field.getName() + ": " + field.get(gradeAnalyzer));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Method[] methods = gradeAnalyzerClass.getDeclaredMethods();

        System.out.println("\nInvoking Methods:\n");
        for (Method method : methods) {
            if (method.getName().startsWith("calculate") || method.getName().startsWith("print")) {
                method.setAccessible(true);
                try {
                    if (!method.getReturnType().equals(void.class)) { //because it kept saying printSummary null
                        Object result = method.invoke(gradeAnalyzer);
                        System.out.println(method.getName() + ": " + result);
                    } else {
                        System.out.println(method.getName());
                        method.invoke(gradeAnalyzer);
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}