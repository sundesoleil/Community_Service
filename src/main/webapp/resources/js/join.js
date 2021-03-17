$(function(){
	let dupCheck = false; //중복 검사 결과 저장
	
	$("#join_btn").click(function(){
		if(dupCheck == false){
			alert("아이디 중복 여부를 확인해주세요");
			return;
		}
		if($("#user_id").val() == ""){
			alert("아이디를 입력해주세요");
			return;
		}
		if($("#user_id").val().length < 4){
				alert("아이디는 4글자 이상 입력해주세요");
				return;
		}
		if($("#user_email").val() == ""){
			alert("이메일을 입력해주세요");
			return;
		}
		if($("#user_pwd").val() == ""){
			alert("비밀번호를 입력해주세요");
			return;
		}
		else{
			if($("#user_pwd").val() != $("#user_pwd_confirm").val()){
				alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
				return;
			}
		}
		
		let userdata = {
		  "ui_id":$("#user_id").val(),
		  "ui_pwd":$("#user_pwd").val(),
		  "ui_name":$("#user_name").val(),
		  "ui_email":$("#user_email").val(),
		  "ui_blog":$("#user_blog").val(),
		  "ui_profile_img":$("#user_profile_img").val(),
		  "ui_introduce":$("#user_introduce").val(),
		  "ui_ip":$("#user_ip").val()
		}
		
		// 서버로 데이터 전송
		$.ajax({
			url:"/api/useradd",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(userdata),
			success:function(data){
				console.log(data);
				alert("가입되었습니다")
			},
			error:function(data){
				alert("에러");
			}
			
		})
		
	});
	$("#id_dup_chk").click(function(){
			if($("#user_id").val() == ""){
			alert("아이디를 입력해주세요");
			return;
			}
			if($("#user_id").val().length < 4){
				alert("아이디는 4글자 이상 입력해주세요");
				return;
			}
			let data = {
				ui_id:$("#user_id").val()	
			};
			
			$.ajax({
			url:"/api/userchk",
			type:"post",
			contentType:"application/json",
			resultType:"json",
			data:JSON.stringify(data), // 객체를 JSON 문자열 형태로 변환
			success:function(data){
				console.log(data);
				dupCheck = !data.result;
				if(data.result == true){
					$(".err_msg").html($("#user_id").val() + " 은/는 이미 가입된 아이디입니다.");
					$(".err_msg").addClass("err").removeClass("ok");
				}
				else{
					$(".err_msg").html($("#user_id").val() + " 은/는 가입할 수 있는 아이디입니다.");
					$(".err_msg").addClass("ok").removeClass("err");
				}
			},
			error:function(data){
				alert("에러발생");
				conosole.log(data);
			}
		})
	})
	
	$("#user_id").keyup(function(){
		$(".err_msg").html("");
		dupCheck = false;
	})
})