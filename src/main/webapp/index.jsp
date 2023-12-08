<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,com.TechBlog.helper.*,java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!--BootStrap css  -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="Js/myjs.js" type="text/javascript"></script>

<style type="text/css">
	.banner-background{
		clip-path: polygon(50% 0%, 100% 0, 100% 35%, 100% 100%, 76% 95%, 50% 100%, 25% 95%, 0 100%, 0% 35%, 0 0);
	}
</style>
</head>
<body>

	<%-- <h1>Hello World</h1>
	<%
		Connection con = ConnectionProvider.getConnection();
	%>
	
	 <h1><%=con %></h1> --%>

	<!-- navbar -->
	<%@include file="navbar.jsp"%>

	<!-- banner  -->
	<div class="container-fluid p-0 m-0">

		<div class="jumbotron primary-background text-white banner-background">
			<div class="container ">
				<h3 class="display-3">Welcome to TechBlog</h3>
				<p>Welcome to technical blog, world of technology. A programming
					language is a system of notation for writing computer programs.[1]
					Most programming languages are text-based formal languages, but
					they may also be graphical. They are a kind of computer language.</p>
				<p>A programming language is a type of written language that
					tells computers what to do. Examples are: Python, Ruby, Java,
					JavaScript, C, C++, and C#. Programming languages are used to write
					all computer programs and computer software. A programming language
					is like a set of instructions that the computer follows to do
					something.</p>

				<button class="btn btn-outline-light btn-lg"><span class="fa fa-child"></span>Starts ! its Free</button>
				<a href="login.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-circle fa-spin"></span>Login</a>

			</div>
		</div>

	</div>

	<!-- cards -->

	<div class="container mb-2">

		<div class="row">

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn primary-background text-white">Read more</a>
					</div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn primary-background text-white">Read more</a>
					</div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn primary-background text-white">Read more</a>
					</div>
				</div>
			</div>

		</div>
		
		<div class="row">

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn primary-background text-white">Read more</a>
					</div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn primary-background text-white">Read more</a>
					</div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn primary-background text-white">Read more</a>
					</div>
				</div>
			</div>

		</div>
		


	</div>

	<!-- javascript -->
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"
		integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		/* check for jquery */
		/* ${document}.ready(function(){
			alert("document loaded");
		}) */
	</script>
</body>
</html>