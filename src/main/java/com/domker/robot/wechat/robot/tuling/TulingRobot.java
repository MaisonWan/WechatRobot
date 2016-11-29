/**
 * 
 */
package com.domker.robot.wechat.robot.tuling;

import com.blade.kit.StringKit;
import com.blade.kit.http.HttpRequest;
import com.domker.robot.wechat.Constant;
import com.domker.robot.wechat.robot.AbstractRobot;

/**
 * 图灵机器人
 * 
 * @author wanlipeng
 * 2016年11月29日
 */
public class TulingRobot extends AbstractRobot {
	private String apiUrl = null;
	private MessageParser parser = null;
	
	public TulingRobot() {
		String api_key = Constant.config.get("tuling.api_key");
		if (StringKit.isNotBlank(api_key)) {
			this.apiUrl = Constant.TULING_API + "?key=" + api_key;
			this.parser = new MessageParser();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.domker.robot.wechat.robot.IRobot#talk(java.lang.String, java.lang.String)
	 */
	@Override
	public String talk(String msg, String talkId) {
		if (this.apiUrl == null) {
			return "机器人未配置";
		}
		String json = requestServer(msg, talkId, Constant.NET_RETRY_COUNT);
		return parser.parser(json);
	}

	/**
	 * 请求服务器
	 * 
	 * @param msg 对话内容
	 * @param talkId 会话id
	 * @param count 重试次数
	 * @return
	 */
	private String requestServer(String msg, String talkId, int count) {
		try {
			String url = apiUrl + "&info=" + msg;
			if (StringKit.isNotBlank(talkId)) {
				url += "&userid=" + getCacheTalkId(talkId);
			}
			System.out.println(url);
			String result = HttpRequest.get(url).connectTimeout(3000).body();
			return result;
		} catch (Exception e) {
			if (count == 0) {
				return msg;
			}
			return requestServer(msg, talkId, count - 1);
		}
	}
	
	
}
