package co.uyeol.prjdb.member.service;

import java.util.List;

import co.uyeol.prjdb.member.vo.MemberVO;

public interface MemberService {
	
	List<MemberVO> memberSelectList();
	
	MemberVO memberSelect(MemberVO vo);
	
	int memberInsert(MemberVO vo);
	
	int memberUpdate(MemberVO vo);
	
	int memberDelete(MemberVO vo);

}
