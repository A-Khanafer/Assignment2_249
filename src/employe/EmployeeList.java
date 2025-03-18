package employe;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class EmployeeList {

    private Employee[] employeeList;

    public EmployeeList() {
        employeeList = new Employee[0];
    }

    public EmployeeList(Employee[] employeeList) {
        this.employeeList = new Employee[employeeList.length];
        for (int i = 0; i < employeeList.length; i++) {
            this.employeeList[i] = new Employee(employeeList[i]);
        }
    }

    public EmployeeList(EmployeeList employeeList) {
        this.employeeList = new Employee[employeeList.employeeList.length];
    }

    public void add(Employee employee) {
        boolean found = false;
        //Searches if the Employee exists Already
        for (Employee value : employeeList) {
            if (value != null && value.equals(employee)) {
                found = true;
                System.out.println("Employee already in Database.");
                break;
            }
        }
        //If he is not in the Database we add him to the List
        if (!found) {
            Employee[] temp = new Employee[employeeList.length + 1];

            for(int i = 0; i < employeeList.length; i++) {

                if(employeeList[i]!=null)
                    temp[i] = new Employee(employeeList[i]);

            }
            temp[employeeList.length] = new Employee(employee);
            employeeList = temp;
            System.out.println("Employee added.");
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (Employee employee : employeeList) {
            s += employee.toString() + "\n";
        }
        return s;
    }
    public void display(){
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream("employees.txt"));
            printWriter.println("\t\t\t\t\t\t\t\t\t\t\tCherkawi & Khanafer Solutions");
            printWriter.println("\t\t\t\t\t\t\t\t\t\t\t-----------------------------");
            printWriter.printf("%-20s %-20s %-20s %20s %20s %20s%n",
            "ID", "FirstName", "LastName", "Gross salary", "Deductions", "Net salary");
            printWriter.println("number");

            printWriter.println("---------------------------------------------------------------------------------------------------------------------------------");
            printWriter.println(toString());
            printWriter.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace());
        }
    }

}
