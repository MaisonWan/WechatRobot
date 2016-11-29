package com.domker.robot.wechat.robot;

import com.blade.kit.StringKit;
import com.blade.kit.http.HttpRequest;
import com.domker.robot.wechat.Constant;

/**
 * 茉莉机器人
 * 
 * @author wanlipeng
 * 2016年11月29日
 */
public class MoLiRobot extends AbstractRobot implements IRobot {

	private String apiUrl;

	public MoLiRobot() {
		String api_key = Constant.config.get("itpk.api_key");
		String api_secret = Constant.config.get("itpk.api_secret");
		if (StringKit.isNotBlank(api_key) && StringKit.isNotBlank(api_secret)) {
			this.apiUrl = Constant.ITPK_API + "?api_key=" + api_key + "&api_secret=" + api_secret;
		}
	}

	@Override
	public String talk(String msg, String talkId) {
		if (null == this.apiUrl) {
			return "机器人未配置";
		}
		String url = apiUrl + "&question=" + msg;
		String result = HttpRequest.get(url).connectTimeout(3000).body();
		return result;
	}

}
