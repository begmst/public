public class Employee implements Cloneable {
    private static long globalId;
    private long id;
    private String name;
    private int age;
    private double salary;
    private Gender gender;
    private int fixedBugs;
    private double defaultBugRate;

    public Employee(String name, int age, double salary, Gender gender, int fixedBugs, double defaultBugRate) {
        this.id = ++Employee.globalId;
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
        this.setGender(gender);
        this.setFixedBugs(fixedBugs);
        this.setDefaultBugRate(defaultBugRate);
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

    public int getFixedBugs() {
        return fixedBugs;
    }

    public void setFixedBugs(int fixedBugs) {
        this.fixedBugs = fixedBugs;
    }

    public double getDefaultBugRate() {
        return defaultBugRate;
    }

    public void setDefaultBugRate(double defaultBugRate) {
        this.defaultBugRate = defaultBugRate;
    }

    public double getBonus() {
        return (double) Math.round(this.fixedBugs * this.defaultBugRate * 100) / 100;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %d\n" +
            "Name: %s\n" +
            "Age: %d\n" +
            "Salary $: %.2f\n" +
            "Gender: %s\n" +
            "Fixed Bugs: %d\n" +
            "Default Bug Rate $: %.2f\n" +
            "Bonus $: %.2f\n",
            this.id,
            this.name,
            this.age,
            this.salary,
            this.gender,
            this.fixedBugs,
            this.defaultBugRate,
            this.getBonus()
        );
    }

    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }
}
