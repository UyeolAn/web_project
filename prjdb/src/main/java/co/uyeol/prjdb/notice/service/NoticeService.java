package co.uyeol.prjdb.notice.service;

import java.util.List;

import co.uyeol.prjdb.notice.vo.NoticeVO;

public interface NoticeService {
	
	List<NoticeVO> noticeSelectList();
	
	NoticeVO noticeSelect(NoticeVO vo);
	
	int noticeInsert(NoticeVO vo);
	
	int noticeUpdate(NoticeVO vo);
	
	int noticeDelete(NoticeVO vo);
	
	
	List<NoticeVO> noticeSelectList(String key, String val); // 게시글 검색

	void noticeHitUpdate(int id); // 조회수 증가
	
}
