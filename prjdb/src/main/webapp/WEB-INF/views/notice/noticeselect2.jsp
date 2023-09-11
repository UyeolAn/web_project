<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
      <link rel="stylesheet" href="//cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
      <script src="//cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
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
        </div><br>
        <h3>댓글등록</h3>
        <div>
          <table border="1">
            <tr>
              <th>댓글번호</th>
              <td><input type="text" id="replyId" name="replyId"></td>
            </tr>
            <tr>
              <th>댓글작성자</th>
              <td><input type="text" id="replyWriter" name="replyWriter"></td>
            </tr>
            <tr>
              <th>댓글내용</th>
              <td><input type="text" id="replySubject" name="replySubject"></td>
            </tr>
            <tr>
              <th>등록날짜</th>
              <td><input type="date" id="replyEnterDate" name="replyEnterDate"></td>
            </tr>
            <tr>
              <td colspan="2"><button id="displayBtn" style="width: 100%">추 가</button></td>
            </tr>
          </table>
        </div>
        <h3>댓글목록</h3>
        <table id="example" class="display" style="width:100%">
          <thead>
            <tr>
              <th>댓글번호</th>
              <th>댓글작성자</th>
              <th>댓글내용</th>
              <th>등록날짜</th>
            </tr>
          </thead>
          <tfoot>
            <tr>
              <th>댓글번호</th>
              <th>댓글작성자</th>
              <th>댓글내용</th>
              <th>등록날짜</th>
            </tr>
          </tfoot>
        </table>
        <button id="deleteBtn">삭제</button>
        <script>
          let noticeId = "${n.noticeId}"
          new DataTable('#example', {
            ajax: 'ajaxreplylist.do?nid=' + noticeId + '&param=jquery'
          });

          const table = new DataTable('#example');
          document.querySelector('button#displayBtn').addEventListener('click', addNewRow);

          function addNewRow() {
            table.row
              .add([
                $('#replyId').val(),
                $('#replyWriter').val(),
                $('#replySubject').val(),
                $('#replyEnterDate').val()
              ])
              .draw(false);
          }

          table.on('click', 'tbody tr', (e) => {
            let classList = e.currentTarget.classList;

            if (classList.contains('selected')) {
              classList.remove('selected');
            }
            else {
              table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
              classList.add('selected');
            }
          });

          document.querySelector('#deleteBtn').addEventListener('click', function () {
            table.row('.selected').remove().draw(false);
          });
        </script>

    </body>

    </html>