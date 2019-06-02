package com.sharemate.server.dao;

import java.util.List;


import com.sharemate.entity.Follow;
import com.sharemate.entity.Like;
import com.sharemate.entity.Note;

public interface NoteMapper {
	public List<Note> findGuanzhuNoteById(int userId);
	public List<Follow> findGuanzhuUser(int followuserid);
	//ͨ��noteid�ҵ�note
	public Note findNoteByNoteId(int noteid);
	//����Ӧ��note������һ
	public void addZanCount(Note note);
	public void insertLike(Like like);
//	//����Ӧ��note�ղ�����һ
//	public void addCollectCount(Note note);
//	public void insertCollect(Collect collect);
}
