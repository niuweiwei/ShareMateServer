package com.sharemate.server.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import com.sharemate.entity.comment;
import com.sharemate.server.service.FollowService;
import com.sharemate.server.service.NoteService;
import com.sharemate.server.service.UserService;

import net.sf.json.JSONObject;
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
		String jsonString="";
		jsonString = JsonTools.createJsonString("notelist",guanzhunotelist);
		PrintWriter writer = rep.getWriter();
		writer.append(jsonString);
		
		
	}
	//�ղأ��ղ���+1
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
	public void zanAdd(int noteid,int userid) {
//		//�ҵ���Ӧ�ıʼ�
//		int noteid=1;
//		int userid=1;
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
	//����ʼ���Ϣ
	@RequestMapping("addBaseNote")
	public void addBaseNote(HttpServletResponse resp,HttpServletRequest req) throws IOException {
//		InputStream is=req.getInputStream();
//		InputStreamReader isr=new InputStreamReader(is);
//		BufferedReader br =new BufferedReader(isr);
//		String json=br.readLine();
//		System.out.println("����"+json);
//		JSONObject object=JSONObject.fromObject(json);
//		int userid=object.getInt("userId");
//		String noteTitle=object.getString("noteTitle");
//		String noteDetail=object.getString("noteDetail");
//		String notePosition=object.getString("notePosition");
//	    int typeid=object.getInt("typeid");
	    Note note=new Note();
	    note.setNoteTitle("123");
	    note.setNoteDetail("123");
	    noteservice.insertBaseNote(note);
	    
		
	}
	//��������
	@RequestMapping("addcomment")
	public void insertComment(HttpServletResponse resp,HttpServletRequest req) {
//		InputStream is=req.getInputStream();
//		InputStreamReader isr=new InputStreamReader(is);
//		BufferedReader br =new BufferedReader(isr);
//		String json=br.readLine();
//		System.out.println("����"+json);
//		JSONObject object=JSONObject.fromObject(json);
//		String commentdetail=object.getString("commentDetail");
//		int commentlikecount=object.getInt("commentLikeCount");
//		int commentUserId=object.getInt("userId");
//		int commentNoteId=object.getInt("commentNoteId");
//		
		comment comment=new comment();
		comment.setCommentDetail("123");
		comment.setCommentLikeCount(5);
		comment.setNoteId(3);
		comment.setUserId(1);
		noteservice.insertComment(comment);
		
	}
	
	
}
