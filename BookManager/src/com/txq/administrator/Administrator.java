package com.txq.administrator;

import java.io.IOException;
import java.util.Scanner;
import com.txq.book.BookManager;

/**
 * 管理界面入口
 * 
 * @author i123t
 *
 */

public class Administrator {
	Scanner sc = new Scanner(System.in);

	public void adminManager() throws IOException {
		System.out.println("********* 管理员 *************");
		System.out.println("1、管理员管理          2、图书管理");
		switch (sc.nextInt()) {
		case 1:
			new AdminManager().Manager();
			break;
		case 2:
			new BookManager().bookManger();
			break;
		default:
			System.out.println("输入错误！！请重新输入~~~");
			adminManager();
			break;
		}
	}
}
