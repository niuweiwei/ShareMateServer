package com.sharemate.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sharemate.entity.Note;

/**

* @author fengjiaxing

* @version 2019年5月15日 上午8:47:23 

*/
public interface NoteMapper {
	/**
	 * 根据userId查询用户发布过的笔记
	 * @param userId
	 * @return
	 */
	public List<Note> findNoteByUserId(int userId);
	/**
	 * 根据noteId查询note
	 * @param noteId
	 * @return
	 */
	public Note findNoteByNoteId(int noteId);
}
