package co.uyeol.prjdb.notice.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uyeol.prjdb.notice.service.ReplyService;
import co.uyeol.prjdb.notice.service.ReplyServiceImpl;
import co.uyeol.prjdb.notice.vo.ReplyVO;

@WebServlet("/ajaxreplydelete.do")
public class AjaxReplyDeleteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public AjaxReplyDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyService replyService = new ReplyServiceImpl();
		String replyId = request.getParameter("rid");
		
		ReplyVO deleteVO = new ReplyVO();
		deleteVO.setReplyId(Integer.parseInt(replyId));
		int numDel = replyService.replyDelete(deleteVO);
		if (numDel != 0) {
			response.getWriter().print("{\"retCode\": \"Success\"}");
		} else {
			response.getWriter().print("{\"retCode\": \"Fail\"}");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
