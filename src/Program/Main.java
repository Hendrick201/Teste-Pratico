package Program;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import Program.entities.Employee;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.of("pt", "BR"));
		List<Employee> industryEmployeeList = new ArrayList<Employee>();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	}
	//Print employee grouped by function
	private static void printEmployeeGroupByFunction(Map<String, List<Employee>> employeeMap) {
		employeeMap.forEach((function, employees) -> {
			System.out.println("=== " + function + " ===");
			employees.forEach(System.out::println);
			System.out.println();
		});
	}

	// Get employee List by birthMonth
	private static List<Employee> getByBirthMonth(List<Employee> employeeList, Integer... birthMonth) {
		List<Integer> months = Arrays.asList(birthMonth);
		return employeeList.stream().filter(p -> months.contains(p.getBirthDate().getMonthValue()))
				.collect(Collectors.toList());
	}

	// Get employee list in alphabetical order
	private static List<Employee> getByAlphabeticalOrder(List<Employee> employeeList) {
		return employeeList.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
	}
}
