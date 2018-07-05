<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<!-- Required meta tags -->

	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

	<link rel="stylesheet" href="style/style.css">

	<title>Version Control Lab</title>

</head>

<body>

	<jsp:include page="layout/navbar.jsp"></jsp:include>

<main>
	<div class="gretting-form">

		<div class="gretting-text">
			<h1 class="mt-5">Lorem ipsum dolor sit amet,</h1>
			<p class="lead"> consectetur adipiscing elit. Proin molestie maximus erat sed molestie. Morbi cursus lectus eu turpis luctus feugiat. Vivamus sollicitudin enim euismod neque elementum, tempor bibendum nisl venenatis. Morbi velit nulla, finibus vitae tempus varius, volutpat sed diam. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nam arcu turpis, aliquam vitae risus at, pulvinar porttitor sem. Phasellus facilisis tristique ligula et porta. Fusce sapien justo, commodo at sapien vitae, tristique cursus tortor. Donec gravida sagittis risus sit amet sollicitudin. Aliquam eget est quis purus dapibus feugiat a pellentesque lacus.
				Vivamus fringilla sodales massa, non facilisis orci.
				Aenean id elit et diam auctor maximus quis vitae nisl.</p>
		</div>

		<div class="registration-form">

			<form class="form-signin custom-sign-in-form" action="FrontController" method="post">
				<input name="command" value="register" type="hidden"/>
				<h2 class="form-signin-heading">Please sign in</h2>
				<label  class="sr-only" > Username</label>
				<input name="login" value="" id="inputUsername" class="form-control" placeholder="Username " required="" autofocus="">

				<label for="inputEmail" class="sr-only">Email address</label>
				<input name="email" value="" type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
				<label for="inputPassword" class="sr-only">Password</label>
				<input  name="password" value="" type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
				<div class="checkbox">
					<label>
						<input type="checkbox" value="remember-me"> Remember me					          </label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit" >Sign up</button>
			</form>

		</div>
	</div>
</main>




<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>