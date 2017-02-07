package org.jmsu.zhiyuan.controller;

import com.jfinal.core.Controller;

public class HomeController extends Controller {

	public void index() {
		renderFreeMarker("/view/home/index.html");
	}
}
