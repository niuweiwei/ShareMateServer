package com.sharemate.server.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.entity.Like;
import com.sharemate.entity.Note;
import com.sharemate.server.service.FollowService;
import com.sharemate.server.service.LikeService;
import com.sharemate.server.service.NoteService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**

* @author fengjiaxing

* @version 2019年5月15日 下午4:59:30 

*/
@Controller
@RequestMapping("/like")
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	@Autowired
	private NoteService noteService;
	@Autowired
	private FollowService followService;
	
	@RequestMapping("/getLikesCount")
	public void getLikesCount(int userId,HttpServletResponse resp) throws IOException {
		List<Note> noteList = noteService.findNoteByUserId(userId);
		int likesCount = 0;
		for(int i=0;i<noteList.size();i++) {
			int noteId = noteList.get(i).getNoteId();
			int likeCount = likeService.getLikesCount(noteId);
			likesCount += likeCount;
		}
		JSONObject likeJson = new JSONObject();
		likeJson.put("likesCount", likesCount);
		System.out.println(likeJson.toString());
		resp.getWriter().append(likeJson.toString());
	}
	
	/*
	 * 薇薇
	 */
	@RequestMapping("getLikeList/{userId}")
	public void getLikeList(HttpServletResponse response,@PathVariable int userId) throws IOException {
		List<Like> likeList = likeService.getLikeListByUserId(userId);
		response.setCharacterEncoding("utf-8");
		JSONArray jsonLikeList = new JSONArray();
		for(Like like : likeList) {
			int fanCount = followService.getFanCountByUserId(like.getUser().getUserId());
			int followCount = followService.getFollowCountByUserId(like.getUser().getUserId());
			List<Note> noteList = noteService.findNoteByUserId(like.getUser().getUserId());
			int likesCount = 0;
			for(int i=0;i<noteList.size();i++) {
				int noteId = noteList.get(i).getNoteId();
				int likeCount = likeService.getLikesCount(noteId);
				likesCount += likeCount;
			}
			System.out.println("fanCount:"+fanCount);
			System.out.println("followCount:"+followCount);
			System.out.println("likesCount:"+likesCount);
			if(like.getUser().getUserId() != userId) {
				JSONObject jsonLike = new JSONObject();
				jsonLike.put("likeId", like.getLikeId());
				jsonLike.put("note", like.getNote());
				jsonLike.put("comment", like.getComment());
				jsonLike.put("reply", like.getReply());
				jsonLike.put("user", like.getUser());
				jsonLike.put("likeDate", like.getLikeDate());
				jsonLike.put("fanCount", fanCount);
				jsonLike.put("followCount", followCount);
				jsonLike.put("likeCount", likesCount);
				jsonLikeList.add(jsonLike);
			}
			
		}
		System.out.println(jsonLikeList.toString());
		response.getWriter().write(jsonLikeList.toString());
	}
	
	@RequestMapping("likeCommentOrReply")
	public void like(HttpServletRequest request) {
		int tag = Integer.parseInt(request.getParameter("tag"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int id = Integer.parseInt(request.getParameter("id"));
		likeService.likeCommentOrReply(tag, userId, id);
	}
	
	@RequestMapping("cancelLike")
	public void cancelLike(HttpServletRequest request) {
		int tag = Integer.parseInt(request.getParameter("tag"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int id = Integer.parseInt(request.getParameter("id"));
		likeService.cancelLikeCommentOrReply(tag, userId, id);
	}
}
