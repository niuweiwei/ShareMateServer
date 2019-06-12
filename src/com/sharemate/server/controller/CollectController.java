package com.sharemate.server.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.entity.Note;
import com.sharemate.entity.User;
import com.sharemate.server.service.CollectService;
import com.sharemate.server.service.NoteService;
import com.sharemate.server.service.UserService;

import net.sf.json.JSONObject;

/**

* @author fengjiaxing

* @version 2019年5月15日 上午11:52:30 

*/
@Controller
@RequestMapping("/collect")
public class CollectController {

	@Autowired
	private CollectService collectService;
	@Autowired
	private NoteService noteService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findCollectNote")
	public void findCollectNote(int userId,HttpServletResponse resp) throws IOException {
		List<Integer> noteIdList = collectService.findNoteIdByUserId(userId);
		System.out.println("noteIdList---"+noteIdList);
		List<Note> collectList = new ArrayList<>();
		for(int i=0;i<noteIdList.size();i++) {
			System.out.println(noteIdList.get(i));
			Note note = noteService.findNoteByNoteId(noteIdList.get(i));
			int uId = noteService.getUserIdByNoteId(note.getNoteId());
			User u = userService.findUserByUserId(uId);
			System.out.println("u---"+u.toString());
			note.setUser(u);
			collectList.add(note);
		}
		JSONObject collectJson = new JSONObject();
		collectJson.put("collectList", collectList);
		System.out.println("collectList---"+collectJson.toString());
		resp.getWriter().append(collectJson.toString());
	}
}
