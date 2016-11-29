/**
 * 
 */
package com.domker.robot.wechat.robot.tuling;

/**
 * 问答相关的实体类
 * 
 * @author wanlipeng 2016年11月29日
 */
public class MessageAsk extends MessageHead {
	private String text;
	private String url;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
