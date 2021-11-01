public class Employee implements Cloneable {
    private static long globalId;
    private long id;
    private String name;
    private int age;
    private double salary;
    private Gender gender;

    public Employee(String name, int age, double salary, Gender gender) {
        this.id = ++Employee.globalId;
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
        this.setGender(gender);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getTotalBill() {
        return this.getSalary();
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %d\n" +
            "Name: %s\n" +
            "Age: %d\n" +
            "Salary $: %.2f\n" +
            "Gender: %s\n" +
            this.id,
            this.name,
            this.age,
            this.salary,
            this.gender
        );
    }

    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }
}
