package jihee;

import java.util.ArrayList;
import java.util.Scanner;

public class Ji_Member {
		Ji_DBClass db = new Ji_DBClass();
		ArrayList<Ji_StudentDTO> list = new ArrayList<>();

	public void play() {
		int num,age, result = 0;
		String id,name,major;
		
		
		Scanner sc = new Scanner(System.in);
		Ji_DBClass db = new Ji_DBClass();
		while(true) {
		System.out.println("**** 회원 정보 ****");
		System.out.println("1.목록보기 2.추가하기");
		System.out.println("3.검색하기 4.삭제하기");
		System.out.println("5.수정하기 6.종료하기");
		System.out.println("*****************");
		System.out.print(">>>");
		num = sc.nextInt();
		switch(num) {
		case 1: list = db.getList();
		for(int i=0; i<list.size(); i++) {
			System.out.println("id : " + list.get(i).getId());
			System.out.println("name : " + list.get(i).getName());
			System.out.println("major : " + list.get(i).getMajor());
			System.out.println("age : " + list.get(i).getAge());
			System.out.println("-------------------");
			
		}
		
		
		break;
		case 2: 
			System.out.println("***** 추가 ******");
			System.out.print("아이디 입력: ");
			id = sc.next();
			System.out.print("이름 입력: ");
			name = sc.next();
			System.out.print("전공 입력: ");
			major = sc.next();
			System.out.print("나이 입력: ");
			age = sc.nextInt();
			
			db.MemberAdd(id, name, major, age);
			
			break;
		case 3: 
			System.out.println("***** 검색 ******");
			System.out.print("아이디 입력 : ");
			id = sc.next();
			Ji_StudentDTO dt = db.searchST(id);
			System.out.println("id : " + dt.getId());
			System.out.println("name : " + dt.getName());
			System.out.println("major : " + dt.getMajor());
			System.out.println("age : " + dt.getAge());
			
			
			
			
			break;
		case 4:
			System.out.println("***** 삭제 ******");
			System.out.print("아이디 입력 : ");
			id = sc.next();
			result = db.Delete(id);
			if(result == 1) {
				System.out.println("삭제완료!!");
			}else {
				System.out.println("해당 아이디는 존재하지 않습니다.");
			}
			break;
		case 5:
			System.out.println("***** 수정 ******");
			System.out.print("아이디 입력 : ");
			id = sc.next();
			System.out.print("이름입력: ");
			name = sc.next();
			System.out.print("나이입력: ");
			age = sc.nextInt();
			System.out.print("전공입력: ");
			major = sc.next();
			result = db.Rename(name, age, major, id);
			
			if(result == 1) {
				System.out.println("수정 완료!!");
			} else {
				System.out.println("수정에 실패하였습니다.");
			}
			break;
		case 6:
			System.out.println("종료합니다.");
			System.exit(0);
		}
		
		}
	}
}
