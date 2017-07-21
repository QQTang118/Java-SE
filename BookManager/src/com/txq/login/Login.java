package com.txq.login;

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
import com.txq.administrator.Administrator;
import com.txq.sign_in.SignIn;

/**
 * 登录界面
 * 
 * @author i123t
 *
 */
public class Login {
	Scanner sc = new Scanner(System.in);
	RandomTest rdt = new RandomTest();
	String r = rdt.random();
	String name, pwd, check, id;
	String s, s0 = null, s1 = "", s2 = "", s5, str, str1;// s1:放登录名 s2:放密码
	BufferedReader br;
	String[] s3 = null;// 以空格分割后的登录名
	String[] s4 = null;// 以空格分割后的密码
	String[] s6 = null;
	List<String> list = new LinkedList<String>();

	/******** 输入登录名称和密码、验证码 ****************/
	public void dengLu() throws IOException {
		System.out.println("请输入登录名：");
		name = sc.next();// 登录名
		System.out.println("请输入密码：");
		pwd = sc.next();// 密码
		System.out.println("验证码：" + r);
		System.out.println("请输入验证码：");
		check = sc.next();// 验证码
		checkVerify();

	}

	/******* 验证验证码 ****************/
	public void checkVerify() throws IOException {
		if (check.equals(r)) {
			readMsg();
		} else {
			System.out.println("验证码错误！！");
			dengLu();
		}
	}

	/********** 当用户名和密码，验证码都正确时而且用户状态为1 *******************/
	public void readMsg() throws IOException {
		int name_count = 0, pwd_count = 0;
		// 读取数据
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt")));
		while ((s = br.readLine()) != null) {
			// s1:放登录名 s2:放密码
			if (s.indexOf(", login_name=") != -1 && s.indexOf(", pawd=") != -1) {
				str = s.substring(s.indexOf(", login_name=") + 13, s.indexOf(", pawd="));
				s1 += str + " ";
			} else {
				s1 += s + "";
			}
			if (s.indexOf(", pawd=") != -1 && s.indexOf(", state=") != -1) {
				str1 = s.substring(s.indexOf(", pawd=") + 7, s.indexOf(", state="));
				s1 += str1 + " ";
			}
		}
		s3 = s1.split(" ");// 以空格分割后的登录名
		for (int i = 0; i < s3.length; i++) {
			if (name.equals(s3[i])) {
				name_count++;
				System.out.println("用户名验证正确！！");
			}

			if (pwd.equals(s3[i])) {
				pwd_count++;
				System.out.println("密码验证正确！！");
			}
		}
		if ((name_count + pwd_count) >= 2)

		{
			System.out.println("恭喜你！成功登录~~~~");
			new Administrator().adminManager();
		} else {
			System.out.println("验证失败~~~");
		}

	}

	/********* 忘记密码 ********************/
	/**
	 * 根据用户名和id去查找密码，<br/>
	 * 并提示用户修改密码，如果用户选择修改则进行密码修改否则退出该功能。
	 * 
	 */
	public void forgetPwd() throws IOException {
		int d = 0;
		String str = "", str1 = "", str2 = "";
		System.out.println("请输入登录名：");
		name = sc.next();// 登录名
		System.out.println("请输入ID：");
		id = sc.next();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "uft-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", id=") != -1 && s.indexOf(", gendar=") != -1) {
				str = s.substring(s.indexOf(", id=") + 5, s.indexOf(", gendar="));
			}
			if (s.indexOf(", login_name=") != -1 && s.indexOf(", pawd=") != -1) {
				str1 = s.substring(s.indexOf(", login_name=") + 13, s.indexOf(", pawd="));
			}
			// 放密码
			if (s.indexOf(", pawd=") != -1 && s.indexOf(", state=") != -1) {
				str2 = s.substring(s.indexOf(", pawd=") + 7, s.indexOf(", state="));
			}

		}
		if (id.equals(str) && name.equals(str1)) {

			d++;
		} else {
			System.out.println("输入错误！！");
			System.out.println("1、重新登录     2、忘记密码     3、退出");
			int sc1 = sc.nextInt();
			switch (sc1) {
			case 1:
				dengLu();
				break;
			case 2:
				forgetPwd();
				break;
			case 3:
				System.out.println("谢谢，欢迎下次使用！");
				break;
			default:
				break;
			}
		}
		if (d == 1) {
			System.out.println("原密码是：  " + str2);
			System.out.println("1、修改密码   2、退出");
			int a = sc.nextInt();
			switch (a) {
			case 1:
				changePwd();
				break;
			case 2:
				System.out.println("谢谢，欢迎下次使用！");
				break;
			default:
				break;
			}
		}
	}

	/******* 修改密码 ***************/

	public void changePwd() throws IOException {
		String str = null;
		BufferedWriter bw;
		System.out.println("请输入新密码：");
		String id = sc.next();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			s0 = s;
			if (s.indexOf(", pawd=") != -1 && s.indexOf(", state=") != -1) {
				str = s.substring(s.indexOf(", pawd=") + 7, s.indexOf(", state="));
			}
			if (id.equals(str)) {
				System.out.println("新密码不能与原密码相同！！！");
				System.out.println("1、重新输入     2、登录     3、退出");
				int sc1 = sc.nextInt();
				switch (sc1) {
				case 1:
					changePwd();
					break;
				case 2:
					dengLu();
					break;
				case 3:
					System.out.println("谢谢，欢迎下次使用！");
					break;
				default:
					break;
				}
			}

		}
		if (id.length() <= 12 && id.length() >= 6) {
			s0 = s0.substring(0, s0.indexOf(", pawd=") + 7) + id + s0.substring(s0.indexOf(", state="));
			list.add(s0);
			for (String string : list) {
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\SignIn.txt"), "utf-8"));
				bw.newLine();
				bw.write(string);
				bw.flush();
			}
			System.out.println("密码修改成功！！！");
			System.out.println("1、登录     2、注册     3、退出");
			int sc1 = sc.nextInt();
			switch (sc1) {
			case 1:
				dengLu();
				break;
			case 2:
				new SignIn().zhuCe();
				break;
			case 3:
				System.out.println("谢谢，欢迎下次使用！");
				break;
			default:
				break;
			}
		} else {
			System.out.println("密码长度应在6-12位！！！");
			System.out.println("1、重新输入     2、登录     3、退出");
			int sc1 = sc.nextInt();
			switch (sc1) {
			case 1:
				changePwd();
				break;
			case 2:
				dengLu();
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