package ua.com.fan.salarycalc.driver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ua.com.fan.salarycalc.employees.Developer;
import ua.com.fan.salarycalc.employees.Employee;
import ua.com.fan.salarycalc.employees.Manager;

public class JsonDriver {
	/*
	 * method to read list of employees from .json file
	 */
	public static void readEmployees(String path) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			// JSON file to Java object
			EmployeePojo[] staff = mapper.readValue(new File(path), EmployeePojo[].class);

			String jsonString = mapper.writeValueAsString(staff);

			// retrieve elements
			JsonNode rootNode = mapper.readTree(jsonString);
			JsonNode idNode = rootNode.path("id");
			JsonNode rateNode = rootNode.path("rate");
			JsonNode hoursInMounthNode = rootNode.path("hoursInMounth");
			JsonNode workedHourNode = rootNode.path("workedHour");
			JsonNode positionNode = rootNode.path("position");

			// Create List of employees
			List<Employee> employees = new ArrayList<Employee>();

			// fill out a List of employees
			if (positionNode.textValue() == "developer") {
				employees
						.add(new Developer(idNode.intValue(), rateNode.doubleValue(), hoursInMounthNode.doubleValue(),
								workedHourNode.doubleValue(), positionNode.textValue()));
			} else {
				employees
						.add(new Manager(idNode.intValue(), rateNode.doubleValue(), hoursInMounthNode.doubleValue(),
								workedHourNode.doubleValue(), positionNode.textValue()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * method to write list of employees to .json file
	 */
	public static void writeEmployees(List<Employee> employees) {
		ObjectMapper mapper = new ObjectMapper();

		String empJsonString;
		try {
			empJsonString = mapper.writeValueAsString(employees);

			try (FileWriter file = new FileWriter(
					"C:\\eclipse-workspace\\TaskThird\\src\\main\\resources\\employees.json")) {
				file.write(empJsonString.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(empJsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Employee developer = new Developer(1, 3000, 150, 300, "developer");
		Employee manager = new Manager(2, 4000, 200, 200, "manager");

		List<Employee> employees = new ArrayList<>();
		employees.add(developer);
		employees.add(manager);

		writeEmployees(employees);

		readEmployees("C:\\eclipse-workspace\\TaskThird\\src\\main\\resources\\employees.json");

	}
}