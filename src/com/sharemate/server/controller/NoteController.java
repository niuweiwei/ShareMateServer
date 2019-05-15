package com.sharemate.server.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.entity.Note;
import com.sharemate.server.service.NoteService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**

* @author fengjiaxing

* @version 2019年5月15日 上午8:49:10 

*/
@Controller
@RequestMapping("/note")
public class NoteController {

	@Autowired
	private NoteService noteService;
	
	@RequestMapping("/findNoteByUserId")
	public void findNoteByUserId(int userId,HttpServletResponse resp) throws IOException {
		List<Note> noteList = noteService.findNoteByUserId(userId);
		System.out.println("noteList---"+noteList);
		JSONObject noteJson = new JSONObject();
		noteJson.put("noteList", noteList);
		System.out.println("noteJson---"+noteJson.toString());
		resp.getWriter().append(noteJson.toString());
	}
}
