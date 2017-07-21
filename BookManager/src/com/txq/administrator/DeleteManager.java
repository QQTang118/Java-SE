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
 * 删除管理员信息<br/>
 * 删除:根据管理员的ID进行删除，<br/>
 * 删除时需要判断id编号是否存在，存在则删除并提示用户删除结果，<br/>
 * 否则则提示用户id编号不存在，重新输入。
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
		System.out.println("***********删除***************");
		System.out.println("请输入要删除的管理员的ID编号：");
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
			System.out.println("用户存在！！\n已删除信息~~~");
			System.out.println("请选择：1、继续删除     2、返回管理员管理页面      3、返回主页面  ");
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
				System.out.println("输入错误~~~");
				delete();
				break;
			}

		} else {
			c = 0;
			System.out.println("输入用户不存在！请重新输入~~~");
			delete();
		}
	}
}
