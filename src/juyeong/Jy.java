package juyeong;

import java.util.Scanner;

public class Jy {
	public void display() {
		Scanner input = new Scanner(System.in);
		int num, age, result=0;
		String id,name,major;
		
		DBClass db = new DBClass();
		while(true) {
			System.out.println("회원 관리 프로그램 입니다.");
			System.out.println("1.등록 2.검색 3.전체보기 \n4.수정 5.삭제 6.나가기");
			System.out.print(">>>");
			num=input.nextInt();
			switch(num) {
			case 1:
				System.out.println("사용하실 id를 입력해주세요: ");
				id = input.next();
				System.out.println("이름을 입력해주세요: ");
				name = input.next();
				System.out.println("나이를 입력해주세요: ");
				age=input.nextInt();
				System.out.println("전공을 입력해주세요: ");
				major=input.next();
				result=db.saveData(id, name, age, major);
				if(result == 1) {
					System.out.println("저장이 완료되었습니다.");
				}else {
					System.out.println("이미 가입된 id 입니다.");
				}
				
				
				break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6:
				System.out.println("이용해 주셔서 감사합니다\n");
				return;
			default: System.out.println("※ 1~6번만 입력해주세요 ※");
			break;
			}
		}
	}
}
