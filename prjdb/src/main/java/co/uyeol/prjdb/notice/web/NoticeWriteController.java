package co.uyeol.prjdb.notice.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.uyeol.prjdb.common.ThumbNail;
import co.uyeol.prjdb.common.ViewResolve;
import co.uyeol.prjdb.notice.service.NoticeService;
import co.uyeol.prjdb.notice.service.NoticeServiceImpl;
import co.uyeol.prjdb.notice.vo.NoticeVO;

@WebServlet("/noticewrite.do")
public class NoticeWriteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public NoticeWriteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService noticeService = new NoticeServiceImpl();
		
		NoticeVO vo = new NoticeVO();
		
		// 파일 업로드 처리
		String saveDir = getServletContext().getRealPath("attach/notice");
		int maxSize = 1024 * 1024 * 100; // 100MB
		
		MultipartRequest multi = new MultipartRequest(
				request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		String imgFileName = multi.getOriginalFileName("imgfile"); // 원본파일명
		String realImg = multi.getFilesystemName("imgfile"); // 저장되는 파일명, 이 시점에 저장됨
		vo.setNoticeImg(realImg);
		String attachFileName = multi.getOriginalFileName("attachfile"); 
		if (attachFileName != null) {
			String realAttach = multi.getFilesystemName("attachfile"); 
			vo.setNoticeAttach(realAttach);
		}
		
//		// 썸네일 처리
//		ThumbNail thunbNail = new ThumbNail();
//		int fileNameIdx = imgFileName.lastIndexOf(".");
//		String fileExt = imgFileName.substring(fileNameIdx + 1);
//		try {
//			thunbNail.makeThumbNail(saveDir, imgFileName, fileExt);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// 나머지 속성도 세팅해줌
		vo.setNoticeWriterId(multi.getParameter("noticeWriterId"));
		vo.setNoticeTitle(multi.getParameter("noticeTitle"));
		vo.setNoticeSubject(multi.getParameter("noticeSubject"));
		vo.setNoticeWriterName(multi.getParameter("noticeWriterName"));
		
		// DB에 저장
		int numIns = noticeService.noticeInsert(vo);
		if (numIns != 0) {
			response.sendRedirect("noticeselectlist.do");
		} else {
			request.setAttribute("message", "게시글 등록에 실패하였습니다.");
			String page = "notice/noticemessage";
			ViewResolve.foward(request, response, page);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
