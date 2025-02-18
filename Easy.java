import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + salary;
    }
}

public class EmployeeManager {
    static List<Employee> employees = new ArrayList<>();
    
    static void addEmployee(int id, String name, double salary) {
        employees.add(new Employee(id, name, salary));
    }

    static void updateEmployee(int id, String name, double salary) {
        for (Employee e : employees) {
            if (e.id == id) {
                e.name = name;
                e.salary = salary;
                return;
            }
        }
    }

    static void removeEmployee(int id) {
        employees.removeIf(e -> e.id == id);
    }

    static Employee searchEmployee(int id) {
        for (Employee e : employees) {
            if (e.id == id) return e;
        }
        return null;
    }

    public static void main(String[] args) {
        addEmployee(1, "John", 50000);
        addEmployee(2, "Doe", 60000);
        updateEmployee(1, "John Updated", 55000);
        removeEmployee(2);
        System.out.println(searchEmployee(1));
    }
}
