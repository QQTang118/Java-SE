package com.txq.book;

import java.io.IOException;
import java.util.Scanner;
/**
 * ͼ��������
 * @author i123t
 *
 */
public class BookManager {
	Scanner sc = new Scanner(System.in);

	public void bookManger() throws IOException {
		System.out.println("***************ͼ�����ҳ��**************");
		System.out.println("1�����ͼ����Ϣ\n2��ɾ��ͼ����Ϣ\n3���޸�ͼ����Ϣ\n4����ѯͼ����Ϣ\n");
		switch (sc.nextInt()) {
		case 1:
			new AddBook().add();
			break;
		case 2:
			new DeleteBook().delete();
			break;
		case 3:
			
			new ChangeBook().change();
			break;
		case 4:
			new FingBook().find();
			break;

		default:
			System.out.println("������󣡣�����������~~~");
			bookManger();
			break;
		}
	}
}
