package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import daten.Person;
import daten.Student;

public class StudentTest {
	private ArrayList<Student> s1, s2;

	@Before
	public void setUp() throws Exception {
		s1 = new ArrayList<Student>();
		s2 = new ArrayList<Student>();
		
		Student st1 = new Student("Mustafa", "Asrak", true, new Date(1994, 12, 8));
		Student st2 = new Student("Mustafa", "Asrak", true, new Date(1994, 12, 5));
		Student st3 = new Student("Mustafa", "Asrak", true, new Date(1991, 8, 8));
		Student st4 = new Student("Mustafa", "Asrak", true, new Date(1994, 11, 8));
		
		s1.add(st1);
		s1.add(st2);
		s1.add(st3);
		s1.add(st4);
		
		s2.add(st3);
		s2.add(st4);
		s2.add(st2);
		s2.add(st1);
	}
	
	@Test
	public void constructorWith4Arguments() {
		Student s = new Student("Mustafa", "Asrak", true, new Date(1994, 12, 8));
		assertEquals("Mustafa", s.getFirstName());
		assertEquals("Asrak", s.getLastName());
		assertEquals(true, s.isSelfEntitled());
		assertEquals(new Date(1994, 12, 8), s.getBirthDate());
	}
	
	@Test
	public void constructorWith3Arguments() {
		Student s = new Student("Mustafa", "Asrak", true);
		assertEquals("Mustafa", s.getFirstName());
		assertEquals("Asrak", s.getLastName());
		assertEquals(true, s.isSelfEntitled());
	}
	
	@Test
	public void constructorWith2Arguments() {
		Student s = new Student("Mustafa", "Asrak");
		assertEquals("Mustafa", s.getFirstName());
		assertEquals("Asrak", s.getLastName());
		assertEquals(false, s.isSelfEntitled());
	}
	
	@Test
	public void compareStudent() {
		Student s = new Student("Mustafa", "Asrak", true, new Date(1994, 12, 8));
		assertEquals(0, s.compareTo(new Student("Mustafa", "Asrak", true, new Date(1994, 12, 8))));
		
		s = new Student("Mustafa", "Asrak", true, new Date(1993, 12, 8));
		assertEquals(-1, s.compareTo(new Student("Mustafa", "Asrak", true, new Date(1994, 12, 8))));
		
		s = new Student("Mustafa", "Asrak", true, new Date(1995, 12, 8));
		assertEquals(1, s.compareTo(new Student("Mustafa", "Asrak", true, new Date(1994, 12, 8))));
	}
	
	@Test
	public void testToString() {
		Student s = new Student("Mustafa", "Asrak",  true, new Date(1994, 11, 8));
		assertEquals("Student {firstName=Mustafa, lastName=Asrak, birthDate=1994-11-8}", s.toString());
	}
	
	@Test
	public void testSortByBirthDate() {
		Student s = new Student("a", "a");
		assertEquals(s2, s.sortByBirthDate(s1));
	}
}
