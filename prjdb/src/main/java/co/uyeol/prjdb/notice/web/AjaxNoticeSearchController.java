package co.uyeol.prjdb.notice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.uyeol.prjdb.notice.service.NoticeService;
import co.uyeol.prjdb.notice.service.NoticeServiceImpl;
import co.uyeol.prjdb.notice.vo.NoticeVO;

@WebServlet("/ajaxnoticesearch.do")
public class AjaxNoticeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxNoticeSearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService noticeService = new NoticeServiceImpl();
		
		String key = request.getParameter("key");
		String val = request.getParameter("val");
		
		List<NoticeVO> notices = noticeService.noticeSelectList(key, val);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String list = objectMapper.registerModule(new JavaTimeModule()).writeValueAsString(notices); // json 형태
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append(list);
		
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
