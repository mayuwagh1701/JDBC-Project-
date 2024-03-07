package com.jbk;
import com.jbk.preparestatement.*;
import java.util.Scanner;


public class TestOperationPr {
	
	
	public static void main(String[] args) {
		PreparedOperation1 po = new PreparedOperation1();
		
		char c;
		Scanner sc = new Scanner(System.in);
		
		
		do {
		System.out.println("Press 1 for INSERT Data:");
		System.out.println("Press 2 for SHOW Data:");
		System.out.println("Press 3 for UPDATE Data:");
		System.out.println("Press 4 for DELETE Data:");
		int choice = sc.nextInt();
		
		
		switch (choice) {
		case 1: {
			po.insertData();
			break;
		}

		case 2: {
			po.showData();
			break;
		}

		case 3: {
			po.updateData();
			break;
		}
		case 4: {
			po.deleteData();
			break;
		}
		default:
			break;

		}
		System.out.println("Do you want to continue? y/n");
		 c= sc.next().charAt(0);
		
	}while(c =='y' || c == 'Y');

}
}
