package deductions;

import employe.Employee;

public class EmploymentInsurance extends Deductions{

    @Override
    public void calculateTax(Employee emp) {
        double deduction;
        deduction = emp.getAnnualGrossSalary() * 0.0164;
        emp.setDeductions( emp.getDeductions() + Math.min(deduction, 1077.48));
        System.out.println("Deductions emplymentInsurance: " + emp.getDeductions());
    }
}

