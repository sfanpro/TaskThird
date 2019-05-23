package ua.com.fan.salarycalc;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import ua.com.fan.salarycalc.employees.Developer;
import ua.com.fan.salarycalc.employees.Employee;
import ua.com.fan.salarycalc.employees.Manager;
import ua.com.fan.salarycalc.service.Accountant;

public class AccountantTest {

	@Test
	public void testGetSalary() {

		Accountant acc = new Accountant();
		Employee developer = new Developer(1, 3000, 160, 320, "developer");
		Manager manager = new Manager(2, 4000, 160, 320, "manager");

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(developer);
		employees.add(manager);

		Map<Employee, Double> expected = new Hashtable<Employee, Double>();
		expected.put(developer, 6000.0);
		expected.put(manager, 4000.0);

		Map<Employee, Double> actual = acc.getSalary(employees);

		Assert.assertEquals(expected, actual);
	}

}
