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
 * ���ӹ���Ա��Ϣ��<br/>
 * ����:�ο�����Ա��ע�Ṧ��
 * 
 * @author i123t
 *
 */
public class AddManager {
	Scanner sc = new Scanner(System.in);
	BufferedReader br;
	String name;// ����
	String id;// Id
	Boolean gendar;// �Ա�
	int age;// ����
	String address;// ��ͥסַ
	String tellnumber;// �ֻ���
	String login_name;// ��¼��
	String pawd;// ��¼����
	int state;// ״̬
	List<Sign> list = new LinkedList<Sign>();

	public void add() throws IOException {
		System.out.println("*****************���*************************");
		File file = new File("E:\\SignIn.txt");
		if (file.isFile()) {
			System.out.println("������id:");
			id = sc.next();
			System.out.println("����������:");
			name = sc.next();
			System.out.println("�������Ա�:��trueΪ�У�falseΪŮ��");
			gendar = sc.nextBoolean();
			System.out.println("����������:");
			age = sc.nextInt();
			System.out.println("�������ͥסַ:");
			address = sc.next();
			System.out.println("��������ϵ�绰:");
			tellnumber = sc.next();
			System.out.println("�������¼��:");
			login_name = sc.next();
			System.out.println("����������:");
			pawd = sc.next();
			System.out.println("������״̬:\nPS���û�ֻ������״̬��1����ʾ����   2����ʾ����   3����ʾ��ְ    Ĭ��״̬Ϊ��1");
			state = sc.nextInt();
			checkID();
		}
	}

	/*************** ���ID���ظ� ******************/
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
				System.out.println("Id���������֣���");
				System.out.println("���ʧ�ܣ�\n��ѡ��1���������   2�����ع���Ա����ҳ��  3���˳�");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					add();
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
				break;
			}
			if (id.equals(s2[i])) {
				System.out.println("��Id�Ѵ��ڣ���");
				System.out.println("���ʧ�ܣ�\n��ѡ��1���������   2�����ع���Ա����ҳ��  3���˳�");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					add();
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
				break;
			} else {
				checkName();
			}
		}

	}

	/*************** ���������Ϊ�� ******************/
	public void checkName() throws IOException {
		if (name.isEmpty()) {
			System.out.println("��������Ϊ�գ�");
			System.out.println("���ʧ�ܣ�\n��ѡ��1���������   2�����ع���Ա����ҳ��  3���˳�");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				add();
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
			checkAge();
		}
	}

	/*************** ������䲻Ϊ�� ******************/
	public void checkAge() throws IOException {
		if (age <= 0 || age > 100) {
			System.out.println("����Ӧ��1~100֮�䣡");
			System.out.println("���ʧ�ܣ�\n��ѡ��1���������   2�����ع���Ա����ҳ��  3���˳�");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				add();
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
			checkNumber();
		}
	}

	/*************** ����ֻ��� ******************/
	public void checkNumber() throws IOException {
		if (tellnumber.length() > 12 || tellnumber.length() < 10) {
			System.out.println("�ֻ���Ӧ��11λ��");
			System.out.println("���ʧ�ܣ�\n��ѡ��1���������   2�����ع���Ա����ҳ��  3���˳�");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				add();
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
			checkLoginName();
		}
	}

	/*************** ����¼�� ******************/
	/**
	 * ����ĸ�����֡������ַ���ɣ�<br/>
	 * ���������ֿ�ͷ��������3-8λ�����Ҳ������ظ��ĵ�¼����
	 * 
	 * @throws IOException
	 */

	public void checkLoginName() throws IOException {
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		String s, s1 = "";
		String[] s2 = null;
		while ((s = br.readLine()) != null) {
			// ����ȡ���ַ��ָ����
			if (s.indexOf(", login_name=") != -1 && s.indexOf(", pawd=") != -1) {
				String str = s.substring(s.indexOf(", login_name=") + 13, s.indexOf(", pawd="));
				s1 += str + " ";
			}
		}
		s2 = s1.split(" ");
		char[] ch;
		for (int i = 0; i < s2.length; i++) {
			// ������3-8λ
			if (login_name.length() < 3 || login_name.length() > 8) {
				System.out.println("��¼��������3-8λ����");
				System.out.println("���ʧ�ܣ�\n��ѡ��1���������   2�����ع���Ա����ҳ��  3���˳�");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					add();
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
				break;
			}
			// ��¼��Ψһ��
			if (login_name.equals(s2[i])) {
				System.out.println("�õ�¼����ע�������");
				System.out.println("���ʧ�ܣ�\n��ѡ��1���������   2�����ع���Ա����ҳ��  3���˳�");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					add();
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
				break;
			} else if (!login_name.equals(s2[i])) {
				// ���ظ����ҳ�����ȷ
				ch = login_name.toCharArray();
				for (int j = 0; j < ch.length; j++) {
					// ���������ֿ�ͷ
					if (Character.isDigit(ch[0])) {
						System.out.println("��¼�����������ֿ�ͷ������ĸ�����֡������ַ���ɣ�����");
						System.out.println("���ʧ�ܣ�\n��ѡ��1���������   2�����ع���Ա����ҳ��  3���˳�");
						Scanner sc1 = new Scanner(System.in);
						switch (sc1.nextInt()) {
						case 1:
							add();
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
						checkPwd();
					}
				}
			}
		}
	}

	/*************** ����¼���� ******************/
	/**
	 * �������½������ͬ�����ұ�����6-12λ
	 */
	public void checkPwd() throws IOException {
		String s, s1 = "";
		String[] s2 = null;
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));
		// �Ȼ�õ�¼��
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", login_name=") != -1 && s.indexOf(", pawd=") != -1) {
				String str = s.substring(s.indexOf(", login_name=") + 13, s.indexOf(", pawd="));
				s1 += str + " ";
			}
		}
		s2 = s1.split(" ");
		for (int i = 0; i < s2.length; i++) {
			// ���볤�ȱ�����6-12λ
			if (pawd.length() < 6 || pawd.length() > 12) {
				System.out.println("���볤�ȱ�����6-12λ����");
				System.out.println("���ʧ�ܣ�\n��ѡ��1���������   2�����ع���Ա����ҳ��  3���˳�");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					add();
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
			// �������¼����ͬ
			if (pawd.equals(s2[i])) {
				System.out.println("�������¼����ͬ����");
				System.out.println("���ʧ�ܣ�\n��ѡ��1���������   2�����ع���Ա����ҳ��  3���˳�");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					add();
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
		System.out.println("��ӳɹ�����");
		System.out.println("��ѡ��1�����ع���Ա�������   2���������  3���˳�");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			new AdminManager().Manager();
			break;
		case 2:
			add();
			break;
		case 3:
			System.out.println("лл����ӭ�´�ʹ�ã�");
			break;
		default:
			break;
		}
	}
}
