package com.kd.tools.redissync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kd.configure.ConfigurationHelper;
import com.kd.thrift.server.impl.RedisSyncServiceDaemon;

/**
 *
 * 同步模块主程序
 * 目前支持定时同步
 * 预留手工同步的接口
 *
 */
public class SyncModule
{
	private static final Logger LOGGER = LoggerFactory.getLogger(SyncModule.class);


    public static void main( String[] args )
    {
    	//ApplicationContext context = new ClassPathXmlApplicationContext("spring-quatz.xml");
    	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-quatz.xml");

    	ConfigurationHelper.init();
    	RedisSyncServiceDaemon redisSyncServiceDaemon = new RedisSyncServiceDaemon();
    	redisSyncServiceDaemon.startServer();

    }
}
