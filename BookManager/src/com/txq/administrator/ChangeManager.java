package com.txq.administrator;

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
 * 修改管理员信息<br/>
 * 修改:先根据用户id编号查询用户信息，然后再进行修改，<br/>
 * 修改时同样需要对输入的信息进行判断<br/>
 * 修改成功则覆盖原先用户数据。否则进行相关信息提示。<br/>
 * 
 * @author i123t
 *
 */
public class ChangeManager {
	Scanner sc = new Scanner(System.in);
	String s, str, pwd, str1, str2, s1, s3;// s3:存数据
	String[] s2;
	BufferedReader br;
	BufferedWriter bw;
	String name;// 姓名
	String id;// Id
	Boolean gendar;// 性别
	Integer age;// 年龄
	String address;// 家庭住址
	String tellnumber;// 手机号
	String login_name;// 登录名
	String pawd;// 登录密码
	List<String> list = new LinkedList<String>();// 放String类型

	public void change() throws IOException {
		System.out.println("************修改管理员信息******************");
		System.out.println("请输入要修改的Id：");
		id = sc.nextLine();
		System.out.println("请输入该Id所对应的密码：");
		pwd = sc.nextLine();
		// 需要对输入的信息进行判断
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", id=") != -1 && s.indexOf(", gendar=") != -1) {
				str = s.substring(s.indexOf(", id=") + 5, s.indexOf(", gendar="));
			}
			if (s.indexOf(", pawd=") != -1 && s.indexOf(", state=") != -1) {
				str1 = s.substring(s.indexOf(", pawd=") + 7, s.indexOf(", state="));
			}

		}
		if (id.equals(str) && pwd.equals(str1)) {
			str2 = s;
			System.out.println("该用户存在！");
			changeMsg();
		} else {
			System.out.println("输入用户不存在！请重新输入~~~");
			change();
		}

	}

	/********** 修改成功则覆盖原先用户数据 ******************/
	public void changeMsg() throws IOException {
		System.out.println("**********修改数据************");
		System.out.println("1、修改Id\n2、修改姓名\n3、修改年龄\n4、修改性别\n5、修改家庭住址\n6、修改联系电话\n7、修改登录名\n8、修改密码");
		switch (sc.nextInt()) {
		case 1:
			changeId();
			break;
		case 2:
			changeName();
			break;
		case 3:
			changeAge();
			break;
		case 4:
			changeSex();
			break;
		case 5:
			changeAddress();
			break;
		case 6:
			changeNumber();
			break;
		case 7:
			changeLname();
			break;
		case 8:
			changePwd();
			break;

		default:
			break;
		}
	}

	/*********** 1、修改Id **************************/
	public void changeId() throws IOException {
		System.out.println("************修改*****************");
		System.out.println("请输入Id：");
		id = sc.next();
		int c = 0;
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", id=") != -1 && s.indexOf(", gendar=") != -1) {
				str = s.substring(s.indexOf(", id=") + 5, s.indexOf(", gendar="));
				str2 = s;
			}
			if (id.equals(str)) {
				c++;
			}
		}
		if (c == 0) {
			str2 = str2.substring(0, str2.indexOf(", id=") + 5) + id
					+ str2.substring(str2.indexOf(", gendar="), str2.indexOf("]") + 1);
			list.add(str2);
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\SignIn.txt"), "utf-8"));
			for (String string : list) {
				bw.newLine();
				bw.write(string);
				bw.flush();
			}
			list.clear();
			System.out.println("修改成功！\n请选择：1、修改其他选项  2、返回管理员管理页面  3、退出");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				changeMsg();
				break;
			case 2:
				new AdminManager().Manager();
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

	/*********** 2、修改姓名 **************************/
	public void changeName() throws IOException {
		System.out.println("************修改*****************");
		System.out.println("请输入姓名：");
		name = sc.next();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf("Sign [name=") != -1 && s.indexOf(", id=") != -1) {
				str = s.substring(s.indexOf("Sign [name=") + 11, s.indexOf(", id="));
				s1 = str + " ";
				str2 = s;
			}
		}
		str2 = str2.substring(0, str2.indexOf("Sign [name=") + 11) + address
				+ str2.substring(str2.indexOf(", id="), str2.indexOf("]") + 1);
		list.add(str2);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\SignIn.txt"), "utf-8"));
		for (String string : list) {
			bw.newLine();
			bw.write(string);
			bw.flush();
		}
		list.clear();
		System.out.println("修改成功！\n请选择：1、修改其他选项  2、返回管理员管理页面  3、退出");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new AdminManager().Manager();
			break;
		case 3:
			System.out.println("谢谢，欢迎下次使用！");
			break;
		default:
			break;
		}
	}

	/*********** 3、修改性别 **************************/
	public void changeSex() throws IOException {
		System.out.println("************修改*****************");
		System.out.println("请输入性别：");
		gendar = sc.nextBoolean();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", gendar=") != -1 && s.indexOf(", age=") != -1) {
				str = s.substring(s.indexOf(", gendar=") + 9, s.indexOf(", age="));
				str2 = s;
			}
		}
		str2 = str2.substring(0, str2.indexOf(", gendar=") + 9) + gendar
				+ str2.substring(str2.indexOf(", age="), str2.indexOf("]") + 1);
		list.add(str2);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\SignIn.txt"), "utf-8"));
		for (String string : list) {
			bw.newLine();
			bw.write(string);
			bw.flush();
		}
		list.clear();
		System.out.println("修改成功！\n请选择：1、修改其他选项  2、返回管理员管理页面  3、退出");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new AdminManager().Manager();
			break;
		case 3:
			System.out.println("谢谢，欢迎下次使用！");
			break;
		default:
			break;
		}
	}

	/*********** 4、修改年龄 **************************/
	public void changeAge() throws IOException {
		System.out.println("************修改*****************");
		System.out.println("请输入年龄：");
		age = sc.nextInt();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", age=") != -1 && s.indexOf(", address=") != -1) {
				str2 = s;
			}
		}
		str2 = str2.substring(0, str2.indexOf(", age=") + 6) + age
				+ str2.substring(str2.indexOf(", address="), str2.indexOf("]") + 1);
		list.add(str2);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\SignIn.txt"), "utf-8"));
		for (String string : list) {
			bw.newLine();
			bw.write(string);
			bw.flush();
		}
		list.clear();
		System.out.println("修改成功！\n请选择：1、修改其他选项  2、返回管理员管理页面  3、退出");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new AdminManager().Manager();
			break;
		case 3:
			System.out.println("谢谢，欢迎下次使用！");
			break;
		default:
			break;
		}
	}

	/*********** 5、修改家庭地址 **************************/
	public void changeAddress() throws IOException {
		System.out.println("************修改*****************");
		System.out.println("请输入家庭地址：");
		address = sc.next();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", address") != -1 && s.indexOf(", tellnumber=") != -1) {
				str = s.substring(s.indexOf(", address=") + 10, s.indexOf(", tellnumber="));
				s1 = str + " ";
				str2 = s;
			}
		}
		str2 = str2.substring(0, str2.indexOf(", address=") + 10) + address
				+ str2.substring(str2.indexOf(", tellnumber="), str2.indexOf("]") + 1);
		list.add(str2);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\SignIn.txt"), "utf-8"));
		for (String string : list) {
			bw.newLine();
			bw.write(string);
			bw.flush();
		}
		list.clear();
		System.out.println("修改成功！\n请选择：1、修改其他选项  2、返回管理员管理页面  3、退出");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new AdminManager().Manager();
			break;
		case 3:
			System.out.println("谢谢，欢迎下次使用！");
			break;
		default:
			break;
		}
	}

	/*********** 6、修改电话 **************************/
	public void changeNumber() throws IOException {
		System.out.println("************修改*****************");
		System.out.println("请输入联系电话：");
		tellnumber = sc.next();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", tellnumber=") != -1 && s.indexOf(", login_name=") != -1) {
				str = s.substring(s.indexOf(", tellnumber=") + 13, s.indexOf(", login_name="));
				str2 = s;
			}
		}
		str2 = str2.substring(0, str2.indexOf(", tellnumber=") + 13) + address
				+ str2.substring(str2.indexOf(", login_name="), str2.indexOf("]") + 1);
		list.add(str2);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\SignIn.txt"), "utf-8"));
		for (String string : list) {
			bw.newLine();
			bw.write(string);
			bw.flush();
		}
		list.clear();
		System.out.println("修改成功！\n请选择：1、修改其他选项  2、返回管理员管理页面  3、退出");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new AdminManager().Manager();
			break;
		case 3:
			System.out.println("谢谢，欢迎下次使用！");
			break;
		default:
			break;
		}
	}

	/*********** 7、修改用户名 **************************/
	public void changeLname() throws IOException {
		System.out.println("************修改*****************");
		System.out.println("请输入用户名：");
		login_name = sc.next();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", login_name=") != -1 && s.indexOf(", pawd=") != -1) {
				str = s.substring(s.indexOf(", login_name=") + 13, s.indexOf(", pawd="));
				s1 = str + " ";
				str2 = s;
			}

		}
		s2 = s1.split(" ");
		char[] ch;
		for (int i = 0; i < s2.length; i++) {
			// 长度在3-8位
			if (login_name.length() < 3 || login_name.length() > 8) {
				System.out.println("登录名长度在3-8位！！");
				System.out.println("修改失败！\n请选择：1、重新修改用户名   2、修改其他选项  3、退出");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					changeLname();
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
				break;
			}
			// 登录名唯一性
			if (login_name.equals(s2[i])) {
				System.out.println("该登录名已注册过！！");
				System.out.println("修改失败！\n请选择：1、重新修改用户名   2、修改其他选项  3、退出");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					changeLname();
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
				break;
			} else if (!login_name.equals(s2[i])) {
				// 不重复并且长度正确
				ch = login_name.toCharArray();
				for (int j = 0; j < ch.length; j++) {
					// 不能以数字开头
					if (Character.isDigit(ch[0])) {
						System.out.println("登录名不能以数字开头，由字母、数字、特殊字符组成，！！");
						System.out.println("修改失败！\n请选择：1、重新修改用户名   2、修改其他选项  3、退出");
						Scanner sc1 = new Scanner(System.in);
						switch (sc1.nextInt()) {
						case 1:
							changeLname();
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
					} else {
						// 存数据
						str2 = str2.substring(0, str2.indexOf(", login_name=") + 13) + login_name
								+ str2.substring(str2.indexOf(", pawd="), str2.indexOf("]") + 1);
						list.add(str2);
						bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\SignIn.txt")));
						for (String string : list) {
							bw.newLine();
							bw.write(string);
							bw.flush();
						}
						list.clear();
						System.out.println("修改成功！\n请选择：1、修改其他选项  2、返回管理员管理页面  3、退出");
						Scanner sc1 = new Scanner(System.in);
						switch (sc1.nextInt()) {
						case 1:
							changeMsg();
							break;
						case 2:
							new AdminManager().Manager();
							break;
						case 3:
							System.out.println("谢谢，欢迎下次使用！");
							break;
						default:
							break;
						}
					}
				}
			}
		}
	}

	/*********** 8、修改密码 **************************/
	public void changePwd() throws IOException {
		System.out.println("************修改*****************");
		System.out.println("请输入密码：");
		pawd = sc.next();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", pawd=") != -1 && s.indexOf(", state=") != -1) {
				str = s.substring(s.indexOf(", pawd=") + 7, s.indexOf(", state="));
				s1 += str + " ";
				str2 = s;
			}
		}
		s2 = s1.split(" ");
		for (int i = 0; i < s2.length; i++) {
			// 密码长度必须是6-12位
			if (pawd.length() < 6 || pawd.length() > 12) {
				System.out.println("密码长度必须是6-12位！！");
				System.out.println("修改失败！\n请选择：1、重新修改密码   2、修改其他选项  3、退出");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					changePwd();
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
			} // 密码与登录名相同
			if (pawd.equals(s2[i])) {
				System.out.println("密码与登录名相同！！");
				System.out.println("修改失败！\n请选择：1、重新修改密码   2、修改其他选项  3、退出");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					changePwd();
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
			}else {
				str2 = str2.substring(0, str2.indexOf(", pawd=") + 7) + pawd
						+ str2.substring(str2.indexOf(", state="), str2.indexOf("]") + 1);
				list.add(str2);
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\SignIn.txt")));
				for (String string : list) {
					bw.newLine();
					bw.write(string);
					bw.flush();
				}
				list.clear();
				System.out.println("修改成功！\n请选择：1、修改其他选项  2、返回管理员管理页面  3、退出");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					changeMsg();
					break;
				case 2:
					new AdminManager().Manager();
					break;
				case 3:
					System.out.println("谢谢，欢迎下次使用！");
					break;
				default:
					break;
				}
			}
		}
	}
}
