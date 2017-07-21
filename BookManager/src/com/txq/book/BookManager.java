package com.txq.book;

import java.io.IOException;
import java.util.Scanner;
/**
 * 图书管理入口
 * @author i123t
 *
 */
public class BookManager {
	Scanner sc = new Scanner(System.in);

	public void bookManger() throws IOException {
		System.out.println("***************图书管理页面**************");
		System.out.println("1、添加图书信息\n2、删除图书信息\n3、修改图书信息\n4、查询图书信息\n");
		switch (sc.nextInt()) {
		case 1:
			new AddBook().add();
			break;
		case 2:
			new DeleteBook().delete();
			break;
		case 3:
			
			new ChangeBook().change();
			break;
		case 4:
			new FingBook().find();
			break;

		default:
			System.out.println("输入错误！！请重新输入~~~");
			bookManger();
			break;
		}
	}
}
