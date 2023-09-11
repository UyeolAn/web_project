package co.uyeol.prjdb.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.uyeol.prjdb.common.DataSource;
import co.uyeol.prjdb.notice.map.ReplyMapper;
import co.uyeol.prjdb.notice.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	
	ReplyMapper map = sqlSession.getMapper(ReplyMapper.class);

	@Override
	public List<ReplyVO> replySelectList(int id) {
		return map.replySelectList(id);
	}

	@Override
	public ReplyVO replySelect(ReplyVO vo) {
		return map.replySelect(vo);
	}

	@Override
	public int replyInsert(ReplyVO vo) {
		return map.replyInsert(vo);
	}

	@Override
	public int replyUpdate(ReplyVO vo) {
		return map.replyUpdate(vo);
	}

	@Override
	public int replyDelete(ReplyVO vo) {
		return map.replyDelete(vo);
	}

}
