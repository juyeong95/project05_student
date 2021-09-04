package jinwon;

import java.util.ArrayList;
import java.util.Scanner;


public class JW {
		public void display() {
	Scanner input = new Scanner(System.in);
	int num, age, result=0;
	String id,name,major;
	ArrayList<StudentDTO> list = null;
	DBClass db = new DBClass();
	while(true) {
		System.out.println("1.회원목록 2. 검색 3.추가 4. 수정 5.삭제");
		//("1.모든데이터보기 2. 검색 3.저장 4.삭제 5.수정") 수업시간 활용 
		
		num = input.nextInt();
		switch(num) {
		case 1:
		
			list = db.getList();
			for(int i=0; i<list.size() ; i++) {
				System.out.println("id : "+list.get(i).getId() );
				System.out.println("name : "+list.get(i).getName() );
				System.out.println("age : "+list.get(i).getAge() );
				System.out.println("전공  : "+list.get(i).getMajor());
				System.out.println("------------------------------");
			}
			break;
		case 2:
		
			System.out.println("검색 id 입력");
			id = input.next();
			StudentDTO dto = db.searchST(id);
			if(dto != null) {
				System.out.println("id : "+dto.getId());
				System.out.println("name : "+dto.getName());
				System.out.println("age : "+dto.getAge());
				System.out.println("전공 : "+dto.getMajor());
				
			}else {
				System.out.println("해당 아이디는 존재하지 않습니다");
			}
			break;
		case 3:
			System.out.println("아이디 입력");
			id = input.next();
			System.out.println("이름 입력");
			name = input.next();
			System.out.println("나이 입력");
			age = input.nextInt();
			System.out.println("전공을 입력해주세요: ");
			major=input.next();
			result=db.saveData(id, name, age, major);	
			
			if(result == 1) {
				System.out.println("저장 성공");
			}else {
				System.out.println("동일한 아이디가 존재합니다");
			}
			
			break;
		case 4:
			System.out.println("수정할 아이디 입력(존재하는 아이디 입력)");
			id = input.next();
			System.out.println("수정(변경)할 이름: ");
			name = input.next();
			System.out.println("수정(변경)할 나이: ");
			age = input.nextInt();
			System.out.println("수정할 전공 입력: ");
			major = input.next();
			
			result = db.updateData(id,name,age,major);
			
			if(result == 1) {
				System.out.println("정상적으로 수정 되었습니다");
			}else {
				System.out.println("해당하는 아이디는 존재하지 않습니다.(수정실패)");
			}
			break;
		case 5:
			System.out.println("삭제할 아이디 입력");
			id = input.next();
			result = db.deleteData(id);
			if(result == 1) {
				System.out.println("정상적으로 삭제 되었습니다");
			}else {
				System.out.println("해당하는 아이디는 존재하지 않습니다.(삭제실패)");
			break;
			}
		}
	}	
}
}
	
	
		
	

