package Program;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import Program.entities.Employee;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.of("pt", "BR"));
		List<Employee> industryEmployeeList = new ArrayList<Employee>();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		
		
	}
	private static void printEmployeeGroupByFunction(Map<String, List<Employee>> employeeMap) {
	    employeeMap.forEach((function, employees) -> {
	        System.out.println("=== " + function + " ===");
	        employees.forEach(System.out::println);
	        System.out.println();
	    });
	}
	
	private static void printByBirthMonth(List<Employee> employeeList, Integer... birthMonth) {
	    List<Integer> months = Arrays.asList(birthMonth);
	    employeeList.stream()
	        .filter(p -> months.contains(p.getBirthDate().getMonthValue()))
	        .forEach(System.out::println);
	}
	
	private static void printByAlphabeticalOrder(List<Employee> employeeList)
	{
		employeeList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
	}
}
