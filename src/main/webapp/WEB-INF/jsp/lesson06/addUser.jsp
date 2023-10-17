<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  
<!-- AJAX를 사용하려면 반드시 jQuery 원본 필요 -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<!-- <form method="post" action="/lesson06/ex01/add-user"> -->
			<div class="form-group">
				<label for="name"><b>이름</b></label>
				<input type="text" id="name" name="name" class="form-control col-3" placeholder="이름을 입력하세요">
			</div>
			<div class="form-group">
				<label for="yyyymmdd"><b>생년월일</b></label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-3" placeholder="예)20190101">
			</div>
			<div class="form-group">
				<label for="email"><b>이메일</b></label>
				<input type="text" id="email" name="email" class="form-control col-3" placeholder="이메일주소를 입력하세요">
			</div>
			<div class="form-group">
				<label for="introduce"><b>자기소개</b></label>
				<textarea id="introduce" name="introduce" class="form-control col-5" rows="10"></textarea>
			</div>
			
			<!-- <input type="submit" class="btn btn-success" value="추가">  -->
			<%-- ★★★★★★ AJAX 통신일 때는 반드시 button 타입으로 지정한다~! ★★★★★★ --%>
			<input id="joinBtn" type="button" class="btn btn-success" value="추가">
		<!-- </form>  -->
	</div>
	
	<script>
		
		$(document).ready(function() {
			
			// 1) jquery submit 기능
			$("form").on("submit", function(e) {  // 추가버튼 눌렀을때     // e
				
				//e.preventDefault(); // 폼태그 동작 막는다.
				
				// validation check
				/* let name = $("#name").val().trim(); 
				if(name == false)
				{
					alert("이름을 입력하세요");
					return false;   // return false;를 해야 submit을 안함!!!!★★★★★★   => 그 페이지에 머물러 있음.
				}
				
				let yyyymmdd = $("#yyyymmdd").val.trim();
				if(yyyymmdd.length < 1)
				{
					alert("생년월일을 입력하세요");
					return false;   // return false;를 해야 submit을 안함!!!!★★★★★★   => 그 페이지에 머물러 있음.
				}
				
				let email = $("#email").val.trim();
				if (!email) 
				{
					alert("이메일을 입력하세요.");
					return false;   // return false;를 해야 submit을 안함!!!!★★★★★★   => 그 페이지에 머물러 있음.
				} */
			
				
				// 여기까지 도달하면 submit 수행
			});
		
			// 2) jquery의 ajax 통신 이용하기
			$("#joinBtn").on("click", function(e) {
				
				// validation check
				let name = $("#name").val();
				if(name == false)
				{
					alert("이름을 입력하세요");
					return;   // return false;를 필요없음 form태그가 아니기 때문.
				}
				
				let yyyymmdd = $("#yyyymmdd").val();
				if(yyyymmdd.length < 1)
				{
					alert("생년월일을 입력하세요");
					return;  
				}
				
				let email = $("#email").val();
				if (!email) 
				{
					alert("이메일을 입력하세요.");
					return;   
				}
				
				let introduce = $("#introduce").val();
				
				console.log(name);
				console.log(yyyymmdd);
				console.log(email);
				console.log(introduce);
				
				// ajax : 서버 요청
				$.ajax({
					// request
					type:"POST" // type은 반드시 소문자
					, url:"/lesson06/ex01/add-user"
					, data:{"name" : name, "yyyymmdd" : yyyymmdd, "email" : email, "introduce" : introduce} // JSON String / 키가 항상 따옴표
					
					// response
					// call back 함수
					, success:function(data) { // data : response 결과 응답.. 위의 data와 아무상관없다.
						// 에러가 없을 때 수행
						// alert(data);
					
						if (data == "성공") {
							location.href = "/lesson06/ex01/get-latest-user";
						}					
					
						
					}
					, complete:function(data) { // data : 응답 값
						// 성공이든 실패든 무조건 호출됨 => 안 씀~!~!!~!~!~!~!~!!
					}
					
					, error:function(request, status, error) {
						// 에러일 때 수행됨 (400, 500...)
						alert("추가에 실패했습니다. 관리자에게 문의해주세요.")
					}
					
					
				});
				
				
				
			});
			
			
		});
	
	
	
	</script>
	
	
</body>
</html>