package com.txq.administrator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 查询管理员信息<br/>
 * 查询:分为id查询和登录名称查询
 * 
 * @author i123t
 *
 */
public class FindManager {
	Scanner sc = new Scanner(System.in);
	String id, s, lname, str, s1, s2;
	String[] s3;

	public void find() throws IOException {
		System.out.println("**********查询****************");
		System.out.println("请输入：\n1、根据Id查询    2、根据登录名查询");
		switch (sc.nextInt()) {
		case 1:
			findId();
			break;
		case 2:
			findLoginName();
			break;
		default:
			System.out.println("输入错误，请重新输入~~~");
			find();
			break;
		}
	}

	/********* 根据Id查询 *********************/
	@SuppressWarnings("null")
	public void findId() throws IOException {
		System.out.println("请输入Id：");
		id = sc.next();
		int c = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt")));

		while ((s = br.readLine()) != null) {
			if (s.indexOf(", id=") != -1 && s.indexOf(", gendar=") != -1) {
				str = s.substring(s.indexOf(", id=") + 5, s.indexOf(", gendar="));
				s1 = s.substring(s.indexOf("Sign"));
			}
			if (id.equals(str)) {
				c++;
				System.out.println("查询成功！！\n" + s1);
				System.out.println("请选择：\n1、继续查询    2、返回管理员管理页面     3、返回主页面");
				switch (sc.nextInt()) {
				case 1:
					find();
					break;
				case 2:
					new AdminManager().Manager();
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
			System.out.println("请选择：\n1、继续查询    2、返回管理员管理页面     3、返回主页面");
			switch (sc.nextInt()) {
			case 1:
				find();
				break;
			case 2:
				new AdminManager().Manager();
				break;
			case 3:
				new Administrator().adminManager();
				break;
			default:
				break;
			}
		}
	}

	/********* 根据登录名查询 *********************/
	public void findLoginName() throws IOException {
		int c = 0;
		System.out.println("请输入登录名：");
		lname = sc.next();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", login_name=") != -1 && s.indexOf(", pawd=") != -1) {
				str = s.substring(s.indexOf(", login_name=") + 13, s.indexOf(", pawd="));
				s2 += str + " ";
			}

			s3 = s2.split(" ");
			for (String string : s3) {
				if (lname.equals(string)) {
					c++;
					System.out.println("查询成功！！\n" + s);
				}
			}
		}
		if (c != 0) {

			System.out.println("请选择：\n1、继续查询    2、返回管理员管理页面     3、返回主页面");
			switch (sc.nextInt()) {
			case 1:
				find();
				break;
			case 2:
				new AdminManager().Manager();
				break;
			case 3:
				new Administrator().adminManager();
				break;
			default:
				break;
			}
		}
		if (c == 0) {
			System.out.println("查询失败！！该用户名不存在~~~");
			System.out.println("请选择：\n1、继续查询    2、返回管理员管理页面     3、返回主页面");
			switch (sc.nextInt()) {
			case 1:
				find();
				break;
			case 2:
				new AdminManager().Manager();
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