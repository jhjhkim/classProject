<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

</head>
<body>

	<h1>입력 폼</h1>
	<hr>
	<form method="post">
		이름 <input type="text" name="uname"> <br>
		나이 <input type="text" name="age"> <br>
		<input type="submit">
	</form>

	<hr>

	<input type="button" id="btn" value="Json전송">

	<script>
		$(document).ready(function() {

			$('#btn').click(function() {

				var obj = {
					itemId : 'product-10',
					number : 1000,
					remark : '파손주의'
				};

				$.ajax({
					url : '/mvc/orderitem',
					type : 'POST',
					data : JSON.stringify(obj),
					dataType : 'json',
					contentType : 'application/json',
					success : function(data) {
						console.log(data);
					},
					error : function() {
						console.log('통신오류');
					}
				});

			})

		});
	</script>

</body>
</html>