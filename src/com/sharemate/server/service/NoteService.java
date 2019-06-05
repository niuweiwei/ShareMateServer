package com.sharemate.server.service;

import java.util.List;

import com.sharemate.entity.Note;

/**

* @author fengjiaxing

* @version 2019年5月15日 上午8:47:38 

*/
public interface NoteService {

	public List<Note> findNoteByUserId(int userId);
	
	public Note findNoteByNoteId(int noteId);
	
	public int getNoteCount(int userId);
}
