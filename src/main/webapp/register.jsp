<%--
  Created by IntelliJ IDEA.
  User: Rayani
  Date: 11/5/2022
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<head>
    <title>Register</title>
</head>
<body>
<%@include file="/WEB-INF/template/header.jsp" %>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
%>
<div class="row col-md-12">
    <h1 style="text-align: center;
    color: #212529;">Sign Up for Free</h1>
</div>
<div class="container d-flex align-items-center justify-content-center">
    <c:if test="${not empty  errorMessage}">
        <div class="toast-container position-absolute top-0 end-0 p-3">
            <div class="toast show " role="alert" aria-live="assertive" aria-atomic="true" delay="3000"  data-bs-autohide="true">
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
    <form id="test" class="" method="post" action="/register">
        <div class="row">
            <div class=" mb-3 col-md-12">
                <input type="email" class="form-control" placeholder="Email address" name="email"
                       id="exampleInputEmail1"
                       aria-describedby="emailHelp">
                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
            </div>
        </div>

        <div class="mb-3 col-md-12">
            <div class="input-group">
                <input type="password" placeholder="Enter your password" name="password" onfocusout="blurPassword()"
                       class="form-control"
                       id="passwordInput">

                <button class="btn btn-primary  btn-sm" onclick="showPassword()" type="button"
                        id="button-addon2">Show Password
                </button>
            </div>
            <p id="passwordElement">Please enter complex password</p>
        </div>

        <div class="mb-3 col-md-12">
            <input type="password" name="password" onblur="blurPasswordConfirm()"
                   placeholder="Enter your confirm Password" class="form-control"
                   id="passwordConfirmInput">
            <p id="passwordConfirmElement">Password not match</p>
        </div>
        <div class="row">
            <div class="col-md-5">
                <button type="submit" class="btn btn-primary" onclick="return isValid()">Register</button>
            </div>
        </div>
    </form>
</div>
<script>
    const passwordElement = document.getElementById("passwordElement");
    const passwordConfirmElement = document.getElementById("passwordConfirmElement");
    passwordElement.style.display = "none";
    passwordConfirmElement.style.display = "none";
    const passwordInput = document.getElementById("passwordInput");
    const passwordConfirmInput = document.getElementById("passwordConfirmInput");

    function isValid() {
        let isPasswordValid = true;
        if (passwordInput.value.length < 6) {
            passwordElement.style.display = "block";
            passwordElement.style.color = "red";
            isPasswordValid = false;
        } else {
            passwordElement.style.display = "none";
        }

        if (passwordConfirmInput.value.length < 6 || passwordConfirmInput.value !== passwordInput.value) {
            passwordConfirmElement.style.display = "block";
            passwordConfirmElement.style.color = "red";
            isPasswordValid = false;
        } else {
            passwordConfirmElement.style.display = "none";
        }
        return isPasswordValid;
    }

    function blurPassword() {
        if (passwordInput.value.length >= 6) {
            passwordElement.style.display = "none";
        } else {
            passwordElement.style.display = "block";
            passwordElement.style.color = "red";
        }
    }

    function blurPasswordConfirm() {
        if (passwordConfirmInput.value.length >= 6) {
            passwordConfirmElement.style.display = "none";
        } else {
            passwordConfirmElement.style.display = "block";
            passwordConfirmElement.style.color = "red";
        }
    }

    function showPassword() {
        var x = document.getElementById("passwordInput");
        var y = document.getElementById("passwordConfirmInput");
        if (x.type === "password") {
            x.type = "text";
            y.type = "text";
        } else {
            x.type = "password";
            y.type = "password";
        }
    }
</script>
</body>
</html>
