package org.jmsu.zhiyuan.model;

import org.wuwz.poi.ExportConfig;

import com.jfinal.plugin.activerecord.Model;

/**
 * user model
 */
public class User extends Model<User> {

	private static final long serialVersionUID = -8044649523771477776L;
	@ExportConfig(value = "ID", width = 20)
	private Integer id;

	@ExportConfig(value = "账户", width = 100)
	private String username;

	@ExportConfig(value = "邮箱", width = 150)
	private String email;

	@ExportConfig(value = "密码", width = 120, isExportData = false)
	private String password;

	@ExportConfig(value = "姓名", width = 150)
	private String realname;

	@ExportConfig(value = "性别（男:1,女:2）", width = 20)
	private Integer gender;

	@ExportConfig(value = "生日", width = 150)
	private String birthday;

	@ExportConfig(value = "状态（默认:1）", width = 20)
	private Integer status;

}
