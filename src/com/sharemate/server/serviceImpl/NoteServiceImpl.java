package com.sharemate.server.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.Note;
import com.sharemate.server.dao.NoteMapper;
import com.sharemate.server.service.NoteService;

/**

* @author fengjiaxing

* @version 2019年5月15日 上午8:47:54 

*/
@Service
public class NoteServiceImpl implements NoteService{

	@Autowired
	private NoteMapper noteMapper;
	
	@Override
	public List<Note> findNoteByUserId(int userId) {
		return noteMapper.findNoteByUserId(userId);
	}

	@Override
	public Note findNoteByNoteId(int noteId) {
		return noteMapper.findNoteByNoteId(noteId);
	}

	@Override
	public int getNoteCount(int userId) {
		return noteMapper.getNoteCount(userId);
	}

}
