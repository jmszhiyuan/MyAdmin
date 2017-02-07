package org.jmsu.zhiyuan.config;

import org.jmsu.zhiyuan.controller.HomeController;
import org.jmsu.zhiyuan.controller.IndexController;
import org.jmsu.zhiyuan.controller.LoginController;
import org.jmsu.zhiyuan.controller.LogoutController;
import org.jmsu.zhiyuan.controller.MenuController;
import org.jmsu.zhiyuan.controller.UserController;
import org.jmsu.zhiyuan.model.Menu;
import org.jmsu.zhiyuan.model.User;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

public class DefaultConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/", IndexController.class);
		me.add("/login", LoginController.class);
		me.add("/logout", LogoutController.class);
		me.add("/home", HomeController.class);
		me.add("/user", UserController.class);
		me.add("/menu", MenuController.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		loadPropertyFile("jdbc.properties");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbc.url"), getProperty("jdbc.username"),
				getProperty("jdbc.password"));
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("ma_user", "id", User.class);
		arp.addMapping("ma_menu", "id", Menu.class);


		// SchedulerPlugin sp = new SchedulerPlugin("job.properties");
		// me.add(sp);

	}

	@Override
	public void configInterceptor(Interceptors me) {

	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("ContextPath"));// 设置上下文路径,防止样式丢失
	}

}
