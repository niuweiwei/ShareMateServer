package com.sharemate.server.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.entity.Follow;
import com.sharemate.entity.Note;
import com.sharemate.server.service.FollowService;
import com.sharemate.server.service.NoteService;
import com.sharemate.server.service.UserService;
@Controller
@RequestMapping("note")
public class NoteController {
	@Autowired
	public  UserService userservice;
	public  NoteService noteservice;
	public  FollowService followservice;
	@RequestMapping("text")
	public void text() {
		userservice.text();
		
	}
	@RequestMapping("allnotelist")
	public void findAllNote(HttpServletRequest req,HttpServletResponse rep) throws Exception{
		userservice.text();
		int userid=1;
		followservice.findGuanzhuUser(userid);
//		List<Note> notelist=noteservice.findGuanzhuNote(1);
		
//		String jsonString="";
//		jsonString = JsonTools.createJsonString("notelist",notelist);
//		PrintWriter writer = rep.getWriter();
//		writer.append(jsonString);
//		
		
	}
	
}
