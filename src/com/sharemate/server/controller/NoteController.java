package com.sharemate.server.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.entity.Collect;
import com.sharemate.entity.Follow;
import com.sharemate.entity.Like;
import com.sharemate.entity.Note;
import com.sharemate.server.service.FollowService;
import com.sharemate.server.service.NoteService;
import com.sharemate.server.service.UserService;
@Controller
@RequestMapping("note")
public class NoteController {
	@Autowired
	public  UserService userservice;
	@Autowired
	public  NoteService noteservice;
	@Autowired
	public  FollowService followservice;
	@RequestMapping("text")
	public void text() {
		userservice.text();
		
	}
	//�ҵ���ע�û������бʼ�
	@RequestMapping("allnotelist")
	public void findAllNote(HttpServletRequest req,HttpServletResponse rep) throws Exception{
		noteservice.text();
		List<Note> guanzhunotelist=new ArrayList<Note>();
		List<Follow> followlist=noteservice.findGuanzhuUser(1);
		for(Follow follow:followlist) {
			int userid=follow.getFolloweduserid();
			System.out.println(String.valueOf(userid));
			List<Note> notelist=noteservice.findGuanzhuNote(userid);
			guanzhunotelist.addAll(notelist);
		}
		System.out.println(String.valueOf(guanzhunotelist.size()));	
//		String jsonString="";
//		jsonString = JsonTools.createJsonString("notelist",notelist);
//		PrintWriter writer = rep.getWriter();
//		writer.append(jsonString);
		
		
	}
	@RequestMapping("collectcount")
	//����int noteid,int userid
	public void collectAdd() {
		//�ҵ���Ӧ�ıʼ�
		int noteid=1;
		int userid=1;
		Note note=new Note();
		note=noteservice.findNoteByNoteId(noteid);
		//�ʼ��ղ���+1
		int collectcount=note.getNoteCollectionCount();
		collectcount++;
		note.setNoteCollectionCount(collectcount);
		noteservice.addCollectCount(note);
		//�����ղر�
		Collect collect=new Collect();
		collect.setNoteid(noteid);
		collect.setUserid(userid);
		noteservice.insertCollect(collect);
	}
	//���ޣ�������һ
	@RequestMapping("zancount")
	//����int noteid,int userid
	public void zanAdd() {
		//�ҵ���Ӧ�ıʼ�
		int noteid=1;
		int userid=1;
		Note note=new Note();
		note=noteservice.findNoteByNoteId(noteid);
		//�ʼǵ�������һ
		int zancount=note.getNoteLikeCount();
		System.out.println(String.valueOf(zancount));
		zancount++;
		System.out.println(String.valueOf(zancount));
		note.setNoteLikeCount(zancount);
		noteservice.addZanCount(note);
		//����like��
		Like like=new Like();
		like.setNoteid(noteid);
		like.setUserid(userid);
		noteservice.insertLike(like);
	}
	
	
}
