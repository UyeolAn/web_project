package co.uyeol.project.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uyeol.project.common.ViewResolve;
import co.uyeol.project.member.service.MemberService;
import co.uyeol.project.member.service.MemberServiceImpl;
import co.uyeol.project.member.vo.MemberVO;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

    public LoginController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Service 객체, MemberVO 객체 등을 생성해서 로그인 처리
		MemberService memberService = new MemberServiceImpl();
		
		String id = request.getParameter("memberId");
		String password = request.getParameter("memberPassword");
		
		MemberVO vo = new MemberVO();
		vo.setMemberId(id);
		vo.setMemberPassword(password);
		
		MemberVO selectedMember = memberService.memberSelect(vo);
		if (selectedMember != null) {
			request.setAttribute("message", "로그인 성공!");
		} else {
			request.setAttribute("message", "로그인 실패.");
		}
	
		String page = "member/membermessage";
		ViewResolve.views(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
