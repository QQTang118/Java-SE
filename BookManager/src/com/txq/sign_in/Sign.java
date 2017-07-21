package com.txq.sign_in;

public class Sign {
	private String name;// 姓名
	private String id;// Id
	private Boolean gendar;// 性别
	private int age;// 年龄
	private String address;// 家庭住址
	private String tellnumber;// 手机号
	private String login_name;// 登录名
	private String pawd;// 登录密码
	private int state;// 状态

	public Sign(String name, String id, Boolean gendar, int age, String address, String tellnumber, String login_name,
			String pawd, int state) {
		this.name=name;
		this.id=id;
		this.gendar=gendar;
		this.address=address;
		this.age=age;
		this.tellnumber=tellnumber;
		this.login_name=login_name;
		this.pawd=pawd;
		this.state=state;
	}

	public Sign() {
		// TODO Auto-generated method stub

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((gendar == null) ? 0 : gendar.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login_name == null) ? 0 : login_name.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pawd == null) ? 0 : pawd.hashCode());
		result = prime * result + state;
		result = prime * result + ((tellnumber == null) ? 0 : tellnumber.hashCode());
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
		Sign other = (Sign) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (gendar == null) {
			if (other.gendar != null)
				return false;
		} else if (!gendar.equals(other.gendar))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login_name == null) {
			if (other.login_name != null)
				return false;
		} else if (!login_name.equals(other.login_name))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pawd == null) {
			if (other.pawd != null)
				return false;
		} else if (!pawd.equals(other.pawd))
			return false;
		if (state != other.state)
			return false;
		if (tellnumber == null) {
			if (other.tellnumber != null)
				return false;
		} else if (!tellnumber.equals(other.tellnumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sign [name=" + name + ", id=" + id + ", gendar=" + ((gendar)?"男":"女")  + ", age=" + age + ", address=" + address
				+ ", tellnumber=" + tellnumber + ", login_name=" + login_name + ", pawd=" + pawd + ", state="
				+ state + "]";
	}
}
	