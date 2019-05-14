package com.sharemate.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sharemate.entity.Like;

/**
 * @author niuweiwei
 * 对笔记的赞进行操作
 * */
@Repository
public interface LikeMapper {

	/**
	 * 根据笔记的id查询赞了该笔记的所有记录
	 * @param 笔记的id
	 * @return 赞了该笔记的记录
	 * */
	public List<Like> getLikeListByNoteId(int noteId);
}
