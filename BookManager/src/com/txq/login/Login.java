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
 * ��¼����
 * 
 * @author i123t
 *
 */
public class Login {
	Scanner sc = new Scanner(System.in);
	RandomTest rdt = new RandomTest();
	String r = rdt.random();
	String name, pwd, check, id;
	String s, s0 = null, s1 = "", s2 = "", s5, str, str1;// s1:�ŵ�¼�� s2:������
	BufferedReader br;
	String[] s3 = null;// �Կո�ָ��ĵ�¼��
	String[] s4 = null;// �Կո�ָ�������
	String[] s6 = null;
	List<String> list = new LinkedList<String>();

	/******** �����¼���ƺ����롢��֤�� ****************/
	public void dengLu() throws IOException {
		System.out.println("�������¼����");
		name = sc.next();// ��¼��
		System.out.println("���������룺");
		pwd = sc.next();// ����
		System.out.println("��֤�룺" + r);
		System.out.println("��������֤�룺");
		check = sc.next();// ��֤��
		checkVerify();

	}

	/******* ��֤��֤�� ****************/
	public void checkVerify() throws IOException {
		if (check.equals(r)) {
			readMsg();
		} else {
			System.out.println("��֤����󣡣�");
			dengLu();
		}
	}

	/********** ���û��������룬��֤�붼��ȷʱ�����û�״̬Ϊ1 *******************/
	public void readMsg() throws IOException {
		int name_count = 0, pwd_count = 0;
		// ��ȡ����
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt")));
		while ((s = br.readLine()) != null) {
			// s1:�ŵ�¼�� s2:������
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
		s3 = s1.split(" ");// �Կո�ָ��ĵ�¼��
		for (int i = 0; i < s3.length; i++) {
			if (name.equals(s3[i])) {
				name_count++;
				System.out.println("�û�����֤��ȷ����");
			}

			if (pwd.equals(s3[i])) {
				pwd_count++;
				System.out.println("������֤��ȷ����");
			}
		}
		if ((name_count + pwd_count) >= 2)

		{
			System.out.println("��ϲ�㣡�ɹ���¼~~~~");
			new Administrator().adminManager();
		} else {
			System.out.println("��֤ʧ��~~~");
		}

	}

	/********* �������� ********************/
	/**
	 * �����û�����idȥ�������룬<br/>
	 * ����ʾ�û��޸����룬����û�ѡ���޸�����������޸ķ����˳��ù��ܡ�
	 * 
	 */
	public void forgetPwd() throws IOException {
		int d = 0;
		String str = "", str1 = "", str2 = "";
		System.out.println("�������¼����");
		name = sc.next();// ��¼��
		System.out.println("������ID��");
		id = sc.next();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "uft-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", id=") != -1 && s.indexOf(", gendar=") != -1) {
				str = s.substring(s.indexOf(", id=") + 5, s.indexOf(", gendar="));
			}
			if (s.indexOf(", login_name=") != -1 && s.indexOf(", pawd=") != -1) {
				str1 = s.substring(s.indexOf(", login_name=") + 13, s.indexOf(", pawd="));
			}
			// ������
			if (s.indexOf(", pawd=") != -1 && s.indexOf(", state=") != -1) {
				str2 = s.substring(s.indexOf(", pawd=") + 7, s.indexOf(", state="));
			}

		}
		if (id.equals(str) && name.equals(str1)) {

			d++;
		} else {
			System.out.println("������󣡣�");
			System.out.println("1�����µ�¼     2����������     3���˳�");
			int sc1 = sc.nextInt();
			switch (sc1) {
			case 1:
				dengLu();
				break;
			case 2:
				forgetPwd();
				break;
			case 3:
				System.out.println("лл����ӭ�´�ʹ�ã�");
				break;
			default:
				break;
			}
		}
		if (d == 1) {
			System.out.println("ԭ�����ǣ�  " + str2);
			System.out.println("1���޸�����   2���˳�");
			int a = sc.nextInt();
			switch (a) {
			case 1:
				changePwd();
				break;
			case 2:
				System.out.println("лл����ӭ�´�ʹ�ã�");
				break;
			default:
				break;
			}
		}
	}

	/******* �޸����� ***************/

	public void changePwd() throws IOException {
		String str = null;
		BufferedWriter bw;
		System.out.println("�����������룺");
		String id = sc.next();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			s0 = s;
			if (s.indexOf(", pawd=") != -1 && s.indexOf(", state=") != -1) {
				str = s.substring(s.indexOf(", pawd=") + 7, s.indexOf(", state="));
			}
			if (id.equals(str)) {
				System.out.println("�����벻����ԭ������ͬ������");
				System.out.println("1����������     2����¼     3���˳�");
				int sc1 = sc.nextInt();
				switch (sc1) {
				case 1:
					changePwd();
					break;
				case 2:
					dengLu();
					break;
				case 3:
					System.out.println("лл����ӭ�´�ʹ�ã�");
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
			System.out.println("�����޸ĳɹ�������");
			System.out.println("1����¼     2��ע��     3���˳�");
			int sc1 = sc.nextInt();
			switch (sc1) {
			case 1:
				dengLu();
				break;
			case 2:
				new SignIn().zhuCe();
				break;
			case 3:
				System.out.println("лл����ӭ�´�ʹ�ã�");
				break;
			default:
				break;
			}
		} else {
			System.out.println("���볤��Ӧ��6-12λ������");
			System.out.println("1����������     2����¼     3���˳�");
			int sc1 = sc.nextInt();
			switch (sc1) {
			case 1:
				changePwd();
				break;
			case 2:
				dengLu();
				break;
			case 3:
				System.out.println("лл����ӭ�´�ʹ�ã�");
				break;
			default:
				break;
			}
		}
	}
}