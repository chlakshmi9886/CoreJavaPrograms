package com.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class MaxSalaryExample {

	public static void main(String[] args) {
		ArrayList<Employee> listemp = new ArrayList<>();
		listemp.add(new Employee(100,"raja","M",40,"Testing",2010,75000.0d));
		listemp.add(new Employee(200,"roji","F",45,"Dev",2010,65000.0d));
		listemp.add(new Employee(600,"suji","F",42,"Dev",2010,35000.0d));
		listemp.add(new Employee(600,"suji","F",42,"Dev",2010,35000.0d));
		listemp.add(new Employee(700,"baji","M",41,"Manager",2010,65000.0d));
		listemp.add(new Employee(400,"raji","F",40,"QA",2010,95000.0d));
		listemp.add(new Employee(500,"raji","F",40,"QA",2010,95000.0d));
		listemp.add(new Employee(300,"krish","M",48,"QA",2010,85000.0d));
		listemp.add(new Employee(800,"venu","M",47,"QA",2010,25000.0d));
		listemp.add(new Employee(800,"venu","M",47,"QA",2010,25000.0d));
		
		Optional<Employee> emp = listemp.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println("max salary employee :: " + emp.get().getSalary());
		
		List<Employee> sortedlist = listemp.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());
		System.out.println("second highest salary :: " + sortedlist.get(1).getSalary());
		
		Optional<Employee> empminsal = listemp.stream().collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println("min salary :: " + empminsal.get().getSalary());

		List<Employee> empsecminsal = listemp.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).collect(Collectors.toList());
		System.out.println("second min salary :: " + empsecminsal.get(1).getSalary());
		
		List<Double> salary = listemp.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).map(Employee::getSalary).distinct().collect(Collectors.toList());
		System.out.println("second max --- salary :: " + salary.get(1));
		
		
		List<Double> minsalary = listemp.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).map(Employee::getSalary).distinct().collect(Collectors.toList());
		System.out.println("second min -dd-- salary :: " + minsalary.get(1));
		
		//find how many employees are present in QA team?
		long qaEmpCount = listemp.stream().filter(Emp->Emp.getDepartment().equalsIgnoreCase("QA")).count();
		System.out.println("Total employee count : "+ listemp.size()+"  QA department employee cound :: " + qaEmpCount);
		//sort employees by employee name
		List<String> nameslist = listemp.stream().sorted((emp1,emp2)->emp1.getEmpname().compareTo(emp2.getEmpname())>0?-1:1).map(Employee::getEmpname).collect(Collectors.toList());
		System.out.println("descending order :: " + nameslist);
		
		List<String> nameslistasc = listemp.stream().sorted((emp1,emp2)->emp1.getEmpname().compareTo(emp2.getEmpname())>0?1:-1).map(Employee::getEmpname).collect(Collectors.toList());
		System.out.println("ascending order :: " + nameslistasc);
	
	}
}

class Employee{
	private Integer empid;
	private String empname;
	private String gender;
	private Integer age;
	private String department;
	private int yearofjoining;
	private double salary;
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getYearofjoining() {
		return yearofjoining;
	}
	public void setYearofjoining(int yearofjoining) {
		this.yearofjoining = yearofjoining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", gender=" + gender + ", age=" + age
				+ ", department=" + department + ", yearofjoining=" + yearofjoining + ", salary=" + salary + "]";
	}
	public Employee(Integer empid, String empname, String gender, Integer age, String department, int yearofjoining,
			double salary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.gender = gender;
		this.age = age;
		this.department = department;
		this.yearofjoining = yearofjoining;
		this.salary = salary;
	}
	
	
}
