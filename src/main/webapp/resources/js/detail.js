// detail.js
$(function(){
	$.ajax({
		url:"/api/patchPostCnt?post_seq="+ $("#pi_seq").html(),
		type:"patch",
		succes:function(data){
			console.log(data);
		},
		error:function(){
			alert("에러");
		}
	})
	
	$("#comment_input_btn").click(function(){
		if($("#comment_content").val() == ""){
			alert("댓글 내용을 입력하세요");
			return;
		}
		// 서버로 전송
		let data = {
		  "ci_pi_seq":$("#pi_seq").html(),
		  "ci_ui_seq":$(".comment_input").attr("data-user-seq"),
		  "ci_content":$("#comment_content").val()
		}
		console.log(JSON.stringify(data));
		
		$.ajax({
			url:"/api/add-comment",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(data){
				alert("댓글이 등록되었습니다")
				location.reload(); // 댓글 등록시 새로 고침
				$("#comment_content").val(""); 
	
			},
			error:function(data){
				alert("댓글등록에 실패하였습니다")
			}
		})
	})
	
	let offset = 0;
	let total = 0;
	getComments();

	function getComments(){
		let data = {
			board_seq:$("#pi_seq").html(), // post_seq(글번호)로 변수 이름 변경 필요
			offset:offset
		}
		
		$.ajax({
			url:"/api/comments",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(data){
				total = data.count;
				$("#total_comments").html(total);
				$(".comment_cnt").html("("+total+")");
				if(total <= 10){
					$("#more_btn").css("display", "none");
				}
				for(let i=0; i < data.data.length; i++){
					let template = null;
					if(data.data[i].ci_ui_seq == $(".likes_area").attr("data-user-seq") || userRole == 1)
					template = 
						'<div class="comment" data-comment-seq="'+data.data[i].ci_seq+'">'+
							'<div>'+
								'<span>' + data.data[i].ui_name + '</span><span>' + makeDate(data.data[i].ci_reg_dt) + '</span>' +
								'<div class="likes">' +
									'<span class="like_cnt">' + 
										'<button id="like_btn" class="like_btn" data-value="1"><i class="far fa-thumbs-up"></i>' + data.data[i].ci_like + '</button>' +
									'</span>' +
									'<span class="dislike_cnt">'+
										'<button id="dislike_btn" class="dislike_btn" data-value="0"><i class="far fa-thumbs-down"></i>' + data.data[i].ci_dislike + '</button>' +
									'</span>' + 
									'<span>'+
										'<button class="comment_delete"><i class="far fa-trash-alt"></i></button>' +
									'</span>' +
								'</div>' +
							'</div>' +
							'<p>' + data.data[i].ci_content + '</p>' +
						'</div>';
					else
					template = 
						'<div class="comment" data-comment-seq="'+data.data[i].ci_seq+'">'+
							'<div>'+
								'<span>' + data.data[i].ui_name + '</span><span>' + makeDate(data.data[i].ci_reg_dt) + '</span>' +
								'<div class="likes">' +
									'<span class="like_cnt">' + 
										'<button id="like_btn" class="like_btn" data-value="1"><i class="far fa-thumbs-up"></i>' + data.data[i].ci_like + '</button>' +
									'</span>' +
									'<span class="dislike_cnt">'+
										'<button id="dislike_btn" class="dislike_btn" data-value="0"><i class="far fa-thumbs-down"></i>' + data.data[i].ci_dislike + '</button>' +
									'</span>' + 
								'</div>' +
							'</div>' +
							'<p>' + data.data[i].ci_content + '</p>' +
						'</div>';
					
						
					$(".comment_list").append(template);
					
					// 반복문 내부에서 처리 let template 첫 번째 div에 id="comment'+i+'"
/*					$("#comment" + i + "button").click(function(){
						let data = {
							post_seq: $("#comment"+i).attr("data-comment-seq"),
							user_seq:$(".likes_area").attr("data-user-seq"),
							good_bad:$(this).attr("data-value")
						}
						console.log(data);
						console.log(JSON.stringify(data));
					})*/
				}
			
					// 반복문 외부에서 처리
					$(".like_btn, .dislike_btn").click(function(){
					
					let data = {
						post_seq:$(this).parent().parent().parent().parent().attr("data-comment-seq"),
						user_seq:$(".likes_area").attr("data-user-seq"),
						good_bad:$(this).attr("data-value"),
					}
					/*console.log(data);
					console.log(JSON.stringify(data));*/
					
					$.ajax({
						url:"/api/comment_likes",
						type:"post",
						contentType:"application/json",
						data:JSON.stringify(data),
						success:function(data){
							alert(data.message)
							offset = 0;
							location.reload();
						},
						error:function(){
							alert("에러");
						}
					})
				})
				// 댓글삭제
				$(".comment_delete").click(function(){
					if(confirm("댓글을 삭제하시겠습니까?") == false) return;
					let seq = $(this).parent().parent().parent().parent().attr("data-comment-seq");
					$.ajax({
						url:"/api/delete_comment?seq="+seq,
						type:"delete",
						success:function(data){
							alert(data.message);
							location.reload();
						},
						error:function(){
							alert("에러");
						}				
					})
				})
			},
			error:function(data){
				alert("에러")
			}
		})
	}
	
	function makeDate(dt){
		let date = new Date(dt);
		let formatted = "";
		formatted = 
			date.getFullYear() + "-" + 
			leadingZero((date.getMonth()+1)) + "-" + 
			leadingZero(date.getDate()) + " " + 
			leadingZero(date.getHours()) + ":" + 
			leadingZero(date.getMinutes());
		return formatted;
	}
	
	
	function leadingZero(n){
		return n < 10 ? "0" + n : n;
	}
	
	$("#more_btn").click(function(){
		offset += 10; //offset은 데이터의 시작 위치
		getComments();
		console.log(offset,total);
		if(offset + 10 >= total){
			$("#more_btn").css("display", "none");
		}
	})
	

	$("#post_delete").click(function(e){
		// 기본 기능 제거 (링크 이동 삭제)
		e.preventDefault();
		if(confirm("삭제하시겠습니까?")){
			$.ajax({
				url:"/api/deletePost?seq="+$("#pi_seq").html(),
				method:"delete",
				success:function(){
					alert("삭제되었습니다.");
					history.back();
				},
				error:function(){
					alert("에러")
				}
			})
		}
	})
	
	$("#post_like_btn, #post_dislike_btn").click(function(){
		let data = {
			post_seq:$("#pi_seq").html(),
			user_seq:$(".likes_area").attr("data-user-seq"),
			good_bad:$(this).attr("data-value")
		}	
		$.ajax({
			url:"/api/likes",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(data){
				alert(data.message);
				location.reload();
			},
			error:function(){
				alert("에러");
			}
		})
	})
})