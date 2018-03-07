package com.education.action;

import com.education.bean.User;
import com.opensymphony.xwork2.ActionSupport;

//action都会继承一个ActionSupport,单这不是强制的,ActionSupport中包含了很多方法以及常用常量
public class HelloWorldAction extends ActionSupport {

	// 前台传入的值会直接注入到该Action的属性中,必须含有get/set方法
	// 如果是非对象则以 <input name="testMsg"/>这样的形式传值
	// 如果是对象则以<input name="user.username"/>这样的形式传值
	private User user;

	private String testMsg;

	public String getTestMsg() {
		return testMsg;
	}

	public void setTestMsg(String testMsg) {
		this.testMsg = testMsg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// execute方法是当struts.xml没有指定方法来处理请求时,就会默认调用该方法
	@Override
	public String execute() throws Exception {
		System.out.println(testMsg);
		System.out.println(user.getUsername());
		return SUCCESS;
	}

	// validate方法是struts框架自带的验证方法
	// 如果重写了该方法则会先于execute方法执行
	// 如果运行了addFieldError方法则会直接返回,不再执行execute方法
	// 返回值为input
	@Override
	public void validate() {
		if (1 > 2) {
			addFieldError("name", "it's impossible");
		}
	}

}
