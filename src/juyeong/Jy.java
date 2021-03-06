package juyeong;

import java.util.ArrayList;
import java.util.Scanner;

public class Jy {
	public void display() {
		Scanner input = new Scanner(System.in);
		int num, age, result=0;
		String id,name,major;
		ArrayList<StudentDTO> list = null;
		
		DBClass db = new DBClass();
		while(true) {
			System.out.println("\n----회원 관리 프로그램 입니다.----");
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
			case 2: 
				System.out.println("검색할 id 입력: ");
				id = input.next();
				StudentDTO dto = db.searchST(id);
				if(dto != null) {
					System.out.println("-----회원 정보-----");
					System.out.println("아이디 : "+dto.getId());
					System.out.println("이름 : "+dto.getName());
					System.out.println("나이 : "+dto.getAge());
					System.out.println("전공 : "+dto.getMajor());
				}else {
					System.out.println("해당 아이디는 존재하지 않습니다.");
				}
				break;
			case 3:
				list = db.getList();
				for(int i =0; i<list.size(); i++) {
					System.out.println("아이디 : "+list.get(i).getId() );
					System.out.println("이름  : "+list.get(i).getName());
					System.out.println("나이  : "+list.get(i).getAge());
					System.out.println("전공  : "+list.get(i).getMajor());
					System.out.println("--------------------------------");
				}
				break;
			case 4:
				System.out.println("아이디 입력: ");
				id = input.next();
				System.out.println("수정할 이름 입력: ");
				name = input.next();
				System.out.println("수정할 나이 입력: ");
				age = input.nextInt();
				System.out.println("수정할 전공 입력: ");
				major = input.next();
				result = db.update(id, name, age, major);
				if(result == 1) {
					System.out.println("수정이 완료되었습니다.");
				}else {
					System.out.println("해당 아이디는 존재하지 않습니다.");
				}
				break;
			case 5:
				System.out.println("삭제할 아이디 입력: ");
				id=input.next();
				result=db.delete(id);
				if(result==1) {
					System.out.println("삭제가 완료되었습니다.");
				}else {
					System.out.println("해당 아이디는 존재하지 않습니다.");
				}
				break;
			case 6:
				System.out.println("이용해 주셔서 감사합니다\n");
				return;
			default: System.out.println("※ 1~6번만 입력해주세요 ※");
			break;
			}
		}
	}
}
