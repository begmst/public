public class Designer extends Employee {

    private double rate;
    private int workedDays;

    public Designer(String name, int age, double salary, Gender gender, double rate, int workedDays) {
        super(name, age, salary, gender);
        this.setRate(rate);
        this.setWorkedDays(workedDays);
    }

    public int getWorkedDays() {
        return workedDays;
    }

    public void setWorkedDays(int workedDays) {
        this.workedDays = workedDays;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double getTotalBill() {
        return this.getSalary() + this.getRate() * getWorkedDays();
    }
}
