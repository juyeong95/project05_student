package seoon;

import java.util.ArrayList;
import java.util.Scanner;

public class seoon_function {
	public void seoon_function() {
		Scanner input = new Scanner(System.in);
		ArrayList<seoon_StDTO> list = null;
		seoon_controller scon = new seoon_controller();
		seoon_StDTO dto = new seoon_StDTO();
		int age = 0, result;
		String id, name = null, major = null;
		
		
		while(true) {
			System.out.println("1. 모든데이터보기\n2. 찾기\n3. 저장\n4. 삭제\n5. 수정");
			System.out.print(">>>>>>>>");
			int num = input.nextInt();
			switch(num) {
			case 1: 
				list = scon.getList();
				for(int i = 0; i < list.size(); i++) {
					System.out.println("id : "+list.get(i).getId());
					System.out.println("name : "+list.get(i).getName());
					System.out.println("major : "+list.get(i).getMajor());
					System.out.println("age : "+list.get(i).getAge());
				}
				break;
				
			case 2: 
				System.out.println("검색하실 ID를 입력하세요.");
				System.out.print(">>>>>>>>");
				id = input.next();
				dto = scon.search(id);

				if(dto != null) {
					System.out.println("id : " + dto.getId());
					System.out.println("name : " + dto.getName());
					System.out.println("Major : " + dto.getMajor());
					System.out.println("age : " + dto.getAge());
				}else {
					System.out.println("ID가 존재하지 않습니다.");
				}
				break;
				
			case 3: 
				System.out.println("아이디 입력 : ");
				id = input.next();
				System.out.println("이름 입력 : ");
				name = input.next();
				System.out.println("전공 입력 : ");
				major = input.next();
				System.out.println("나이 입력 : ");
				age = input.nextInt();
				
				result = scon.saveData(id, name, major, age);
				if(result == 1) {
					System.out.println("해당 ID를 저장하였습니다.");
				}else {
					System.out.println("이미 저장된 ID입니다.");
				}
				break;
				
			case 4: 
				System.out.println("삭제하실 ID를 입력하세요.");
				System.out.print(">>>>>>>>>");
				id = input.next();
				result = scon.deleteDataString(id);
				if(result == 1){
					System.out.println("요청하신 ID가 삭제되었습니다.");
				}else {
					System.out.println("삭제 실패(요청하신 ID가 존재하지 않습니다.)");
				}
				break;
				
			case 5: 
				System.out.println("수정하실 ID를 입력하십시오.");
				System.out.print(">>>>>>>>");
				id = input.next();
				if(id.contains(dto.getId())) {
					System.out.println("1. 이름 수정\n2. 전공 수정\n3. 나이 수정\n4. 돌아가기");
					switch(num) {
					case 1:
						System.out.println("수정하실 이름을 입력해 주세요.");
						System.out.print(">>>>>>>>");
						name = input.next();
						break;
					case 2:
						System.out.println("수정하실 전공명을 입력해 주세요.");
						System.out.print(">>>>>>>>");
						major = input.next();
						break;
					case 3:
						System.out.println("수정하실 나이를 입력해 주세요.");
						System.out.print(">>>>>>>>");
						age = input.nextInt();
						break;
					case 4:
						seoon_function();
					}
					result = scon.updateData(id, name, major, age);
					
					if(result == 1) {
						System.out.println("정상적으로 처리 되었습니다.");
					}else {
						System.out.println("입력하신 ID가 존재하지 않습니다.");
					}
				}
				break;
			}
		}
	}
}
