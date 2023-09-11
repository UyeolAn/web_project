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

@WebServlet("/ajaxreplymodify.do")
public class AjaxReplyModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxReplyModifyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyService replyService = new ReplyServiceImpl();
		
		String replyId = request.getParameter("replyId");
		String newSubject = request.getParameter("replySubject");
		
		ReplyVO updateVO = new ReplyVO();
		updateVO.setReplyId(Integer.parseInt(replyId));
		updateVO.setReplySubject(newSubject);
		
		Map<String, Object> resultMap = new HashMap<>();
		
		int numUpd = replyService.replyUpdate(updateVO);
		if (numUpd != 0) {
			resultMap.put("retCode", "Success");
		} else {
			resultMap.put("retCode", "Fail");
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(resultMap);

		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
