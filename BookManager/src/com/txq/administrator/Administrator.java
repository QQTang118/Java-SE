package com.txq.administrator;

import java.io.IOException;
import java.util.Scanner;
import com.txq.book.BookManager;

/**
 * ����������
 * 
 * @author i123t
 *
 */

public class Administrator {
	Scanner sc = new Scanner(System.in);

	public void adminManager() throws IOException {
		System.out.println("********* ����Ա *************");
		System.out.println("1������Ա����          2��ͼ�����");
		switch (sc.nextInt()) {
		case 1:
			new AdminManager().Manager();
			break;
		case 2:
			new BookManager().bookManger();
			break;
		default:
			System.out.println("������󣡣�����������~~~");
			adminManager();
			break;
		}
	}
}
