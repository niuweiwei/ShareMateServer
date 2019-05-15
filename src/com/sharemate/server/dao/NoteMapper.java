package com.sharemate.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharemate.entity.Note;

public interface NoteMapper {

	//分页查询得到部分笔记列表
	public List<Note> getNoteSubList();
	
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
	
	//收藏
	public int insertCollect(@Param("userId")int userId,@Param("noteId")int noteId);
	
	//取消收藏
	public int deleteCollect(@Param("userId")int userId,@Param("noteId")int noteId);
}
