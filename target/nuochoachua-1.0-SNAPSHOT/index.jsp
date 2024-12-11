<%-- 
    Document   : index
    Created on : Nov 22, 2024, 2:38:34 PM
    Author     : Jackt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Perfume Store - Log In</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./resources/css/bootstrap.css"/>
        <script src="./resources/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="login-container">
            <!-- Phần form đăng nhập -->
            <div class="login-form">
                <h2>Log In</h2>
                <p>Log in to continue in our website</p>
                <form action="#" method="POST">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
                    </div>
                    <div class="mb-3 form-check">
                        <input type="checkbox" class="form-check-input" id="rememberMe">
                        <label class="form-check-label" for="rememberMe">Remember me</label>
                    </div>
                    <button type="submit" class="btn w-100">Log In</button>
                    <div class="text-center mt-3">
                        <a href="#" class="text-decoration-none">Forgot Password</a> | 
                        <a href="#" class="text-decoration-none">Register</a>
                    </div>
                </form>
            </div>

            <!-- Phần hình ảnh -->
            <div class="login-image">
                
            </div>
        </div>

    </body>
</html>
