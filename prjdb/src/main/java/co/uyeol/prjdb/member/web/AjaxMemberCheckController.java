package co.uyeol.prjdb.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uyeol.prjdb.member.service.MemberService;
import co.uyeol.prjdb.member.service.MemberServiceImpl;
import co.uyeol.prjdb.member.vo.MemberVO;

@WebServlet("/ajaxmembercheck.do")
public class AjaxMemberCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxMemberCheckController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberService = new MemberServiceImpl();
		
		MemberVO targetVO = new MemberVO();
		targetVO.setMemberId(request.getParameter("memberId"));
		
		MemberVO searchedVO = memberService.memberSelect(targetVO);
		String text = "Yes";
		if (searchedVO != null) {
			text = "No"; 
		}
		
		// ajax 처리를 위해 호출한 페이지로 넘김
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append(text);
		
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
