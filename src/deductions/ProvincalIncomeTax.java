package deductions;

import employe.Employee;

public class ProvincalIncomeTax extends Deductions {

    @Override
    public void calculateTax(Employee emp) {
        double deduction;
        if (emp.getAnnualGrossSalary() > 18571 && emp.getAnnualGrossSalary() <= 53255) {
            deduction = emp.getAnnualGrossSalary() * 0.14;
            emp.setDeductions(emp.getDeductions() + deduction);
        } else if (emp.getAnnualGrossSalary() > 53255 && emp.getAnnualGrossSalary() <= 106495) {
            deduction = emp.getAnnualGrossSalary() * 0.19;
            emp.setDeductions(emp.getDeductions() + deduction);
        } else if (emp.getAnnualGrossSalary() > 106495 && emp.getAnnualGrossSalary() <= 129590) {
            deduction = emp.getAnnualGrossSalary() * 0.24;
            emp.setDeductions(emp.getDeductions() + deduction);
        } else if (emp.getAnnualGrossSalary() > 129590) {
            deduction = emp.getAnnualGrossSalary() * 0.2575;
            emp.setDeductions(emp.getDeductions() + deduction);
        }
        System.out.println("Deductions provincal: " + emp.getDeductions());
    }
}
