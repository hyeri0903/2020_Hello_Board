package com.sinc.intern.user.model.vo;

public class UserVO {
	private String 	id , pwd , name ;
	private double 	point ;
	private String 	dept , imgSrc ;
	
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVO(String id, String pwd, String name, double point, String dept, String imgSrc) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.point = point;
		this.dept = dept;
		this.imgSrc = imgSrc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", point=" + point + ", dept=" + dept
				+ ", imgSrc=" + imgSrc + "]";
	}
	
}
