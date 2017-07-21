package com.txq.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 修改:先根据图书id编号查询图书信息，然后再进行修改，<br/>
 * 修改时同样需要对输入的信息进行判断<br/>
 * 修改成功则覆盖原先图书数据。否则进行相关信息提示。<br/>
 * 
 * @author i123t
 *
 */
public class ChangeBook {
	Scanner sc = new Scanner(System.in);
	String s, s1, str, str1;
	String id;// 图书编号
	String bname;// 图书名称
	String author;// 作者
	String money;// 单价
	String publishing;// 出版社
	String category;// 类别
	List<String> list = new LinkedList<>();
	BufferedWriter bw;
	BufferedReader br;

	public void change() throws IOException {
		System.out.println("************修改图书信息************");
		System.out.println("请输入图书Id编号：");
		id = sc.next();
		// 根据图书id编号查询图书信息
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf("BookMsg [id=") != -1 && s.indexOf(", bname=") != -1) {
				str = s.substring(s.indexOf("BookMsg [id=") + 12, s.indexOf(", bname="));
			}
		}
		if (id.equals(str)) {
			str1 = s;
			System.out.println("图书存在~~~");
			changeMsg();
		} else {
			System.out.println("该书不存在~~\n请重新输入：");
			change();
		}
	}

	/********** 修改成功则覆盖原先用户数据 ******************/
	public void changeMsg() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("************修改图书************");
		System.out.println("1、修改Id\n2、修改图书名称\n3、修改作者\n4、修改单价\n5、修改出版社\n");
		switch (sc.nextInt()) {
		case 1:
			changeId();
			break;
		case 2:
			changeName();
			break;
		case 3:
			changeAuthor();
			break;
		case 4:
			changeMoney();
			break;
		case 5:
			changePub();
			break;

		default:
			break;
		}
	}

	/*********** 1、修改Id **************************/
	public void changeId() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("************修改*****************");
		System.out.println("请输入Id：");
		id = sc.next();
		int c = 0;
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf("BookMsg [id=") != -1 && s.indexOf(", bname=") != -1) {
				str = s.substring(s.indexOf("BookMsg [id=") + 12, s.indexOf(", bname="));
				str1 = s;
			}
			if (id.equals(str)) {
				c++;
			}
		}
		if (c == 0) {
			str1 = str1.substring(0, str1.indexOf("BookMsg [id=") + 12) + id
					+ str1.substring(str1.indexOf(", bname="), str1.indexOf("]") + 1);
			list.add(str1);
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Book.txt"), "utf-8"));
			for (String string : list) {
				bw.newLine();
				bw.write(string);
				bw.flush();
			}
			list.clear();
			System.out.println("修改成功！\n请选择：1、修改其他选项  2、返回图书管理页面  3、退出");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				changeMsg();
				break;
			case 2:
				new BookManager().bookManger();
				break;
			case 3:
				System.out.println("谢谢，欢迎下次使用！");
				break;
			default:
				break;
			}
		} else {
			System.out.println("该Id已存在！！！");
			System.out.println("修改失败！\n请选择：1、重新修改用户名   2、修改其他选项  3、退出");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				changeId();
				break;
			case 2:
				changeMsg();
				break;
			case 3:
				System.out.println("谢谢，欢迎下次使用！");
				break;
			default:
				break;
			}
		}

	}

	/*********** 2、修改图书名 **************************/
	public void changeName() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("************修改*****************");
		System.out.println("请输入书名：");
		bname = sc.next();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", bname=") != -1 && s.indexOf(", author=") != -1) {
				str = s.substring(s.indexOf(", bname=") + 8, s.indexOf(", author="));
				s1 = str + " ";
				str1 = s;
			}
		}
		str1 = str1.substring(0, str1.indexOf(", bname=") + 8) + bname
				+ str1.substring(str1.indexOf(", author="), str1.indexOf("]") + 1);
		list.add(str1);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Book.txt"), "utf-8"));
		for (String string : list) {
			bw.newLine();
			bw.write(string);
			bw.flush();
		}
		list.clear();
		System.out.println("修改成功！\n请选择：1、修改其他选项  2、返回图书管理页面  3、退出");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new BookManager().bookManger();
			break;
		case 3:
			System.out.println("谢谢，欢迎下次使用！");
			break;
		default:
			break;
		}

	}

	/*********** 3、修改作者 **************************/
	public void changeAuthor() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("************修改*****************");
		System.out.println("请输入作者：");
		author = sc.next();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", author=") != -1 && s.indexOf(", money=") != -1) {
				str = s.substring(s.indexOf(", author=") + 9, s.indexOf(", money="));
				str1 = s;
			}
		}
		str1 = str1.substring(0, str1.indexOf(", author=") + 9) + author
				+ str1.substring(str1.indexOf(", money="), str1.indexOf("]") + 1);
		list.add(str1);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Book.txt"), "utf-8"));
		for (String string : list) {
			bw.newLine();
			bw.write(string);
			bw.flush();
		}
		list.clear();
		System.out.println("修改成功！\n请选择：1、修改其他选项  2、返回图书管理页面  3、退出");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new BookManager().bookManger();
			break;
		case 3:
			System.out.println("谢谢，欢迎下次使用！");
			break;
		default:
			break;
		}

	}

	/*********** 4、修改单价 **************************/
	public void changeMoney() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("************修改*****************");
		System.out.println("请输入出版社：");
		publishing = sc.next();
		char[] ch;
		int c = 0;
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", money") != -1 && s.indexOf(", publishing=") != -1) {
				str = s.substring(s.indexOf(", money=") + 10, s.indexOf(", publishing="));
				s1 = str + " ";
				str1 = s;
			}
		}
		ch = s1.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isDigit(ch[i])) {
				c++;
			} else {
				System.out.println("单价必须是数字！！！");
				System.out.println("修改失败！\n请选择：1、重新修改单价   2、修改其他选项  3、退出");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					changeMoney();
					break;
				case 2:
					changeMsg();
					break;
				case 3:
					System.out.println("谢谢，欢迎下次使用！");
					break;
				default:
					break;
				}
			}
		}
		if (c >= 1) {
			str1 = str1.substring(0, str1.indexOf(", money=") + 8) + money
					+ str1.substring(str1.indexOf(", publishing="), str1.indexOf("]") + 1);
			list.add(str1);
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Book.txt"), "utf-8"));
			for (String string : list) {
				bw.newLine();
				bw.write(string);
				bw.flush();
			}
			list.clear();
			System.out.println("修改成功！\n请选择：1、修改其他选项  2、返回图书管理页面  3、退出");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				changeMsg();
				break;
			case 2:
				new BookManager().bookManger();
				break;
			case 3:
				System.out.println("谢谢，欢迎下次使用！");
				break;
			default:
				break;
			}
		}

	}

	/*********** 5、修改出版社 **************************/
	public void changePub() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("************修改*****************");
		System.out.println("请输入出版社：");
		publishing = sc.next();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", publishing") != -1 && s.indexOf(", date=") != -1) {
				str = s.substring(s.indexOf(", publishing=") + 10, s.indexOf(", date="));
				s1 = str + " ";
				str1 = s;
			}
		}
		str1 = str1.substring(0, str1.indexOf(", publishing=") + 13) + publishing
				+ str1.substring(str1.indexOf(", date="), str1.indexOf("]") + 1);
		list.add(str1);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Book.txt"), "utf-8"));
		for (String string : list) {
			bw.newLine();
			bw.write(string);
			bw.flush();
		}
		list.clear();
		System.out.println("修改成功！\n请选择：1、修改其他选项  2、返回图书管理页面  3、退出");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new BookManager().bookManger();
			break;
		case 3:
			System.out.println("谢谢，欢迎下次使用！");
			break;
		default:
			break;
		}

	}

}
