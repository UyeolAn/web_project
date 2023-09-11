package co.uyeol.prjdb.notice.service;

import java.util.List;

import co.uyeol.prjdb.notice.vo.ReplyVO;

public interface ReplyService {

	List<ReplyVO> replySelectList(int id);
	
	ReplyVO replySelect(ReplyVO vo);
	
	int replyInsert(ReplyVO vo);
	
	int replyUpdate(ReplyVO vo);
	
	int replyDelete(ReplyVO vo);

}
