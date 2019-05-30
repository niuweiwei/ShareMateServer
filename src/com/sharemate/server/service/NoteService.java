package com.sharemate.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sharemate.entity.Note;

@Service
public interface NoteService {
	public void text();
	public List<Note> findGuanzhuNote(int userid);
	public void insertNote(Note note);
}



	
