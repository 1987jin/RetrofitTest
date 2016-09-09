package com.shine.wechat;

import java.util.List;

/**
 * @desc:
 * @author: jiangcy
 * @date: 16-9-9
 * @time: 上午9:25
 */
public class WeChatResult {
	private int code;
	private String msg;
	private List<News> newslist;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<News> getNewslist() {
		return newslist;
	}

	public void setNewslist(List<News> newslist) {
		this.newslist = newslist;
	}

	public static class News{
		private  String ctime;
		private String title;
		private String description;
		private String picUrl;
		private String url;

		public String getCtime() {
			return ctime;
		}

		public void setCtime(String ctime) {
			this.ctime = ctime;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getPicUrl() {
			return picUrl;
		}

		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		@Override public String toString() {
			return "News{" +
					"ctime='" + ctime + '\'' +
					", title='" + title + '\'' +
					", description='" + description + '\'' +
					", picUrl='" + picUrl + '\'' +
					", url='" + url + '\'' +
					'}';
		}
	}

	@Override public String toString() {
		return "WeChatResult{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", newslist=" + newslist +
				'}';
	}
}
