import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Employee NV1 = new EmployeeFullTime("name1", 20, 15000000, 500000, 700000);
        Employee NV2 = new EmployeeFullTime("name2", 22, 9000000, 500000, 900000);
        Employee NV3 = new EmployeeFullTime("name3", 25, 17000000, 500000, 1000000);
        Employee NV4 = new EmployeeFullTime("name4", 27, 5000000, 500000, 1000000);
        Employee NV5 = new EmployeePartTime("name5", 15, 30);
        Employee NV6 = new EmployeePartTime("name6", 16, 35);
        Employee NV7 = new EmployeePartTime("name7", 18, 38);
        Scanner s = new Scanner(System.in);
        Scanner n = new Scanner(System.in);

        Employee[] employeesList = {NV1,NV2, NV3, NV4, NV5, NV6, NV7};

        getInfo(employeesList);
        System.out.println("Tổng lương parttime");
        System.out.printf("%.1f",getTotalMoneyPartTime(employeesList));
        System.out.println("\nNhững người lương thấp");
        getListEmployee(employeesList);
        System.out.println("sắp xếp tên theo lương tăng dần");
        sortEmployee(employeesList);
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
    } // số lượng nhân vien fulltime
    public static int getNumberOfEmployeeFullTime(Employee[] arr){
        int count= 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof EmployeeFullTime){
                count++;
            }
        }
        return count;
    }
    // trung bình lương
    public static double getAverageSalary(Employee[] arr){
        double averageSalary;
        averageSalary = getTotalMoneyFullTime(arr) / getNumberOfEmployeeFullTime(arr);
        return averageSalary;
    }
    // in ra nhân viên có lương thấp hơn luong tb
    public static void getListEmployee(Employee[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof  EmployeeFullTime){
                if (arr[i].payroll() < getAverageSalary(arr)){
                    System.out.println(arr[i].getName());
                }
            }
        }
    }
//    thông tin nhân viên
    public static void getInfo(Employee[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    // thêm nv fulltime
    public static void addEmployee(Employee[] arr){
        Scanner s = new Scanner(System.in);
        Scanner n = new Scanner(System.in);
        System.out.println("so luong nhan vien");
        int a = n.nextInt();
        for (int i = 0; i < a; i++) {
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
            arr[i] = new EmployeeFullTime(name, age, salary, bonus, forfeit);
        }
    }
    // tính tổng tiền nhân viên parttime
    public static double getTotalMoneyPartTime(Employee[] arr){
        double total=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof EmployeePartTime){
                total += arr[i].payroll();
            }
        }
        return total;
    }
  // lay danh sach nv full time
    public static Employee[] getListEmployeeFullTime(Employee[] arr) {
        Employee[] fulltimeList = new EmployeeFullTime[getNumberOfEmployeeFullTime(arr)];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] instanceof EmployeeFullTime) {
                fulltimeList[j] = arr[i];
                j++;
            }
        }
        return fulltimeList;
    }
    // sắp xếp nhân viên theo lương;
    public static void sortEmployee(Employee[] arr){
        Employee[] a = getListEmployeeFullTime(arr);
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i; j < a.length-1; j++) {
                if (a[j].payroll() > a[j+1].payroll()){
                    Employee temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].getName());
        }
    }
}
