package main;

import java.util.Scanner;
import skh.DBClass;
import skh.Member;
import seoon.seoon_function;
import juyeong.Jy;


public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Member mb = new Member();

		seoon_function sf = new seoon_function();
		Jy jy = new Jy();
		
		int num;
		while(true) {
			System.out.println("1.이주영님 2.성기룡님 3.설지희님 \n"
					+ "4.서광훈님 5.송영관님 6.이진원님 7.종료");
			num=input.nextInt();
			switch(num) {
			case 1:	jy.display();	break;
			case 2:	sf.seoon_function();	break;
			case 3:break;
			case 4:
				mb.Display();
				break;
			case 5:break;
			case 6:
				break;
			case 7: System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			}
		}
	}
}