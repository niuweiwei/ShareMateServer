package com.sharemate.server.service;

import java.util.List;

import com.sharemate.entity.Collect;
import com.sharemate.entity.Comment;
import com.sharemate.entity.Follow;
import com.sharemate.entity.Like;
import com.sharemate.entity.Note;

/**

* @author fengjiaxing

* @version 2019年5月15日 上午8:47:38 

*/
public interface NoteService {

	public List<Note> findNoteByUserId(int userId);
	
	public Note findNoteByNoteId(int noteId);
	
	public int getNoteCount(int userId);
	
	/**
	 * 付娆
	 */
	public void text();
	public List<Note> findGuanzhuNote(int userid);
	public void insertNote(Note note);
	public List<Follow> findGuanzhuUser(int followuserid);
//	public Note findNoteByNoteId(int noteid);
	public void addZanCount(Note note);
	//加入like表
	public void insertLike(Like like);
	public void addCollectCount(Note note);
	public void insertCollect(Collect collect);
	//插入笔记基础信息
	public void insertBaseNote(Note note);
	//插入评论
	public void insertComment(Comment comment);
	//赞总数
	public int getZancount(int noteid);
	//获收藏的总数
	public int getCollectcount(int noteid);
	//获评论的总数
	public int getCommentcount(int noteid);
	//查询笔记评论
	public List<Comment> findCommentByNoteId(int noteid);
	
	/*
	 * 春柳
	 */
	//分页查询得到部分笔记列表
	public List<Note> getNoteSubList();
	
	//分页查询得到附近笔记列表
	public List<Note> getNearbyNoteList(String address);
	
	//根据typeId查询笔记列表
	public List<Note> getNoteByTypeId(int typeId);
	
	//根据noteId查询笔记
	public Note getNoteByNoteId(int noteId);
	
	//根据登录用户所在位置查询附近的人的笔记列表
	public Note getNoteListByUserLocation(String useraddress);
	
	//根据noteId查询笔记被点赞的总数
	public int getLikeCountBynoteId(int noteId);
	
	//根据noteId查询笔记被收藏的总数
	public int getCollectCountBynoteId(int noteId);
	
	//根据noteId查询笔记被评论的总数
	public int getCommentCountBynoteId(int noteId);
	
	//根据userId查询赞表中被该用户赞过的note列表
	public List<Integer> getNoteIdListByUserId(int userId);
	
	//根据userId查询关注表中被该用户关注过的user列表
	public List<Integer> getUserIdFollowByUserId(int userId);
	
	//根据userId查询收藏表中被该用户收藏过的note列表
	public List<Integer> getNoteIdCollectByUserId(int userId);
	
	//点赞向likes表中添加赞
	public int insertPick(int userId,int noteId,String date);
	
	//取消赞
	public void deletePick(int userId,int noteId);
	
	//收藏
	public int insertCollect1(int userId,int noteId);
	
	//取消收藏
	public int deleteCollect(int userId,int noteId);
	
	//加关注
	public int insertFollow(int userId,int followedId,String date);
	
	//取消关注
	public int deleteFollow(int userId,int followedId);
}
