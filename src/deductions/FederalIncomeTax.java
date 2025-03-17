package deductions;

import employe.Employee;

public class FederalIncomeTax extends Deductions{
    @Override
    public void calculateTax(Employee emp) {
        double deduction;
        if (emp.getAnnualGrossSalary() > 16129 && emp.getAnnualGrossSalary() <= 57375) {
            deduction = emp.getAnnualGrossSalary() * 0.15;
            emp.setDeductions(emp.getDeductions() + deduction);
        } else if (emp.getAnnualGrossSalary() > 57376 && emp.getAnnualGrossSalary() <= 114750) {
            deduction = emp.getAnnualGrossSalary() * 0.205;
            emp.setDeductions(emp.getDeductions() + deduction);
        } else if (emp.getAnnualGrossSalary() > 114751 && emp.getAnnualGrossSalary() <= 177882) {
            deduction = emp.getAnnualGrossSalary() * 0.26;
            emp.setDeductions(emp.getDeductions() + deduction);
        } else if (emp.getAnnualGrossSalary() > 177883 && emp.getAnnualGrossSalary() <= 253414) {
            deduction = emp.getAnnualGrossSalary() * 0.29;
            emp.setDeductions(emp.getDeductions() + deduction);
        } else if (emp.getAnnualGrossSalary() > 253414) {
            deduction = emp.getAnnualGrossSalary() * 0.33;
            emp.setDeductions(emp.getDeductions() + deduction);
        }
        System.out.println("Deductions federal: " + emp.getDeductions());
    }
}

