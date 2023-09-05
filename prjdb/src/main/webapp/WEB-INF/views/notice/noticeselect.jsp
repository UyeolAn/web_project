<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>

  <body>
    <div align="center">
      <jsp:include page="../menu/menu.jsp" />
      <div>
        <h2>게시글 상세보기</h2>
        <div>
          <table border="1">
            <tr>
              <th width="150">작성자</th>
              <td width="150">${n.noticeWriterName}</td>
              <th width="150">작성일자</th>
              <td width="150">${n.noticeDate}</td>
              <th width="100">조회수</th>
              <td width="50">${n.noticeHit}</td>
            </tr>
            <tr>
              <th>이미지</th>
              <td colspan="5">
                <img src="attach/notice/${n.noticeImg}" alt="이미지" style="width:100px;height:70px;">
              </td>
            </tr>
            <tr>
              <th>제 목</th>
              <td colspan="5">${n.noticeTitle}</td>
            </tr>
            <tr>
              <th>내 용</th>
              <td colspan="5">${n.noticeSubject}</td>
            </tr>
            <tr>
              <th>첨부파일</th>
              <td colspan="5">${n.noticeAttach}</td>
            </tr>
          </table>
        </div>
      </div>
    </div>
  </body>

  </html>