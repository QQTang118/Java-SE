package com.txq.administrator;

import java.io.IOException;
import java.util.Scanner;

/**
 * ���ܷ�Ϊ:���ӡ�ɾ�����޸ġ���ѯ����Ա<br/>
 * ����:�ο�����Ա��ע�Ṧ��<br/>
 * ɾ��:���ݹ���Ա��ID����ɾ����<br/>
 * ɾ��ʱ��Ҫ�ж�id����Ƿ���ڣ�������ɾ������ʾ�û�ɾ�������<br/>
 * ��������ʾ�û�id��Ų����ڣ��������롣<br/>
 * �޸�:�ȸ����û�id��Ų�ѯ�û���Ϣ��Ȼ���ٽ����޸ģ�<br/>
 * �޸�ʱͬ����Ҫ���������Ϣ�����ж�<br/>
 * �޸ĳɹ��򸲸�ԭ���û����ݡ�������������Ϣ��ʾ��<br/>
 * ��ѯ:��Ϊid��ѯ�͵�¼���Ʋ�ѯ
 * 
 * @author i123t
 *
 */

public class AdminManager {
	Scanner sc = new Scanner(System.in);

	public void Manager() throws IOException {
		System.out.println("*********����Ա�������************");
		System.out.println("1�����ӹ���Ա��Ϣ\n2��ɾ������Ա��Ϣ\n3���޸Ĺ���Ա��Ϣ\n4����ѯ����Ա��Ϣ");
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
			System.out.println("������󣡣�����������~~~");
			Manager();
			break;
		}
	}
}
