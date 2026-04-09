package Program;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import Program.entities.Employee;
import Program.entities.IndustryEmployee;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.of("pt", "BR"));
		List<Employee> industryEmployeeList = new ArrayList<Employee>();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		addIndustryEmployee("Maria", LocalDate.parse("18/10/2000", dateTimeFormatter), new BigDecimal("2009.440"),
				"Operador", industryEmployeeList);
		addIndustryEmployee("João", LocalDate.parse("12/05/1990", dateTimeFormatter), new BigDecimal("2284.380"),
				"Operador", industryEmployeeList);
		addIndustryEmployee("Caio", LocalDate.parse("02/05/1961", dateTimeFormatter), new BigDecimal("9836.140"),
				"Coordenador", industryEmployeeList);
		addIndustryEmployee("Miguel", LocalDate.parse("14/10/1988", dateTimeFormatter), new BigDecimal("19119.880"),
				"Diretor", industryEmployeeList);
		addIndustryEmployee("Alice", LocalDate.parse("05/01/1995", dateTimeFormatter), new BigDecimal("2234.680"),
				"Recepcionista", industryEmployeeList);
		addIndustryEmployee("Heitor", LocalDate.parse("19/11/1999", dateTimeFormatter), new BigDecimal("1582.720"),
				"Operador", industryEmployeeList);
		addIndustryEmployee("Arthur", LocalDate.parse("31/03/1993", dateTimeFormatter), new BigDecimal("4071.840"),
				"Contador", industryEmployeeList);
		addIndustryEmployee("Laura", LocalDate.parse("08/07/1994", dateTimeFormatter), new BigDecimal("3017.450"),
				"Gerente", industryEmployeeList);
		addIndustryEmployee("Heloísa", LocalDate.parse("24/05/2003", dateTimeFormatter), new BigDecimal("1606.850"),
				"Eletricista", industryEmployeeList);
		addIndustryEmployee("Helena", LocalDate.parse("02/09/1996", dateTimeFormatter), new BigDecimal("2799.93"),
				"Gerente", industryEmployeeList);

		// remove João
		removeEmployeeByName("João", industryEmployeeList);

		// Increase salary - 10%
		raiseEmployeeSalaryPercentage(new BigDecimal("10"), industryEmployeeList);

		// Group by function
		Map<String, List<Employee>> employeeMap = groupByFunction(industryEmployeeList);

		// Print employee grouped by function
		groupByFunction(industryEmployeeList).forEach((function, employees) -> {
			System.out.println("=== " + function + " ===");
			employees.forEach(System.out::println);
			System.out.println();
		});
		
		// Print employee by birth month
		System.out.println("=== Employees by birth month ===");
		for(Employee employee : getByBirthMonth(industryEmployeeList,10,12))
		{
			System.out.println(employee);
		}
		System.out.println("==============");
		System.out.println();
		
		//Print employee list in alphabetical order
		System.out.println("=== Employees in alphabetical order ===");
		for(Employee employee : getByAlphabeticalOrder(industryEmployeeList))
		{
			System.out.println(employee);
		}
		System.out.println("==============");

	}

	// Add a Industry Employee
	private static void addIndustryEmployee(String name, LocalDate birthDate, BigDecimal salary, String function,
			List<Employee> industryEmployeeList) {
		industryEmployeeList.add(new IndustryEmployee(name, birthDate, salary, function));
	}

	// Remove a Employee
	private static void removeEmployeeByName(String name, List<Employee> employeeList) {
		employeeList.removeIf(p -> p.getName().equals("João"));
	}

	// Raise Employee salary%
	private static void raiseEmployeeSalaryPercentage(BigDecimal percentage, List<Employee> listEmployee) {
		for (Employee emp : listEmployee) {
			emp.applyRaise(percentage);
		}
	}

	// Group by function using Map
	private static Map<String, List<Employee>> groupByFunction(List<Employee> employeeList) {
		return employeeList.stream().collect(Collectors.groupingBy(Employee::getFunction));
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
