package com.sharemate.server.dao;

import java.util.List;

import com.sharemate.entity.Note;

public interface NoteMapper {
	public List<Note> findGuanzhuNoteById(int userId);
}
