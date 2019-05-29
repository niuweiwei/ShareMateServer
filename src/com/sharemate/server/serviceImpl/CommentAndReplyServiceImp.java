package com.sharemate.server.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.Comment;
import com.sharemate.entity.CommentAndReply;
import com.sharemate.entity.Like;
import com.sharemate.entity.Note;
import com.sharemate.entity.Reply;
import com.sharemate.server.dao.CommentMapper;
import com.sharemate.server.dao.LikeMapper;
import com.sharemate.server.dao.NoteMapper;
import com.sharemate.server.dao.ReplyMapper;
import com.sharemate.server.service.CommentAndReplyService;

@Service
public class CommentAndReplyServiceImp implements CommentAndReplyService {

	@Autowired
	public NoteMapper noteMapper;
	@Autowired
	public CommentMapper commentMapper;
	@Autowired
	public LikeMapper likeMapper;
	@Autowired
	public ReplyMapper replyMapper;
	
	@Override
	public CommentAndReply getCommentAndReplyByComment(int userId,Comment comment) {
		// TODO Auto-generated method stub
		//将对笔记的Comment对象转换为CommentAndReply对象
		CommentAndReply commentAndReply = new CommentAndReply();
		commentAndReply.setTag(CommentAndReply.COMMENT_TYPE);
		commentAndReply.setUser(comment.getUser());
		commentAndReply.setNote(comment.getNote());
		commentAndReply.setCommentContent(comment.getCommentDetail());
		commentAndReply.setCommentDate(comment.getCommentDate());
		//判断用户是否对该评论点赞
		Like likeComment = likeMapper.isLikeComment(userId, comment.getCommentId());
		if(likeComment == null)
			commentAndReply.setLike(false);
		else
			commentAndReply.setLike(true);
		return commentAndReply;
	}
	
	@Override
	public CommentAndReply getCommentAndReplyByReply(int userId, Reply reply) {
		// TODO Auto-generated method stub
		CommentAndReply commentAndReply = new CommentAndReply();
		//判断该回复是对评论的回复 还是回复的回复
		Comment comment = reply.getComment();
		if(comment != null) {
			//是对评论的回复
			commentAndReply.setTag(CommentAndReply.REPLY_TYPE);
			commentAndReply.setNote(comment.getNote());
			commentAndReply.setArguedId(comment.getCommentId());
			commentAndReply.setArguedUser(comment.getUser());
			commentAndReply.setCommentedContent(comment.getCommentDetail());
		} else {
			//对回复的回复
			commentAndReply.setTag(CommentAndReply.RE_REPLY_TYPE);
			commentAndReply.setArguedId(reply.getReReplyId());
			commentAndReply.setArguedUser(replyMapper.getReplyByReplyId(reply.getReReplyId()).getUser());
			commentAndReply.setCommentedContent(replyMapper.getReplyByReplyId(reply.getReReplyId()).getReplyDetail());
			//向上回溯到最顶层的评论 找出相关的笔记
			Reply tmp = reply;
			while(tmp.getComment() == null ) {
				//根据被回复的id reReplyId 找到被回复的回复详情
				tmp = replyMapper.getReplyByReplyId(tmp.getReReplyId());
			}
			commentAndReply.setNote(tmp.getComment().getNote());
		}
		commentAndReply.setUser(reply.getUser());
		commentAndReply.setCommentContent(reply.getReplyDetail());
		commentAndReply.setCommentDate(reply.getReplyDate());
		
		Like likeReply = likeMapper.isLikeReply(userId, reply.getReplyId());
		if(likeReply == null)
			commentAndReply.setLike(false);
		else
			commentAndReply.setLike(true);
		
		return commentAndReply;
	}
	
	@Override
	public void putReRepliesIntoList(int userId,Reply reply, List<CommentAndReply> list) {
		// TODO Auto-generated method stub
		//获取到所有回复了reply的回复
		 List<Reply> replyList = replyMapper.getReplyListByReReplyId(reply.getReplyId());
		 if(replyList.size() != 0) {
			 //表明该回复被回复了
			 for(Reply replyItem : replyList) {
				 CommentAndReply cReply = getCommentAndReplyByReply(userId,replyItem);
				 list.add(cReply);
				 //获取该回复的回复列表
				 putReRepliesIntoList(userId,replyItem,list);
			 }
		 }else {
			 return;
		 }
		 
	}
	
	@Override
	public List<CommentAndReply> getAllCAndR(int userId) {
		// TODO Auto-generated method stub
		List<CommentAndReply> list = new ArrayList<>();
		//根据用户id查询该用户发过的所有笔记 再根据该笔记下查询其所有的评论及回复
		List<Note> noteList = noteMapper.getNoteListByUserId(userId);
		for(Note note : noteList) {
			//获得每个笔记下的全部评论
			List<Comment> commentList = commentMapper.getCommentListByNoteId(note.getNoteId());
			for(Comment commentItem : commentList) {
				CommentAndReply comment = getCommentAndReplyByComment(userId,commentItem);
				list.add(comment);
				
				//获得每个评论下的全部回复
				List<Reply> replyList = replyMapper.getReplyListByCommentId(commentItem.getCommentId());
				for(Reply replyItem : replyList) {
					CommentAndReply reply = getCommentAndReplyByReply(userId,replyItem);
					list.add(reply);
					//将回复下的所有回复放入CommentAndReply的list中
					putReRepliesIntoList(userId,replyItem,list);
				}
			}
		}
		
		//根据当前用户的id查询该用户发布的所有评论
		List<Comment> commentList = commentMapper.getCommentListByUserId(userId);
		for(Comment comment : commentList) {
			//查询回复了该评论的所有回复
			List<Reply> replyList = replyMapper.getReplyListByCommentId(comment.getCommentId());
			for(Reply replyItem : replyList) {
				CommentAndReply reply = getCommentAndReplyByReply(userId,replyItem);
				list.add(reply);
			}
		}
		
		//根据当前用户的id查询该用户发布的所有回复
		List<Reply> replyList = replyMapper.getReplyListByUserId(userId);
		for(Reply replyItem : replyList) {
			//查询回复了该回复的所有回复
			List<Reply> secReplyList = replyMapper.getReplyListByReReplyId(replyItem.getReplyId());
			for(Reply secReply : secReplyList ) {
				CommentAndReply reply = getCommentAndReplyByReply(userId,secReply);
				list.add(reply);
			}
		}
		//将列表中发布者为当前用户的记录去掉
		for(int i=0;i<list.size();i++) {
			CommentAndReply commentAndReply = list.get(i);
			if(commentAndReply.getUser().getUserId() == userId) {
				int tmp = i;
				list.remove(i);
				i = tmp-1;
			}
	
		}
		//根据时间进行排序
		list.sort(new DateComparator());
		return list;
	}

	private class DateComparator implements Comparator<CommentAndReply>{

		@Override
		public int compare(CommentAndReply o1, CommentAndReply o2) {
			// TODO Auto-generated method stub
			String date1 = o1.getCommentDate();
			String date2 = o2.getCommentDate();
			System.out.println(date1);
			System.out.println(date2);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date time1 = new Date();
			Date time2 = new Date();
			try {
				time1 = dateFormat.parse(date1);
				time2 = dateFormat.parse(date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(time1.after(time2)) 
				return -1;
			else if(time1.before(time2))
				return 1;
			else
				return 0;
		}
	}

	


}
