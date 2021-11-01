import java.util.Random;

public class Developer extends Employee {

    static final double fixedBugsCoef = 0.5;

    public Developer(String name, int age, double salary, Gender gender, int fixedBugs) {
        super(name, age, salary, gender);
        this.setFixedBugs(fixedBugs);
    }
    private int fixedBugs;

    public int getFixedBugs() {
        return fixedBugs;
    }

    public void setFixedBugs(int fixedBugs) {
        this.fixedBugs = fixedBugs;
    }

    @Override
    public double getTotalBill() {
        Random random = new Random();
        return (this.getSalary() + this.getFixedBugs() * Developer.fixedBugsCoef) *
            (random.nextBoolean() ? 2 : 0);
    }
}
