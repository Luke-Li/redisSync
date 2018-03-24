package com.kd.thrift.server.impl;

import java.net.InetSocketAddress;
import java.net.ServerSocket;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;

import com.kd.configure.ConfigurationHelper;
import com.kd.redissync.thrift.RedisSyncService;

public class RedisSyncServiceDaemon {
	public static final int SERVER_PORT = 18666;

	public void startServer() {
		try {
			System.out.println("RedisSyncService TThreadPoolServer start ....");

			TProcessor tprocessor = new RedisSyncService.Processor<RedisSyncService.Iface>(new RedisSyncServiceImpl());

			ServerSocket serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0",SERVER_PORT));
			TServerSocket serverTransport = new TServerSocket(serverSocket);
			TThreadPoolServer.Args ttpsArgs = new TThreadPoolServer.Args(serverTransport);
			ttpsArgs.processor(tprocessor);
			ttpsArgs.protocolFactory(new TBinaryProtocol.Factory());

			// 线程池服务模型，使用标准的阻塞式IO，预先创建一组线程处理请求。
			TServer server = new TThreadPoolServer(ttpsArgs);
			server.serve();
		} catch (Exception e) {
			System.out.println("Server start error!!!");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		RedisSyncServiceDaemon server = new RedisSyncServiceDaemon();
		ConfigurationHelper.init();
		server.startServer();
	}

}
