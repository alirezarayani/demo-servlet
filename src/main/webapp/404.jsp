<%--
  Created by IntelliJ IDEA.
  User: Rayani
  Date: 12/31/2022
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page Not Found</title>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Roboto+Mono');
        .center-xy {
        // width: inherit;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            position: absolute;
        }

        html, body {
            font-family: 'Roboto Mono', monospace;
            font-size: 16px;
        }

        html {
            box-sizing: border-box;
            user-select: none;
        }

        body {
            background-color: #000;
        }

        *, *:before, *:after {
            box-sizing: inherit;
        }

        .container {
            width: 100%;
        }

        .copy-container {
            text-align: center;
        }

        p {
            color: #fff;
            font-size: 24px;
            letter-spacing: .2px;
            margin: 0;
        }

        .handle {
            background: #ffe500;
            width: 14px;
            height: 30px;
            top: 0;
            left: 0;
            margin-top: 1px;
            position: absolute;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="copy-container center-xy">
        <p>
            404, page not found.
        </p>
        <span class="handle"></span>
    </div>
</div>
</body>
</html>
