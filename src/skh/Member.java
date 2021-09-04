package skh;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {
	
	
	public void Display() {
		
		Scanner input = new Scanner(System.in);
		DBClass db = new DBClass();
		String id,name,major;
		int age;
		System.out.println("1.회원 목록 2.회원 추가 3.회원 수정 4.회원 삭제 5.종료");
		int num = input.nextInt();
		ArrayList<Student> arr = new ArrayList<Student>();
		switch(num) {
		
		case 1 : 
			arr = db.MemberView();
			
			for(int i=0; i<arr.size();i++) {
				System.out.println("나이 : "+arr.get(i).getAge());
				System.out.println("아이디 : "+arr.get(i).getId());
				System.out.println("전공 : "+arr.get(i).getMajor());
				System.out.println("이름 : "+arr.get(i).getName());
				System.out.println("----------------------------");
			}
			
			break;
		case 2 : 
			System.out.println("아이디를 입력하세요 : ");
			id = input.next();
			System.out.println("이름을 입력하세요 : ");
			name = input.next();
			System.out.println("나이를 입력하세요 : ");
			age = input.nextInt();
			System.out.println("전공을 입력하세요 : ");
			major = input.next();
			
			int result = db.MemberAdd(id, name, age, major);
			
			if(result == 1) {
				
				System.out.println("저장이 완료되었습니다.");
			} else {
				
				System.out.println("저장에 실패했습니다.");
			}
			break;
		case 3 : 
			System.out.println("수정할 아이디를 입력하세요");
			id = input.next();
			System.out.println("이름을 입력하세요");
			name = input.next();
			System.out.println("나이를 입력하세요");
			age = input.nextInt();
			System.out.println("전공을 입력하세요");
			major = input.next();
			
			result = db.Rename(name, age, major, id);
			
			if(result == 1) {
				System.out.println("수정이 완료되었습니다.");
			} else {
				System.out.println("수정에 실패하였습니다.");
			}
			break;
		case 4 : 
			System.out.println("삭제 할 아이디를 입력하세요");
			id = input.next();
			result = db.Delete(id);
			
			if(result == 1) {
				System.out.println("삭제하였습니다.");
			}else {
				System.out.println("삭제에 실패했습니다.");
			}
			
			break;
		case 5 : 
			
			System.out.println("종료합니다.");
			break;
		
		
		
		}
		
		
	}
	

}
