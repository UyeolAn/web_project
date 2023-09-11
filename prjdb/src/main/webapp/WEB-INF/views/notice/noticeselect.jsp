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
      <table border="1">
        <tr>
          <th>댓글내용</th>
          <td><input type="text" id="replySubject" name="replySubject"></td>
        </tr>
        <tr>
          <th>작성자</th>
          <td><input type="text" id="replyWriter" name="replyWriter"></td>
        </tr>
        <tr>
          <td colspan="2">
            <button type="button" id="addReply">댓글등록</button>
          </td>
        </tr>
      </table>
      <h3>댓글목록</h3>
      <table border="1">
        <tbody id="replyList">
          <tr>
            <td>1</td>
            <td>1번글의 댓글입니다</td>
            <td>user1</td>
            <td>2023-09-05</td>
          </tr>
        </tbody>
      </table>
    </div>
    <style>
      /* The Modal (background) */
      .modal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 1; /* Sit on top */
        left: 0;
        top: 0;
        width: 100%; /* Full width */
        height: 100%; /* Full height */
        overflow: auto; /* Enable scroll if needed */
        background-color: rgb(0,0,0); /* Fallback color */
        background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
      }

      /* Modal Content/Box */
      .modal-content {
        background-color: #fefefe;
        margin: 15% auto; /* 15% from the top and centered */
        padding: 20px;
        border: 1px solid #888;
        width: 80%; /* Could be more or less, depending on screen size */
      }

      /* The Close Button */
      .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
      }

      .close:hover,
      .close:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
      }
    </style>
    <!-- The Modal -->
    <div id="myModal" class="modal">
      <!-- Modal content -->
      <div class="modal-content">
        <span class="close">&times;</span>
        <p>1</p>
        <p><input type="text" class="content"></p>
        <p><button id="editReply">수정</button></p>
      </div>
    </div>
    <script src="js/reply.js"></script>
    <script>
      // 변수 설정
      const replyObj = new Reply();
      replyObj.showInfo();
      let noticeId = "<c:out value='${n.noticeId}' />"

      // 댓글 리스트
      replyObj.replyList(noticeId, datas => showList(datas));

      // 등록 버튼
      document.querySelector("#addReply").addEventListener("click", elem => {
        let subject = document.querySelector("#replySubject").value;
        let writer = document.querySelector("#replyWriter").value;
        const reply = {
          noticeId: noticeId,
          replySubject: subject,
          replyWriter: writer
        };

        replyObj.replyAdd(reply, data => {
          if (data.retCode == "Success") {
            alert("댓글 등록 완료!!");
            replyObj.replyList(noticeId, datas => showList(datas));
          } else {
            alert("댓글 등록 실패");
          }
        });
      });

      // 수정 폼 닫기
      document.querySelector("span.close").addEventListener("click", () => {
        let modal = document.getElementById("myModal");
        modal.style.display = "none";
        document.querySelector('#myModal')
      });
      window.onclick = function(event) {
        let modal = document.getElementById("myModal");
        if (event.target == modal) {
          modal.style.display = "none";
        }
      };

      // 수정 버튼
      document.querySelector("#editReply").addEventListener("click", () => {
        let rid = document.querySelector("#myModal p").innerText;
        let subject = document.querySelector("#myModal input.content").value;

        const updateData = {
          replyId: rid,
          replySubject: subject
        };

        replyObj.replyModify(updateData, res => {
          if (res.retCode == "Success") {
            alert("수정 성공!!!")
            // 이렇게 해도 되지만 페이지가 많아질 경우 replaceChild(newData, oldData) 를 사용할 것!!!
            replyObj.replyList(noticeId, datas => showList(datas));
          } else if (res.retCode == "Fail") {
            alert("수정 실패");
          } else {
            alert("예상치 못한 수정 오류");
          }
        });
      });

      // 함수 모음
      // 댓글 리스트
      function showList(datas) {
        let target = document.querySelector("#replyList");
        const fields = ["noticeId", "replySubject", "replyWriter", "replyEnterDate"];
        target.innerHTML = "";

        for (let data of datas) {
          let tr = document.createElement("tr");
          tr.setAttribute("rid", data.replyId);
          tr.addEventListener("dblclick", showEditForm);
          for (let field of fields) {
            let td = document.createElement("td");
            td.innerText = data[field];
            tr.appendChild(td);
          }
          
          // 삭제 버튼
          td = document.createElement("td");
          let delBtn = document.createElement("button");
          delBtn.innerText = "삭제";
          delBtn.addEventListener("click", deleteReply);
          td.appendChild(delBtn);
          tr.appendChild(td);

          target.appendChild(tr);
        }
      }

      // 댓글 수정 폼
      function showEditForm(elem) {
        let modal = document.getElementById("myModal");
        modal.style.display = "block";

        let rid = this.getAttribute("rid");
        console.log(rid);
        replyObj.replySearch(rid, data => {
          document.querySelector("#myModal p").innerText = data.replyId;
          document.querySelector("#myModal input.content").value = data.replySubject;
        });
      }

      // 댓글 삭제
      function deleteReply(elem) {
        let rid = elem.target.parentElement.parentElement.getAttribute("rid");
        replyObj.replyRemove(rid, res => {
          if (res.retCode == "Success") {
            elem.target.parentElement.parentElement.remove();
          } else if (res.retCode == "Fail") {
            alert("댓글 삭제 실패");
          } else {
            alert("댓글 삭제에서 예상치 못한 일이 발생하였음");
          }
        });
      }

    </script>
    <!-- <script>
      // Get the modal
      var modal = document.getElementById("myModal");

      // Get the button that opens the modal
      var btn = document.getElementById("myBtn");

      // Get the <span> element that closes the modal
      var span = document.getElementsByClassName("close")[0];

      // When the user clicks on the button, open the modal
      btn.onclick = function() {
        modal.style.display = "block";
      }

      // When the user clicks on <span> (x), close the modal
      span.onclick = function() {
        modal.style.display = "none";
      }

      // When the user clicks anywhere outside of the modal, close it
      window.onclick = function(event) {
        if (event.target == modal) {
          modal.style.display = "none";
        }
      }
    </script> -->
  </body>

  </html>