package com.sharemate.server.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.entity.Follow;
import com.sharemate.entity.Note;
import com.sharemate.server.service.FollowService;
import com.sharemate.server.service.LikesService;
import com.sharemate.server.service.NoteService;

import net.sf.json.JSONArray;
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
	@Autowired
	private LikesService likesService;
	@Autowired
	private NoteService noteService;
	/**
	 * 获取关注数量
	 * @param userId
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/getFollowCount")
	public void getFollowCount(int userId,HttpServletResponse resp) throws IOException {
		int followCount = followService.getFollowCountByUserId(userId);
		JSONObject followJson = new JSONObject();
		followJson.put("followCount", followCount);
		System.out.println(followJson.toString());
		resp.getWriter().append(followJson.toString());
	}
	/**
	 * 获取粉丝数量
	 * @param userId
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/getFanCount")
	public void getFanCount(int userId,HttpServletResponse resp) throws IOException {
		int fanCount = followService.getFanCountByUserId(userId);
		JSONObject fanJson = new JSONObject();
		fanJson.put("fanCount", fanCount);
		System.out.println("fanCount---"+fanJson.toString());
		resp.getWriter().append(fanJson.toString());
	}
	/**
	 * 获取所有粉丝
	 * @param userId
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/getFan")
	public void getFan(int userId,HttpServletResponse resp) throws IOException {
		List<Follow> fanList = followService.getFan(userId);
		System.out.println("fanList---"+fanList);
		JSONArray array = new JSONArray();
		for(Follow follow:fanList) {
			int noteCount = noteService.getNoteCount(follow.getFollowUser().getUserId());
			int fanCount = followService.getFanCountByUserId(follow.getFollowUser().getUserId());
			int followCount = followService.getFollowCountByUserId(follow.getFollowUser().getUserId());
			List<Note> noteList = noteService.findNoteByUserId(follow.getFollowUser().getUserId());
			int likesCount = 0;
			for(int i=0;i<noteList.size();i++) {
				int noteId = noteList.get(i).getNoteId();
				int likeCount = likesService.getLikesCount(noteId);
				likesCount += likeCount;
			}
			System.out.println("noteCount:"+noteCount+";fanCount"+fanCount+";followCount"+followCount+";likesCount:"+likesCount);
			JSONObject object = new JSONObject();
			object.put("userId",follow.getFollowUser().getUserId());
			object.put("userName",follow.getFollowUser().getUserName());
			object.put("userPhoto", follow.getFollowUser().getUserPhoto());
			object.put("userIntro", follow.getFollowUser().getUserIntro());
			object.put("status", follow.isStatus());
			object.put("noteCount", noteCount);
			object.put("fanCount", fanCount);
			object.put("followCount", followCount);
			object.put("likesCount", likesCount);
			array.add(object);
		}
		System.out.println("array---"+array.toString());
		resp.getWriter().append(array.toString());
	}
	/**
	 * 关注（插入粉丝）
	 * @param followId
	 * @param userId
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/insertFan")
	public void insertFan(int followId,int userId,HttpServletResponse resp) throws IOException {
		int i = followService.insertFan(followId, userId);
		System.out.println("插入了："+i+"行");
		if(i!=0) {
			resp.getWriter().append("插入成功");
		}else {
			resp.getWriter().append("插入失败");
		}
	}
	/**
	 * 取关（删除粉丝）
	 * @param followId
	 * @param userId
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("deleteFollow")
	public void deleteFollow(int followId,int userId,HttpServletResponse resp) throws IOException {
		int i = followService.deleteFollow(followId, userId);
		System.out.println("删除了："+i+"行");
		if(i!=0) {
			resp.getWriter().append("删除成功");
		}else {
			resp.getWriter().append("删除失败");
		}
	}
	/**
	 * 查看关注数量
	 * @param userId
	 * @param resp
	 * @throws IOException 
	 */
	@RequestMapping("getFollowed")
	public void getFollowed(int userId,HttpServletResponse resp) throws IOException {
		List<Follow> followList = followService.getFollowed(userId);
		System.out.println("followList---"+followList);
		JSONArray array = new JSONArray();
		for(Follow follow:followList) {
			int noteCount = noteService.getNoteCount(follow.getFollowedUser().getUserId());
			int fanCount = followService.getFanCountByUserId(follow.getFollowedUser().getUserId());
			int followCount = followService.getFollowCountByUserId(follow.getFollowedUser().getUserId());
			List<Note> noteList = noteService.findNoteByUserId(follow.getFollowedUser().getUserId());
			int likesCount = 0;
			for(int i=0;i<noteList.size();i++) {
				int noteId = noteList.get(i).getNoteId();
				int likeCount = likesService.getLikesCount(noteId);
				likesCount += likeCount;
			}
			System.out.println("noteCount:"+noteCount+";fanCount"+fanCount+";followCount"+followCount+";likesCount:"+likesCount);
			JSONObject object = new JSONObject();
			object.put("userId",follow.getFollowedUser().getUserId());
			object.put("userName",follow.getFollowedUser().getUserName());
			object.put("userPhoto", follow.getFollowedUser().getUserPhoto());
			object.put("userIntro", follow.getFollowedUser().getUserIntro());
			object.put("status", follow.isStatus());
			object.put("noteCount", noteCount);
			object.put("fanCount", fanCount);
			object.put("followCount", followCount);
			object.put("likesCount", likesCount);
			array.add(object);
		}
		System.out.println("array---"+array.toString());
		resp.getWriter().append(array.toString());
	}
}
