package com.sharemate.server.controller;

<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sharemate.entity.Note;
import com.sharemate.entity.Title;

/**
 * user控制类
 * @author fengjiaxing
 * @version 2019年5月14日 上午11:11:57
 */

import com.sharemate.entity.User;
import com.sharemate.server.service.FollowService;
import com.sharemate.server.service.TitleService;
import com.sharemate.server.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private TitleService titleService;
	/**
	 * 根据手机号判断用户是否登录过
	 * @param userPhone
	 * @param resp
	 * @throws IOException 
	 */
	@RequestMapping("isLogin")
	public void isLogin(String userPhone,HttpServletResponse resp) throws IOException {
		boolean isExist = userService.isExistUser(userPhone);
		System.out.println("isExist----"+isExist);
		JSONObject back = new JSONObject();
		if(isExist == true) {
			//用户存在
			User user = userService.findUserByUserPhone(userPhone);
			int userId = user.getUserId();
			List<Integer> typeList = new ArrayList<>();
			List<Title> titleList = titleService.findType(userId);
			for(int i=0;i<titleList.size();i++) {
				typeList.add(titleList.get(i).getType().getTypeId());
			}
			Map<String,Object> map = new HashMap<>();
			map.put("typeList", typeList);
			map.put("user", user);
			back.put("map", map);
			System.out.println("back---"+back.toString());
			resp.getWriter().append(back.toString());
		}
	}
	
	/**
	 * 根据手机号判断用户是否存在
	 * @param userPhone
	 * @param resp
	 * @throws IOException 
	 */
	@RequestMapping("login")
	public void login(String userPhone,HttpServletResponse resp) throws IOException {
		boolean isExist = userService.isExistUser(userPhone);
		System.out.println("isExist----"+isExist);
		JSONObject object = new JSONObject();
		if(isExist == true) {
			//用户存在
			User user = userService.findUserByUserPhone(userPhone);
			object.put("user", user);
			System.out.println(user.getUserPhone());
			resp.getWriter().append(object.toString());
		}
	}
	/**
	 * 根据手机、密码判断用户是否存在
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping(value="login2",method=RequestMethod.POST)
	public void login2(HttpServletResponse resp,HttpServletRequest req) throws IOException {
		InputStream is = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String json = br.readLine();
		System.out.println("login2---"+json);
		JSONObject object = JSONObject.fromObject(json);
		String userPhone = object.getString("userPhone");
		String userPassword = object.getString("userPassword");
		System.out.println("userPhone:"+userPhone+"  userPassword:"+userPassword);
		
		boolean isExist = userService.isExistUser(userPhone);
		System.out.println("isExist----"+isExist);
		JSONObject back = new JSONObject();
		Map<String,Object> map = new HashMap<>();
		if(isExist == true) {
			//用户存在
			User user = userService.findUserByUserPhone(userPhone);
			int userId = user.getUserId();
			String userPassword2 = user.getUserPassword();
			System.out.println("userPassword="+userPassword+";userPassword2="+userPassword2);
			if(userPassword.equals(userPassword2)) {
				List<Integer> typeList = new ArrayList<>();
				List<Title> titleList = titleService.findType(userId);
				for(int i=0;i<titleList.size();i++) {
					typeList.add(titleList.get(i).getType().getTypeId());
				}
				String msg = "该用户存在";
				map.put("typeList", typeList);
				map.put("user", user);
				map.put("msg", msg);
				back.put("map", map);
				System.out.println("back---"+back.toString());
				resp.getWriter().append(back.toString());
			}else {
				String msg = "密码输入错误";
				map.put("typeList", null);
				map.put("user", null);
				map.put("msg", msg);
				back.put("map", map);
				System.out.println("back---"+back.toString());
				resp.getWriter().append(back.toString());
			}
		}else {
			//用户不存在
			String msg = "该用户不存在";
			map.put("typeList", null);
			map.put("user", null);
			map.put("msg", msg);
			back.put("map", map);
			System.out.println("back---"+back.toString());
			resp.getWriter().append(back.toString());
		}
	}
	/**
	 * 注册用户
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	public void register(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		InputStream is = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String json = br.readLine();
		System.out.println("register---"+json);
		JSONObject object = JSONObject.fromObject(json);
		String userName = object.getString("userName");
		String userPassword = object.getString("userPassword");
		String userPhone = object.getString("userPhone");
		String userPhoto = "images/userPhotos/0.png";
		String userIntro = "添加个人描述，可以让大家更好的认识你";
		String userAddress = "完善你的位置信息";
		System.out.println("头像：" + userPhoto + "; 用户名：" + userName + "; 密码：" + userPassword + "; 电话：" + userPhone);
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setUserPhone(userPhone);
		user.setUserPhoto(userPhoto);
		user.setUserAddress(userAddress);
		user.setUserIntro(userIntro);
		boolean isRegist = userService.isExistUser(userPhone);
		if(isRegist == true) {
			//该用户已经注册过
			resp.getWriter().append("该用户已经注册");
		}else {
			//该用户是新用户
			int count = userService.insertUser(user);
			System.out.println("插入了"+count+"行");
			if(count != 0) {
				resp.getWriter().append("注册成功");
			}else {
				resp.getWriter().append("注册失败");
			}
		}
	}
	/**
	 * 注册用户2  性别和生日
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping(value="register2",method=RequestMethod.POST)
	public void register2(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		InputStream is = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String json = br.readLine();
		System.out.println("register2---"+json);
		JSONObject object = JSONObject.fromObject(json);
		String userSex = object.getString("userSex");
		String userBirth = object.getString("userBirth");
//		User user = new User();
//		user.setUserSex(userSex);
//		user.setUserBirth(userBirth);
		int maxId = userService.getMaxUserId();
		System.out.println("maxId--"+maxId+" userSex--"+userSex+" userBirth--"+userBirth);
		int count = userService.updateUser2(userSex,userBirth, maxId);
		System.out.println("更新了"+count+"行");
		if(count != 0) {
			JSONObject result = new JSONObject();
			User u = userService.findUserByUserId(maxId);
			result.put("user", u);
			resp.getWriter().append(result.toString());
		}else {
			resp.getWriter().append("更新失败");
		}
	}
	/**
	 * 更新用户信息
	 * @param user
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping(value="updateUser",method=RequestMethod.POST)
	public void updateUser(HttpServletResponse resp,HttpServletRequest req) throws IOException {
		InputStream is = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String json = br.readLine();
		System.out.println("数据："+json);
		JSONObject object = JSONObject.fromObject(json);
		int userId = object.getInt("userId");
		String userName = object.getString("userName");
		String userAddress = object.getString("userAddress");
		String userSex = object.getString("userSex");
		String userBirth = object.getString("userBirth");
		String userIntro = object.getString("userIntro");
		
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserAddress(userAddress);
		user.setUserBirth(userBirth);
		user.setUserIntro(userIntro);
		user.setUserSex(userSex);
		int count = userService.updateUser(user);
		System.out.println("user---"+user);
		System.out.println("更新了"+count+"行");
		if(count != 0) {
			resp.getWriter().append("更新成功");
		}else {
			resp.getWriter().append("更新失败");
		}
	}
	/**
	 * 修改头像
	 * @param userId
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("updatePhoto")
	public void updatePhoto(int userId,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		System.out.println("updatePhoto");
		//1、创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录。 
	    DiskFileItemFactory factory = new DiskFileItemFactory();
	    //2、使用DiskFileItemFactory 对象创建ServletFileUpload对象，并设置上传文件的大小限制。
	    ServletFileUpload upload = new ServletFileUpload(factory);
		String userPhoto = "";   
	    try{  
	    	//3、调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象。
	    	List<FileItem>list = upload.parseRequest(req);
			for(FileItem item:list) {
				if(item.isFormField()) {
					//4.1、 为普通表单字段，则调用getFieldName、getString方法得到字段名和字段值。
				}else{  
					//4.2、为上传文件，则调用getInputStream方法得到数据输入流，从而读取上传数据。
					//pathName有的浏览器会返回文件名，而有的浏览器会返回“路径”+“文件名”
					String pathName = item.getName(); 
					//fileName获取的是文件的名字
					String fileName = pathName.substring(pathName.lastIndexOf("\\")+1);
					System.out.print(fileName);
					//serverPath是项目运行后的路径,在使用ServletContext.getRealPath() 时，传入的参数是从 当前servlet 部署在tomcat中的文件夹算起的相对路径，要以"/" 开头，否则会找不到路径，导致NullPointerException
					String serverPath = req.getSession().getServletContext().getRealPath("/");
					fileName = userId+".jpg";
					item.write(new File(serverPath+"\\images\\userPhotos\\",fileName));
					userPhoto = fileName;
					System.out.println(userPhoto);
				}
			}
		}catch(Exception e){
			e.printStackTrace();  
        }     
	  }
=======
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sharemate.entity.User;
import com.sharemate.server.service.UserService;
import com.sharemate.util.JsonTools;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	//收藏和取消收藏
	@RequestMapping("/getUser/{userId}")
	@ResponseBody
	public void collect(@PathVariable Integer userId,
		HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		User user = userService.getUserByUserId(userId);
		String jsonString="";
		jsonString = JsonTools.createJsonString("user",user);
		try {
			response.getWriter().append(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
>>>>>>> refs/remotes/origin/lichunliu
}
