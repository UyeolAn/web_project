package co.uyeol.prjdb.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uyeol.prjdb.common.Sha256;
import co.uyeol.prjdb.common.ViewResolve;
import co.uyeol.prjdb.member.service.MemberService;
import co.uyeol.prjdb.member.service.MemberServiceImpl;
import co.uyeol.prjdb.member.vo.MemberVO;

@WebServlet("/memberjoin.do")
public class MemberJoinController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public MemberJoinController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberService = new MemberServiceImpl();
		
		MemberVO newVO = new MemberVO();

		newVO.setMemberId(request.getParameter("memberId"));
		newVO.setMemberPassword(Sha256.encrypt(request.getParameter("memberPassword")));
		newVO.setMemberName(request.getParameter("memberName"));
		newVO.setMemberTel(request.getParameter("memberTel"));
		
		int numIns = memberService.memberInsert(newVO);
		if (numIns != 0) {
			request.setAttribute("message", "회원가입이 완료되었습니다.");
		} else {
			request.setAttribute("message", "회원가입이 실패하였습니다.");
		}
		
		String page = "member/membermessage";
		ViewResolve.foward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
