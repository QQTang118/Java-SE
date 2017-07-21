package com.txq.book;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.txq.administrator.AdminManager;
import com.txq.administrator.Administrator;

/**
 * 分为id查询和图书名称查询
 * 
 * @author i123t
 *
 */
public class FingBook {
	Scanner sc = new Scanner(System.in);
	String id, s, s1, str;
	BufferedReader br;

	public void find() throws IOException {
		System.out.println("************查询图书************");
		System.out.println("请输入要查询的图书Id：");
		id = sc.next();
		int c = 0;
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf("BookMsg [id=") != -1 && s.indexOf(", bname=") != -1) {
				str = s.substring(s.indexOf("BookMsg [id=") + 12, s.indexOf(", bname="));
				s1 = s.substring(s.indexOf("Sign"));
			}
			if (id.equals(str)) {
				c++;
				System.out.println("查询成功！！\n" + s1);
				System.out.println("请选择：\n1、继续查询    2、返回图书管理页面     3、返回主页面");
				switch (sc.nextInt()) {
				case 1:
					find();
					break;
				case 2:
					new BookManager().bookManger();
					break;
				case 3:
					new Administrator().adminManager();
					break;
				default:
					break;
				}

			}
		}
		if (c == 0) {
			System.out.println("查询失败！！该Id不存在~~~");
			System.out.println("请选择：\n1、继续查询    2、返回图书管理页面     3、返回主页面");
			switch (sc.nextInt()) {
			case 1:
				find();
				break;
			case 2:
				new BookManager().bookManger();
				break;
			case 3:
				new Administrator().adminManager();
				break;
			default:
				break;
			}

		}
	}
}
