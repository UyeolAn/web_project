<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
  <html lang="ko">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/menu.css">
    <title>메 뉴 바</title>
  </head>

  <body>
    <div id="container">
      <header>
        <h1>홈 가 기</h1>
        <nav>
          <ul>
          	<li class="menu"><a href="noticeselectlist.do">게시글목록</a></li>
            <c:if test="${empty id}">
              <li class="menu"><a href="memberloginform.do">로그인</a></li>
              <li class="menu"><a href="memberjoinform.do">회원가입</a></li>
              <li class="showname"><p>로그인 하지않음</p></li>
            </c:if>
            <c:if test="${not empty id}">
              <li class="menu"><a href="memberlogout.do">로그아웃</a></li>
              <li class="menu"><a href="memberlist.do">회원목록</a></li>
              <li class="menu"><a href="home.do">메뉴4</a></li>
              <li class="showname"><p>${name}님 접속중</p></li>
            </c:if>
          </ul>
        </nav>
      </header>
    </div>
  </body>

  </html>