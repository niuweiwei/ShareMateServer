package com.sharemate.server.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
		    Collections.shuffle(noteSubList);
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
}
