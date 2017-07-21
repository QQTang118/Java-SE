package com.txq.administrator;

import java.io.IOException;
import java.util.Scanner;

/**
 * 功能分为:增加、删除、修改、查询管理员<br/>
 * 增加:参考管理员的注册功能<br/>
 * 删除:根据管理员的ID进行删除，<br/>
 * 删除时需要判断id编号是否存在，存在则删除并提示用户删除结果，<br/>
 * 否则则提示用户id编号不存在，重新输入。<br/>
 * 修改:先根据用户id编号查询用户信息，然后再进行修改，<br/>
 * 修改时同样需要对输入的信息进行判断<br/>
 * 修改成功则覆盖原先用户数据。否则进行相关信息提示。<br/>
 * 查询:分为id查询和登录名称查询
 * 
 * @author i123t
 *
 */

public class AdminManager {
	Scanner sc = new Scanner(System.in);

	public void Manager() throws IOException {
		System.out.println("*********管理员管理界面************");
		System.out.println("1、增加管理员信息\n2、删除管理员信息\n3、修改管理员信息\n4、查询管理员信息");
		switch (sc.nextInt()) {
		case 1:
			new AddManager().add();
			break;
		case 2:
			new DeleteManager().delete();
			break;
		case 3:
			new ChangeManager().change();
			break;
		case 4:
			new FindManager().find();
			break;
		default:
			System.out.println("输入错误！！请重新输入~~~");
			Manager();
			break;
		}
	}
}
