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
        <h1>회 원 가 입</h1>
      </div>
      <div>
        <form id="frm" action="memberjoin.do" onsubmit="return formCheck()" method="post">
          <div>
            <table border="1">
              <tr>
                <th width="150">아이디*</th>
                <td>
                  <input type="text" id="memberId" name="memberId" required="required">
                  <button type="button" id="idCheck" value="No" onclick="memberIdCheck()">중복체크</button>
                </td>
              </tr>
              <tr>
                <th width="150">비밀번호*</th>
                <td>
                  <input type="password" id="memberPassword" name="memberPassword" style="width:250px;" required="required">
                </td>
              </tr>
              <tr>
                <th width="150">비밀번호 확인*</th>
                <td>
                  <input type="password" id="checkPassword" style="width:250px;" required="required">
                </td>
              </tr>
              <tr>
                <th width="150">이름*</th>
                <td>
                  <input type="text" id="memberName" name="memberName" required="required">
                </td>
              </tr>
              <tr>
                <th width="150">연락처</th>
                <td>
                  <input type="text" id="memberTel" name="memberTel" style="width:250px;">
                </td>
              </tr>
              <tr><td colspan="2" align="center">*표기 항목은 필수 입력 정보입니다.</tr>
            </table>
          </div><br>
          <div>
            <input type="submit" value="회원가입">&nbsp;&nbsp;
            <input type="reset" value="취소">
          </div>
        </form>
      </div>
    </div>
   	<script type="text/javascript">
      function formCheck() {
        let form = document.getElementById("frm");
   		
        if (form.idCheck.value == "No") {
          alert("아이디 중복체크를 하세요.");
          return false;
        }
        if (form.memberPassword.value != form.checkPassword.value) {
          alert("입력한 패스워드가 일치하지 않습니다.");
          form.memberPassword.value = "";
          form.checkPassword.value = "";
          form.memberPassword.focus();
          return false;
   		}
        
        return true;
      }
      
      function memberIdCheck() { 
    	  let url = "ajaxmembercheck.do"
        let payload = document.getElementById("memberId").value;

        url = url + "?memberId=" + payload; //쿼리 파라미터

        //ajax GET 방식
        fetch(url)
          .then(response => response.text())
          .then(text => memberCheck(text));
      }

      function memberCheck(text) {
        if (text == 'Yes') {
          alert("사용 가능한 ID 입니다.");
          document.getElementById("idCheck").value = "Yes";
          document.getElementById("idCheck").disabled = true;
        } else {
          alert("이미 존재하는 ID 입니다.");
          document.getElementById("idCheck").value = "No";
          document.getElementById("memberId").value = "";
          document.getElementById("memberId").focus();
        }
      }
   	</script>
  </body>

  </html>