package Program.entities;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class IndustryEmployee extends Employee {
	
	public IndustryEmployee(String name, LocalDate birthDate, BigDecimal salary, String function) {
	    super(name, birthDate, salary, function);
	}

	// Reserved for salary calculation business rules (e.g. bonuses, deductions, regional tax)
	@Override
	public BigDecimal calculateSalary(BigDecimal currentBaseSalary) 
	{
		
		return currentBaseSalary;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.of("pt", "BR"));
		
		stringBuilder.append("Name: " + super.getName() + "\n");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		stringBuilder.append("Birth Date: " + dateTimeFormatter.format(super.getBirthDate()) + "\n");
		stringBuilder.append("Age: " + super.getAge() + "\n");
		stringBuilder.append("Function: " + super.getFunction() + "\n");
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		stringBuilder.append("Salary:  "  + nf.format(getSalary()) + "\n");
		
		return stringBuilder.toString();
		
	}

}
