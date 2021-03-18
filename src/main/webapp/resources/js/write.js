$(function(){
	$("#post_save").click(function(){
		if($("#post_title").val() == ''){
			alert("제목을 입력해주세요");
			return;
		}
		if($("#post_content").val() == ''){
			alert("내용을 입력해주세요");
			return;
		}
		// 데이터 전송
		let data = {
		  "board_seq":boardseq,
		  "user_seq":$(".title_area").attr("data-user-seq"),
		  "post_title":$("#post_title").val(),
		  "post_content":$("#post_content").val(),
		  "post_ip":"127.0.0.1"
		}
		console.log(JSON.stringify(data));
		 
		$.ajax({
			url:"/api/write",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(data){
				alert("글이 등록되었습니다")
				history.back();
				$("#post_content").val(""); 
	
			},
			error:function(data){
				alert("글 등록에 실패하였습니다")
			}
	});
	})
		$("#post_cancel").click(function(){
			if(confirm("취소하시겠습니까?")){
			history.back();
			}
		})
	
})