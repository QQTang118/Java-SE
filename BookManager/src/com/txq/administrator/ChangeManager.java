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
 * �޸Ĺ���Ա��Ϣ<br/>
 * �޸�:�ȸ����û�id��Ų�ѯ�û���Ϣ��Ȼ���ٽ����޸ģ�<br/>
 * �޸�ʱͬ����Ҫ���������Ϣ�����ж�<br/>
 * �޸ĳɹ��򸲸�ԭ���û����ݡ�������������Ϣ��ʾ��<br/>
 * 
 * @author i123t
 *
 */
public class ChangeManager {
	Scanner sc = new Scanner(System.in);
	String s, str, pwd, str1, str2, s1, s3;// s3:������
	String[] s2;
	BufferedReader br;
	BufferedWriter bw;
	String name;// ����
	String id;// Id
	Boolean gendar;// �Ա�
	Integer age;// ����
	String address;// ��ͥסַ
	String tellnumber;// �ֻ���
	String login_name;// ��¼��
	String pawd;// ��¼����
	List<String> list = new LinkedList<String>();// ��String����

	public void change() throws IOException {
		System.out.println("************�޸Ĺ���Ա��Ϣ******************");
		System.out.println("������Ҫ�޸ĵ�Id��");
		id = sc.nextLine();
		System.out.println("�������Id����Ӧ�����룺");
		pwd = sc.nextLine();
		// ��Ҫ���������Ϣ�����ж�
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
			System.out.println("���û����ڣ�");
			changeMsg();
		} else {
			System.out.println("�����û������ڣ�����������~~~");
			change();
		}

	}

	/********** �޸ĳɹ��򸲸�ԭ���û����� ******************/
	public void changeMsg() throws IOException {
		System.out.println("**********�޸�����************");
		System.out.println("1���޸�Id\n2���޸�����\n3���޸�����\n4���޸��Ա�\n5���޸ļ�ͥסַ\n6���޸���ϵ�绰\n7���޸ĵ�¼��\n8���޸�����");
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

	/*********** 1���޸�Id **************************/
	public void changeId() throws IOException {
		System.out.println("************�޸�*****************");
		System.out.println("������Id��");
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
			System.out.println("�޸ĳɹ���\n��ѡ��1���޸�����ѡ��  2�����ع���Ա����ҳ��  3���˳�");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				changeMsg();
				break;
			case 2:
				new AdminManager().Manager();
				break;
			case 3:
				System.out.println("лл����ӭ�´�ʹ�ã�");
				break;
			default:
				break;
			}
		} else {
			System.out.println("��Id�Ѵ��ڣ�����");
			System.out.println("�޸�ʧ�ܣ�\n��ѡ��1�������޸��û���   2���޸�����ѡ��  3���˳�");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				changeId();
				break;
			case 2:
				changeMsg();
				break;
			case 3:
				System.out.println("лл����ӭ�´�ʹ�ã�");
				break;
			default:
				break;
			}
		}
	}

	/*********** 2���޸����� **************************/
	public void changeName() throws IOException {
		System.out.println("************�޸�*****************");
		System.out.println("������������");
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
		System.out.println("�޸ĳɹ���\n��ѡ��1���޸�����ѡ��  2�����ع���Ա����ҳ��  3���˳�");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new AdminManager().Manager();
			break;
		case 3:
			System.out.println("лл����ӭ�´�ʹ�ã�");
			break;
		default:
			break;
		}
	}

	/*********** 3���޸��Ա� **************************/
	public void changeSex() throws IOException {
		System.out.println("************�޸�*****************");
		System.out.println("�������Ա�");
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
		System.out.println("�޸ĳɹ���\n��ѡ��1���޸�����ѡ��  2�����ع���Ա����ҳ��  3���˳�");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new AdminManager().Manager();
			break;
		case 3:
			System.out.println("лл����ӭ�´�ʹ�ã�");
			break;
		default:
			break;
		}
	}

	/*********** 4���޸����� **************************/
	public void changeAge() throws IOException {
		System.out.println("************�޸�*****************");
		System.out.println("���������䣺");
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
		System.out.println("�޸ĳɹ���\n��ѡ��1���޸�����ѡ��  2�����ع���Ա����ҳ��  3���˳�");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new AdminManager().Manager();
			break;
		case 3:
			System.out.println("лл����ӭ�´�ʹ�ã�");
			break;
		default:
			break;
		}
	}

	/*********** 5���޸ļ�ͥ��ַ **************************/
	public void changeAddress() throws IOException {
		System.out.println("************�޸�*****************");
		System.out.println("�������ͥ��ַ��");
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
		System.out.println("�޸ĳɹ���\n��ѡ��1���޸�����ѡ��  2�����ع���Ա����ҳ��  3���˳�");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new AdminManager().Manager();
			break;
		case 3:
			System.out.println("лл����ӭ�´�ʹ�ã�");
			break;
		default:
			break;
		}
	}

	/*********** 6���޸ĵ绰 **************************/
	public void changeNumber() throws IOException {
		System.out.println("************�޸�*****************");
		System.out.println("��������ϵ�绰��");
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
		System.out.println("�޸ĳɹ���\n��ѡ��1���޸�����ѡ��  2�����ع���Ա����ҳ��  3���˳�");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new AdminManager().Manager();
			break;
		case 3:
			System.out.println("лл����ӭ�´�ʹ�ã�");
			break;
		default:
			break;
		}
	}

	/*********** 7���޸��û��� **************************/
	public void changeLname() throws IOException {
		System.out.println("************�޸�*****************");
		System.out.println("�������û�����");
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
			// ������3-8λ
			if (login_name.length() < 3 || login_name.length() > 8) {
				System.out.println("��¼��������3-8λ����");
				System.out.println("�޸�ʧ�ܣ�\n��ѡ��1�������޸��û���   2���޸�����ѡ��  3���˳�");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					changeLname();
					break;
				case 2:
					changeMsg();
					break;
				case 3:
					System.out.println("лл����ӭ�´�ʹ�ã�");
					break;
				default:
					break;
				}
				break;
			}
			// ��¼��Ψһ��
			if (login_name.equals(s2[i])) {
				System.out.println("�õ�¼����ע�������");
				System.out.println("�޸�ʧ�ܣ�\n��ѡ��1�������޸��û���   2���޸�����ѡ��  3���˳�");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					changeLname();
					break;
				case 2:
					changeMsg();
					break;
				case 3:
					System.out.println("лл����ӭ�´�ʹ�ã�");
					break;
				default:
					break;
				}
				break;
			} else if (!login_name.equals(s2[i])) {
				// ���ظ����ҳ�����ȷ
				ch = login_name.toCharArray();
				for (int j = 0; j < ch.length; j++) {
					// ���������ֿ�ͷ
					if (Character.isDigit(ch[0])) {
						System.out.println("��¼�����������ֿ�ͷ������ĸ�����֡������ַ���ɣ�����");
						System.out.println("�޸�ʧ�ܣ�\n��ѡ��1�������޸��û���   2���޸�����ѡ��  3���˳�");
						Scanner sc1 = new Scanner(System.in);
						switch (sc1.nextInt()) {
						case 1:
							changeLname();
							break;
						case 2:
							changeMsg();
							break;
						case 3:
							System.out.println("лл����ӭ�´�ʹ�ã�");
							break;
						default:
							break;
						}
					} else {
						// ������
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
						System.out.println("�޸ĳɹ���\n��ѡ��1���޸�����ѡ��  2�����ع���Ա����ҳ��  3���˳�");
						Scanner sc1 = new Scanner(System.in);
						switch (sc1.nextInt()) {
						case 1:
							changeMsg();
							break;
						case 2:
							new AdminManager().Manager();
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
		}
	}

	/*********** 8���޸����� **************************/
	public void changePwd() throws IOException {
		System.out.println("************�޸�*****************");
		System.out.println("���������룺");
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
			// ���볤�ȱ�����6-12λ
			if (pawd.length() < 6 || pawd.length() > 12) {
				System.out.println("���볤�ȱ�����6-12λ����");
				System.out.println("�޸�ʧ�ܣ�\n��ѡ��1�������޸�����   2���޸�����ѡ��  3���˳�");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					changePwd();
					break;
				case 2:
					changeMsg();
					break;
				case 3:
					System.out.println("лл����ӭ�´�ʹ�ã�");
					break;
				default:
					break;
				}
			} // �������¼����ͬ
			if (pawd.equals(s2[i])) {
				System.out.println("�������¼����ͬ����");
				System.out.println("�޸�ʧ�ܣ�\n��ѡ��1�������޸�����   2���޸�����ѡ��  3���˳�");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					changePwd();
					break;
				case 2:
					changeMsg();
					break;
				case 3:
					System.out.println("лл����ӭ�´�ʹ�ã�");
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
				System.out.println("�޸ĳɹ���\n��ѡ��1���޸�����ѡ��  2�����ع���Ա����ҳ��  3���˳�");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					changeMsg();
					break;
				case 2:
					new AdminManager().Manager();
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
}
