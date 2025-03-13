package employe;

import exception.MinimumWageException;

import java.util.Objects;

public class Employee {


    private long id;
    private String name;
    private String surname;
    private double wage;
    private double hoursWorked;
    private double annualSalary;

    public Employee(long id, String name, String surname, double hoursWorked, double wage) throws MinimumWageException {
        if(wage < 15.75)
            throw new MinimumWageException();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.wage = wage;
        this.hoursWorked = hoursWorked;
        annualSalary = wage * hoursWorked*52.0;
    }

    public Employee() {
        id = 0;
        name = "";
        surname = "";
        wage = 0;
        hoursWorked = 0;
        annualSalary = 0;
    }

    public Employee(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.surname = employee.surname;
        this.wage = employee.wage;
        this.hoursWorked = employee.hoursWorked;
        this.annualSalary = employee.annualSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", wage=" + wage +
                ", annualSalary=" + annualSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                wage == employee.wage &&
                hoursWorked == employee.hoursWorked &&
                annualSalary == employee.annualSalary &&
                name.equals(employee.name) &&
                surname.equals(employee.surname);
    }

}
