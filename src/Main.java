import employe.EmployeeList;
import exception.MinimumWageException;
import payrollmanager.PayrollReader;

public class Main {
    public static void main(String[] args) {

        PayrollReader fileReader = new PayrollReader("payroll.txt");
        EmployeeList elist = new EmployeeList();

        fileReader.getEmployees(elist);
        System.out.println(elist);

    }
}