<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="co.test.vo.BookVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	BookVO book = new BookVO();
%>

<c:set target="<%=book %>" property="title" value="The Secret" />
<%=book.getBookTitle() %><br>

<h3>
	<c:out value="${b.title }" />
</h3>

<c:set var="b" value="<%=book %>" />
<c:set target="${b }" property="author" value="Byrne, Rhoda" />
<c:out value="${b.author }" /><br>
"${b.author }"
<br>

<a href="examList.jsp">리스트</a>