package com.sharemate.server.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sharemate.entity.Comment;
import com.sharemate.entity.Reply;
import com.sharemate.server.service.CommentService;
import com.sharemate.server.service.UserService;
import com.sharemate.util.JsonTools;

@RequestMapping("/comment")
@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	//获取评论和回复
	@RequestMapping("/getComment/{noteId}")
	@ResponseBody
	public void getComment(@PathVariable Integer noteId,
		HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		String userId = request.getParameter("userId");
		int userid = Integer.parseInt(userId);
		List<Comment> commentList = commentService.getCommentListByNoteId(noteId);
	    List<Integer> commentLikeList = commentService.getLikeCommentByUserId(userid);
	    List<Integer> replyLikeList = commentService.getLikeReplyByUserId(userid);
		for(Comment c:commentList) {
			List<Reply> reply = new ArrayList<Reply>();
		    for(Reply r:c.getReplyList()) {
		    	List<Reply> reReplyList = new ArrayList<Reply>();
		    	commentService.getReReplyListByReplyId(r,reReplyList);
		    	reply.add(r);
		    	reply.addAll(reReplyList);
		    }
		    c.setReplyList(reply);
		   
		}
	    for(Comment c:commentList) {
	    	for(Reply r:c.getReplyList()) {
	    		for(int rId:replyLikeList){
			    	if(r.getReplyId()==rId) {
			    		r.setLike(true);
			    		break;
			    	}
			    }
	    	 }
	    	 for(int cId:commentLikeList){
			    	if(c.getCommentId()==cId) {
			    		c.setLike(true);
			    		break;
			    	}
			 }
	    }
		String jsonString="已更新";
		jsonString = JsonTools.createJsonString("commentList",commentList);
		try {
			response.getWriter().append(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		    
	
	//添加评论和回复
	@RequestMapping("/addComment")
	@ResponseBody
	public void addComment(HttpServletRequest request,HttpServletResponse response){
			response.setContentType("text/html;charset=UTF-8");
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String date = sdf.format(d);
			String userId = request.getParameter("userId");
			String noteId = request.getParameter("noteId");
			int userid = Integer.parseInt(userId);
			int noteid = Integer.parseInt(noteId);
			String comment = request.getParameter("comment");
			commentService.addComment(userid, noteid, date, comment);
			String jsonString="已更新";
			try {
				response.getWriter().append(jsonString);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	//添加回复
	@RequestMapping("/addReply")
	@ResponseBody
	public void addReply(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");	
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String date = sdf.format(d);
		String userId = request.getParameter("userId");
		String commentId = request.getParameter("commentId");
		int userid = Integer.parseInt(userId);
		int commentid = Integer.parseInt(commentId);
		String reply = request.getParameter("reply");
		commentService.addReply(userid, commentid, date,reply);
		String jsonString="已更新";
		try {
			response.getWriter().append(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//添加回复
	@RequestMapping("/addReReply")
	@ResponseBody
	public void addReReply(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String date = sdf.format(d);
		String userId = request.getParameter("userId");
		String reReplyId = request.getParameter("reReplyId");
		int userid = Integer.parseInt(userId);
		int reReplyid = Integer.parseInt(reReplyId);
		String reply = request.getParameter("reply");
		commentService.addReReply(userid, reReplyid, date,reply);
		String jsonString="已更新";
		try {
			response.getWriter().append(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//点赞和取消点赞
	@RequestMapping("/pick/{commentId}")
	@ResponseBody
	public void pick(ModelMap map,@PathVariable Integer commentId,
			HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		String uId = request.getParameter("userId");
		String  like = request.getParameter("like");
		int userId = Integer.parseInt(uId);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String date = sdf.format(d);
	    if(like.equals("false")) {
	    	commentService.insertPick(userId, commentId, date);
	    }else {
	    	commentService.deletePick(userId, commentId);
	    }
		String jsonString="已更新";
		try {
			response.getWriter().append(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}	
	//回复的点赞和取消点赞
	@RequestMapping("/pickReply/{replyId}")
	@ResponseBody
	public void pickReply(ModelMap map,@PathVariable Integer replyId,
				HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		String uId = request.getParameter("userId");
		String  like = request.getParameter("like");
		int userId = Integer.parseInt(uId);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String date = sdf.format(d);
	    if(like.equals("false")) {
	    	commentService.insertReplyPick(userId, replyId, date);
	    }else {
	    	commentService.deleteReplyPick(userId, replyId);
	    }
		String jsonString="已更新";
		try {
			response.getWriter().append(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}					
	}		
}
