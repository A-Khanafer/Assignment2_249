import employe.Employee;
import employe.EmployeeList;
import payrollmanager.FileManager;

import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        FileManager fileReader = new FileManager("payroll.txt");
        EmployeeList elist = new EmployeeList();

        fileReader.getEmployees(elist);
        System.out.println(elist);
elist.display();

    }
}