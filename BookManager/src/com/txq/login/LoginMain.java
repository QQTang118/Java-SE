package com.txq.login;

import java.io.IOException;
import java.util.Scanner;

import com.txq.sign_in.SignIn;

/**
 * ��¼����
 * 
 * @author i123t
 *
 */

public class LoginMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("��ӭ����ͼ�����ϵͳ~~~");
		System.out.println("���ȵ�¼��ע�����Ա~~~");
		System.out.println("������1��2~~~~");
		toPlay();
	}

	public static void toPlay() throws IOException {

		System.out.println("1����¼\n2��ע��");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			new Login().dengLu();
			break;
		case 2:
			new SignIn().zhuCe();
			break;
		default:
			System.out.println("������󣡣�����������~~~");
			toPlay();
			break;
		}
	}
}
