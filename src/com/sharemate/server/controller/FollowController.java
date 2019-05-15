package com.sharemate.server.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.entity.Follow;
import com.sharemate.server.service.FollowService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("follow")
public class FollowController {

	@Autowired
	private FollowService followService;
	
	@RequestMapping("followList/{followedId}")
	public void getFollowList(HttpServletResponse response,@PathVariable int followedId) throws IOException {
		response.setCharacterEncoding("utf-8");
		List<Follow> followList = followService.getFollowList(followedId);
		JSONArray jsonFollowList = new JSONArray();
		for(Follow follow : followList) {
			JSONObject jsonFollow = new JSONObject();
			jsonFollow.put("id", follow.getId());
			jsonFollow.put("followUser", follow.getFollowUser());
			jsonFollow.put("followedUser", follow.getFollowedUser());
			jsonFollow.put("followDate", follow.getFollowDate());
			jsonFollow.put("isFollow", follow.isFollow());
			jsonFollowList.add(jsonFollow);
		}
		response.getWriter().write(jsonFollowList.toString());
	}
	
	@RequestMapping("addFollow/{followId}/{followedId}")
	public void addFollow(@PathVariable int followId,@PathVariable int followedId) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String followDate = dateFormat.format(date);
		followService.follow(followId, followedId, followDate);
	}
	
	@RequestMapping("deleteFollow/{followId}/{followedId}")
	public void deleteFollow(@PathVariable int followId,@PathVariable int followedId) {
		followService.cancelFollow(followId, followedId);
	}
}
