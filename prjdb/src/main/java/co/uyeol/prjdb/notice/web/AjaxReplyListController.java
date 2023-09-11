package co.uyeol.prjdb.notice.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/ajaxreplylist.do")
public class AjaxReplyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxReplyListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyService replyService = new ReplyServiceImpl();
		List<ReplyVO> list = replyService.replySelectList(Integer.parseInt(request.getParameter("nid")));
		
		String param = request.getParameter("param");
		String json = null;
		
		if (param == null) {
			ObjectMapper objectMapper = new ObjectMapper();
			json = objectMapper.registerModule(new JavaTimeModule()).writeValueAsString(list);
		} else {
			int cnt = 0;
			json = "{\"data\": [";
			for (ReplyVO vo : list) {
				json += "[" //
						+ "\"" + vo.getReplyId() + "\", "//
						+ "\"" + vo.getReplySubject() + "\", "//
						+ "\"" + vo.getReplyWriter() + "\", "//
						+ "\"" + vo.getReplyEnterDate() + "\""//
						+ "]";
				if (++cnt != list.size()) {
					json += ", ";
				}
			}
			json += "]}";
		}
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
