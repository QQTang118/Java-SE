package com.txq.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 1.id唯一<br/>
 * 2.作者如果输入的是中文则至少是两个汉字，如果输入的是英文至少需要五个字符<br/>
 * 3.单价只能是数字<br/>
 * 4.出版社只要验证非空即可<br/>
 * 6.类别供用户选择1：java 2:.net 3:android 4:ios<br/>
 * 所有的信息验证通过时，需要把这些信息给图书JavaBean对象
 * 
 * @author i123t
 *
 */
public class AddBook {
	Scanner sc = new Scanner(System.in);
	String s, str;
	String id;// 图书编号
	String bname;// 图书名称
	String author;// 作者
	String money;// 单价
	String publishing;// 出版社
	String category;// 类别
	List<BookMsg> list = new LinkedList<BookMsg>();
	BufferedReader br;// 读取文件
	BufferedWriter bw;// 写入文件

	public void add() throws IOException {
		System.out.println("************添加图书************");
		File file = new File("E:\\Book.txt");
		if (file.isFile()) {
			System.out.println("请输入图书编号Id：");
			id = sc.next();
			System.out.println("请输入图书名称：");
			bname = sc.next();
			System.out.println("请输入作者：");
			author = sc.next();
			System.out.println("请输入图书单价：");
			money = sc.next();
			System.out.println("请输入出版社：");
			publishing = sc.next();
			System.out.println("请输入图书类别：\n1：java    2:.net    3:android    4:ios");
			category = sc.next();
			checkId();
		} else {
			file.createNewFile();
			add();
		}
	}

	/********** 检查id唯一 ***********************/
	public void checkId() throws IOException {
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf("BookMsg [id=") != -1 && s.indexOf(", bname=") != -1) {
				str = s.substring(s.indexOf("BookMsg [id=") + 12, s.indexOf(", bname="));
			}
		}
		if (id.equals(str)) {
			System.out.println("该Id已存在！！");
			System.out.println("添加失败！！！请选择：\n1、重新添加     2、返回图书管理页面     3、退出");
			switch (sc.nextInt()) {
			case 1:
				add();
				break;
			case 2:
				new BookManager().bookManger();
				break;
			case 3:
				System.out.println("谢谢使用！");
				break;
			default:
				break;
			}
		} else {
			checkAuthor();
		}

	}

	/********** 检查作者名 ***********************/
	/**
	 * 作者如果输入的是中文则至少是两个汉字<br/>
	 * 如果输入的是英文至少需要五个字符
	 * 
	 * @throws IOException
	 */
	public void checkAuthor() throws IOException {
		int eCount = 0, cCount = 0;
		char[] ch = author.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isLetterOrDigit(ch[i])) {
				eCount++;
			} else {
				cCount++;
			}

		}
		if (eCount >= 5 || cCount >= 2 || !author.isEmpty()) {
			checkMoney();
		} else {

			System.out.println("书名长度错误！！");
			System.out.println("添加失败！！！请选择：\n1、重新添加     2、返回图书管理页面     3、退出");
			switch (sc.nextInt()) {
			case 1:
				add();
				break;
			case 2:
				new BookManager().bookManger();
				break;
			case 3:
				System.out.println("谢谢使用！");
				break;
			default:
				break;
			}
		}
	}

	/********** 检查单价 ***********************/
	public void checkMoney() throws IOException {
		char[] ch = money.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (!Character.isDigit(ch[i])) {
				System.out.println("单价应为数字！！");
				System.out.println("添加失败！！！请选择：\n1、重新添加     2、返回图书管理页面     3、退出");
				switch (sc.nextInt()) {
				case 1:
					add();
					break;
				case 2:
					new BookManager().bookManger();
					break;
				case 3:
					System.out.println("谢谢使用！");
					break;
				default:
					break;
				}
			} else {
				checkPub();
			}
		}
	}

	/********** 检查出版社 ***********************/
	public void checkPub() throws IOException {
		if (publishing.isEmpty()) {
			System.out.println("出版社不能为空！！！");
			System.out.println("添加失败！！！请选择：\n1、重新添加     2、返回图书管理页面     3、退出");
			switch (sc.nextInt()) {
			case 1:
				add();
				break;
			case 2:
				new BookManager().bookManger();
				break;
			case 3:
				System.out.println("谢谢使用！");
				break;
			default:
				break;
			}
		} else {
			saveMsg();
		}

	}

	/********** 存储数据 ***********************/
	public void saveMsg() throws IOException {
		list.add(new BookMsg(id, bname, author, money, publishing, category));
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Book.txt", true), "utf-8"));
		for (BookMsg bookMsg : list) {
			bw.newLine();
			bw.write(bookMsg.toString());
			bw.flush();
			bw.close();
		}
		list.clear();
		;
		System.out.println("添加成功！！！请选择：\n1、继续添加     2、返回图书管理页面     3、退出");
		switch (sc.nextInt()) {
		case 1:
			add();
			break;
		case 2:
			new BookManager().bookManger();
			break;
		case 3:
			System.out.println("谢谢使用！");
			break;
		default:
			break;
		}
	}
}
