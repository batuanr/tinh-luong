public class EmployeePartTime extends Employee{
    private double workingHour;

    public EmployeePartTime() {
    }

    public EmployeePartTime(String name, int age, double workingHour) {
        super(name, age);
        this.workingHour = workingHour;
    }

    public double getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(double workingHour) {
        this.workingHour = workingHour;
    }

    @Override
    public double payroll() {
        return workingHour * 100000;
    }

    @Override
    public String toString() {
        return "EmployeePartTime{" +
                " name: " + getName() +
                " age: " + getAge() +
                " workingHour=" + workingHour +
                '}';
    }
}
