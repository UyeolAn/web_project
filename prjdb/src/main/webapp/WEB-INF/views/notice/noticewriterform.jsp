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
      <div><h2>게시글 작성</h2></div>
      <div>
        <form id="frm" action="noticewrite.do" method="post" enctype="multipart/form-data">
          <div>
            <table border="1">
              <tr>
                <th width="150">작성자</th>
                <td width="150">
                  <input type="text" id="noticeWriterName" name="noticeWriterName" value="${name}" readonly>
                </td>
                <th width="150">작성일자</th>
                <td width="150">
                  <input type="date" id="noticeDate" name="noticeDate">
                </td>
              </tr>
              <tr>
                <th>이미지</th>
                <td colspan="3">
                  <input type="file" id="imgfile" name="imgfile" required="required">
                </td>
              </tr>
              <tr>
                <th>제 목</th>
                <td colspan="3">
                  <input type="text" id="noticeTitle" name="noticeTitle" style="width:480px;" required="required">
                </td>
              </tr>
              <tr>
                <th>내 용</th>
                <td colspan="3">
                  <textarea id="noticeSubject" name="noticeSubject" cols="65" rows="10"></textarea>
                </td>
              </tr>
              <tr>
                <th>첨부파일</th>
                <td colspan="3">
                  <input type="file" id="attachfile" name="attachfile">
                </td>
              </tr>
            </table>
          </div><br>
          <div>
            <input type="hidden" name="noticeWriterId" value="${id}">
            <input type="submit" value="글등록">&nbsp;&nbsp;
            <input type="reset" value="취소">
          </div>
        </form>
      </div>
    </div>
  </body>

  </html>