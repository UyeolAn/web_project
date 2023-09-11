package co.uyeol.prjdb.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.uyeol.prjdb.notice.map.ReplyMapper;
import co.uyeol.prjdb.notice.vo.ReplyVO;

public class MainExe {
	
	public static void main(String[] args) {
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		
		ReplyMapper map = sqlSession.getMapper(ReplyMapper.class);
		
//		ReplyVO insertVO = new ReplyVO();
//		insertVO.setNoticeId(1);
//		insertVO.setReplySubject("자바로부터 저장함");
//		insertVO.setReplyWriter("자바");
//		map.replyInsert(insertVO);
		
//		ReplyVO updateVO = new ReplyVO();
//		updateVO.setReplyId(6);
//		updateVO.setReplySubject("자바에서 테스트중...");
//		map.replyUpdate(updateVO);
		
//		ReplyVO deleteVO = new ReplyVO();
//		deleteVO.setReplyId(6);
//		map.replyDelete(deleteVO);
		
		List<ReplyVO> list = map.replySelectList(1);
		for (ReplyVO vo : list) {
			System.out.println(vo);
		}
		
		ReplyVO targetVO = new ReplyVO();
		targetVO.setReplyId(5);
		ReplyVO selectedVO = map.replySelect(targetVO);
		System.out.println(selectedVO);	
		
	}
	
}
