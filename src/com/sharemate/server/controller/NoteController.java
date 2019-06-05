package com.sharemate.server.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
	public int notecurrent;
	@RequestMapping("text")
	public void text() {
		userservice.text();
		
	}
	//找到关注用户的所有笔记
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
		for(Note note:guanzhunotelist) {
			int noteid=note.getNoteId();
			int likecount=noteservice.getZancount(noteid);
			int collectcount=noteservice.getCollectcount(noteid);
			int commentcount=noteservice.getCommentcount(noteid);
			comment comment=noteservice.findCommentByNoteId(noteid).get(0);
			String commentdetial=comment.getCommentDetail();
			System.out.println(commentdetial);
			System.out.println(String.valueOf(likecount)+"like");
			System.out.println(String.valueOf(collectcount)+"colect");
			note.setNoteLikeCount(likecount);
			note.setNoteCollectionCount(collectcount);
			note.setNoteCommentCount(commentcount);
			note.setCommentdetial(commentdetial);
		}
		
		System.out.println(String.valueOf(guanzhunotelist.size()));	
		String jsonString="";
		jsonString = JsonTools.createJsonString("notelist",guanzhunotelist);
		System.out.println(String.valueOf(guanzhunotelist.size()));
		PrintWriter writer = rep.getWriter();
		writer.append(jsonString);
		
		
	}
	//收藏，收藏数+1
	@RequestMapping("collectcount")
	//参数int noteid,int userid
	public void collectAdd(int noteid,int userid) {
		//加入收藏表
		Collect collect=new Collect();
		collect.setNoteid(noteid);
		collect.setUserid(userid);
		noteservice.insertCollect(collect);
	}
	//点赞，赞数加一
	@RequestMapping("zancount")
	//参数int noteid,int userid
	public void zanAdd(int noteid,int userid) throws ParseException {

		//加入like表
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String date=df.format(new Date());// new Date()为获取当前系统时间
	    Date datetime=df.parse(date);
		Like like=new Like();
		like.setNoteid(noteid);
		like.setUserid(userid);
		like.setLikeDate(datetime);
		noteservice.insertLike(like);
	}
	//插入笔记信息
	@RequestMapping("addBaseNote")
	public void addBaseNote(HttpServletResponse resp,HttpServletRequest req) throws IOException, ParseException {
		InputStream is=req.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br =new BufferedReader(isr);
		String json=br.readLine();
		System.out.println("数据"+json);
		JSONObject object=JSONObject.fromObject(json);
		String userid=object.getString("userid");
		String noteTitle=object.getString("title");
		String noteDetail=object.getString("detial");
		String notePosition=object.getString("position");
	    String typeid=object.getString("typeid");
	    String videoPath=object.getString("videoPath");
	    Note note=new Note();
	    if(videoPath.equals(1)) {
	    	
	    }else {
	    	note.setVideoPath(videoPath);
	    }
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String date=df.format(new Date());// new Date()为获取当前系统时间
	    Date datetime=df.parse(date);
	   
	    note.setNoteDetail(noteDetail);
	    note.setNoteTitle(noteTitle);
	    note.setNotePosition(notePosition);
	    note.setUserId(userid);
	    note.setTypeId(typeid);
	    note.setNoteDate(datetime);
	    noteservice.insertBaseNote(note);
	    notecurrent=note.getNoteId();
	    
	    
		
	}
	//插入评论
	@RequestMapping("addcomment")
	public void insertComment(HttpServletResponse resp,HttpServletRequest req) throws IOException, ParseException {
		InputStream is=req.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br =new BufferedReader(isr);
		String json=br.readLine();
		System.out.println("数据"+json);
		JSONObject object=JSONObject.fromObject(json);
		String commentdetail=object.getString("pinglunfabu");
		int commentUserId=object.getInt("userid");
		int NoteId=object.getInt("noteid");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String date=df.format(new Date());// new Date()为获取当前系统时间
	    Date datetime=df.parse(date);
		comment comment=new comment();
		comment.setCommentDetail(commentdetail);
		comment.setNoteId(NoteId);
		comment.setUserId(commentUserId);
		comment.setCommentDate(datetime);
		noteservice.insertComment(comment);
		
	}
	//保存图片
	@SuppressWarnings("unchecked")
	@RequestMapping("addPic")
	public void addVideo(HttpServletResponse resp,HttpServletRequest req) {
		try {
			PrintWriter out = resp.getWriter();
			 DiskFileItemFactory factory = new DiskFileItemFactory();
		     ServletFileUpload upload = new ServletFileUpload(factory);
		     List<FileItem>list = upload.parseRequest(req);
		     for(FileItem item:list) {
					if(item.isFormField()) {//�ı���
					}else{
						String pathName = item.getName(); 
						String fileName = pathName.substring(pathName.lastIndexOf("\\")+1);
						System.out.print(fileName);
						String serverPath = req.getServletContext().getRealPath("/");
						item.write(new File(serverPath+"\\images\\notePhotos\\"+fileName));
						String picpath="images/notePhotos/"+fileName;
						System.out.println(notecurrent);
						System.out.println(picpath);
					}
				}
		     
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
