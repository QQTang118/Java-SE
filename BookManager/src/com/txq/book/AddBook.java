package com.txq.book;

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

/**
 * 1.idΨһ<br/>
 * 2.���������������������������������֣�����������Ӣ��������Ҫ����ַ�<br/>
 * 3.����ֻ��������<br/>
 * 4.������ֻҪ��֤�ǿռ���<br/>
 * 6.����û�ѡ��1��java 2:.net 3:android 4:ios<br/>
 * ���е���Ϣ��֤ͨ��ʱ����Ҫ����Щ��Ϣ��ͼ��JavaBean����
 * 
 * @author i123t
 *
 */
public class AddBook {
	Scanner sc = new Scanner(System.in);
	String s, str;
	String id;// ͼ����
	String bname;// ͼ������
	String author;// ����
	String money;// ����
	String publishing;// ������
	String category;// ���
	List<BookMsg> list = new LinkedList<BookMsg>();
	BufferedReader br;// ��ȡ�ļ�
	BufferedWriter bw;// д���ļ�

	public void add() throws IOException {
		System.out.println("************���ͼ��************");
		File file = new File("E:\\Book.txt");
		if (file.isFile()) {
			System.out.println("������ͼ����Id��");
			id = sc.next();
			System.out.println("������ͼ�����ƣ�");
			bname = sc.next();
			System.out.println("���������ߣ�");
			author = sc.next();
			System.out.println("������ͼ�鵥�ۣ�");
			money = sc.next();
			System.out.println("����������磺");
			publishing = sc.next();
			System.out.println("������ͼ�����\n1��java    2:.net    3:android    4:ios");
			category = sc.next();
			checkId();
		} else {
			file.createNewFile();
			add();
		}
	}

	/********** ���idΨһ ***********************/
	public void checkId() throws IOException {
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf("BookMsg [id=") != -1 && s.indexOf(", bname=") != -1) {
				str = s.substring(s.indexOf("BookMsg [id=") + 12, s.indexOf(", bname="));
			}
		}
		if (id.equals(str)) {
			System.out.println("��Id�Ѵ��ڣ���");
			System.out.println("���ʧ�ܣ�������ѡ��\n1���������     2������ͼ�����ҳ��     3���˳�");
			switch (sc.nextInt()) {
			case 1:
				add();
				break;
			case 2:
				new BookManager().bookManger();
				break;
			case 3:
				System.out.println("ллʹ�ã�");
				break;
			default:
				break;
			}
		} else {
			checkAuthor();
		}

	}

	/********** ��������� ***********************/
	/**
	 * ����������������������������������<br/>
	 * ����������Ӣ��������Ҫ����ַ�
	 * 
	 * @throws IOException
	 */
	public void checkAuthor() throws IOException {
		int eCount = 0, cCount = 0;
		char[] ch = author.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isLetterOrDigit(ch[i])) {
				eCount++;
			} else {
				cCount++;
			}

		}
		if (eCount >= 5 || cCount >= 2 || !author.isEmpty()) {
			checkMoney();
		} else {

			System.out.println("�������ȴ��󣡣�");
			System.out.println("���ʧ�ܣ�������ѡ��\n1���������     2������ͼ�����ҳ��     3���˳�");
			switch (sc.nextInt()) {
			case 1:
				add();
				break;
			case 2:
				new BookManager().bookManger();
				break;
			case 3:
				System.out.println("ллʹ�ã�");
				break;
			default:
				break;
			}
		}
	}

	/********** ��鵥�� ***********************/
	public void checkMoney() throws IOException {
		char[] ch = money.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (!Character.isDigit(ch[i])) {
				System.out.println("����ӦΪ���֣���");
				System.out.println("���ʧ�ܣ�������ѡ��\n1���������     2������ͼ�����ҳ��     3���˳�");
				switch (sc.nextInt()) {
				case 1:
					add();
					break;
				case 2:
					new BookManager().bookManger();
					break;
				case 3:
					System.out.println("ллʹ�ã�");
					break;
				default:
					break;
				}
			} else {
				checkPub();
			}
		}
	}

	/********** �������� ***********************/
	public void checkPub() throws IOException {
		if (publishing.isEmpty()) {
			System.out.println("�����粻��Ϊ�գ�����");
			System.out.println("���ʧ�ܣ�������ѡ��\n1���������     2������ͼ�����ҳ��     3���˳�");
			switch (sc.nextInt()) {
			case 1:
				add();
				break;
			case 2:
				new BookManager().bookManger();
				break;
			case 3:
				System.out.println("ллʹ�ã�");
				break;
			default:
				break;
			}
		} else {
			saveMsg();
		}

	}

	/********** �洢���� ***********************/
	public void saveMsg() throws IOException {
		list.add(new BookMsg(id, bname, author, money, publishing, category));
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Book.txt", true), "utf-8"));
		for (BookMsg bookMsg : list) {
			bw.newLine();
			bw.write(bookMsg.toString());
			bw.flush();
			bw.close();
		}
		list.clear();
		;
		System.out.println("��ӳɹ���������ѡ��\n1���������     2������ͼ�����ҳ��     3���˳�");
		switch (sc.nextInt()) {
		case 1:
			add();
			break;
		case 2:
			new BookManager().bookManger();
			break;
		case 3:
			System.out.println("ллʹ�ã�");
			break;
		default:
			break;
		}
	}
}
