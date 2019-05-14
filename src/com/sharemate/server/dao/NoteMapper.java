package com.sharemate.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sharemate.entity.Note;

@Repository
public interface NoteMapper {
	
	/**
	 * @author niuweiwei
	 * 根据用户的id查询该用户发布过的所有笔记
	 * @param userId: 指定的用户id
	 * @return 返回笔记列表
	 * */
	public List<Note> getNoteListByUserId(int userId);
	
	/**
	 * @author niuweiwei
	 * 根据笔记的id查询笔记详情
	 * @param noteId 指定的笔记id
	 * @return 返回笔记列表
	 * */
	public Note getNoteByNoteId(int noteId);
}
