package co.uyeol.prjdb.notice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uyeol.prjdb.common.ViewResolve;
import co.uyeol.prjdb.notice.service.NoticeService;
import co.uyeol.prjdb.notice.service.NoticeServiceImpl;
import co.uyeol.prjdb.notice.vo.NoticeVO;

@WebServlet("/noticeselectlist.do")
public class NoticeSelectListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NoticeSelectListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService noticeService = new NoticeServiceImpl();
		
		List<NoticeVO> notices = noticeService.noticeSelectList();
		request.setAttribute("notices", notices);
		
		String page = "notice/noticeselectlist";
		ViewResolve.foward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
