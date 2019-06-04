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

	@Override
	public int getLikeCountBynoteId(int noteId) {
		//根据noteId查询笔记被点赞的总数
		return noteMapper.getLikeCountBynoteId(noteId);
	}

	@Override
	public List<Integer> getNoteIdListByUserId(int userId) {
		//根据userId查询赞表中被该用户赞过的note列表
		return noteMapper.getNoteIdListByUserId(userId);
	}

	@Override
	public int insertPick(int userId, int noteId, String date) {
		//点赞向likes表中添加赞
		return noteMapper.insertPick(userId, noteId, date);
	}

	@Override
	public void deletePick(int userId, int noteId) {
		// 取消赞
		noteMapper.deletePick(userId, noteId);
	}

	@Override
	public int getCollectCountBynoteId(int noteId) {
		//根据noteId查询笔记被收藏的总数
		return noteMapper.getCollectCountBynoteId(noteId);
	}

	@Override
	public int getCommentCountBynoteId(int noteId) {
		//根据noteId查询笔记被评论的总数
		return noteMapper.getCollectCountBynoteId(noteId);
	}

	@Override
	public List<Integer> getUserIdFollowByUserId(int userId) {
		//根据userId查询关注表中被该用户关注过的user列表
		return noteMapper.getUserIdFollowByUserId(userId);
		
	}

	@Override
	public List<Integer> getNoteIdCollectByUserId(int userId) {
		//根据userId查询收藏表中被该用户收藏过的note列表
		return noteMapper.getNoteIdCollectByUserId(userId);
	}

	@Override
	public int insertCollect(int userId, int noteId) {
		// 收藏
		return noteMapper.insertCollect(userId, noteId);
	}

	@Override
	public int deleteCollect(int userId, int noteId) {
		// 取消收藏
		return noteMapper.deleteCollect(userId, noteId);
	}

	@Override
	public int insertFollow(int userId, int followedId, String date) {
		// 关注
		return noteMapper.insertFollow(userId, followedId, date);
	}

	@Override
	public int deleteFollow(int userId, int followedId) {
		// 取消关注
		return noteMapper.deleteFollow(userId, followedId);
	}

	@Override
	public List<Note> getNearbyNoteList(String address) {
		//分页查询得到附近笔记列表
		return noteMapper.getNearbyNoteList(address);
	}
	
}
