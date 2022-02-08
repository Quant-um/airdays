<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html> <html>
    <head>
        <meta charset="UTF-8">
    <title>MEMBER LOGIN</title>
</head>
<body>
    <div style="float: none; margin: 0 auto;">
        <h1>Login</h1>
        <form action="/user/login" name="LoginForm" method="post">
            <h1>ID</h1> <input type="text" required name="id">
            <h1>PW</h1> <input type="password" required name="pw">
            <button type="submit">Login</button>
        </form>
        <button type="button" onclick="location.href='/user/joinPage'">Join</button>
        <button type="button" onclick="location.href='/user/findPage'">Find Id/Pw</button>
        <button type="button" onclick="location.href='/'">Main</button>
    </div>
</body>
</html>