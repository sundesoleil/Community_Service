package com.greenart.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.greenart.mapper.BoardMapper;
import com.greenart.vo.CategoryVO;
import com.greenart.vo.CommentReqVO;
import com.greenart.vo.CommentVO;
import com.greenart.vo.GoodBadVO;
import com.greenart.vo.PostRegistVO;
import com.greenart.vo.PostVO;

@Repository
@Primary
public class BoardDaoImpl implements BoardDao{
	@Autowired
	BoardMapper mapper;
	
	@Override
	public List<CategoryVO> getCategoryList() {
		return mapper.getCategoryList();
	}
	
	@Override
	public List<PostVO> getPostList(Integer offset, Integer board, String keyword, String type) {
		return mapper.getPostList(offset, board, keyword, type);
	}
	
	@Override
	public PostVO getPostBySeq(Integer no) {
		return mapper.getPostBySeq(no);
	}
	
	@Override
	public void addComment(CommentVO vo) {
		mapper.addComment(vo);
	}

	
	@Override
	public List<CommentVO> selectComment(CommentReqVO vo) {
		return mapper.selectComment(vo);
	}
	
	@Override
	public Integer selectCommentCount(CommentReqVO vo) {
		return mapper.selectCommentCount(vo);
	}	
	@Override
	public void updatePostCount(Integer seq) {
		mapper.updatePostCount(seq);
	}
	
	@Override
	public void insertPost(PostRegistVO vo) {
		mapper.insertPost(vo);
	}
	@Override
	public void deletePost(Integer seq) {
		mapper.deletePost(seq);
	}
	
	@Override
	public void modifyPost(PostVO vo) {
		mapper.modifyPost(vo);
	}
	@Override
	public Integer getBoardPostCount(Integer board_seq, String keyword, String type) {
		return mapper.getBoardPostCount(board_seq, keyword, type);
	}
	
	@Override
	public void insertPostGoodBad(GoodBadVO vo) {
		mapper.insertPostGoodBad(vo);
	}
	
	@Override
	public GoodBadVO selectPostGoodBad(GoodBadVO vo) {
		return mapper.selectPostGoodBad(vo);
	}
	
	@Override
	public void updatePostGoodBad(GoodBadVO vo) {
		mapper.updatePostGoodBad(vo);
	}
	
	@Override
	public List<Integer> selectPostLikesCount(Integer seq) {
		return mapper.selectPostLikesCount(seq);
	}
	
	@Override
	public void insertCommentGoodBad(GoodBadVO vo) {
		mapper.insertCommentGoodBad(vo);
	}
	@Override
	public GoodBadVO selectCommentGoodBad(GoodBadVO vo) {
		return mapper.selectCommentGoodBad(vo);
	}
	@Override
	public void updateCommentGoodBad(GoodBadVO vo) {
		mapper.updateCommentGoodBad(vo);
	}
	@Override
	public List<Integer> selectCommentLikesCount(Integer seq) {
		return mapper.selectCommentLikesCount(seq);
	}
	@Override
	public void deleteComment(Integer seq) {
		mapper.deleteComment(seq);
	}

	@Override
	public PostVO getStockBySeq(Integer no) {
		return mapper.getStockBySeq(no);
	}
	@Override
	public PostVO getQNABySeq(Integer no) {
		return mapper.getQNABySeq(no);
	}
	@Override
	public PostVO getReportBySeq(Integer no) {
		return mapper.getReportBySeq(no);
	}
	@Override
	public PostVO getCarBySeq(Integer no) {
		return mapper.getCarBySeq(no);
	}
	@Override
	public PostVO getItBySeq(Integer no) {
		return mapper.getItBySeq(no);
	}
	@Override
	public PostVO getItReviewBySeq(Integer no) {
		return mapper.getItReviewBySeq(no);
	}
}