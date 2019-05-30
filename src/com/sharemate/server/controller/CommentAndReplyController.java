package com.sharemate.server.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.entity.CommentAndReply;
import com.sharemate.server.service.CommentAndReplyService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("CommentAndReply")
public class CommentAndReplyController {

	@Autowired
	public CommentAndReplyService service;
	
	@RequestMapping("getCAndRList/{userId}")
	public void getCommentAndReplyList(@PathVariable("userId")int userId,HttpServletResponse response) throws IOException {
		List<CommentAndReply> commentAndReplyList = service.getAllCAndR(userId);
		JSONArray jsonArray = new JSONArray();
		for(CommentAndReply item : commentAndReplyList) {
			JSONObject object = new JSONObject();
			object.put("tag", item.getTag());
			object.put("user", item.getUser());
			object.put("commentContent", item.getCommentContent());
			object.put("arguedUser", item.getArguedUser());
			object.put("commentedContent", item.getCommentedContent());
			object.put("commentDate", item.getCommentDate());
			object.put("note", item.getNote());
			object.put("id", item.getId());
			object.put("arguedId", item.getArguedId());
			object.put("isLike", item.isLike());
			jsonArray.add(object);
		}
		
		System.out.println(jsonArray.toString());
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonArray.toString());
	}
	
	@RequestMapping("addReply")
	public void addReply(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		int tag = Integer.parseInt(request.getParameter("tag"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int id = Integer.parseInt(request.getParameter("id"));
		String replyDetail = request.getParameter("replyContent");
		service.replyCommentOrReply(userId, tag, id, replyDetail);
	}
}
