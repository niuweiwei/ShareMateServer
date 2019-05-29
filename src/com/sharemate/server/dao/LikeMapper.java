package com.sharemate.server.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sharemate.entity.Like;

/**
 * @author niuweiwei
 *对点赞类的内容进行增删改查
 * */
@Repository
public interface LikeMapper {

	/**
	 * 根据笔记的id查询赞了该笔记的所有记录
	 * @param 笔记的id
	 * @return 赞了该笔记的记录
	 * */
	public List<Like> getLikeListByNoteId(int noteId);
	
	/**
	 * 根据评论的id查询赞了该评论的所有记录
	 * @param 评论的id
	 * @return 赞了该评论的记录
	 * */
	public List<Like> getLikeListByCommentId(int commentId);
	
	/**
	 * 根据回复的id查询赞了该回复的所有记录
	 * @param 回复的id
	 * @return 赞了该回复的记录
	 * */
	public List<Like> getLikeListByReplyId(int replyId);
	
	/**
	 * 根据返回对象判断某个用户是否点赞了该条评论 如果对象为null则代表数据库中没有该条记录 
	 * @param userId 用户id
	 * @param commentId 评论id
	 * @return
	 * */
	public Like isLikeComment(@Param("userId")int userId,@Param("commentId")int commentId);
	
	/**
	 * 根据返回对象判断某个用户是否点赞了该条回复 如果对象为null则代表数据库中没有该条记录
	 * @param userId 用户id
	 * @param replyId 回复id
	 * @return
	 * */
	public Like isLikeReply(@Param("userId") int userId,@Param("replyId") int replyId);
	
	/**
	 * 对评论进行点赞
	 * @param userId 点赞的用户的id
	 * @param commentId 点赞的评论的id
	 * @param likeDate 点赞的日期
	 * @return int 受影响的行数
	 * */
	public int likeComment(@Param("userId") int userId,@Param("commentId") int commentId,@Param("likeDate")Date likeDate);
	
	/**
	 * 对回复进行点赞
	 * @param userId 点赞的用户的id
	 * @param replyId 点赞的回复的id
	 * @param likeDate 点赞的日期
	 * @return int 受影响的行数
	 * */
	public int likeReply(@Param("userId") int userId,@Param("replyId")int replyId,@Param("likeDate")Date likeDate);
	
	/**
	 * 取消对评论的点赞
	 * @param userId 点赞的用户的id
	 * @param commentId 需要取消点赞的评论的id
	 * @return int 返回受影响的行数
	 * */
	public int cancelLikeComment(@Param("userId")int userId,@Param("commentId")int commentId);
	
	/**
	 * 取消对回复的点赞
	 * @param userId 点赞的用户的id
	 * @param commentId 需要取消点赞的回复的id
	 * @return int 返回受影响的行数
	 * */
	public int cancelLikeReply(@Param("userId")int userId,@Param("replyId")int replyId);
}
