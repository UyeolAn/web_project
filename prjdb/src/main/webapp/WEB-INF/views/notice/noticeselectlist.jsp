<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h2>게시글 목록</h2>
      </div>
      <div>
        <form action="" method="post">
          <table border="1">
            <tr><td>
              <label for="key">Choose a key:</label>
              <select id="key" name="key">
                <option value="title">제목</option>
                <option value="subject">내용</option>
                <option value="writer">작성자</option>
              </select>
              <input type="text" id="val" name="val">
              <button type="button" id="btn" onclick="searchList()">검색</button>
            </td></tr>
          </table>
        </form>
      </div><br>
      <div>
        <table border="1">
          <thead>
            <tr>
              <th width="50">순번</th>
              <th width="100">이미지</th>
              <th width="200">제목</th>
              <th width="100">작성자</th>
              <th width="100">작성일자</th>
              <th width="50">조회수</th>
              <th width="100">첨부파일</th>
            </tr>
          </thead>
          <tbody>
            <c:choose>
              <c:when test="${empty notices}">
                <tr>
                  <td colspan="7" align="center">게시글이 없습니다..</td>
                </tr>
              </c:when>
              <c:otherwise>
                <c:forEach var="n" items="${notices}">
                  <tr>
                    <td align="center">${n.noticeId}</td>
                    <td align="center">
                      <img src="attach/notice/${n.noticeImg}" alt="이미지">
                    </td>
                    <td>${n.noticeTitle}</td>
                    <td align="center">${n.noticeWriterName}</td>
                    <td align="center">${n.noticeDate}</td>
                    <td align="center">${n.noticeHit}</td>
                    <td align="center">${n.noticeAttach}</td>
                  </tr>
                </c:forEach>
              </c:otherwise>
            </c:choose>
          </tbody>
        </table>
      </div><br>
      <div>
        <c:if test="${not empty id}">
          <button type="button" onclick="location.href='noticewriterform.do'">글쓰기</button>
        </c:if>
      </div>
    </div>
  </body>

  </html>