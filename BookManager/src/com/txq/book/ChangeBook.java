package com.txq.book;

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
 * �޸�:�ȸ���ͼ��id��Ų�ѯͼ����Ϣ��Ȼ���ٽ����޸ģ�<br/>
 * �޸�ʱͬ����Ҫ���������Ϣ�����ж�<br/>
 * �޸ĳɹ��򸲸�ԭ��ͼ�����ݡ�������������Ϣ��ʾ��<br/>
 * 
 * @author i123t
 *
 */
public class ChangeBook {
	Scanner sc = new Scanner(System.in);
	String s, s1, str, str1;
	String id;// ͼ����
	String bname;// ͼ������
	String author;// ����
	String money;// ����
	String publishing;// ������
	String category;// ���
	List<String> list = new LinkedList<>();
	BufferedWriter bw;
	BufferedReader br;

	public void change() throws IOException {
		System.out.println("************�޸�ͼ����Ϣ************");
		System.out.println("������ͼ��Id��ţ�");
		id = sc.next();
		// ����ͼ��id��Ų�ѯͼ����Ϣ
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf("BookMsg [id=") != -1 && s.indexOf(", bname=") != -1) {
				str = s.substring(s.indexOf("BookMsg [id=") + 12, s.indexOf(", bname="));
			}
		}
		if (id.equals(str)) {
			str1 = s;
			System.out.println("ͼ�����~~~");
			changeMsg();
		} else {
			System.out.println("���鲻����~~\n���������룺");
			change();
		}
	}

	/********** �޸ĳɹ��򸲸�ԭ���û����� ******************/
	public void changeMsg() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("************�޸�ͼ��************");
		System.out.println("1���޸�Id\n2���޸�ͼ������\n3���޸�����\n4���޸ĵ���\n5���޸ĳ�����\n");
		switch (sc.nextInt()) {
		case 1:
			changeId();
			break;
		case 2:
			changeName();
			break;
		case 3:
			changeAuthor();
			break;
		case 4:
			changeMoney();
			break;
		case 5:
			changePub();
			break;

		default:
			break;
		}
	}

	/*********** 1���޸�Id **************************/
	public void changeId() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("************�޸�*****************");
		System.out.println("������Id��");
		id = sc.next();
		int c = 0;
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf("BookMsg [id=") != -1 && s.indexOf(", bname=") != -1) {
				str = s.substring(s.indexOf("BookMsg [id=") + 12, s.indexOf(", bname="));
				str1 = s;
			}
			if (id.equals(str)) {
				c++;
			}
		}
		if (c == 0) {
			str1 = str1.substring(0, str1.indexOf("BookMsg [id=") + 12) + id
					+ str1.substring(str1.indexOf(", bname="), str1.indexOf("]") + 1);
			list.add(str1);
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Book.txt"), "utf-8"));
			for (String string : list) {
				bw.newLine();
				bw.write(string);
				bw.flush();
			}
			list.clear();
			System.out.println("�޸ĳɹ���\n��ѡ��1���޸�����ѡ��  2������ͼ�����ҳ��  3���˳�");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				changeMsg();
				break;
			case 2:
				new BookManager().bookManger();
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

	/*********** 2���޸�ͼ���� **************************/
	public void changeName() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("************�޸�*****************");
		System.out.println("������������");
		bname = sc.next();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", bname=") != -1 && s.indexOf(", author=") != -1) {
				str = s.substring(s.indexOf(", bname=") + 8, s.indexOf(", author="));
				s1 = str + " ";
				str1 = s;
			}
		}
		str1 = str1.substring(0, str1.indexOf(", bname=") + 8) + bname
				+ str1.substring(str1.indexOf(", author="), str1.indexOf("]") + 1);
		list.add(str1);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Book.txt"), "utf-8"));
		for (String string : list) {
			bw.newLine();
			bw.write(string);
			bw.flush();
		}
		list.clear();
		System.out.println("�޸ĳɹ���\n��ѡ��1���޸�����ѡ��  2������ͼ�����ҳ��  3���˳�");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new BookManager().bookManger();
			break;
		case 3:
			System.out.println("лл����ӭ�´�ʹ�ã�");
			break;
		default:
			break;
		}

	}

	/*********** 3���޸����� **************************/
	public void changeAuthor() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("************�޸�*****************");
		System.out.println("���������ߣ�");
		author = sc.next();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", author=") != -1 && s.indexOf(", money=") != -1) {
				str = s.substring(s.indexOf(", author=") + 9, s.indexOf(", money="));
				str1 = s;
			}
		}
		str1 = str1.substring(0, str1.indexOf(", author=") + 9) + author
				+ str1.substring(str1.indexOf(", money="), str1.indexOf("]") + 1);
		list.add(str1);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Book.txt"), "utf-8"));
		for (String string : list) {
			bw.newLine();
			bw.write(string);
			bw.flush();
		}
		list.clear();
		System.out.println("�޸ĳɹ���\n��ѡ��1���޸�����ѡ��  2������ͼ�����ҳ��  3���˳�");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new BookManager().bookManger();
			break;
		case 3:
			System.out.println("лл����ӭ�´�ʹ�ã�");
			break;
		default:
			break;
		}

	}

	/*********** 4���޸ĵ��� **************************/
	public void changeMoney() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("************�޸�*****************");
		System.out.println("����������磺");
		publishing = sc.next();
		char[] ch;
		int c = 0;
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", money") != -1 && s.indexOf(", publishing=") != -1) {
				str = s.substring(s.indexOf(", money=") + 10, s.indexOf(", publishing="));
				s1 = str + " ";
				str1 = s;
			}
		}
		ch = s1.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isDigit(ch[i])) {
				c++;
			} else {
				System.out.println("���۱��������֣�����");
				System.out.println("�޸�ʧ�ܣ�\n��ѡ��1�������޸ĵ���   2���޸�����ѡ��  3���˳�");
				Scanner sc1 = new Scanner(System.in);
				switch (sc1.nextInt()) {
				case 1:
					changeMoney();
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
		if (c >= 1) {
			str1 = str1.substring(0, str1.indexOf(", money=") + 8) + money
					+ str1.substring(str1.indexOf(", publishing="), str1.indexOf("]") + 1);
			list.add(str1);
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Book.txt"), "utf-8"));
			for (String string : list) {
				bw.newLine();
				bw.write(string);
				bw.flush();
			}
			list.clear();
			System.out.println("�޸ĳɹ���\n��ѡ��1���޸�����ѡ��  2������ͼ�����ҳ��  3���˳�");
			Scanner sc1 = new Scanner(System.in);
			switch (sc1.nextInt()) {
			case 1:
				changeMsg();
				break;
			case 2:
				new BookManager().bookManger();
				break;
			case 3:
				System.out.println("лл����ӭ�´�ʹ�ã�");
				break;
			default:
				break;
			}
		}

	}

	/*********** 5���޸ĳ����� **************************/
	public void changePub() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("************�޸�*****************");
		System.out.println("����������磺");
		publishing = sc.next();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf(", publishing") != -1 && s.indexOf(", date=") != -1) {
				str = s.substring(s.indexOf(", publishing=") + 10, s.indexOf(", date="));
				s1 = str + " ";
				str1 = s;
			}
		}
		str1 = str1.substring(0, str1.indexOf(", publishing=") + 13) + publishing
				+ str1.substring(str1.indexOf(", date="), str1.indexOf("]") + 1);
		list.add(str1);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Book.txt"), "utf-8"));
		for (String string : list) {
			bw.newLine();
			bw.write(string);
			bw.flush();
		}
		list.clear();
		System.out.println("�޸ĳɹ���\n��ѡ��1���޸�����ѡ��  2������ͼ�����ҳ��  3���˳�");
		Scanner sc1 = new Scanner(System.in);
		switch (sc1.nextInt()) {
		case 1:
			changeMsg();
			break;
		case 2:
			new BookManager().bookManger();
			break;
		case 3:
			System.out.println("лл����ӭ�´�ʹ�ã�");
			break;
		default:
			break;
		}

	}

}
