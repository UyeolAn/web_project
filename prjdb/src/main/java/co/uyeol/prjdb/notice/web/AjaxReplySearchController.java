package co.uyeol.prjdb.notice.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.uyeol.prjdb.notice.service.ReplyService;
import co.uyeol.prjdb.notice.service.ReplyServiceImpl;
import co.uyeol.prjdb.notice.vo.ReplyVO;

@WebServlet("/ajaxreplysearch.do")
public class AjaxReplySearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxReplySearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyService replyService = new ReplyServiceImpl();

		String rid = request.getParameter("rid");
		ReplyVO targetVO = new ReplyVO();
		targetVO.setReplyId(Integer.parseInt(rid));
		
		ReplyVO searchedVO = replyService.replySelect(targetVO);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.registerModule(new JavaTimeModule()).writeValueAsString(searchedVO);
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
