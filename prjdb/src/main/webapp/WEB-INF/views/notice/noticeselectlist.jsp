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
        <form id="searchfrm" method="post">
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
        <table id="listtable" border="1">
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
          <tbody id="tlist">
            <c:choose>
              <c:when test="${empty notices}">
                <tr>
                  <td colspan="7" align="center">게시글이 없습니다..</td>
                </tr>
              </c:when>
              <c:otherwise>
                <c:forEach var="n" items="${notices}">
                  <tr onmouseover="this.style.background='#C8FE2E'"
                      onmouseout="this.style.background='#FFFFFF'"
                      onclick="noticeSelect('${n.noticeId}')">
                    <td align="center">${n.noticeId}</td>
                    <td align="center">
                      <img src="attach/notice/${n.noticeImg}" alt="이미지" style="width:100px;height:70px;">
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
        <form id="selectfrm" action="noticeselect.do" method="post">
          <input type="hidden" id="noticeId" name="noticeId">
        </form>
      </div>
    </div>
    <script type="text/javascript">
      function noticeSelect(id) {
        let form = document.getElementById("selectfrm");
        form.noticeId.value = id;
        form.submit();
      }

      function searchList() {
        let form = document.getElementById("searchfrm");

        let key = form.key.value;
        let val = form.val.value;

        let payload = "key=" + key + "&val=" + val;
        let url = "ajaxnoticesearch.do"
        
        // ajax POST 방식
        fetch(url, {
          method: "POST",
          headers: {'Content-Type': 'application/x-www-form-urlencoded'},
          body: payload
        }).then(response => response.json())
          .then(json => htmlViews(json));
      }

      function htmlViews(datas) {
        document.querySelector('#tlist').remove(); // 일단 목록을 전부 지움

        const tbody = document.createElement('tbody'); // 그리고 검색 결과를 담아줄 tbody 생성
        tbody.setAttribute("id", "tlist"); // id값도 지정해줌
        tbody.innerHTML = datas.map(data => htmlConvert(data)).join('');

        document.querySelector('#listtable').appendChild(tbody); // 만들어놓은 tbody를 붙임
      }

      function htmlConvert(n) {
        if(n.noticeAttach == null) {
          n.noticeAttach = '';
        }
        return `
          <tr onmouseover="this.style.background='#C8FE2E'"
              onmouseout="this.style.background='#FFFFFF'"
              onclick="noticeSelect('\${n.noticeId}')">
            <td align="center">\${n.noticeId}</td>
            <td align="center">
              <img src="attach/notice/\${n.noticeImg}" alt="이미지" style="width:100px;height:70px;">
            </td>
            <td>\${n.noticeTitle}</td>
            <td align="center">\${n.noticeWriterName}</td>
            <td align="center">\${n.noticeDate}</td>
            <td align="center">\${n.noticeHit}</td>
            <td align="center">\${n.noticeAttach}</td>
          </tr>
        `
      }
    </script>
  </body>

  </html>