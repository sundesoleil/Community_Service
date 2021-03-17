// resources/js/menu.js

$(function(){
	let rootmenu = new Array();
	let submenu = new Array();
	$.ajax({
		url:"/api/category",
		type:"get",
		success:function(data){
			console.log(data);
			rootmenu = data.filter(menu => menu.bi_parent_seq == null);
			submenu = data.filter(menu => menu.bi_parent_seq != null);

			rootmenu.forEach(menu => {
				let template = 
				'<li id="rootmenu'+ menu.bi_seq + '"><a href="'+ menu.bi_url + '">' + menu.bi_name + '</a><ul></ul></li>';
				$("#gnb>ul").append(template);
			})
			
			submenu.forEach(menu =>{
				let template =
				'<li><a href="'+ menu.bi_url + '">' + menu.bi_name + '</a></li>';
				let selector = "#rootmenu" + menu.bi_parent_seq +">ul";
				$(selector).append(template);
			})
		
		},
		error:function(){
			alert("에러");
		}
	})
})