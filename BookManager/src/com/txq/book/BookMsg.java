package com.txq.book;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 图书信息存放<br/>
 * 图书属性包括: id,图书名称，作者，单价，出版社，出版日期，类别<br/>
 * 出版日期默认是当前系统日期，日期格式为(YYYY-MM-dd )
 * 
 * @author i123t
 *
 */
public class BookMsg {
	private String id;//
	private String bname;// 图书名称
	private String author;// 作者
	private String money;// 单价
	private String publishing;// 出版社
	private Date date;// 出版日期
	private String category;// 类别
	SimpleDateFormat sdf;

	public BookMsg() {
		// TODO Auto-generated constructor stub
	}

	public BookMsg(String id, String bname, String author, String money, String publishing, String category) {
		this.id = id;
		this.bname = bname;
		this.author = author;
		this.money = money;
		this.publishing = publishing;
		this.category = category;
		Calendar cal = Calendar.getInstance();
		sdf = new SimpleDateFormat("yyyy年MM月dd日");
		date = cal.getTime();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bname == null) ? 0 : bname.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((publishing == null) ? 0 : publishing.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookMsg other = (BookMsg) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bname == null) {
			if (other.bname != null)
				return false;
		} else if (!bname.equals(other.bname))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (publishing == null) {
			if (other.publishing != null)
				return false;
		} else if (!publishing.equals(other.publishing))
			return false;
		return true;
	}

	@Override
	public String toString() {
		switch (category) {
		case "1":
			category = "Java";
			break;
		case "2":
			category = ".net";
			break;
		case "3":
			category = "android";
			break;
		case "4":
			category = "ios";
			break;

		default:
			break;
		}
		return "BookMsg [id=" + id + ", bname=" + bname + ", author=" + author + ", money=" + money + ", publishing="
				+ publishing + ", date=" + date + ", category=" + category + "]";
	}

}
