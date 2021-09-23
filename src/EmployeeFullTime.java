public class EmployeeFullTime extends Employee{
    private int salary;
    private int forfeit;
    private  int bonus;

    public EmployeeFullTime() {
    }

    public EmployeeFullTime(int salary, int fine, int bonus) {
        this.salary = salary;
        this.forfeit = fine;
        this.bonus = bonus;
    }

    public EmployeeFullTime(String name, int age, int salary, int fine, int bonus) {
        super(name, age);
        this.salary = salary;
        this.forfeit = fine;
        this.bonus = bonus;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getFine() {
        return forfeit;
    }

    public void setFine(int fine) {
        this.forfeit = fine;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public double payroll() {
        return (salary + bonus - forfeit);
    }

    @Override
    public String toString() {
        return "EmployeeFullTime{" +
                " name: " + getName()+
                " age: " + getAge() +
                " salary=" + salary +
                ", fine=" + forfeit +
                ", bonus=" + bonus +
                '}';
    }
}
