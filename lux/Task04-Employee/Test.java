public class Test {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        EmployeeFactory factory = new EmployeeFactory();

        Employee[] employees = factory.generateEmployees(100);
        for (Employee employee : employees) {
            service.add(employee);
        }

        service.printEmployees();

        int number = 5;
        Employee employeeNo5 = service.getById(number);
        if (employeeNo5 != null) {
            System.out.println(String.format("Employee #%d:\n" + employeeNo5, number));
        } else {
            System.out.println(String.format("Employee #%d not found", number));
        }

        String name = employeeNo5.getName();
        Employee[] employeesByName = service.getByName(name);
        System.out.println(String.format("Found %d \"%s\" employee(s).", employeesByName.length, name));
        for (Employee employee : employeesByName) {
            System.out.println(employee);
        }

        long existingEmployeeId = employeesByName[0].getId();
        Employee existingEmployee = service.getById(existingEmployeeId);
        System.out.println("Existing employee:");
        System.out.println(existingEmployee);

        if (existingEmployee != null) {
            Employee oldEmployee = service.edit(existingEmployeeId, new Employee(
                "Vasiliy Pupkin",
                18,
                999,
                Gender.MALE,
                100,
                1.0
            ));
            assert existingEmployee.getId() == oldEmployee.getId();
            System.out.println("Old employee (identical to existing one):");
            System.out.println(oldEmployee);

            Employee newEmployee = service.getById(existingEmployeeId);
            System.out.println("New employee:");
            System.out.println(newEmployee);
        }

        Employee deletedEmployee = service.remove(existingEmployeeId);
        System.out.println("Deleted employee:");
        System.out.println(deletedEmployee);

        System.out.println("List of all employees:");
        service.printEmployees();
    }
}
