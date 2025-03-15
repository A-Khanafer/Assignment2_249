package payrollmanager;

import employe.Employee;
import employe.EmployeeList;
import exception.MinimumWageException;

import java.io.*;
import java.util.Scanner;

public class FileManager {

    private String fileName;


    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public void getEmployees(EmployeeList employees){
        Scanner scanner;
        PrintWriter errorWriter;
        try{
            scanner = new Scanner(new FileInputStream(this.fileName));
            errorWriter = new PrintWriter(new FileOutputStream("error.txt"));

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
                    errorWriter.println(tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4] + " // Number Format Exception.");
                }catch (MinimumWageException e) {
                    errorWriter.println(tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4] + " // Minimum Wage Exception.");
                }
            }
            scanner.close();
            errorWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
