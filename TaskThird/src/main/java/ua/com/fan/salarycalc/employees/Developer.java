package ua.com.fan.salarycalc.employees;

public class Developer extends Employee {

	public Developer(int id, double rate, double hoursInMounth, double workedHour, String position) {
		super(id, rate, hoursInMounth, workedHour, position);
	}

	@Override
	public double calculateSalary() {
		double salary = super.getRate() * super.getWorkedPercent();
		return salary;
	}
}
