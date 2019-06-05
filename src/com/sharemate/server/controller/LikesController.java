package com.sharemate.server.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.entity.Note;
import com.sharemate.server.service.LikesService;
import com.sharemate.server.service.NoteService;

import net.sf.json.JSONObject;

/**

* @author fengjiaxing

* @version 2019年5月15日 下午4:59:30 

*/
@Controller
@RequestMapping("/likes")
public class LikesController {
	
	@Autowired
	private LikesService likesService;
	@Autowired
	private NoteService noteService;
	
	@RequestMapping("/getLikesCount")
	public void getLikesCount(int userId,HttpServletResponse resp) throws IOException {
		List<Note> noteList = noteService.findNoteByUserId(userId);
		int likesCount = 0;
		for(int i=0;i<noteList.size();i++) {
			int noteId = noteList.get(i).getNoteId();
			int likeCount = likesService.getLikesCount(noteId);
			likesCount += likeCount;
		}
		JSONObject likeJson = new JSONObject();
		likeJson.put("likesCount", likesCount);
		System.out.println(likeJson.toString());
		resp.getWriter().append(likeJson.toString());
	}
}
