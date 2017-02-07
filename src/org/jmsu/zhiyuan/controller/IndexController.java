package org.jmsu.zhiyuan.controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
	public void index() {
		if (getSessionAttr("login_success") != null) {
			renderFreeMarker("/view/index.html");
		} else {
			redirect("/login");
		}
	}
}
