<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> <meta charset="UTF-8">
<title>MEMBER DETAIL</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/template/header.jsp" /> <br>
    <div style="float: none; margin: 0 auto;">
        <h1 align="center">User Detail</h1>
        <h6>아이디</h6>
        <input type="text" name="id" value="${memberDetail.id}" readonly>
        <h6>비밀번호</h6> <input type="text" name="pw" value="${memberDetail.pw}" readonly>
        <h6>이름</h6> <input type="text" name="name" value="${memberDetail.name}" readonly>
        <h6>우편주소</h6> <input type="text" name="zipcode" value="${memberDetail.zipcode}" readonly>
        <h6>도로명 주소</h6> <input type="text" name="addr1" value="${memberDetail.addr1}" readonly>
        <h6>상세 주소</h6> <input type="text" name="addr2" value="${memberDetail.addr2}" readonly>
        <h6>전화번호</h6> <input type="text" name="phone" value="${memberDetail.phone}" readonly>
        <h6>이메일</h6> <input type="text" name="email" value="${memberDetail.email}" readonly>
    </div> <div align="center">
        <button type="button" onclick="location.href='/user/editPage?id=${memberDetail.id}'">수정</button>
        <button type="button" onclick="location.href='/user/delete?id=${memberDetail.id}'">탈퇴</button>
        <button type="button" onclick="location.href='/board/list'">뒤로</button> </div>
    </body>
    </html>