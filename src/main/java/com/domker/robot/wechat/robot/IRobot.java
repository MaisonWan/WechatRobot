package com.domker.robot.wechat.robot;

/**
 * 机器人聊天的接口
 * 
 * @author wanlipeng
 * 2016年11月29日
 */
public interface IRobot {

	/**
	 * 请求消息，返回结果
	 * 
	 * @param msg
	 * @return
	 */
	public String talk(String msg);

	/**
	 * 请求消息，携带会话id，上下文相关。
	 * @param msg
	 * @param talkId
	 * @return
	 */
	public String talk(String msg, String talkId);
	
}
