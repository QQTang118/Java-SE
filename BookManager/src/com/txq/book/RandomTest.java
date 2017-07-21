package com.txq.book;

import java.util.Random;
/**
 * 生成验证码
 * @author i123t
 *
 */
public class RandomTest {
	public String random() {
		Random random = new Random();
		int count = 0;
		String d = "";
		String str = "abcdefghijklmnopqrstuvwsyz1234567890";
		while (true) {
			char a = str.charAt(random.nextInt(36));
			if (d.indexOf(a, 0) == -1) {
				d += a;
				count++;
			}
			if (count == 6) {
				break;
			}
		}
		return d;
	}

}
