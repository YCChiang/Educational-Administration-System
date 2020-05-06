package test;
import dao.impl.*;
import entity.ClassGrade;
public class insertgrade {
	public static void main(String [] args) {
		ClassGrade grade = new ClassGrade("2017011315","002",99,1);
		classgradeDaoimpl c1 = new classgradeDaoimpl();
		if(c1.insert(grade) == 1){
			
		}
		else {
			System.out.println("error");
		}
	}
}
