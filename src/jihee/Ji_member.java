package jihee;

import java.util.Scanner;

public class Ji_member {
	
	public void jihee() {
		Ji_DBClass db = new Ji_DBClass();
		Scanner sc = new Scanner(System.in);
		int num;
		while(true) {
			System.out.println("1. 모든데이터보기  2. 검색  3. 저장 4. 삭제 5.수정 ");
			num = sc.nextInt();
			switch(num) {
			case 1:
				db.getList();
				break;
			case 2:break;
			case 3:break;
			case 4:break;
			case 5:break;
		
			}
		}
	
	
	
	
	
	
	
	
	}
	
	
}
