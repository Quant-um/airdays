<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Join</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script language="javascript"> function checks() {
	//값 불러오기
	var getPw = document.getElementById("pw");
	var getPwCheck = document.getElementById("password_check");
	var getMail = document.getElementById("email");
	//value 불러오기 
	var pw = getPw.value; var pwCheck = getPwCheck.value;
	//유효성 검사
	var regExp = /^[a-zA-Z0-9]{4,12}$/;
	//id, password
	var regMail = /[a-z0-9]{2,}@[a-z0-9-]{2,}.[a-z0-9]{2,}/i;
	//mail
	if (!regExp.test(pw)) {
		//password
		alert("비밀번호 다시 설정"); getPw.value = ""; getPw.focus();
		return false; } else if (!(pwCheck.slice(0, pwCheck.length) == pw.slice(0, pw.length))) {
			//password 동일한지 확인
			alert("비밀번호 서로 안맞아"); getPwCheck.value = ""; getPwCheck.focus();
			return false; }
		else if ((pw.slice(0, pwCheck.length) == id.slice(0, id.length))) {
			//password랑 id 다른지 확인
			alert("비밀번호와 id가 동일하면  안되요!"); getPw.value = ""; getPwCheck.value = ""; getPw.focus();
			return false; } } * / } </script>
<script language="javascript">
function execDaumPostcode() {
	new daum.Postcode({ oncomplete:
		function (data) {
		// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
		// 각 주소의 노출 규칙에 따라 주소를 조합한다.
		// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		var addr = ''; // 주소 변수 var extraAddr = '';
		// 참고항목 변수
		//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
		if (data.userSelectedType === 'R') {
			// 사용자가 도로명 주소를 선택했을 경우
			addr = data.roadAddress; }
		else {
				// 사용자가 지번 주소를 선택했을 경우
				(J) addr = data.jibunAddress; }
		// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
		if (data.userSelectedType === 'R') {
			// 법정동명이 있을 경우 추가한다. (법정리는 제외)
			// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) { extraAddr += data.bname; }
			// 건물명이 있고, 공동주택일 경우 추가한다.
			if (data.buildingName !== '' && data.apartment === 'Y') { extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName); }
			// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
			if (extraAddr !== '') { extraAddr = ' (' + extraAddr + ')'; } }
		// 우편번호와 주소 정보를 해당 필드에 넣는다.
		document.getElementById('zipcode').value = data.zonecode; document.getElementById("addr1").value = addr;
		// 커서를 상세주소 필드로 이동한다.
		document.getElementById("addr2").focus(); } }).open(); } </script>
		</head>
		<body>
		<jsp:include page="/WEB-INF/views/template/header.jsp" /> <br>
		<form action="/user/edit" method="post" onSubmit="return checks()">
		<div style="float: none; margin: 0 auto;">
		<h1 align="center">User Edit
		</h1> <h6>아이디</h6>
		<input type="text" name="id" value="${userEdit.id}" readonly>
		<h6>비밀번호 : 4~12자의 영문 대소문자와 숫자로만 입력</h6>
		<input type="password" id="pw" name="pw" value="${userEdit.pw}">
		<h6>비밀번호 확인</h6>
		<input type="password" id="password_check" value="${userEdit.pw}">
		<h6>이름</h6>
		<input type="text" name="name" value="${userEdit.name}" readonly>
		<h6> 우편주소 
		<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"> </h6>
		<input type="text" id="zipcode" name="zipcode" value="${userEdit.zipcode}">
		<h6>도로명 주소</h6>
		<input type="text" id="addr1" name="addr1" value="${userEdit.addr1}">
		<h6>상세 주소</h6>
		<input type="text" id="addr2" name="addr2" value="${userEdit.addr2}">
		<h6>전화번호</h6>
		<input type="text" name="phone" value="${userEdit.phone}">
		<h6>이메일 : id@domain.com</h6>
		<input type="text" id="email" name="email" value="${userEdit.email}"> </div> <br>
		<div align="center"> <button type="submit">수정</button>
		<button type="button" onclick="location.href='/board/list'">뒤로</button>
		</div>
		</form>
		</body>
		</html>
