package co.uyeol.prjdb.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.uyeol.prjdb.common.ViewResolve;

@WebServlet("/memberlogout.do")
public class MemberLogout extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public MemberLogout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		session.invalidate(); //세션 정보를 완전히 삭제함
		
		request.setAttribute("message", name + "님 로그아웃 하셨습니다.");
		
		String page = "member/membermessage";
		ViewResolve.foward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
