package org.jmsu.zhiyuan.run;

import org.jmsu.zhiyuan.config.DefaultConfig;

import com.jfinal.core.JFinal;

public class Run extends DefaultConfig {
	public static void main(String[] args) {
		JFinal.start("WebContent", 8081, "/MyAdmin", 5);
	}
}
