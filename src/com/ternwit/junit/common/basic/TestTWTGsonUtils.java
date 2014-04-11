package com.ternwit.junit.common.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.ternwit.common.basic.TWTGsonUtils;
import com.ternwit.common.file.TWTFileUtils;
/*
 * Audit Log
 * 2013-01-31 new created full test passed 
 * */
public class TestTWTGsonUtils {

	@Test
	public void testGetInstance() {
		Person person = new Person();
		person.setId(10010);
		person.setDOB(new Date());
		PersonName personName = new PersonName();
		personName.setId(100);
		personName.setName("Jim");
		person.setPersonName(personName);
		Hobby hob1 = new Hobby();
		hob1.setId(1);
		hob1.setHobby("Sleep");
		Hobby hob2 = new Hobby();
		hob2.setId(2);
		hob2.setHobby("Eat");
		Hobby hob3 = new Hobby();
		hob3.setId(3);
		hob3.setHobby("Play");
		List<Hobby> list = new ArrayList<Hobby>();
		list.add(hob1);
		list.add(hob2);
		list.add(hob3);
		person.setHobbies(list);
		System.out.println(TWTGsonUtils.getInstance(false).toJson(person));
	}
	
	@Test
	public void testFromJson() {
		String path = "person.json";
		String content = new TWTFileUtils().readFileToString(path);
		Person p = (Person)TWTGsonUtils.fromJson(content, Person.class);
		System.out.println(p.getPersonName().getName());
		System.out.println(p.getDOB());
	}
	
	class Person {
		private int id;
		private PersonName personName;
		private Date DOB;
		private List<Hobby> hobbies;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public PersonName getPersonName() {
			return personName;
		}
		public void setPersonName(PersonName personName) {
			this.personName = personName;
		}
		public Date getDOB() {
			return DOB;
		}
		public void setDOB(Date dOB) {
			DOB = dOB;
		}
		public List<Hobby> getHobbies() {
			return hobbies;
		}
		public void setHobbies(List<Hobby> hobbies) {
			this.hobbies = hobbies;
		}
	}
	
	class PersonName {
		private int id;
		private String name;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	
	class Hobby {
		private int id;
		private String hobby;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getHobby() {
			return hobby;
		}
		public void setHobby(String hobby) {
			this.hobby = hobby;
		}
	}

}
