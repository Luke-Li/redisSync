package com.kd.sync;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.kd.model.general.EntBasicInfo;
import com.kd.model.general.EventTopic;
import com.kd.model.general.PmExitEventDetail;
import com.kd.model.general.PmInvestEventDetail;
import com.kd.tools.redissync.Sync;
import com.kd.utils.RedisJfinalModel;
import com.kd.utils.StringUtil;
import com.kd.utils.TopicClient;

/**
 * 计算投资退出事件的topic信息并保存到event_topic表
 * @author luke
 *
 */
public class TopicEventSync implements Sync {

	private static final Logger logger = LoggerFactory.getLogger(TopicEventSync.class);
	private static final int Invest_Type = 1;
	private static final int Exit_Type = 2;

	@Override
	public void doSync() {
		long start = System.currentTimeMillis();
		Db.update("truncate event_topic");
		analysisData(Invest_Type);
		analysisData(Exit_Type);
		long end = System.currentTimeMillis();
		logger.info(String.format("sync all event_topic took %d seconds.",end-start));
	}

	@Override
	public void doFullSync() {
		doSync();
	}

	@Override
	public void clearData() {
		// TODO Auto-generated method stub

	}

	public void analysisData(int type) {
		try {
			List<Record> list = null;
			if (Exit_Type == type) {
				list = Db.find(
						String.format("select event_id, event_title,ent_uuid from %s", PmInvestEventDetail.TableName));
			} else if (Invest_Type == type) {
				list = Db.find(
						String.format("select event_id, event_title,ent_uuid from %s", PmExitEventDetail.TableName));
			}
			logger.info("total records: " + list.size());
			if (list != null && !list.isEmpty()) {
				int count =1;
				for (Record record : list) {
					String analysis = record.getStr("event_title");
					if (!StringUtil.isNullOrEmpty(record.getStr("ent_uuid"))) {
						EntBasicInfo entinfo = RedisJfinalModel.getEntBasicInfo(record.getStr("ent_uuid"));
						if (entinfo != null) {
							analysis = analysis + " " + entinfo.getBizArea();
						}
					}

					int topic = StringUtil.parseInt(TopicClient.getIndustryTopic(analysis), -1);
					if (topic < 0) {
						count ++;
						continue;
					}
					EventTopic eventTopic = new EventTopic();
					eventTopic.setEventId(record.getInt("event_id"));
					eventTopic.setEventType(type);
					eventTopic.setTopicId(topic);
					eventTopic.save();
				}
				logger.info("total records have not topic: " + count);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}

}
