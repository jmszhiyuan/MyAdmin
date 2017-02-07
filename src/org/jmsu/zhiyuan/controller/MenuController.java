package org.jmsu.zhiyuan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jmsu.zhiyuan.model.Menu;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.render.JsonRender;

public class MenuController extends Controller {
	private Menu menu = new Menu();

	public void index() {
		renderFreeMarker("/view/menu/index.html");
	}
	public void add() {
		renderFreeMarker("/view/menu/add.html");
	}
	public void treegrid() {

		List<Menu> menuList = menu
				.find("select ma_menu.id,ma_menu.name,ma_menu.icon,ma_menu.title,ma_menu.url,ma_menu.parent as _parentId,ma_level.level,ma_status.status "
						+ "from ma_menu,ma_level,ma_status "
						+ "where ma_menu.status=ma_status.id and ma_menu.level=ma_level.id");
		Map<String, Object> menuMap = new HashMap<String, Object>();
		menuMap.put("total", menuList.size());
		menuMap.put("rows", menuList);
		String jsonstr = JsonKit.toJson(menuMap) == null || "null".equals(JsonKit.toJson(menuMap)) ? "[]"
				: JsonKit.toJson(menuMap);
		System.out.println(jsonstr);

		render(new JsonRender(jsonstr).forIE());
	}
}
