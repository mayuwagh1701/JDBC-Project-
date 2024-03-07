package com.jbk;

import java.util.Scanner;

import com.jbk.statements.StatementOperations;

public class TestOperationSt {

	public static void main(String[] args) {

		StatementOperations so = new StatementOperations();
		char c;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Press 1 for INSERT Data:");
			System.out.println("Press 2 for SHOW Data:");
			System.out.println("Press 3 for UPDATE Data:");
			System.out.println("Press 4 for DELETE Data:");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:{
				so.insertData();
				break;
				
			}
			case 2:{
				so.showData();
				break;
			}
			case 3:{
				so.deleteDate();
			}

			case 4:{
				so
			}
			default:
				break;
			}
		}
		
		

		

		
	

}
}
