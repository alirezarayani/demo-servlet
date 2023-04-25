
<%@ page import="ir.lazydeveloper.model.Accessor" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<head>
    <%@ include file="bootstrap.jsp" %>
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="#">
            <i class="fa-solid fa-r"></i>
        </a>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Upload.jsp">Music</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pricing</a>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <%
                        HttpSession session = request.getSession(true);
                        Accessor accessor = (Accessor) session.getAttribute("Accessor");
                    %>
                    <%
                        if (accessor != null) {
                    %>
                    <a class="nav-link active" aria-current="page" href="/logout">logout</a>
                    <%
                        }
                    %>
                    <%
                        if (accessor == null) {
                    %>
                    <a class="nav-link active" aria-current="page" href="/login.jsp">Login</a>
                    <%
                        }
                    %>
                </li>
            </ul>
        </div>
    </div>
</nav>

