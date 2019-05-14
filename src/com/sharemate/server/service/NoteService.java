package com.sharemate.server.service;

import java.util.List;

import com.sharemate.entity.Note;

public interface NoteService {

	//分页查询得到部分笔记列表
		public List<Note> getNoteSubList();
		
		//根据typeId查询笔记列表
		public List<Note> getNoteByTypeId(int typeId);
		
		//根据noteId查询笔记
		public Note getNoteByNoteId(int noteId);
		
		//根据登录用户所在位置查询附近的人的笔记列表
		public Note getNoteListByUserLocation(String useraddress);
		
		//根据noteId查询笔记被点赞的总数
		public int getLikeCountBynoteId(int noteId);
}
