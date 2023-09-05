package co.uyeol.prjdb.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.uyeol.prjdb.common.Sha256;
import co.uyeol.prjdb.common.ViewResolve;
import co.uyeol.prjdb.member.service.MemberService;
import co.uyeol.prjdb.member.service.MemberServiceImpl;
import co.uyeol.prjdb.member.vo.MemberVO;

@WebServlet("/memberlogin.do")
public class MemberLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public MemberLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberService = new MemberServiceImpl();
		HttpSession session = request.getSession(); //세션객체 호출

		MemberVO targetVO = new MemberVO();
		targetVO.setMemberId(request.getParameter("memberId"));
		targetVO.setMemberPassword(Sha256.encrypt(request.getParameter("memberPassword")));
		
		MemberVO searchedVO = memberService.memberSelect(targetVO);
		if (searchedVO != null) {
			session.setAttribute("id", searchedVO.getMemberId());
			session.setAttribute("name", searchedVO.getMemberName());
			request.setAttribute("message", searchedVO.getMemberName() + "님 환영합니다!!");
		} else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		}
		
		String page = "member/membermessage";
		ViewResolve.foward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
