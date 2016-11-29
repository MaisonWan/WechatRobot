/**
 * 
 */
package com.domker.robot.wechat.robot;

import java.util.HashMap;
import java.util.Map;

import com.domker.robot.wechat.util.MD5Util;

/**
 * 机器人云端AI的抽象基类
 * 
 * @author wanlipeng 2016年11月29日
 */
public abstract class AbstractRobot implements IRobot {
	private Map<String, String> map = new HashMap<String, String>();

	public AbstractRobot() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.domker.robot.wechat.robot.IRobot#talk(java.lang.String)
	 */
	@Override
	public String talk(String msg) {
		return talk(msg, null);
	}

	/**
	 * 得到缓存的会话ID
	 * 
	 * @param id md5之后统一长度
	 * @return
	 */
	protected String getCacheTalkId(String id) {
		if (map.containsKey(id)) {
			return map.get(id);
		}
		String talkId = MD5Util.getMD5(id);
		map.put(id, talkId);
		return talkId;
	}
}
