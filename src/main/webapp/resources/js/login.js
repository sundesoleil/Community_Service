
/*$(document).ready(function(){ // jsp 파일 완료 시점에 스크립트 실행
	
})*/

$(function(){
	
	$("#login_btn").click(function(){
		
		let id = $("#user_id").val();
		let pwd = $("#user_pwd").val();
		
		let loginData = {
			id: id,
			pwd: pwd
		}
		
		$.ajax({
			url:"/api/login",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(loginData),
			success:function(data){
				if(data.result == true){
					//location.href="/";
					history.back();
				}
				else{
					alert("아이디 또는 비밀번호 오류입니다");
					}
				},
				error:function(){
					alert("에러!");
				}
			})
		})
			$("#user_pwd").keydown(function(e){
				if(e.keydown == 13){
					$("#login_btn").trigger("click"); // 코드로 login_btn 클릭
				}	
		})
	})
