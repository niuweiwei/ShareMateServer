package com.sharemate.server.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.server.service.FollowService;

import net.sf.json.JSONObject;

/**

* @author fengjiaxing

* @version 2019年5月15日 下午4:00:11 

*/
@Controller
@RequestMapping("/follow")
public class FollowController {

	@Autowired
	private FollowService followService;

	@RequestMapping("/getFollowCount")
	public void getFollowCount(int userId,HttpServletResponse resp) throws IOException {
		int followCount = followService.getFollowCountByUserId(userId);
		JSONObject followJson = new JSONObject();
		followJson.put("followCount", followCount);
		System.out.println(followJson.toString());
		resp.getWriter().append(followJson.toString());
	}
	
	@RequestMapping("/getFanCount")
	public void getFanCount(int userId,HttpServletResponse resp) throws IOException {
		int fanCount = followService.getFanCountByUserId(userId);
		JSONObject fanJson = new JSONObject();
		fanJson.put("fanCount", fanCount);
		System.out.println(fanJson.toString());
		resp.getWriter().append(fanJson.toString());
	}
	
}
