package co.uyeol.prjdb.notice.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.uyeol.prjdb.notice.service.ReplyService;
import co.uyeol.prjdb.notice.service.ReplyServiceImpl;
import co.uyeol.prjdb.notice.vo.ReplyVO;

@WebServlet("/ajaxreplyadd.do")
public class AjaxReplyAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxReplyAddController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyService replyService = new ReplyServiceImpl();
		
		String noticeId = request.getParameter("noticeId");
		String replySubject = request.getParameter("replySubject");
		String replyWriter = request.getParameter("replyWriter");
		
		ReplyVO vo = new ReplyVO();
		vo.setNoticeId(Integer.parseInt(noticeId));
		vo.setReplySubject(replySubject);
		vo.setReplyWriter(replyWriter);
		
		Map<String, Object> resultMap = new HashMap<>();
		
		int numIns = replyService.replyInsert(vo);
		if (numIns != 0) {
			resultMap.put("retCode", "Success");
			resultMap.put("data", vo);
		} else {
			resultMap.put("retCode", "Fail");
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(resultMap);
		
//		response.setCharacterEncoding("text/json;charset=utf-8");
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
