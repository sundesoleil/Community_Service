package com.greenart.vo;

import java.util.Date;

public class PostVO {
	private Integer pi_seq;
	private Integer pi_owner;
	private String pi_title;
	private String pi_content;
	private Date pi_reg_dt;
	private Date pi_mod_dt;
	private String pi_ip;
	private Integer pi_count;
	private Integer pi_like;
	private Integer pi_dislike;
	private Integer pi_status;
	private Integer pi_board_seq;
	private String ui_name;
	private Integer no;
	
	public Integer getPi_seq() {
		return pi_seq;
	}
	public void setPi_seq(Integer pi_seq) {
		this.pi_seq = pi_seq;
	}
	public Integer getPi_owner() {
		return pi_owner;
	}
	public void setPi_owner(Integer pi_owner) {
		this.pi_owner = pi_owner;
	}
	public String getPi_title() {
		return pi_title;
	}
	public void setPi_title(String pi_title) {
		this.pi_title = pi_title;
	}
	public String getPi_content() {
		return pi_content;
	}
	public void setPi_content(String pi_content) {
		this.pi_content = pi_content;
	}
	public Date getPi_reg_dt() {
		return pi_reg_dt;
	}
	public void setPi_reg_dt(Date pi_reg_dt) {
		this.pi_reg_dt = pi_reg_dt;
	}
	public Date getPi_mod_dt() {
		return pi_mod_dt;
	}
	public void setPi_mod_dt(Date pi_mod_dt) {
		this.pi_mod_dt = pi_mod_dt;
	}
	public String getPi_ip() {
		return pi_ip;
	}
	public void setPi_ip(String pi_ip) {
		this.pi_ip = pi_ip;
	}
	public Integer getPi_count() {
		return pi_count;
	}
	public void setPi_count(Integer pi_count) {
		this.pi_count = pi_count;
	}
	public Integer getPi_like() {
		return pi_like;
	}
	public void setPi_like(Integer pi_like) {
		this.pi_like = pi_like;
	}
	public Integer getPi_dislike() {
		return pi_dislike;
	}
	public void setPi_dislike(Integer pi_dislike) {
		this.pi_dislike = pi_dislike;
	}
	public Integer getPi_status() {
		return pi_status;
	}
	public void setPi_status(Integer pi_status) {
		this.pi_status = pi_status;
	}
	public Integer getPi_board_seq() {
		return pi_board_seq;
	}
	public void setPi_board_seq(Integer pi_board_seq) {
		this.pi_board_seq = pi_board_seq;
	}
	public String getUi_name() {
		return ui_name;
	}
	public void setUi_name(String ui_name) {
		this.ui_name = ui_name;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	
}
