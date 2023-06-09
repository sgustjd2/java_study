package jdbc.dao;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	CustomerDAO dao = new CustomerDAOImpl();

	public void insertMenu() {
		System.out.println("************사원등록************");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String pass = key.next();
		System.out.print("성명:");
		String name = key.next();
		System.out.print("주소:");
		String addr = key.next();
		System.out.print("메모:");
		String memo = key.next();
		CustomerVO customer = new CustomerVO(id, pass, name, addr, memo);
		int result = dao.insert(customer);
		if (result > 0) {
			System.out.println("사원 등록 완료");
		} else {
			System.out.println("## 등록 실패 / 아이디 중복 ##");
		}
	}

	public void getMemberListMenu() {
		System.out.println("************전체사원조회************");
		ArrayList<CustomerVO> userlist = dao.getMemberList();
		int size = userlist.size();
		for (int i = 0; i < size; i++) {
			CustomerVO customer = userlist.get(i);
			System.out.print(customer.getId() + "\t");
			System.out.print(customer.getPass() + "\t");
			System.out.print(customer.getName() + "\t");
			System.out.print(customer.getAddr() + "\t");
			System.out.print(customer.getRegdate() + "\t");
			System.out.print(customer.getPoint() + "\t");
			System.out.println(customer.getMemo() + "\t");
		}
	}

	public void updateMenu() {
		System.out.println("************사원정보수정************");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("포인트:");
		int point = key.nextInt();
		System.out.print("패스워드:");
		String pass = key.next();

		int result = dao.update(id, point, pass);
		if (result > 0) {
			System.out.println("사원 업데이트 완료");
		} else {
			System.out.println("## 업데이트 실패 / 해당 아이디가 없습니다##");
		}
	}

	public void deleteMenu() {
		System.out.println("************퇴사하기************");
		System.out.print("아이디:");
		String id = key.next();

		int result = dao.delete(id);
		if (result > 0) {
			System.out.println("사원 퇴사 처리 완료");
		} else {
			System.out.println("## 퇴사 처리 실패 / 해당 아이디 없습니다##");
		}
	}

	public void selectMenu() {
		System.out.println("************주소검색************");
		System.out.print("주소:");
		String addr = key.next();
		ArrayList<CustomerVO> userlist = dao.select(addr);
		int size = userlist.size();
		for (int i = 0; i < size; i++) {
			CustomerVO customer = userlist.get(i);
			System.out.print(customer.getId() + "\t");
			System.out.print(customer.getPass() + "\t");
			System.out.print(customer.getName() + "\t");
			System.out.print(customer.getAddr() + "\t");
			System.out.print(customer.getRegdate() + "\t");
			System.out.print(customer.getPoint() + "\t");
			System.out.println(customer.getMemo() + "\t");
		}
	}

	public void login() {
		System.out.println("************로그인************");
		System.out.print("아이디:");
		String id = key.nextLine();
		System.out.print("패스워드:");
		String pass = key.next();

		CustomerVO customer = dao.login(id, pass);
		if (customer != null) {
			System.out.print(customer.getId() + "\t");
			System.out.print(customer.getPass() + "\t");
			System.out.print(customer.getName() + "\t");
			System.out.print(customer.getAddr() + "\t");
			System.out.print(customer.getRegdate() + "\t");
			System.out.print(customer.getPoint() + "\t");
			System.out.println(customer.getMemo() + "\t");
		} else {
			System.out.println("해당 아이디 없음");
		}
	}

	public void getInfoMenu() {
		System.out.println("************사원조회************");
		System.out.print("아이디:");
		String id = key.nextLine();
		CustomerVO customer = dao.getCustomerInfo(id);
		if (customer != null) {
			System.out.print(customer.getId() + "\t");
			System.out.print(customer.getPass() + "\t");
			System.out.print(customer.getName() + "\t");
			System.out.print(customer.getAddr() + "\t");
			System.out.print(customer.getRegdate() + "\t");
			System.out.print(customer.getPoint() + "\t");
			System.out.println(customer.getMemo() + "\t");
		} else {
			System.out.println("해당 아이디 없음");
		}
	}

}
