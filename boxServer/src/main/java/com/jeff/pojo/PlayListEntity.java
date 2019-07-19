package com.jeff.pojo;

/**
 * @Classname: PlayListEntity
 * @PackageName: com.jeff.pojo
 * @Description:
 * @Date: 2019/7/16 11:36
 * @Created by: tangfan
 * @version: 1.0.0
 */
public class PlayListEntity {

	public String url;
	public String name;
	public int time;

	@Override
	public String toString() {
		return "PlayListEntity{" +
				"url='" + url + '\'' +
				", name='" + name + '\'' +
				", time=" + time +
				'}';
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
