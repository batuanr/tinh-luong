import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Employee NV1 = new EmployeeFullTime("name1", 20, 5000000, 500000, 700000);
        Employee NV2 = new EmployeeFullTime("name2", 22, 9000000, 500000, 900000);
        Employee NV3 = new EmployeeFullTime("name3", 25, 17000000, 500000, 1000000);
        Employee NV4 = new EmployeeFullTime("name4", 27, 15000000, 500000, 1000000);
        Employee NV5 = new EmployeePartTime("name5", 15, 30);
        Employee NV6 = new EmployeePartTime("name6", 16, 35);
        Employee NV7 = new EmployeePartTime("name7", 18, 38);
        Scanner s = new Scanner(System.in);
        Scanner n = new Scanner(System.in);

        Employee[] employeesList = {NV1,NV2, NV3, NV4, NV5, NV6, NV7};

        getInfo(employeesList);
        System.out.println(getTotalMoneyFullTime(employeesList));
        getListEmployee(employeesList);
    }
    // tính tổng tiền nv full time
    public static double getTotalMoneyFullTime(Employee[] arr) {
        double total = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof EmployeeFullTime) {
               total += arr[i].payroll();
            }
        }
        return total;
    }
    // in ra nhân viên có lương thấp hơn luong tb
    public static void getListEmployee(Employee[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof  EmployeeFullTime){
               count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof  EmployeeFullTime){
                if (arr[i].payroll() < (getTotalMoneyFullTime(arr) / count)){
                    System.out.println(arr[i].getName());
                }
            }
        }
    }
    public static void getInfo(Employee[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void addEmployee(Employee[] arr){
        Scanner s = new Scanner(System.in);
        Scanner n = new Scanner(System.in);
        System.out.println("name:");
        String name = s.nextLine();
        System.out.println("age:");
        int age = n.nextInt();
        System.out.println("salary");
        int salary = n.nextInt();
        System.out.println("bonus");
        int bonus = n.nextInt();
        System.out.println("forfeit");
        int forfeit = n.nextInt();
        arr[arr.length] = new EmployeeFullTime(name, age, salary, bonus, forfeit);
    }
    public static double getTotalMoneyPartTime(Employee[] arr){
        double total=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof EmployeePartTime){
                total += arr[i].payroll();
            }
        }
        return total;
    }
}
