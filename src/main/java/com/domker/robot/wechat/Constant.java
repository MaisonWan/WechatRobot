package com.domker.robot.wechat;

import java.util.Arrays;
import java.util.List;

import com.blade.kit.base.Config;
import com.domker.robot.wechat.model.WechatContact;

public class Constant {

	public static final String HTTP_OK = "200";
	public static final String BASE_URL = "https://webpush2.weixin.qq.com/cgi-bin/mmwebwx-bin";
	public static final String JS_LOGIN_URL = "https://login.weixin.qq.com/jslogin";
	public static final String QRCODE_URL = "https://login.weixin.qq.com/qrcode/";

	public static final String ITPK_API = "http://i.itpk.cn/api.php";
	/**
	 * 图灵机器人请求API
	 */
	public static final String TULING_API = "http://www.tuling123.com/openapi/api";

	/**
	 * 机器人的名字
	 */
	public static final String ROBOT_NAME = "二蛋";
	/**
	 * 群内聊天前缀
	 */
	public static final String ROBOT_NAME_PREX = "@二蛋 ";

	/**
	 * 网络出现问题之后，重试次数
	 */
	public static final int NET_RETRY_COUNT = 5;
	
	// 特殊用户 须过滤
	public static final List<String> FILTER_USERS = Arrays.asList("newsapp",
			"fmessage", "filehelper", "weibo", "qqmail", "fmessage",
			"tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp",
			"shakeapp", "medianote", "qqfriend", "readerapp", "blogapp",
			"facebookapp", "masssendapp", "meishiapp", "feedsapp", "voip",
			"blogappweixin", "weixin", "brandsessionholder", "weixinreminder",
			"wxid_novlwrv3lqwv11", "gh_22b87fa7cb3c", "officialaccounts",
			"notification_messages", "wxid_novlwrv3lqwv11", "gh_22b87fa7cb3c",
			"wxitil", "userexperience_alarm", "notification_messages");

	public static final String[] SYNC_HOST = { "webpush.weixin.qq.com",
			"webpush2.weixin.qq.com", "webpush.wechat.com",
			"webpush1.wechat.com", "webpush2.wechat.com",
			"webpush1.wechatapp.com" };

	public static WechatContact CONTACT;

	// 全局配置文件
	public static Config config;
}
