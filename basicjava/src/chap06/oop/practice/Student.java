package chap06.oop.practice;

public class Student {

	public static void main(String args[]) {
		Student stu = new Student("장동건", "jspprogram", 500000);
		stu.calcReturnFee();
		stu.print();
	}
}
