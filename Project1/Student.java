package Project1;

public class Student {
	private String studentID;
	private String name;
	private int quiz1;
	private int quiz2;
	private int midterm;
	private int finalexam;
	private double avg;
	private String grade;

	public Student() {
		// TODO initialize all the private data members (id="na", n="na", quiz1=0,
		// quiz2=0,
		// midterm=0, finalexam=0, avg=0.0, grade="na")
		// Here is an example
		this("na", "na", 0, 0, 0, 0, 0.0, "na");
	}

	public Student(String id, String n, int q1, int q2, int m, int f) {
		// TODO initialize all the private data members with the given arguments, while
		// the grade is "na"

		// Here is an example
		this(id, n, q1, q2, m, f, 0.0, "na");

	}

	public Student(String id, String n, int q1, int q2, int m, int f, double a, String letterGrade) {
		// TODO initialize all the private data members with the given arguments

		// Here is an example
		studentID = id;
		name = n;
		quiz1 = q1;
		quiz2 = q2;
		midterm = m;
		finalexam = f;
		avg = a;
		grade = letterGrade;

	}

	public void set(String id, String n, int q1, int q2, int m, int f, double a, String g) {
		// TODO set all the private data members with the given arguments

	}

	public void calcAvg() {
		avg = quiz1 * 1.25 + quiz2 * 1.25 + midterm * 0.25 + finalexam * .50;

	}

	public void calcGrade() {
		// TODO Calculate the letter grade (A, B, C, D and F) based on the student's
		// average grade (avg)
		/**
		 * Any grades of 90 or more is an A, any grades of 80 or more (but less than 90)
		 * is a B, any grades of 70 or more (but less than 80) is a C, any grades of 60
		 * or more (but less than 70) is a D, and any grades below 60 is an F.
		 */

		if (avg >= 90.0) {
			this.grade = "A";
		} else if (avg >= 80.0) {
			this.grade = "B";
		} else if (avg >= 70.0) {
			this.grade = "C";
		} else if (avg >= 60.0) {
			this.grade = "D";
		} else
			this.grade = "F";
	}

	public String getID() {
		// TODO return studentID
		// Here is an example
		return studentID;
	}

	public String getName() {
		// TODO return name
		return name;
	}

	public int getQuiz1() {
		// TODO return quiz1
		return quiz1;
	}

	public int getQuiz2() {
		// TODO return quiz2
		return quiz2;
	}

	public int getMidterm() {
		// TODO return midterm
		return midterm;
	}

	public int getFinalexam() {
		// TODO return finalexam
		return finalexam;
	}

	public double getAvg() {
		// TODO calculate the average grade and return the calculated value (avg)
		this.calcAvg();
		return avg;
	}

	public String getGrade() {
		// TODO calculate the letter grade and return the calculated value (grade)
		this.calcGrade();
		return grade;
	}

}
