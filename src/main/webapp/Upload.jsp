<%--
  Created by IntelliJ IDEA.
  User: Rayani
  Date: 11/8/2022
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<%@include file="WEB-INF/template/header.jsp"%>
<h1>Upload music</h1>
<form action="upload" method="post" enctype="multipart/form-data">
    Music Name: <input type="text" name="MusicName"><br>
    Artist Name: <input type="text" name="ArtistName"><br>
    picture File:<input type="file" name="picture"><br>
    Music File:<input type="file" name="Music"><br>
    <input type="submit">
</form>
</body>
</html>
