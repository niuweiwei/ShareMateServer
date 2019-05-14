package com.sharemate.server.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.Like;
import com.sharemate.entity.Note;
import com.sharemate.server.dao.LikeMapper;
import com.sharemate.server.dao.NoteMapper;
import com.sharemate.server.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeMapper likeMapper;
	@Autowired
	private NoteMapper noteMapper;
	
	@Override
	public List<Like> getLikeListByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Like> likeList = new ArrayList<>();
		List<Note> noteList = noteMapper.getNoteListByUserId(userId);
		for(Note note:noteList) {
			List<Like> subLikeList = likeMapper.getLikeListByNoteId(note.getNoteId());
			likeList.addAll(subLikeList);
		}
		//对likeList中的记录按照时间顺序进行排序
		likeList.sort(new DateComparator());
		System.out.println(likeList);
		return likeList;
	}

	private class DateComparator implements Comparator<Like>{

		@Override
		public int compare(Like o1, Like o2) {
			// TODO Auto-generated method stub
			Date date1 = o1.getLikeDate();
			Date date2 = o2.getLikeDate();
			if(date1.after(date2)) 
				return -1;
			else if(date1.before(date2))
				return 1;
			else
				return 0;
		}
	}
}
