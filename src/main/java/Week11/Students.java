package Week11;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


class Student {
    private int id;
    private String name;
    private String department;
    private String university;
    private double gpa;

    public Student(int id, String name, String department, String university, double gpa) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.university = university;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getUniversity() {
        return university;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return name;
    }
}

class EmptyStudentListException extends RuntimeException {
    public EmptyStudentListException(String message) {
        super(message);
    }
}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class StudentSystem {
    public List<Student> students;

    public StudentSystem(String fileName) {
        try {
            this.students = readStudents(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            this.students = new ArrayList<>();
        }
    }

    public List<Student> readStudents(String fileName) throws IOException {
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String university = parts[2];
                String department = parts[3];
                double gpa = Double.parseDouble(parts[4]);
                Student student = new Student(id, name, university, department, gpa);
                studentList.add(student);
            }
        }
        return studentList;
    }

    public Optional<Student> findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Student details for ID " + id + ":");
                System.out.println("Name: " + student.getName());
                System.out.println("Department: " + student.getDepartment());
                System.out.println("University: " + student.getUniversity());
                System.out.println("GPA: " + student.getGpa());
                return Optional.of(student);
            }
        }
        System.out.println("Student with ID " + id + " not found.");
        return Optional.empty();
    }

    public Student findStudentWithHighestGPA() throws EmptyStudentListException {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("No students available.");
        }

        double maxGPA = 0;
        Student highestGPAStudent = null;

        for (Student student : students) {
            if (student.getGpa() > maxGPA) {
                maxGPA = student.getGpa();
                highestGPAStudent = student;
            }
        }

        return highestGPAStudent;
    }

    public Student findStudentWithLongestName() throws EmptyStudentListException {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("No students available.");
        }

        int maxLength = 0;
        Student longestNameStudent = null;

        for (Student student : students) {
            if (student.getName().length() > maxLength) {
                maxLength = student.getName().length();
                longestNameStudent = student;
            }
        }

        return longestNameStudent;
    }
}

class MainTest {
    private StudentSystem studentSystem;

    @BeforeEach
    void setUp() {
        studentSystem = new StudentSystem("students.csv");
    }

    @Test
    void testIfStudentsNotEmpty() {
        List<Student> studentList = studentSystem.students;
        assertFalse(studentList.isEmpty(), "List of students is empty.");
    }

    @Test
    void testFindStudentById() {
        Optional<Student> student = studentSystem.findStudentById(100);
        assertFalse(student.isEmpty(), "Student with ID 100 not found.");
    }

    @Test
    void testFindStudentByIdNotFound() {
        Optional<Student> student = studentSystem.findStudentById(999);
        assertFalse(student.isPresent(), "Student with ID 999 should not be found.");
    }

    @Test
    void testFindStudentWithHighestGPA() {
        try {
            Student student = studentSystem.findStudentWithHighestGPA();
            assertNotNull(student);
        } catch (EmptyStudentListException e) {
            fail("No students available.");
        }
    }

    @Test
    void testExceptionForEmptyStudentList() {
        StudentSystem emptySystem = new StudentSystem("empty.csv");
        assertThrows(EmptyStudentListException.class, emptySystem::findStudentWithHighestGPA);
    }

    @Test
    void testNames() throws IOException {
        List<Student> students = studentSystem.readStudents("students.csv");
        String[] actualNames = new String[5];
        for (int i = 0; i < 5; i++) {
            actualNames[i] = students.get(i).getName();
        }
        String[] expectedNames = {"a", "b", "c", "d", "e"};
        assertArrayEquals(expectedNames, actualNames);
    }

    @Test
    void testSize() throws IOException {
        assertEquals(70, studentSystem.readStudents("students.csv").size());
    }

    @Test
    void testLargestName() {
        Student student = studentSystem.findStudentWithLongestName();
        assertNotNull(student);
        assertNotEquals("Ava White", student.getName());
    }

    @Test
    void testStudents() {
        try {
            Student highestGPAStudent = studentSystem.findStudentWithHighestGPA();
            Student longestNameStudent = studentSystem.findStudentWithLongestName();
            assertNotEquals(highestGPAStudent, longestNameStudent);
        } catch (EmptyStudentListException e) {
            fail("No students available.");
        }
    }

    @Test
    void testSameStudent() throws StudentNotFoundException {
        try {
            Student highestGPAStudent = studentSystem.findStudentWithHighestGPA();
            assertNotEquals(highestGPAStudent, studentSystem.findStudentById(12).orElse(null));
        } catch (EmptyStudentListException e) {
            fail("No students available.");
        }
    }
}
public class Students {
    private static StudentSystem studentSystem;

    public static void main(String[] args) {
        studentSystem = new StudentSystem("students.csv");

        try {
            Optional<Student> studentById = studentSystem.findStudentById(10);
            if (studentById.isPresent()) {
                studentById.get();
            } else {
                System.out.println("Student with ID 10 not found.");
            }

            Student studentWithHighestGPA = studentSystem.findStudentWithHighestGPA();
            System.out.println("\nStudent with highest GPA: " + studentWithHighestGPA);
            System.out.println("GPA: "+studentWithHighestGPA.getGpa());

            Student studentWithLongestName = studentSystem.findStudentWithLongestName();
            System.out.println("\nStudent with longest name: " + studentWithLongestName);

        } catch (EmptyStudentListException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}