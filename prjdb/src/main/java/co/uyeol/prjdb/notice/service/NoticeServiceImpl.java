package co.uyeol.prjdb.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.uyeol.prjdb.common.DataSource;
import co.uyeol.prjdb.notice.map.NoticeMapper;
import co.uyeol.prjdb.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		map.noticeHitUpdate(vo.getNoticeId());
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

	@Override
	public List<NoticeVO> noticeSelectList(String key, String value) {
		return map.noticeSelectList(key, value);
	}

	@Override
	public void noticeHitUpdate(int id) {
		map.noticeHitUpdate(id);
	}
	
	

}
