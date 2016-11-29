package com.domker.robot.wechat.robot.tuling;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻列表
 * 
 * @author Maison
 *
 */
public class MessageNewsList extends MessageHead {
	private String text = null;
	private List<MessageNews> list = new ArrayList<MessageNews>();

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<MessageNews> getList() {
		return list;
	}

	public void setList(List<MessageNews> list) {
		this.list = list;
	}

}
