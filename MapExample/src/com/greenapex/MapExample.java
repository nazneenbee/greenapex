package com.greenapex;

import java.util.*;

class Student
{
int rollno;
String name;
String branch;
double fee;
public Student(int rollno, String name, String branch, double fee) {
	this.rollno = rollno;
	this.name = name;
	this.branch = branch;
	this.fee = fee;
}
public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public double getFee() {
	return fee;
}
public void setFee(double fee) {
	this.fee = fee;
}
}
public class MapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(1, "ram");
		map.put(2, "naaz");
		map.put(3, "raj");
		map.putIfAbsent(4, "ratan");
		map.put(5, "ayan");
		Map<Integer,String> map1=new HashMap<Integer,String>();
		map1.put(6, "ram");
		map1.put(7, "syam");
		map1.put(8, "raj");
		map.putAll(map1);
		//map.remove(2, "syam");
		//map.remove(2);
//		map.containsValue("raj");
//		map.forEach((k,v)->System.out.println(k+" "+v));
		//map.replace(1, "ram","ravi");
		//map.compute(2, (k,v)->(v=="syam")?"abc":v);
		
		 map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);  
	*/
		
		Student s1=new Student(1, "naaz", "IT", 50000);
		Student s2=new Student(2, "ravi", "CS", 60000);
		Student s3=new Student(3, "Utkarsha", "ec", 50000);
		Student s4=new Student(4, "udit", "IT", 60000);
		Map<Integer,Student> map=new HashMap<Integer,Student>();
		map.put(1, s1);
		map.put(2, s2);
		map.put(3, s3);
		map.put(4, s4);
		
		//map.forEach((k,v)->System.out.println(k+" "+v.getRollno()+" "+v.getName()+" "+v.getBranch()+" "+v.getFee()));
		
		for(Map.Entry<Integer, Student> data:map.entrySet()) {
		 System.out.println(data.getKey()+" "+data.getValue().rollno+" "+data.getValue
		 ().name+" "+data.getValue().branch+" "+data.getValue().fee); }
		
	}

}
