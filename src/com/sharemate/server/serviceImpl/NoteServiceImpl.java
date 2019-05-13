package com.sharemate.server.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.Note;
import com.sharemate.server.dao.NoteMapper;
import com.sharemate.server.dao.UserMapper;
import com.sharemate.server.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService{

	@Autowired
	private NoteMapper noteMapper;

	@Override
	public List<Note> getNoteSubList() {
		//分页查询得到部分笔记列表
		return noteMapper.getNoteSubList();
	}

	@Override
	public List<Note> getNoteByTypeId(int typeId) {
		//根据typeId查询笔记列表
		return noteMapper.getNoteByTypeId(typeId);
	}

	@Override
	public Note getNoteByNoteId(int noteId) {
		//根据noteId查询笔记
		return noteMapper.getNoteByNoteId(noteId);
	}

	@Override
	public Note getNoteListByUserLocation(String useraddress) {
		//根据登录用户所在位置查询附近的人的笔记列表
		return noteMapper.getNoteListByUserLocation(useraddress);
	}
	
}
