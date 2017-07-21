package com.txq.book;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.txq.administrator.AdminManager;
import com.txq.administrator.Administrator;

/**
 * ��Ϊid��ѯ��ͼ�����Ʋ�ѯ
 * 
 * @author i123t
 *
 */
public class FingBook {
	Scanner sc = new Scanner(System.in);
	String id, s, s1, str;
	BufferedReader br;

	public void find() throws IOException {
		System.out.println("************��ѯͼ��************");
		System.out.println("������Ҫ��ѯ��ͼ��Id��");
		id = sc.next();
		int c = 0;
		br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf("BookMsg [id=") != -1 && s.indexOf(", bname=") != -1) {
				str = s.substring(s.indexOf("BookMsg [id=") + 12, s.indexOf(", bname="));
				s1 = s.substring(s.indexOf("Sign"));
			}
			if (id.equals(str)) {
				c++;
				System.out.println("��ѯ�ɹ�����\n" + s1);
				System.out.println("��ѡ��\n1��������ѯ    2������ͼ�����ҳ��     3��������ҳ��");
				switch (sc.nextInt()) {
				case 1:
					find();
					break;
				case 2:
					new BookManager().bookManger();
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
			System.out.println("��ѡ��\n1��������ѯ    2������ͼ�����ҳ��     3��������ҳ��");
			switch (sc.nextInt()) {
			case 1:
				find();
				break;
			case 2:
				new BookManager().bookManger();
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
