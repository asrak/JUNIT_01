package daten;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Student extends Person implements Comparable<Student> {

	public Student(String firstName, String lastName) {
		this(firstName, lastName, false);
	}

	public Student(String firstName, String lastName, boolean selfEntitled) {
		super(firstName, lastName);
		setSelfEntitled(selfEntitled);
	}

	public Student(String firstName, String lastName, boolean selfEntitled,
			Date birthDate) {
		super(firstName, lastName);
		setSelfEntitled(selfEntitled);
		this.birthDate = birthDate;
	}

	private boolean selfEntitled;
	private Date birthDate; // TODO add getter,setter,Constructors

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isSelfEntitled() {
		return selfEntitled;
	}

	public void setSelfEntitled(boolean selfEntitled) {
		this.selfEntitled = selfEntitled;
	}

	@Override
	public int compareTo(Student o) {
		int result = 0;

		// TODO implement meaningful unit tests
		if ((result = getLastName().compareTo(o.getLastName())) == 0) {
			if ((result = getFirstName().compareTo(o.getFirstName())) == 0) {
				result = birthDate.compareTo(o.getBirthDate()); // TODO change to
															// getter after
															// implementation
			}
		}
		return result;
	}
	
	public ArrayList<Student> sortByBirthDate(ArrayList<Student> students) {
		Collections.sort(students, new Comparator<Student>(){
			public int compare(Student s1, Student s2) {
				return s1.getBirthDate().compareTo(s2.getBirthDate());
			}
		});
		
		return students;
	}

	@Override
	public String toString() {
		String s = super.toString();
		return s.substring(0, s.length()-1) + ", birthDate=" + getBirthDate().getYear() + "-"+ getBirthDate().getMonth() + "-" + getBirthDate().getDate() + "}";
	}
}
