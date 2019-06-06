package com.sharemate.server.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sharemate.entity.Reply;

@Repository
public interface ReplyMapper {
	
	/**
	 * 根据指定的用户id获取该用户发布过的所有回复
	 * @param userId 指定用户id
	 * @return 返回回复列表
	 * */
	public List<Reply> getReplyListByUserId(int userId);
	
	/**
	 * 根据回复的id查询回复的详情
	 * @param replyId 指定回复id
	 * @return 返回回复对象
	 * */
	public Reply getReplyByReplyId(int replyId);
	
	/**
	 * 查询回复了指定回复的回复列表
	 * @param reReplyId 指定的回复
	 * */
	public List<Reply> getReplyListByReReplyId(int reReplyId);

	/**
	 * 根据指定的评论id获取对该评论的所有回复
	 * */
	public List<Reply> getReplyListByCommentId(int commentId);
	
	/**
	 * 向reply表中添加对评论的回复
	 * @param userId 发布该回复的用户id
	 * @param commentId 对哪个comment的回复 对应数据库中的comment_id字段名
	 * @param replyDetail 回复的具体内容
	 * @param date 回复的时间
	 * @return 返回受影响的行数
	 * */
	public int addCommentReply(@Param("userId")int userId,@Param("commentId")int commentId,@Param("replyDetail")String replyDetail,@Param("replyDate") Date date);
	
	/**
	 * 向reply表中添加对回复的回复
	 * @param userId 发布该回复的用户id
	 * @param replyId 对哪个reply的回复 对应reply表中的re_reply_id字段名
	 * @param replyDetail 回复的具体内容
	 * @param date 回复的时间
	 * @return 返回受影响的行数
	 * */
	public int addReplyReply(@Param("userId")int userId,@Param("reReplyId")int replyId,@Param("replyDetail")String replyDetail,@Param("replyDate")Date date);
	
	/**
	 * 删除回复
	 * @param replyId 回复的id 对应reply表中的reply_id
	 * @return int 返回受影响的行数
	 * */
	public int deleteReply(int replyId);
}
