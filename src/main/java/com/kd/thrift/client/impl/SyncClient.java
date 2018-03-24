package com.kd.thrift.client.impl;

import com.kd.utils.StringUtil;

public class SyncClient {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("start to sync the data to redis!");
		String command = args[1];
		long start = System.currentTimeMillis();
		RedisSyncClient client = new RedisSyncClient();

		if(StringUtil.isNullOrEmpty(command)){
			client.doSync("SyncSupervisor");
		}else{
			client.doSync(command);
		}

		System.out.println(String.format("total spend %d", System.currentTimeMillis()-start));

	}
}
