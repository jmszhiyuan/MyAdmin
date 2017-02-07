package org.jmsu.zhiyuan.controller;

import com.jfinal.core.Controller;

public class LogoutController extends Controller {
	public void index() {
		setSessionAttr("login_success", null);
		redirect("/");
	}

}
