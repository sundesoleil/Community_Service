package com.greenart.vo;

import java.util.Date;

public class CommentVO {
	private Integer ci_seq;
	private Integer ci_pi_seq;
	private Integer ci_ui_seq;
	private String ci_content;
	private Integer ci_like;
	private Integer ci_dislike;
	private Integer ci_status;
	private Date ci_reg_dt;
	private String ui_name;
	
	
	public Integer getCi_seq() {
		return ci_seq;
	}
	public void setCi_seq(Integer ci_seq) {
		this.ci_seq = ci_seq;
	}
	public Integer getCi_pi_seq() {
		return ci_pi_seq;
	}
	public void setCi_pi_seq(Integer ci_pi_seq) {
		this.ci_pi_seq = ci_pi_seq;
	}
	public Integer getCi_ui_seq() {
		return ci_ui_seq;
	}
	public void setCi_ui_seq(Integer ci_ui_seq) {
		this.ci_ui_seq = ci_ui_seq;
	}
	public String getCi_content() {
		return ci_content;
	}
	public void setCi_content(String ci_content) {
		this.ci_content = ci_content;
	}
	public Integer getCi_like() {
		return ci_like;
	}
	public void setCi_like(Integer ci_like) {
		this.ci_like = ci_like;
	}
	public Integer getCi_dislike() {
		return ci_dislike;
	}
	public void setCi_dislike(Integer ci_dislike) {
		this.ci_dislike = ci_dislike;
	}
	public Integer getCi_status() {
		return ci_status;
	}
	public void setCi_status(Integer ci_status) {
		this.ci_status = ci_status;
	}
	public Date getCi_reg_dt() {
		return ci_reg_dt;
	}
	public void setCi_reg_dt(Date ci_reg_dt) {
		this.ci_reg_dt = ci_reg_dt;
	}
	public String getUi_name() {
		return ui_name;
	}
	public void setUi_name(String ui_name) {
		this.ui_name = ui_name;
	}
	
	

}
