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
	//ͨ��noteid�ҵ�note
	public Note findNoteByNoteId(int noteid);
	//����Ӧ��note������һ
	public void addZanCount(Note note);
	public void insertLike(Like like);
	//����Ӧ��note�ղ�����һ
	public void addCollectCount(Note note);
	public void insertCollect(Collect collect);
	//����ʼǻ�����Ϣ
	public void insertBaseNote(Note note);
	//��������
	public void insertComment(comment comment);
}
