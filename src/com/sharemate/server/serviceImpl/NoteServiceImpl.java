package com.sharemate.server.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.Collect;
import com.sharemate.entity.Follow;
import com.sharemate.entity.Like;
import com.sharemate.entity.Note;
import com.sharemate.entity.comment;
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
		System.out.println("noteservice");
		return noteMapper.findGuanzhuNoteById(userid);
	}

	@Override
	public void insertNote(Note note) {
		//noteMapper.insertNote(note);
		
	}

	@Override
	public List<Follow> findGuanzhuUser(int followuserid) {
		
		return noteMapper.findGuanzhuUser(followuserid);
	}

	@Override
	public Note findNoteByNoteId(int noteid) {
		
		return noteMapper.findNoteByNoteId(noteid);
	}

	@Override
	public void addZanCount(Note note) {
		noteMapper.addZanCount(note);
		
	}
	public void insertLike(Like like) {
		noteMapper.insertLike(like);
		
	}

	@Override
	public void addCollectCount(Note note) {
		noteMapper.addCollectCount(note);
		
	}

	@Override
	public void insertCollect(Collect collect) {
		noteMapper.insertCollect(collect);
		
	}

	@Override
	public void insertBaseNote(Note note) {
		noteMapper.insertBaseNote(note);
		
	}

	@Override
	public void insertComment(comment comment) {
		noteMapper.insertComment(comment);
		
	}

	@Override
	public int getZancount(int noteid) {
		
		return noteMapper.getZancount(noteid);
	}

	@Override
	public int getCollectcount(int noteid) {
		
		return noteMapper.getCollectcount(noteid);
	}

	@Override
	public int getCommentcount(int noteid) {
		// TODO Auto-generated method stub
		return noteMapper.getCommentcount(noteid);
	}

	@Override
	public List<comment> findCommentByNoteId(int noteid) {
		// TODO Auto-generated method stub
		return noteMapper.findCommentByNoteId(noteid);
	}
}

