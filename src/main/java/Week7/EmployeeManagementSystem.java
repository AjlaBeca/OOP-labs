package Week7;
import java.util.List;

record Employee(int id, String name, double salary){}

public class EmployeeManagementSystem {

    public List<Employee> filterEmployeeBySalary(List<Employee> employees, double minSalary){
        return employees.stream()
                .filter(employee -> minSalary <= employee.salary())
                .toList();
    }

    public double calculateTotalSalary(List<Employee> employees){
        return employees.stream()
                .mapToDouble(Employee::salary)
                .sum();
    }

    public void displayEmployeeDetails(List <Employee> employees) {
        employees.forEach(employee -> System.out.println((
                "ID: " + employee.id() +
                ", Name: " + employee.name() +
                ", Salary: " + employee.salary()+"KM")));
    }

    public static void main(String[] args) {
        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();
        List<Employee> employees = List.of(
                new Employee(1, "Lara Veliant", 500.0),
                new Employee(2, "Aren Kertell", 600.0),
                new Employee(3, "Evangeline Fox", 750.0),
                new Employee(4, "Donatella Dragna", 550.0));

        //displaying employee details
        System.out.println("List of workers:");
        employeeManagementSystem.displayEmployeeDetails(employees);
        System.out.println();
        //filter employees by minimum salary
        System.out.println("Filtered list of workers:");
        List<Employee> filteredEmployees = employeeManagementSystem.filterEmployeeBySalary(employees, 600);
        employeeManagementSystem.displayEmployeeDetails(filteredEmployees);
        //calculating total salary
        System.out.println("\nTotal salary of all workers is: "+employeeManagementSystem.calculateTotalSalary(employees)+"KM");


    }

}
