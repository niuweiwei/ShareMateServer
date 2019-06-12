package com.sharemate.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharemate.entity.Collect;
import com.sharemate.entity.Comment;
import com.sharemate.entity.Follow;
import com.sharemate.entity.Like;
import com.sharemate.entity.Note;
import com.sharemate.entity.User;

/**

* @author fengjiaxing

* @version 2019年5月15日 上午8:47:23 

*/
public interface NoteMapper {
	/**
	 * 根据userId查询用户发布过的笔记
	 * @param userId
	 * @return
	 */
	public List<Note> findNoteByUserId(int userId);
	/**
	 * 根据noteId查询note
	 * @param noteId
	 * @return
	 */
	public Note findNoteByNoteId(int noteId);
	/**
	 * 查询出用户发表过的笔记数量
	 * @param userId
	 * @return
	 */
	public int getNoteCount(int userId);
	
	public int getUserIdByNoteId(int noteId);
	/**
	 * 付娆
	 */
	public List<Note> findGuanzhuNoteById(int userId);
	public List<Follow> findGuanzhuUser(int followuserid);
	//通过noteid找到note
//	public Note findNoteByNoteId(int noteid);
	//给对应的note赞数加一
	public void addZanCount(Note note);
	public void insertLike(Like like);
	//获取赞的总数
	public int getZancount(int noteid);
	//获收藏的总数
	public int getCollectcount(int noteid);
	//获评论的总数
	public int getCommentcount(int noteid);
	//给对应的note收藏数加一
	public void addCollectCount(Note note);
	public void insertCollect(Collect collect);
	//插入笔记基础信息
	public void insertBaseNote(Note note);
	//插入评论
	public void insertComment(Comment comment);
	//查询笔记评论
	public List<Comment> findCommentByNoteId(int noteid);
	//插入图片路径
	public void addPicAddress(Note note);
	//查userpic
	public User getUserPhoto(int userid);
	//获得点赞list
	public List<Like> findPickList(int userId);
	//获得收藏list
	public List<Collect> findCollectList(int userId);
	//查询最大的id
	public int findMaxNoteId();
	


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
	
	//根据userId查询关注表中被该用户赞过的note列表
	public List<Integer> getUserIdFollowByUserId(int userId);
	
	//根据userId查询关注表中被该用户赞过的note列表
	public List<Integer> getNoteIdCollectByUserId(int userId);
	
	//点赞向likes表中添加赞
	public int insertPick(@Param("userId")int userId,@Param("noteId")int noteId,
			@Param("date")String date);
	//取消赞
	public void deletePick(@Param("userId")int userId,@Param("noteId")int noteId);
	
	//加关注
	public int insertFollow(@Param("userId")int userId,@Param("followedId")int followedId,
			@Param("date")String date);
	
	//取消关注
	public int deleteFollow(@Param("userId")int userId,@Param("followedId")int followedId);
	
	//收藏
	public int insertCollect1(@Param("userId")int userId,@Param("noteId")int noteId);
	
	//取消收藏
	public int deleteCollect(@Param("userId")int userId,@Param("noteId")int noteId);
	
	/*
	 * 薇薇
	 */
	/**
	 * 根据用户的id查询该用户发布过的所有笔记
	 * @param userId: 指定的用户id
	 * @return 返回笔记列表
	 * */
	public List<Note> getNoteListByUserId(int userId);
	
	
	/**
	 * 根据笔记的id查询笔记详情
	 * @param noteId 指定的笔记id
	 * @return 返回笔记列表
	 * */
//	public Note getNoteByNoteId(int noteId);
}
