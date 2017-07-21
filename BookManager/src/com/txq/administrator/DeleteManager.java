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
 * ɾ������Ա��Ϣ<br/>
 * ɾ��:���ݹ���Ա��ID����ɾ����<br/>
 * ɾ��ʱ��Ҫ�ж�id����Ƿ���ڣ�������ɾ������ʾ�û�ɾ�������<br/>
 * ��������ʾ�û�id��Ų����ڣ��������롣
 * 
 * @author i123t
 *
 */

public class DeleteManager {
	Scanner sc = new Scanner(System.in);
	String id, s, str;
	int c = 0;
	BufferedWriter bw;
	List<String> list = new LinkedList<String>();

	public void delete() throws IOException {
		System.out.println("***********ɾ��***************");
		System.out.println("������Ҫɾ���Ĺ���Ա��ID��ţ�");
		id = sc.next();

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\SignIn.txt"), "utf-8"));

		while ((s = br.readLine()) != null) {
			if (s.indexOf(", id=") != -1 && s.indexOf(", gendar=") != -1) {
				str = s.substring(s.indexOf(", id=") + 5, s.indexOf(", gendar="));
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
		if (c != 0) {
			c = 0;
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\SignIn.txt"), "utf-8"));
			for (String string : list) {
				bw.newLine();
				bw.write(string);
				bw.flush();
			}
			list.clear();
			System.out.println("�û����ڣ���\n��ɾ����Ϣ~~~");
			System.out.println("��ѡ��1������ɾ��     2�����ع���Ա����ҳ��      3��������ҳ��  ");
			switch (sc.nextInt()) {
			case 1:
				delete();
				break;
			case 2:
				new AdminManager().Manager();
				break;
			case 3:
				new Administrator().adminManager();
				break;
			default:
				System.out.println("�������~~~");
				delete();
				break;
			}

		} else {
			c = 0;
			System.out.println("�����û������ڣ�����������~~~");
			delete();
		}
	}
}
