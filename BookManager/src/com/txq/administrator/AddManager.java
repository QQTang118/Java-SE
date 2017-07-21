package com.txq.administrator;

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
import com.txq.login.Login;
import com.txq.sign_in.Sign;

/**
 * 增加管理员信息、<br/>
 * 增加:参考管理员的注册功能
 * 
 * @author i123t
 *
 */
public class AddManager {
	Scanner sc = new Scanner(System.in);
	BufferedReader br;
	String name;// 姓名
	String id;// Id
	Boolean gendar;// 性别
	int age;// 年龄
	String address;// 家庭住址
	String tellnumber;// 手机号
	String login_name;// 登录名
	String pawd;// 登录密码
	int state;// 状态
	List<Sign> list = new LinkedList<Sign>();

	public void add() throws IOException {
		System.out.println("*****************添加*************************");
		File file = new File("E:\\SignIn.txt");
		if (file.isFile()) {
			System.out.println("请输入id:");
			id = sc.next();
			System.out.println("请输入姓名:");
			name = sc.next();
			System.out.println("请输入性别:（true为男，false为女）");
			gendar = sc.nextBoolean();
			System.out.println("请输入年龄:");
			age = sc.nextInt();
			System.out.println("请输入家庭住址:");
			address = sc.next();
			System.out.println("请输入联系电话:");
			tellnumber = sc.next();
			System.out.println("请输入登录名:");
			login_name = sc.next();
			System.out.println("请输入密码:");
			pawd = sc.next();
			System.out.println("请输入状态:\nPS：用户只有三种状态，1、表示正常   2、表示禁用   3、表示离职    默认状态为：1");
			state = sc.nextInt();
			checkID();
		}
	}

	/*************** 检查ID不重复 ******************/
	public void checkID() throws IOException {
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		String s, s1 = "";
		String[] s2 = null;
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", id=") != -1 && s.indexOf(", gendar=") != -1) {
				String str = s.substring(s.indexOf(", id=") + 5, s.indexOf(", gendar="));
				s1 += str + " ";
			}
		}
		s2 = s1.split(" ");
		char[] ch = id.toCharArray();
		for (int i = 0; i < s2.length; i++) {
			if (!Character.isDigit(ch[0])) {
				System.out.println("Id必须是数字！！");
				System.out.println("添加失败！\n请选择：1、重新添加   2、返回管理员管理页面  3、退出");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					add();
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
				break;
			}
			if (id.equals(s2[i])) {
				System.out.println("该Id已存在！！");
				System.out.println("添加失败！\n请选择：1、重新添加   2、返回管理员管理页面  3、退出");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					add();
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
				break;
			} else {
				checkName();
			}
		}

	}

	/*************** 检查姓名不为空 ******************/
	public void checkName() throws IOException {
		if (name.isEmpty()) {
			System.out.println("姓名不能为空！");
			System.out.println("添加失败！\n请选择：1、重新添加   2、返回管理员管理页面  3、退出");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				add();
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
			checkAge();
		}
	}

	/*************** 检查年龄不为空 ******************/
	public void checkAge() throws IOException {
		if (age <= 0 || age > 100) {
			System.out.println("年龄应在1~100之间！");
			System.out.println("添加失败！\n请选择：1、重新添加   2、返回管理员管理页面  3、退出");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				add();
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
			checkNumber();
		}
	}

	/*************** 检查手机号 ******************/
	public void checkNumber() throws IOException {
		if (tellnumber.length() > 12 || tellnumber.length() < 10) {
			System.out.println("手机号应有11位！");
			System.out.println("添加失败！\n请选择：1、重新添加   2、返回管理员管理页面  3、退出");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				add();
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
			checkLoginName();
		}
	}

	/*************** 检查登录名 ******************/
	/**
	 * 有字母、数字、特殊字符组成，<br/>
	 * 不能以数字开头，长度在3-8位，而且不能有重复的登录名称
	 * 
	 * @throws IOException
	 */

	public void checkLoginName() throws IOException {
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		String s, s1 = "";
		String[] s2 = null;
		while ((s = br.readLine()) != null) {
			// 将获取的字符分割放入
			if (s.indexOf(", login_name=") != -1 && s.indexOf(", pawd=") != -1) {
				String str = s.substring(s.indexOf(", login_name=") + 13, s.indexOf(", pawd="));
				s1 += str + " ";
			}
		}
		s2 = s1.split(" ");
		char[] ch;
		for (int i = 0; i < s2.length; i++) {
			// 长度在3-8位
			if (login_name.length() < 3 || login_name.length() > 8) {
				System.out.println("登录名长度在3-8位！！");
				System.out.println("添加失败！\n请选择：1、重新添加   2、返回管理员管理页面  3、退出");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					add();
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
				break;
			}
			// 登录名唯一性
			if (login_name.equals(s2[i])) {
				System.out.println("该登录名已注册过！！");
				System.out.println("添加失败！\n请选择：1、重新添加   2、返回管理员管理页面  3、退出");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					add();
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
				break;
			} else if (!login_name.equals(s2[i])) {
				// 不重复并且长度正确
				ch = login_name.toCharArray();
				for (int j = 0; j < ch.length; j++) {
					// 不能以数字开头
					if (Character.isDigit(ch[0])) {
						System.out.println("登录名不能以数字开头，由字母、数字、特殊字符组成，！！");
						System.out.println("添加失败！\n请选择：1、重新添加   2、返回管理员管理页面  3、退出");
						Scanner sc1 = new Scanner(System.in);
						switch (sc1.nextInt()) {
						case 1:
							add();
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
						checkPwd();
					}
				}
			}
		}
	}

	/*************** 检查登录密码 ******************/
	/**
	 * 不能与登陆名称相同，而且必须是6-12位
	 */
	public void checkPwd() throws IOException {
		String s, s1 = "";
		String[] s2 = null;
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		// 先获得登录名
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", login_name=") != -1 && s.indexOf(", pawd=") != -1) {
				String str = s.substring(s.indexOf(", login_name=") + 13, s.indexOf(", pawd="));
				s1 += str + " ";
			}
		}
		s2 = s1.split(" ");
		for (int i = 0; i < s2.length; i++) {
			// 密码长度必须是6-12位
			if (pawd.length() < 6 || pawd.length() > 12) {
				System.out.println("密码长度必须是6-12位！！");
				System.out.println("添加失败！\n请选择：1、重新添加   2、返回管理员管理页面  3、退出");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					add();
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
			// 密码与登录名相同
			if (pawd.equals(s2[i])) {
				System.out.println("密码与登录名相同！！");
				System.out.println("添加失败！\n请选择：1、重新添加   2、返回管理员管理页面  3、退出");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					add();
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
				saveData();
			}
		}
	}

	public void saveData() throws IOException {
		list.add(new Sign(name, id, gendar, age, address, tellnumber, login_name, pawd, state));
		for (Sign sign : list) {
			try {
				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("E:\\SignIn.txt", true), "utf-8"));
				bw.newLine();
				bw.write(sign.toString());
				bw.flush();
				bw.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("添加成功！！");
		System.out.println("请选择：1、返回管理员管理界面   2、继续添加  3、退出");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			new AdminManager().Manager();
			break;
		case 2:
			add();
			break;
		case 3:
			System.out.println("谢谢，欢迎下次使用！");
			break;
		default:
			break;
		}
	}
}
