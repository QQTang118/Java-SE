package com.txq.login;

import java.io.IOException;
import java.util.Scanner;

import com.txq.sign_in.SignIn;

/**
 * 登录界面
 * 
 * @author i123t
 *
 */

public class LoginMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("欢迎来到图书管理系统~~~");
		System.out.println("请先登录或注册管理员~~~");
		System.out.println("请输入1或2~~~~");
		toPlay();
	}

	public static void toPlay() throws IOException {

		System.out.println("1、登录\n2、注册");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			new Login().dengLu();
			break;
		case 2:
			new SignIn().zhuCe();
			break;
		default:
			System.out.println("输入错误！！请重新输入~~~");
			toPlay();
			break;
		}
	}
}
