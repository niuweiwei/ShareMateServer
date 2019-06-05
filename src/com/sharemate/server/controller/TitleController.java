package com.sharemate.server.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.entity.Title;
import com.sharemate.server.service.TitleService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**

* @author fengjiaxing

* @version 2019年5月30日 上午10:00:50 

*/
@Controller
@RequestMapping("/title")
public class TitleController {

	@Autowired
	private TitleService titleService;
	
	/**
	 * 根据用户选择的type插入title表
	 * @param userId
	 * @param typeId
	 * @param remark
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("type")
	public void type(int userId,int typeId,String remark,HttpServletResponse resp) throws IOException {
		if(remark.equals("add")) {
			int count = titleService.insertTitle(userId, typeId);
			System.out.println("插入了"+count+"行");
			resp.getWriter().append("title表插入成功");
		}else if(remark.equals("delete")){
			int count = titleService.deleteTitle(userId,typeId);
			System.out.println("删除了"+count+"行");
			resp.getWriter().append("title表删除成功");
		}
	}
	/**
	 * 根据userId查询type
	 * @param userId
	 * @param resp
	 * @throws IOException 
	 */
	@RequestMapping("findTypeByUserId")
	public void findTypeByUserId(int userId,HttpServletResponse resp) throws IOException {
		List<Title> titleList = titleService.findType(userId);
		List<Integer> typeList = new ArrayList<>();
		for(int i=0;i<titleList.size();i++) {
			typeList.add(titleList.get(i).getType().getTypeId());
		}
		JSONArray array = new JSONArray();
		for(Integer i:typeList) {
			JSONObject object = new JSONObject();
			object.put("typeId", i);
			array.add(object);
		}
		resp.getWriter().append(array.toString());
	}
}
