package test;
import dao.impl.*;
public class insertgrade {
	public static void main(String [] args) {
		classgradeDaoimpl c1 = new classgradeDaoimpl();
		if(c1.Enterresults("2017011315","002",99,1)){
			
		}
		else {
			System.out.println("error");
		}
	}
}
