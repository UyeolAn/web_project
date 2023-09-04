package co.uyeol.prjdb.member.map;

import java.util.List;

import co.uyeol.prjdb.member.vo.MemberVO;

public interface MemberMapper {
	
	List<MemberVO> memberSelectList();
	
	MemberVO memberSelect(MemberVO vo);
	
	int memberInsert(MemberVO vo);
	
	int memberUpdate(MemberVO vo);
	
	int memberDelete(MemberVO vo);

}
