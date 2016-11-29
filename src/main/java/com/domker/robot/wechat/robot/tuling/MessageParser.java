/**
 * 
 */
package com.domker.robot.wechat.robot.tuling;

import java.util.List;

import com.blade.kit.StringKit;
import com.google.gson.Gson;

/**
 * 图灵机器人消息解析类
 * 
 * @author wanlipeng 2016年11月29日
 */
public class MessageParser {
	private Gson gson = new Gson();

	/**
	 * 解析json消息
	 * 
	 * @param json
	 * @return
	 */
	public String parser(String json) {
		try {
			MessageHead head = gson.fromJson(json, MessageHead.class);
			switch (head.getCode()) {
			case 100000: // 问答
			case 200000: // 带url的问答
				return parserAsk(json);
			case 308000:// 菜谱
				return parserMenuList(json);
			case 302000:// 新闻
				return parserNewsList(json);
			default:
				return json;
			}
		} catch (Exception e) {
			return json;
		}
	}

	/**
	 * 解析问答类
	 * 
	 * @param json
	 * @return
	 */
	private String parserAsk(String json) {
		MessageAsk ask = gson.fromJson(json, MessageAsk.class);
		if (StringKit.isNotBlank(ask.getUrl())) {
			return String.format("%s\n%s", ask.getText(), ask.getUrl());
		}
		return ask.getText();
	}

	/**
	 * 解析菜单列表
	 * 
	 * @param json
	 * @return
	 */
	private String parserMenuList(String json) {
		MessageMenuList menuList = gson.fromJson(json, MessageMenuList.class);
		List<MessageMenu> list = menuList.getList();
		StringBuffer sb = new StringBuffer();
		for (MessageMenu menu : list) {
			sb.append(menu.getName()).append("\n");
			sb.append(menu.getInfo()).append("\n");
			sb.append(menu.getDetailurl()).append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * 解析新闻
	 * 
	 * @param json
	 * @return
	 */
	private String parserNewsList(String json) {
		MessageNewsList newsList = gson.fromJson(json, MessageNewsList.class);
		List<MessageNews> list = newsList.getList();
		StringBuffer sb = new StringBuffer();
		for (MessageNews news : list) {
			sb.append(news.getArticle()).append("[").append(news.getSource()).append("]\n");
			sb.append(news.getDetailurl()).append("\n");
		}
		return sb.toString();
	}
}
