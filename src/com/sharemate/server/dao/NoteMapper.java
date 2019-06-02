package com.sharemate.server.dao;

import java.util.List;


import com.sharemate.entity.Follow;
import com.sharemate.entity.Like;
import com.sharemate.entity.Note;

public interface NoteMapper {
	public List<Note> findGuanzhuNoteById(int userId);
	public List<Follow> findGuanzhuUser(int followuserid);
	//通过noteid找到note
	public Note findNoteByNoteId(int noteid);
	//给对应的note赞数加一
	public void addZanCount(Note note);
	public void insertLike(Like like);
//	//给对应的note收藏数加一
//	public void addCollectCount(Note note);
//	public void insertCollect(Collect collect);
}
