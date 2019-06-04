package com.sharemate.server.dao;

import java.util.List;

import com.sharemate.entity.Collect;
import com.sharemate.entity.Follow;
import com.sharemate.entity.Like;
import com.sharemate.entity.Note;
import com.sharemate.entity.comment;

public interface NoteMapper {
	public List<Note> findGuanzhuNoteById(int userId);
	public List<Follow> findGuanzhuUser(int followuserid);
	//通过noteid找到note
	public Note findNoteByNoteId(int noteid);
	//给对应的note赞数加一
	public void addZanCount(Note note);
	public void insertLike(Like like);
	//获取赞的总数
	public int getZancount(int noteid);
	//获收藏的总数
	public int getCollectcount(int noteid);
	//获评论的总数
	public int getCommentcount(int noteid);
	//给对应的note收藏数加一
	public void addCollectCount(Note note);
	public void insertCollect(Collect collect);
	//插入笔记基础信息
	public void insertBaseNote(Note note);
	//插入评论
	public void insertComment(comment comment);
	//查询笔记评论
	public List<comment> findCommentByNoteId(int noteid);
}
