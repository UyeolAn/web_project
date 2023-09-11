package co.uyeol.prjdb.notice.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uyeol.prjdb.common.ViewResolve;
import co.uyeol.prjdb.notice.service.NoticeService;
import co.uyeol.prjdb.notice.service.NoticeServiceImpl;
import co.uyeol.prjdb.notice.vo.NoticeVO;

@WebServlet("/noticeselect.do")
public class NoticeSelectController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public NoticeSelectController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService noticeService = new NoticeServiceImpl();
		
		NoticeVO targetVO = new NoticeVO();
		targetVO.setNoticeId(Integer.parseInt(request.getParameter("noticeId")));
		
		NoticeVO searchedVO = noticeService.noticeSelect(targetVO);
		request.setAttribute("n", searchedVO);
		
		String page = "notice/noticeselect2";
		ViewResolve.foward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
