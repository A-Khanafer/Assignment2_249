package employe;

import deductions.*;
import exception.MinimumWageException;

public class Employee {


    private long id;
    private String name;
    private String surname;
    private double wage;
    private double hoursWorked;
    private double annualGrossSalary;
    private double deductions;
    private Deductions[] deductionsCalculator = {new ProvincalIncomeTax(),
                                                 new FederalIncomeTax(),
                                                 new QuebecPensionPlan(),
                                                 new EmploymentInsurance(),
                                                 new QuebecParentalInsurancePlan()};

    public Employee(long id, String name, String surname, double hoursWorked, double wage) throws MinimumWageException {
        if(wage < 15.75)
            throw new MinimumWageException();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.wage = wage;
        this.hoursWorked = hoursWorked;
        this.annualGrossSalary = wage * hoursWorked*52.0;
        calculateDeductions();
    }

    public Employee() {
        id = 0;
        name = "";
        surname = "";
        wage = 0;
        hoursWorked = 0;
        annualGrossSalary = 0;
        deductions = 0;
    }

    public Employee(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.surname = employee.surname;
        this.wage = employee.wage;
        this.hoursWorked = employee.hoursWorked;
        this.annualGrossSalary = employee.annualGrossSalary;
        this.deductions = employee.deductions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getAnnualGrossSalary() {
        return annualGrossSalary;
    }

    public void setAnnualGrossSalary(double annualGrossSalary) {
        this.annualGrossSalary = annualGrossSalary;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    private void calculateDeductions() {
        for (Deductions deduction : deductionsCalculator) {
            deduction.calculateTax(this);
        }
        System.out.println("This is The Deductions : " + deductions );
    }
    @Override
    public String toString() {
        return String.format("%-20s %-20s %-20s %20.2f %20.2f %20.2f",
                this.id, this.name, this.surname, this.annualGrossSalary, this.deductions, (annualGrossSalary-deductions));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                wage == employee.wage &&
                hoursWorked == employee.hoursWorked &&
                annualGrossSalary == employee.annualGrossSalary &&
                name.equals(employee.name) &&
                surname.equals(employee.surname);
    }

}
