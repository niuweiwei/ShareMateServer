package com.sharemate.server.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.Note;
import com.sharemate.server.dao.NoteMapper;
import com.sharemate.server.service.NoteService;
import com.sharemate.server.service.UserService;

@Service
public class NoteServiceImpl implements NoteService{
	@Autowired
	private NoteMapper noteMapper;
	@Override
	public void text() {
		System.out.println("notetest");
		
	}

	@Override
	public List<Note> findGuanzhuNote(int userid) {
		
		return noteMapper.findGuanzhuNoteById(userid);
	}

	@Override
	public void insertNote(Note note) {
		//noteMapper.insertNote(note);
		
	}

}