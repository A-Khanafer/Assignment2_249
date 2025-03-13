package payrollmanager;

import employe.Employee;
import employe.EmployeeList;
import exception.MinimumWageException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PayrollReader {

    private Scanner scanner;
    private String fileName;


    public PayrollReader(String fileName) {
        this.fileName = fileName;
        try{
            scanner = new Scanner(new FileInputStream(this.fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void getEmployees(EmployeeList employees){
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split(" ");
            try {
                employees.add(new Employee(Long.parseLong(tokens[0]),//ID
                                            tokens[1],// Name
                                            tokens[2],//Surname
                                            Double.parseDouble(tokens[3]),//Hours Worked
                                            Double.parseDouble(tokens[4])));//Wage

            }catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }catch (MinimumWageException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
