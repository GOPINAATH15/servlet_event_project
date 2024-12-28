<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
<%
ResultSet rs = (ResultSet) request.getAttribute("rs");
%>
<h1>Update Page</h1>
<input type="text" name="id" value="<%=rs.getInt(1)%>" readonly="readonly" placeholder="Enter Event id">
<input type="text" name="title" value="<%=rs.getString(2)%>" placeholder="Enter Event title">
<input type="text" name="loc" value="<%=rs.getString(3)%>" placeholder="Enter Event location">
<input type="text" name="date" value="<%=rs.getString(4)%>" placeholder="Enter Event Date">
<input type="text" name="guest" value="<%=rs.getString(3)%>" placeholder="Enter Event guest name">
</body>
</html>