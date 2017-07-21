package com.txq.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ����ͼ��ID����ɾ��
 * 
 * @author i123t
 *
 */
public class DeleteBook {
	Scanner sc = new Scanner(System.in);
	int c = 0;
	String id, s, str;
	List<String> list = new LinkedList<>();

	public void delete() throws IOException, IOException {
		System.out.println("************ɾ��ͼ��************");
		System.out.println("������Ҫɾ����ͼ��Id��");
		id = sc.next();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Book.txt"), "utf-8"));
		while ((s = br.readLine()) != null) {
			if (s.indexOf("BookMsg [id=") != -1 && s.indexOf(", bname=") != -1) {
				str = s.substring(s.indexOf("") + 12, s.indexOf(", bname="));
			}
			if (id.equals(str)) {
				c++;
				deleteMsg();
			} else {
				list.add(s);
			}
		}
	}

	public void deleteMsg() throws IOException {
		// TODO Auto-generated method stub
		if (c != 0) {
			c = 0;
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("E:\\Book.txt"), "utf-8"));
			for (String string : list) {
				bw.newLine();
				bw.write(string);
				bw.flush();
			}

			list.clear();
			System.out.println("ͼ����ڣ���\n��ɾ��~~~");
			System.out.println("��ѡ��1������ɾ��     2������ͼ�����ҳ��      3��������ҳ�� ");
			switch (sc.nextInt()) {
			case 1:
				delete();
				break;
			case 2:
				new BookManager().bookManger();
				break;
			case 3:
				System.out.println("лл~��ӭ�´�ʹ��~~~");
				break;

			default:
				break;
			}
		} else {
			c = 0;
			System.out.println("�����û������ڣ�����������~~~");
			delete();
		}
	}
}
