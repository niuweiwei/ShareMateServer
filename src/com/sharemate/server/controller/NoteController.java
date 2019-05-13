package com.sharemate.server.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.sharemate.entity.Note;
import com.sharemate.server.service.NoteService;
import com.sharemate.util.JsonTools;

@RequestMapping("/note")
@Controller
public class NoteController {

	@Autowired
	private NoteService noteService;
	
	//返回首页页面（num=当前页数）
	@RequestMapping("/recommend/{currentPage}")
	@ResponseBody
	public void getNoteList(ModelMap map,@PathVariable Integer currentPage,
		HttpServletRequest request,HttpServletResponse response){
		System.out.println("notesublist");
		response.setContentType("text/html;charset=UTF-8");
		PageHelper.startPage(currentPage,20);
		List<Note> noteList = noteService.getNoteSubList();
		PageInfo<Note> pageInfo = new PageInfo<>(noteList);
		List<Note> noteSubList = pageInfo.getList();
		String jsonString="";
		jsonString = JsonTools.createJsonString("note",noteSubList);
		try {
			response.getWriter().append(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
