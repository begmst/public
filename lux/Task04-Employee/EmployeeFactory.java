import java.util.Random;

public class EmployeeFactory {
    private static String[] firstNames = {
            "Jaya",
            "Marian",
            "Ismail",
            "Jennie",
            "Amelia-Grace",
            "Theresa",
            "Matteo",
            "Tillie",
            "Conner",
            "Dustin",            
    };
    private static String[] lastNames = {
            "Colley",
            "Churchill",
            "Oakley",
            "Sanderson",
            "Conrad",
            "Davies",
            "Pace",
            "Ferguson",
            "Carson",
            "Gentry",            
    };

    public Employee[] generateEmployees(int size) {
        Employee[] employees = new Employee[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            String name = EmployeeFactory.firstNames[random.nextInt(EmployeeFactory.firstNames.length)]
                + " "
                + EmployeeFactory.lastNames[random.nextInt(EmployeeFactory.lastNames.length)];
            employees[i] = new Employee(
                name,
                random.nextInt(18,65),
                random.nextDouble(100, 1000),
                Gender.values()[random.nextInt(Gender.values().length)],
                random.nextInt(100),
                0.5
            );
        }
        return employees;
    }
}
