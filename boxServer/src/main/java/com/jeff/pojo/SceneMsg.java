package com.jeff.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname: SceneMsg
 * @PackageName: com.jeff.pojo
 * @Description: 场景消息实体类
 * @Date: 2019/7/16 11:10
 * @Created by: tangfan
 * @version: 1.0.0
 */
public class SceneMsg implements Serializable {

	private static final long serialVersionUID = 1L;

	private String boxId;

	private List<PlayListEntity> playList;

	@Override
	public String toString() {
		return "SceneMsg{" +
				"boxId='" + boxId + '\'' +
				", playList=" + playList +
				'}';
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public List<PlayListEntity> getPlayList() {
		return playList;
	}

	public void setPlayList(List<PlayListEntity> playList) {
		this.playList = playList;
	}
}
