package com.kd.thrift.client.impl;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.kd.redissync.thrift.RedisSyncService;

public class RedisSyncClient {
	public static final String SERVER_IP = "10.27.224.63"; //datanode-02
	//public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = 18666;
	public static final int TIMEOUT = 30000000;

	/**
	 *
	 * @param userName
	 */
	public void doSync(String sync_job_name) {
		TTransport transport = null;
		try {
			transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
			// 协议要和服务端一致
			TProtocol protocol = new TBinaryProtocol(transport);
			RedisSyncService.Client client = new RedisSyncService.Client(
					protocol);
			transport.open();
//			String result = client.sync(sync_job_name);
			String result = client.resync(sync_job_name);
			System.out.println("Thrify client sync result =: " + result);

		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		} finally {
			if (null != transport) {
				transport.close();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RedisSyncClient client = new RedisSyncClient();
		long start = System.currentTimeMillis();
		client.doSync("SupervisorStockSync");
		System.out.println(String.format("total spend %d", System.currentTimeMillis()-start));

	}

}
