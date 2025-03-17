import employe.EmployeeList;
import payrollmanager.FileManager;

public class Main {
    public static void main(String[] args) {

        FileManager fileReader = new FileManager("payroll.txt");
        EmployeeList elist = new EmployeeList();

        fileReader.getEmployees(elist);
        System.out.println(elist);



    }
}