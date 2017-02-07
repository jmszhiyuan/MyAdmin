package org.jmsu.zhiyuan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jmsu.zhiyuan.model.User;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.render.JsonRender;

public class UserController extends Controller {
	private User user = new User();

	public void index() {
		renderFreeMarker("/view/user/index.html");
	}

	public void add() {
		renderFreeMarker("/view/user/add.html");
	}

	public void datagrid() {
		List<User> userList = user
				.find("select ma_user.id,ma_user.username,ma_user.email,ma_user.password,ma_user.realname,ma_gender.gender,ma_user.birthday,ma_status.status "
						+ "from ma_user,ma_gender,ma_status "
						+ "where ma_user.gender=ma_gender.id and ma_user.status=ma_status.id");
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("total", userList.size());
		userMap.put("rows", userList);
		String jsonstr = JsonKit.toJson(userMap) == null || "null".equals(JsonKit.toJson(userMap)) ? "[]"
				: JsonKit.toJson(userMap);
		System.out.println(jsonstr);
		render(new JsonRender(jsonstr).forIE());
	}

}
