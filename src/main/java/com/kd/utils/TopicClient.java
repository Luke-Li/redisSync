package com.kd.utils;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopicClient {
	private static final Logger logger = LoggerFactory.getLogger(TopicClient.class);
	public static final String SERVER_IP = "192.168.0.70";
	public static final int SERVER_PORT = 18090;
	public static final int TIMEOUT = 30000;
	private static TopicService.Client client = null;
	private static TopicService.Client getClient(){
		if(client == null){
			try {
				TTransport transport = null;

				transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
				// 协议要和服务端一致
				TProtocol protocol = new TBinaryProtocol(transport);
				client = new TopicService.Client(
						protocol);
				transport.open();
			}catch(Exception e){
				logger.error(e.toString());
			}
		}

		return client;
	}

	public static String getIndustryTopic(String content){
		try {
			return getClient().getIndusryTopic(content);
		} catch (TTransportException e) {
			logger.error(e.toString());
		} catch (TException e) {
			logger.error(e.toString());
		}
		return null;
	}

	public static String getMediaTopic(String content){
		try {
			return getClient().getMediaTopic(content);
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *
	 * @param userName
	 */
	public void startClient(String content) {
		TTransport transport = null;
		try {
			transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
			// 协议要和服务端一致
			TProtocol protocol = new TBinaryProtocol(transport);
			TopicService.Client client = new TopicService.Client(
					protocol);
			transport.open();
			String result = client.getIndusryTopic(content);
			System.out.println("Thrify client getIndusryTopic result =: " + result);

			result = client.getMediaTopic(content);
			System.out.println("Thrify client getMediaTopic result =: " + result);
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
		TopicClient client = new TopicClient();
		client.startClient("　万科股权之争再添变数，恒大集团许家印也加入了这场旷日持久的争斗。8月4日下午，中国恒大（3333.HK）公告，称已耗资91亿元购入万科4.68%股票。纸牌屋里，本已经有了万科集团董事会主席王石（总裁郁亮）、宝能集团董事长姚振华、华润集团董事长傅育宁、安邦集团董事长吴小辉、深圳地铁集团等五位重磅玩家。许家印的加入，让牌局的扑簌迷离程度，再呈几何级增长。恒大搅局“宝万之争”，目的何在？其在公告解释称，“收购项目为本公司的投资”，而选择投资的原因是“万科为中国的最大房地产开发商之一，其财务表现强劲”。但外界普遍认为，许家印另有所图。如同宝能曾在公告中解释，自己希望做万科的“长期的财务战略投资人”，但并未妨碍其发出议案，试图罢免所有董事会、监事会成员一样，恒大的“投资”，亦不排除对万科有更大的野心。而恒大集团旗下上市公司的现金储备，以及曾作为姚振华利器的万能险，均为恒大提供了充足的弹药。");

	}

}
