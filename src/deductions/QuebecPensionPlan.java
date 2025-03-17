package deductions;

import employe.Employee;

public class QuebecPensionPlan extends Deductions{

    @Override
    public void calculateTax(Employee emp) {
        double deduction;
        deduction = emp.getAnnualGrossSalary() * 0.108;
        emp.setDeductions( emp.getDeductions() + Math.min(deduction, 7700.40));
        System.out.println("Deductions pension: " + emp.getDeductions());
    }
}

