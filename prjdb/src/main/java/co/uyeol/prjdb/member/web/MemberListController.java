package co.uyeol.prjdb.member.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uyeol.prjdb.common.ViewResolve;
import co.uyeol.prjdb.member.service.MemberService;
import co.uyeol.prjdb.member.service.MemberServiceImpl;
import co.uyeol.prjdb.member.vo.MemberVO;

@WebServlet("/memberlist.do")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberService = new MemberServiceImpl();
		
		List<MemberVO> list = memberService.memberSelectList();
		request.setAttribute("members", list);
		
		String page = "member/memberlist";
		ViewResolve.foward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
