package deductions;

import employe.Employee;

public class QuebecParentalInsurancePlan extends Deductions{

    @Override
    public void calculateTax(Employee emp) {
        double deduction;
        deduction = emp.getAnnualGrossSalary() * 0.00494;
        emp.setDeductions( emp.getDeductions() + Math.min(deduction, 484.12));
        System.out.println("Deductions parent: " + emp.getDeductions());
    }
}

