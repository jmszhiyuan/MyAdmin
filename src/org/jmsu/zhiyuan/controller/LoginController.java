package org.jmsu.zhiyuan.controller;


import com.jfinal.core.Controller;

public class LoginController extends Controller {
	public void index() {
		renderFreeMarker("/view/login.html");
	}
	public void login(){
		setSessionAttr("login_success", "ok");
		redirect("/");
	}
}
