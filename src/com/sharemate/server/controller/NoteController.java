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
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sharemate.entity.Collect;
import com.sharemate.entity.Follow;
import com.sharemate.entity.Like;
import com.sharemate.entity.Note;
import com.sharemate.entity.Comment;
import com.sharemate.server.service.FollowService;
import com.sharemate.server.service.NoteService;
import com.sharemate.server.service.UserService;
import com.sharemate.util.JsonTools;

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
	@Autowired
	public  UserService userservice;
	@Autowired
	public  FollowService followservice;
	
	public int notecurrent;
	/**
	 * 嘉星   findNoteByUserId
	 * @param userId
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/findNoteByUserId")
	public void findNoteByUserId(int userId,HttpServletResponse resp) throws IOException {
		List<Note> noteList = noteService.findNoteByUserId(userId);
		System.out.println("noteList---"+noteList);
		JSONObject noteJson = new JSONObject();
		noteJson.put("noteList", noteList);
		System.out.println("noteJson---"+noteJson.toString());
		resp.getWriter().append(noteJson.toString());
	}
	
	/**
	 * 付娆
	 */
	//找到关注用户的所有笔记
	@RequestMapping("allnotelist")
	public void findAllNote(HttpServletRequest req,HttpServletResponse rep) throws Exception{
		noteService.text();
		List<Note> guanzhunotelist=new ArrayList<Note>();
		List<Follow> followlist=noteService.findGuanzhuUser(1);
		for(Follow follow:followlist) {
			int userid=follow.getFolloweduserid();
			System.out.println(String.valueOf(userid));
			List<Note> notelist=noteService.findGuanzhuNote(userid);
			guanzhunotelist.addAll(notelist);
		}
		for(Note note:guanzhunotelist) {
			int noteid=note.getNoteId();
			int likecount=noteService.getZancount(noteid);
			int collectcount=noteService.getCollectcount(noteid);
			int commentcount=noteService.getCommentcount(noteid);
			Comment comment=noteService.findCommentByNoteId(noteid).get(0);
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
		noteService.insertCollect(collect);
	}
	//点赞，赞数加一
	@RequestMapping("zancount")
	//参数int noteid,int userid
	public void zanAdd(int noteid,int userid) throws ParseException {

		//加入like表
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String date=df.format(new Date());// new Date()为获取当前系统时间
//	    Date datetime=df.parse(date);
		Like like=new Like();
		like.setNoteid(noteid);
		like.setUserid(userid);
		like.setLikeDate(date);
		noteService.insertLike(like);
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
		int userid=object.getInt("userid");
		String noteTitle=object.getString("title");
		String noteDetail=object.getString("detial");
		String notePosition=object.getString("position");
	    int typeid=object.getInt("typeid");
	    String videoPath=object.getString("videoPath");
	    Note note=new Note();
	    if(videoPath.equals(1)) {
	    	
	    }else {
	    	note.setVideoPath(videoPath);
	    }
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String date=df.format(new Date());// new Date()为获取当前系统时间
//	    Date datetime=df.parse(date);
	   
	    note.setNoteDetail(noteDetail);
	    note.setNoteTitle(noteTitle);
	    note.setNotePosition(notePosition);
	    note.setUserId(userid);
	    note.setTypeId(typeid);
	    note.setNoteDate(date);
	    noteService.insertBaseNote(note);
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
//	    Date datetime=df.parse(date);
		Comment comment=new Comment();
		comment.setCommentDetail(commentdetail);
		comment.setNoteId(NoteId);
		comment.setUserId(commentUserId);
		comment.setCommentDate(date);
		noteService.insertComment(comment);
		
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
	
	/*
	 * 春柳
	 */
	//返回首页推荐页面（currentPage=当前页数）
		@RequestMapping("/recommend/{currentPage}")
		@ResponseBody
		public void getNoteList(ModelMap map,@PathVariable Integer currentPage,
			HttpServletRequest request,HttpServletResponse response){
			response.setContentType("text/html;charset=UTF-8");
			String tid = request.getParameter("typeId");
			String uId = request.getParameter("userId");
			int typeId = Integer.parseInt(tid);
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
				PageHelper.startPage(currentPage,30);
	            //根据typeId查询note
				List<Note> noteList=noteService.getNoteByTypeId(typeId);
				PageInfo<Note> pageInfo = new PageInfo<>(noteList);
				pages = pageInfo.getPages();
			    noteSubList = pageInfo.getList();
	            //Collections.shuffle(noteSubList);
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
							continue;
						}
					}
					for(int noteId:noteIdCollectList) {
						if(note.getNoteId()==noteId) {
							note.setCollect(true);
							continue;
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
		
		//返回附近页面（currentPage=当前页数）
		@RequestMapping("/nearby/{currentPage}")
		@ResponseBody
		public void getNearbyNoteList(ModelMap map,@PathVariable Integer currentPage,
				HttpServletRequest request,HttpServletResponse response){
			response.setContentType("text/html;charset=UTF-8");
			String address = request.getParameter("address");
			String uId = request.getParameter("userId");
			List<Note> noteSubList = new ArrayList<>();
			int pages=0;
			if(!address.equals("")) {
			    PageHelper.startPage(currentPage,30);
			    List<Note> noteList = noteService.getNearbyNoteList(address);
			    Collections.shuffle(noteList);
			    PageInfo<Note> pageInfo = new PageInfo<>(noteList);
			    pages = pageInfo.getPages();
			    noteSubList = pageInfo.getList();
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
							continue;
						}
					}
					for(int noteId:noteIdCollectList) {
						if(note.getNoteId()==noteId) {
							note.setCollect(true);
							continue;
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
		
		//点赞和取消点赞
		@RequestMapping("/pick/{noteId}")
		@ResponseBody
		public void pick(ModelMap map,@PathVariable Integer noteId,
			HttpServletRequest request,HttpServletResponse response){
			response.setContentType("text/html;charset=UTF-8");
			String uId = request.getParameter("userId");
			String  like = request.getParameter("like");
			int userId = Integer.parseInt(uId);
			//获取当时间对象
			Date d = new Date();
			//获取时间格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			//将当前时间临时存储date上
			String date = sdf.format(d);
		    if(like.equals("false")) {
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
		
		//收藏和取消收藏
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
		
		//关注和取消关注
		@RequestMapping("/follow/{followedId}")
		@ResponseBody
		public void follow(@PathVariable Integer followedId,
				HttpServletRequest request,HttpServletResponse response) {
			String uId = request.getParameter("userId");
			String  follow = request.getParameter("follow");
			System.out.println("lfollow"+follow);
			int userId = Integer.parseInt(uId);
			//获取当时间对象
			Date d = new Date();
			//获取时间格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			//将当前时间临时存储date上
			String date = sdf.format(d);
		    if(follow.equals("false")) {
		    	noteService.insertFollow(userId,followedId,date);
		    }else {
		    	System.out.println("isfollow:"+follow);
		    	noteService.deleteFollow(userId, followedId);
		    }
		    String jsonString="已更新";
			try {
				response.getWriter().append(jsonString);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
