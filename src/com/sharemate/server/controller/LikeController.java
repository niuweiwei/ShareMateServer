package com.sharemate.server.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.entity.Like;
import com.sharemate.server.service.LikeService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("like")
public class LikeController {

	@Autowired
	private LikeService likeService;
	
	@RequestMapping("getLikeList/{userId}")
	public void getLikeList(HttpServletResponse response,@PathVariable int userId) throws IOException {
		List<Like> likeList = likeService.getLikeListByUserId(userId);
		response.setCharacterEncoding("utf-8");
		JSONArray jsonLikeList = new JSONArray();
		for(Like like : likeList) {
			JSONObject jsonLike = new JSONObject();
			jsonLike.put("likeId", like.getLikeId());
			jsonLike.put("note", like.getNote());
			jsonLike.put("comment", like.getComment());
			jsonLike.put("reply", like.getReply());
			jsonLike.put("user", like.getUser());
			SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
			String likeDate = formate.format(like.getLikeDate());
			jsonLike.put("likeDate", likeDate);
			jsonLikeList.add(jsonLike);
		}
		response.getWriter().write(jsonLikeList.toString());
	}
}
