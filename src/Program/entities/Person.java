package Program.entities;

import java.time.LocalDate;

public abstract class Person {
	private String name;
	private LocalDate birthDate;
	private Integer age;
	
	public Person()
	{
		
	}
	public Person(String name, LocalDate birthDate) {
		this.name = name;
		this.birthDate = birthDate;
		setAge();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge() {
		this.age = LocalDate.now().compareTo(birthDate);
	}
	@Override
	public abstract String toString();
	
	
	
}
