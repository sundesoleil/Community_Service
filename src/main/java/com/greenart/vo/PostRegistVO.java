package com.greenart.vo;

public class PostRegistVO { /*글 등록시에만 사용*/
	private Integer board_seq;
	private Integer user_seq;
	private String post_title;
	private String post_content;
	private String post_ip;
	
	public Integer getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(Integer board_seq) {
		this.board_seq = board_seq;
	}
	public Integer getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(Integer user_seq) {
		this.user_seq = user_seq;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public String getPost_ip() {
		return post_ip;
	}
	public void setPost_ip(String post_ip) {
		this.post_ip = post_ip;
	}	
	
}
