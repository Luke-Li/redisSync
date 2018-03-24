package com.kd.sync;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.kd.model.general.AppRumorTopic;
import com.kd.tools.redissync.Sync;
import com.kd.utils.StringUtil;
import com.kd.utils.TopicClient;

public class RumorTopicSync implements Sync {

	private static final Logger logger = LoggerFactory.getLogger(RumorTopicSync.class);
	@Override
	public void doSync() {
		long start = System.currentTimeMillis();
		Db.update("truncate app_rumor_topic");
		analysisData();
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

	public void analysisData() {
		try {
			List<Record> list = null;
			list = Db.find("select id, record from pm_rumor");

			logger.info("total records: " + list.size());
			if (list != null && !list.isEmpty()) {
				int count =1;
				for (Record record : list) {
					String analysis = record.getStr("record");

					int topic = StringUtil.parseInt(TopicClient.getMediaTopic(analysis), -1);
					if (topic < 0) {
						count ++;
						continue;
					}
					AppRumorTopic rumorTopic = new AppRumorTopic();
					rumorTopic.setRumorId(record.getInt("id"));
					rumorTopic.setTopicId(topic);
					rumorTopic.save();
				}
				logger.info("total records have not topic: " + count);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}

}
