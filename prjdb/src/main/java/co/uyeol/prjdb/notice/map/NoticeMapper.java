package co.uyeol.prjdb.notice.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.uyeol.prjdb.notice.vo.NoticeVO;

public interface NoticeMapper {
	
	List<NoticeVO> noticeSelectList();
	
	NoticeVO noticeSelect(NoticeVO vo);
	
	int noticeInsert(NoticeVO vo);
	
	int noticeUpdate(NoticeVO vo);
	
	int noticeDelete(NoticeVO vo);
	
	
	List<NoticeVO> noticeSelectList(@Param("key") String key, @Param("val") String val); // 게시글 검색

	void noticeHitUpdate(int id); // 조회수 증가

}
