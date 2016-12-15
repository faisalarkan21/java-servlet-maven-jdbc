


<%@include file="/WEB-INF/header.jsp"%>

<div style="padding-top: 40px;" class="col-md-5 col-md-offset-4">




	<div style="padding-bottom: 30px;" class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Login Disini mas..</h3>
		</div>
		<div class="panel-body">

			<form class="col-md-offset-3"  method="POST" action='LoginServlet'>

				<div class="col-md-8 ">
					<br />
					<div class="form-group">
						<label class="control-label" for="inputDefault">Email</label> <input
							type="email" name="email" class="form-control" id="inputDefault">
					</div>
					<div class="form-group">
						<label class="control-label" for="inputDefault">Password</label> <input
							type="password" name="password" class="form-control" id="inputDefault">
					</div>

					<br />
					<a href="adduser.jsp" class="btn btn-info">Daftar</a>
					<button type="submit" class="btn btn-primary">Masuk</button>
					


				</div>



			</form>


		</div>
	</div>



</div>


</body>
</html>