package co.uyeol.project.member.service;

import org.apache.ibatis.session.SqlSession;

import co.uyeol.project.common.DataSource;
import co.uyeol.project.member.mapper.MemberMapper;
import co.uyeol.project.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

}
