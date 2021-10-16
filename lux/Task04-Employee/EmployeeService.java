import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<Employee>();
    }

    public void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void printEmployees() {
        this.printEmployees(this.employees);
    }

    public double calculateSalaryAndBonus() {
        double result = employees.stream().mapToDouble(employee -> employee.getSalary() + employee.getBonus()).sum();
        return result;
    }

    public Employee getById(long id) {
        for (Employee employee : this.employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Employee[] getByName(String name) {
        Employee[] result = this.employees
            .stream()
            .filter(employee -> employee.getName().equals(name))
            .toArray(Employee[]::new);
        return result;
    }

    public Employee edit(long id, Employee employee) {
        Employee currentEmployee = this.getById(id);
        Employee oldEmployee = null;
        try {
            oldEmployee = currentEmployee.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (currentEmployee != null) {
            currentEmployee.setName(employee.getName());
            currentEmployee.setAge(employee.getAge());
            currentEmployee.setSalary(employee.getSalary());
            currentEmployee.setGender(employee.getGender());
            currentEmployee.setFixedBugs(employee.getFixedBugs());
            currentEmployee.setDefaultBugRate(employee.getDefaultBugRate());
            return oldEmployee;
        }
        return null;
    }

    public Employee remove(long id) {
        Employee employee = this.getById(id);
        this.employees.removeIf(e -> e.getId() == id);
        return employee;
    }

    public void add(Employee employee) {
        this.employees.add(employee);
    }

    public List<Employee> sortByName() {
        List<Employee> employeeList = new ArrayList<>(this.employees);
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return employeeList;
    }

    public List<Employee> sortByNameSalary() {
        List<Employee> employeeList = new ArrayList<>(this.employees);
        return employeeList
            .stream()
            .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary))
            .collect(Collectors.toList());
    }

    public List<Employee> sortByAgeSalary() {
        List<Employee> employeeList = new ArrayList<>(this.employees);
        return employeeList
            .stream()
            .sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName))
            .collect(Collectors.toList());
    }
}
