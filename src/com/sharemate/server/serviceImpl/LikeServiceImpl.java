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
import com.sharemate.server.service.LikeService;

/**

* @author fengjiaxing

* @version 2019年5月15日 下午4:59:12 

*/
@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeMapper likeMapper;
	@Autowired
	private NoteMapper noteMapper;
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public int getLikesCount(int noteId) {
		return likeMapper.getLikesCount(noteId);
	}

	/*
	 * 薇薇
	 */
	@Override
	public List<Like> getLikeListByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Like> likeList = new ArrayList<>();
		List<Note> noteList = noteMapper.getNoteListByUserId(userId);
		List<Comment> commentList = commentMapper.getCommentListByUserId(userId);
		List<Reply> replyList = replyMapper.getReplyListByUserId(userId);
		for(Note note:noteList) {
			List<Like> subNoteLikeList = likeMapper.getLikeListByNoteId(note.getNoteId());
			likeList.addAll(subNoteLikeList);
		}
		for(Comment comment:commentList) {
			List<Like> subCommentLikeList = likeMapper.getLikeListByCommentId(comment.getCommentId());
			for(Like likeComment : subCommentLikeList) {
				likeComment.setNote(likeComment.getComment().getNote());
			}
			likeList.addAll(subCommentLikeList);
		}
		for(Reply reply:replyList) {
			List<Like> subReplyLikeList = likeMapper.getLikeListByReplyId(reply.getReplyId());
			for(Like likeReply : subReplyLikeList) {
				//得到的是like的回复
				Reply likeDetail = likeReply.getReply();
				Comment comment = likeDetail.getComment();
				while(comment == null) {	//表示likeDetail所指的reply是对回复的回复
				//将被likeDetail回复的回复赋值给likeDetail
					likeDetail = replyMapper.getReplyByReplyId(likeDetail.getReReplyId());
					comment = likeDetail.getComment();
				}
				likeReply.setNote(comment.getNote());
			}
			likeList.addAll(subReplyLikeList);
		}
		//对likeList中的记录按照时间顺序进行排序
		likeList.sort(new DateComparator());
		return likeList;
	}

	private class DateComparator implements Comparator<Like>{

		@Override
		public int compare(Like o1, Like o2) {
			// TODO Auto-generated method stub
			String date1 = o1.getLikeDate();
			String date2 = o2.getLikeDate();
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

	@Override
	public void likeCommentOrReply(int tag, int userId, int id) {
		// TODO Auto-generated method stub
		Date date = new Date();
		if(tag == CommentAndReply.COMMENT_TYPE)
			likeMapper.likeComment(userId, id,date);
		else
			likeMapper.likeComment(userId, id,date);
	}

	@Override
	public void cancelLikeCommentOrReply(int tag, int userId, int id) {
		// TODO Auto-generated method stub
		if(tag == CommentAndReply.COMMENT_TYPE)
			likeMapper.cancelLikeComment(userId, id);
		else
			likeMapper.cancelLikeReply(userId, id);
	}
}
