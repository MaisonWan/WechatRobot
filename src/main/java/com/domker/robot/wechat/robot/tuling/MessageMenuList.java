/**
 * 
 */
package com.domker.robot.wechat.robot.tuling;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单列表
 * 
 * @author wanlipeng 2016年11月29日
 */
public class MessageMenuList extends MessageHead {
	private String text = null;
	private List<MessageMenu> list = new ArrayList<MessageMenu>();

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<MessageMenu> getList() {
		return list;
	}

	public void setList(List<MessageMenu> list) {
		this.list = list;
	}

}
