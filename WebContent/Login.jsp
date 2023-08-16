<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>
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
        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
            	<div>
		    		<a href="HomeController" class="back-icon"><i class='bx bx-arrow-back'></i></a>
		    	</div>
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="public/img/signin-image.jpg" alt="sing up image"></figure>
                        <a href="RegisterController" class="signup-image-link">Create an account</a>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Sign up</h2>
                        <form action="LoginController" method="POST" class="register-form" id="login-form">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="userName" id="your_name" placeholder="Your Name" />
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="your_pass" placeholder="Password" />
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in" />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="public/js/jquery.min.js"></script>
    <script src="public/js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>