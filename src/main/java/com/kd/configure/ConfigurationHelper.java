package com.kd.configure;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.kd.model.general._MappingKit;

public class ConfigurationHelper {
	public static void init(){
//		new ClassPathXmlApplicationContext("classpath:spring-quatz.xml");
		JFinalConfig();
	}

	public static void JFinalConfig(){

		 String url = "jdbc:mysql://172.19.171.12:3306/peseer_online?Unicode=true&characterEncoding=UTF-8&remarks=true&useInformationSchema=true";

	    DruidPlugin dp = new  DruidPlugin(url,"dataProduct","dataProduct753");
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		_MappingKit.mapping(arp);
		// 与web环境唯一的不同是要手动调用一次相关插件的start()方法
		dp.start();
		arp.start();
	}


}
