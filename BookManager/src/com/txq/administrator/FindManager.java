package com.txq.administrator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ��ѯ����Ա��Ϣ<br/>
 * ��ѯ:��Ϊid��ѯ�͵�¼���Ʋ�ѯ
 * 
 * @author i123t
 *
 */
public class FindManager {
	Scanner sc = new Scanner(System.in);
	String id, s, lname, str, s1, s2;
	String[] s3;

	public void find() throws IOException {
		System.out.println("**********��ѯ****************");
		System.out.println("�����룺\n1������Id��ѯ    2�����ݵ�¼����ѯ");
		switch (sc.nextInt()) {
		case 1:
			findId();
			break;
		case 2:
			findLoginName();
			break;
		default:
			System.out.println("�����������������~~~");
			find();
			break;
		}
	}

	/********* ����Id��ѯ *********************/
	@SuppressWarnings("null")
	public void findId() throws IOException {
		System.out.println("������Id��");
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
				System.out.println("��ѯ�ɹ�����\n" + s1);
				System.out.println("��ѡ��\n1��������ѯ    2�����ع���Ա����ҳ��     3��������ҳ��");
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
			System.out.println("��ѯʧ�ܣ�����Id������~~~");
			System.out.println("��ѡ��\n1��������ѯ    2�����ع���Ա����ҳ��     3��������ҳ��");
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

	/********* ���ݵ�¼����ѯ *********************/
	public void findLoginName() throws IOException {
		int c = 0;
		System.out.println("�������¼����");
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
					System.out.println("��ѯ�ɹ�����\n" + s);
				}
			}
		}
		if (c != 0) {

			System.out.println("��ѡ��\n1��������ѯ    2�����ع���Ա����ҳ��     3��������ҳ��");
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
			System.out.println("��ѯʧ�ܣ������û���������~~~");
			System.out.println("��ѡ��\n1��������ѯ    2�����ع���Ա����ҳ��     3��������ҳ��");
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