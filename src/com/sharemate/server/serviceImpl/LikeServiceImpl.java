package com.sharemate.server.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.Comment;
import com.sharemate.entity.Like;
import com.sharemate.entity.Note;
import com.sharemate.entity.Reply;
import com.sharemate.server.dao.CommentMapper;
import com.sharemate.server.dao.LikeMapper;
import com.sharemate.server.dao.NoteMapper;
import com.sharemate.server.dao.ReplyMapper;
import com.sharemate.server.service.LikeService;

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
			likeList.addAll(subCommentLikeList);
		}
		for(Reply reply:replyList) {
			List<Like> subReplyLikeList = likeMapper.getLikeListByReplyId(reply.getReplyId());
			likeList.addAll(subReplyLikeList);
		}
		//对likeList中的记录按照时间顺序进行排序
		likeList.sort(new DateComparator());
		System.out.println(likeList);
		return likeList;
	}

	private class DateComparator implements Comparator<Like>{

		@Override
		public int compare(Like o1, Like o2) {
			// TODO Auto-generated method stub
			Date date1 = o1.getLikeDate();
			Date date2 = o2.getLikeDate();
			if(date1.after(date2)) 
				return -1;
			else if(date1.before(date2))
				return 1;
			else
				return 0;
		}
	}
}
