package co.uyeol.prjdb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.uyeol.prjdb.common.DataSource;

@WebServlet("/ajaxeventlist.do")
public class AjaxEventListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	
	private EventListMapper map = sqlSession.getMapper(EventListMapper.class);

    public AjaxEventListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EventVO> eventList = map.eventSelectList();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(eventList);
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
