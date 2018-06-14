<%-- 
    Document   : login
    Created on : Jun 14, 2018, 11:27:00 AM
    Author     : sivaganesan_t
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<!--<link href="resources/templateResources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="resources/templateResources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<script src="resources/templateResources/vendor/jquery/jquery.min.js" type="text/javascript"></script>
<script src="resources/templateResources/vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>-->
<style type="text/css">
	.login-form {
		width: 385px;
		margin: 30px auto;
	}
    .login-form form {        
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .login-btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .input-group-addon .fa {
        font-size: 18px;
    }
    .login-btn {
        font-size: 15px;
        font-weight: bold;
    }
	.social-btn .btn {
		border: none;
        margin: 10px 3px 0;
        opacity: 1;
	}
    .social-btn .btn:hover {
        opacity: 0.9;
    }
	.social-btn .btn-primary {
        background: #507cc0;
    }
	.social-btn .btn-info {
		background: #64ccf1;
	}
	.social-btn .btn-danger {
		background: #df4930;
	}
    .or-seperator {
        margin-top: 20px;
        text-align: center;
        border-top: 1px solid #ccc;
    }
    .or-seperator i {
        padding: 0 10px;
        background: #f7f7f7;
        position: relative;
        top: -11px;
        z-index: 1;
    }   
</style>
</head>
<body>
<div class="login-form">
    <form action="ValidateLoginServlet" method="post">
        <h2 class="text-center">Sign in</h2>   
        <div class="form-group">
        	<div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" class="form-control" name="username" placeholder="Username" required="required">				
            </div>
        </div>
		<div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <input type="password" class="form-control" name="password" placeholder="Password" required="required">				
            </div>
        </div>        
        <div class="form-group">
            <button type="submit" class="btn btn-primary login-btn btn-block">Sign in</button>
        </div>
        <div class="clearfix">
            <label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>
            <a href="#" class="pull-right">Forgot Password?</a>
        </div>
        
    </form>
    <p class="text-center text-muted small">Don't have an account? <a href="#">Sign up here!</a></p>
</div>
</body>
</html>                            