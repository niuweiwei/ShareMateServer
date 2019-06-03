package com.sharemate.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sharemate.entity.Collect;
import com.sharemate.entity.Follow;
import com.sharemate.entity.Like;
import com.sharemate.entity.Note;
import com.sharemate.entity.comment;

@Service
public interface NoteService {
	public void text();
	public List<Note> findGuanzhuNote(int userid);
	public void insertNote(Note note);
	public List<Follow> findGuanzhuUser(int followuserid);
	public Note findNoteByNoteId(int noteid);
	public void addZanCount(Note note);
	//加入like表
	public void insertLike(Like like);
	public void addCollectCount(Note note);
	public void insertCollect(Collect collect);
	//插入笔记基础信息
	public void insertBaseNote(Note note);
	//插入评论
	public void insertComment(comment comment);
}



	
