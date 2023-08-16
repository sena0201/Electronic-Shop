<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    <!-- Font Icon -->
    <link rel="stylesheet" href="public/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="public/css/style.css">
</head>

<body>
	<%
		String warning = (String)request.getAttribute("warning");
		if(warning != null){
			out.print("<script>alert('"+ warning +"')</script>");
		}
	%>
    <div class="main">
        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
            	<div>
		    		<a href="HomeController" class="back-icon"><i class='bx bx-arrow-back'></i></a>
		    	</div>
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <form action="RegisterController" method="POST" class="register-form" id="register-form">
                            <div class="form-group">
                                <label><i class='bx bx-rename'></i></label>
                                <input type="text" name="customerName" placeholder="Your Name" />
                            </div>
                            <div class="form-group">
                                <label><i class='bx bxs-home'></i></label>
                                <input type="text" name="address" placeholder="Your Address" />
                            </div>
                            <div class="form-group">
                                <label><i class='bx bx-phone'></i></label>
                                <input type="text" name="phoneNumber" placeholder="Phone Number" />
                            </div>
                            <div class="form-group">
                                <label for="user"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="userName" id="user" placeholder="User" />
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="pass" placeholder="Password" />
                            </div>
                            <div class="form-group">
                                <label><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="repeatPassword" placeholder="Repeat your password" />
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register" />
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="public/img/signup-image.jpg" alt="sing up image"></figure>
                        <a href="LoginController" class="signup-image-link">I am already member</a>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <!-- JS -->
     <!-- JS -->
    <script src="public/js/jquery.min.js"></script>
    <script src="public/js/main.js"></script>
</body>

</html>