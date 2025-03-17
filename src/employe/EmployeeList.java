package employe;

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

    public void calculateDeductions() {
        for (Employee employee : employeeList) {
            employee.calculateDeductions();
        }
    }
    @Override
    public String toString() {
        String s = "List : \n";
        for (Employee employee : employeeList) {
            s += employee.toString() + "\n";
        }
        return s;
    }
}
