<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>404 - Page Not Found</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .error-container {
            text-align: center;
            background-color: #ffffff;
            padding: 50px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
            width: 500px;
        }

        .error-code {
            font-size: 100px;
            font-weight: bold;
            color: #e74c3c;
            line-height: 1;
        }

        .error-title {
            font-size: 28px;
            color: #333333;
            margin: 10px 0;
        }

        .error-message {
            font-size: 16px;
            color: #777777;
            margin: 15px 0 30px 0;
            line-height: 1.6;
        }

        .btn-home {
            display: inline-block;
            padding: 12px 30px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            margin: 5px;
        }

        .btn-back {
            display: inline-block;
            padding: 12px 30px;
            background-color: #95a5a6;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            margin: 5px;
        }

        .btn-home:hover { background-color: #2980b9; }
        .btn-back:hover { background-color: #7f8c8d; }

        .error-icon {
            font-size: 60px;
            margin-bottom: 10px;
        }

        .divider {
            border: none;
            border-top: 1px solid #eeeeee;
            margin: 20px 0;
        }

        .error-details {
            font-size: 13px;
            color: #aaaaaa;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <div class="error-container">

        <div class="error-icon">&#128269;</div>

        <div class="error-code">404</div>

        <div class="error-title">Page Not Found</div>

        <hr class="divider"/>

        <div class="error-message">
            Oops! The page you are looking for does not exist.<br>
            It may have been moved or deleted.
        </div>

        <a href="index.jsp"    class="btn-home">Go to Home</a>
        <a href="javascript:history.back()" class="btn-back">Go Back</a>

        <div class="error-details">
            Requested URL: <%= request.getAttribute("javax.servlet.error.request_uri") %>
        </div>

    </div>

</body>
</html>s