<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>

    <h3>도서삭제조회</h3>
    <form action="../searchBook.do" method="get">
        <input type="text" name="bookCode" id=""><br>
        <input type="hidden" name="job" value="remove">
        <input type="submit" value="조회">
    </form>

</body>

</html>