package com.sharemate.server.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sun.net.www.content.text.plain;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;
import com.sharemate.entity.Note;
import com.sharemate.server.dao.NoteMapper;
import com.sharemate.server.service.NoteService;
import com.sharemate.util.JsonTools;

@RequestMapping("/note")
@Controller
public class NoteController {

	@Autowired
	private NoteService noteService;
	
	//返回首页页面（currentPage=当前页数）
	@RequestMapping("/recommend/{currentPage}")
	@ResponseBody
	public void getNoteList(ModelMap map,@PathVariable Integer currentPage,
		HttpServletRequest request,HttpServletResponse response){
		
		response.setContentType("text/html;charset=UTF-8");
		String tid = request.getParameter("typeId");
		String uId = request.getParameter("userId");
		int typeId = Integer.parseInt(tid);
		System.out.println("typeid"+typeId);
		List<Note> noteSubList = new ArrayList<>();
		int pages=0;
		if(typeId==0) {
		    PageHelper.startPage(currentPage,30);
		    List<Note> noteList = noteService.getNoteSubList();
		    Collections.shuffle(noteList);
		    PageInfo<Note> pageInfo = new PageInfo<>(noteList);
		    pages = pageInfo.getPages();
		    noteSubList = pageInfo.getList();
		}else {
			PageHelper.startPage(currentPage,20);
            //根据typeId查询note
			List<Note> noteList=noteService.getNoteByTypeId(typeId);
			PageInfo<Note> pageInfo = new PageInfo<>(noteList);
			pages = pageInfo.getPages();
		    noteSubList = pageInfo.getList();
//		    Collections.shuffle(noteSubList);
		}
		if(uId!=null&&!uId.equals("")) {
			int userId = Integer.parseInt(uId);
			List<Integer> noteIdList = new ArrayList<>();
			noteIdList = noteService.getNoteIdListByUserId(userId);
			List<Integer> userIdFollowList = new ArrayList<>();
			userIdFollowList = noteService.getUserIdFollowByUserId(userId);
			List<Integer> noteIdCollectList = new ArrayList<>();
			noteIdCollectList = noteService.getNoteIdCollectByUserId(userId);
			for(Note note:noteSubList) {
				for(int noteId:noteIdList) {
					if(note.getNoteId()==noteId) {
						note.setLike(true);
						break;
					}
				}
				for(int noteId:noteIdCollectList) {
					if(note.getNoteId()==noteId) {
						note.setCollect(true);
						break;
					}
				}
				for(int userid:userIdFollowList) {
					if(note.getUser().getUserId()==userid) {
						note.setFollow(true);
						break;
					}
				}
			}
		}
		String jsonString="";
	    Map<String, Object> m = new HashMap<>();
	    m.put("note", noteSubList);
	    m.put("pages", pages);
	    jsonString = JsonTools.createJsonString("map",m);
		try {
			response.getWriter().append(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//点赞
	@RequestMapping("/pick/{noteId}")
	@ResponseBody
	public void pick(ModelMap map,@PathVariable Integer noteId,
		HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		String uId = request.getParameter("userId");
		String  like = request.getParameter("like");
		System.out.println("likekkk"+like);
		int userId = Integer.parseInt(uId);
		Date d = new Date();//获取当时间对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//获取时间格式
		String date = sdf.format(d);//将当前时间临时存储time上
	    if(like.equals("false")) {
	    	System.out.println(date);//打印输出当前时间
	    	noteService.insertPick(userId, noteId, date);
	    }else {
	    	System.out.println("islikehhhhh:"+like);
	    	noteService.deletePick(userId, noteId);
	    }
		String jsonString="已更新";
		try {
			response.getWriter().append(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//点赞
		@RequestMapping("/collect/{noteId}")
		@ResponseBody
		public void collect(@PathVariable Integer noteId,
			HttpServletRequest request,HttpServletResponse response){
			response.setContentType("text/html;charset=UTF-8");
			String uId = request.getParameter("userId");
			String  collect = request.getParameter("collect");
			System.out.println("lcollect"+collect);
			int userId = Integer.parseInt(uId);
		    if(collect.equals("false")) {
		    	noteService.insertCollect(userId, noteId);
		    }else {
		    	System.out.println("iscollect:"+collect);
		    	noteService.deleteCollect(userId, noteId);
		    }
			String jsonString="已更新";
			try {
				response.getWriter().append(jsonString);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
