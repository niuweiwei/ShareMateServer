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
		        
		    List<Comment> commentList = commentService.getCommentListByNoteId(noteId);
			for(Comment c:commentList) {
			    for(Reply r:c.getReplyList()) {
			    	List<Reply> reReplyList = new ArrayList<Reply>();
			    	commentService.getReReplyListByReplyId(r,reReplyList);
			    	r.setReReplyList(reReplyList);
			    }
			    System.out.println("回复的回复");
			}
			System.out.println("回复的回复"+commentList.get(0).getReplyList().get(0).getReReplyList());
			String jsonString="已更新";
			jsonString = JsonTools.createJsonString("commentList",commentList);
			try {
				response.getWriter().append(jsonString);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
