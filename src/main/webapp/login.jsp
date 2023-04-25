<%--
  Created by IntelliJ IDEA.
  User: Rayani
  Date: 10/7/2022
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<head>
    <title>Login</title>
    <script src="assets/js"></script>
</head>
<body>
<%@include file="/WEB-INF/template/header.jsp" %>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
%>
<div class="container d-flex align-items-center justify-content-center">
    <c:if test="${not empty  errorMessage}">
        <div class="toast-container position-absolute top-0 end-0 p-3" style="z-index: 11" >
            <div class="toast show" role="alert" aria-live="assertive" aria-atomic="true" delay="3000"  data-bs-autohide="true">
                <div class="toast-header">
                    <img src="assets/pic/rayani-logo.png"  class="rounded me-2 fas" alt="">
                    <strong class="me-auto text-danger">Error</strong>
                    <small class="text-muted">just now</small>
                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
                <div class="toast-body">
                    <p class="text-danger">${errorMessage}</p>
                </div>
            </div>
        </div>
    </c:if>
    <form class="" method="post" action="/login">
        <div class="mb-3 col-md-12">
            <label for="emailID" class="form-label">Email address</label>
            <input type="email" class="form-control" name="email" id="emailID"
                   aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
            <div id="emailValidate" class="form-text">Email is incorrect</div>
        </div>
        <div class="mb-3 col-md-12">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1">
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Remember Me</label>
        </div>
        <div class="row d-flex justify-content-around">
            <div class="col-md-5">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
            <div class="col-md-5">
                <a href="/register.jsp">
                    <button type="button" class="btn btn-secondary">Register</button>
                </a>
            </div>
        </div>
    </form>
    <script>
        let emailValidationElement = document.getElementById("emailValidate");
        emailValidationElement.style.display = "none";
        document.getElementById("emailID").addEventListener("blur", validateEmail);
        function validateEmail() {
            let emailValue = document.getElementById("emailID").value;
            const re = /^\S+@\S+\.\S+$/
            if (!re.test(emailValue)) {
                emailValidationElement.style.display = "block";
                emailValidationElement.style.color = "red";
            } else {
                emailValidationElement.style.display = "none";
            }
        }
    </script>
</div>
</body>
</html>
