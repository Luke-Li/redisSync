package com.kd.thrift.client.impl;


import com.kd.configure.ConfigurationHelper;
import com.kd.sync.SyncSupervisor;

public class JedisClient {
	public static void main(String[] args) {
		ConfigurationHelper.init();
		new SyncSupervisor().doSync();
	}

}
