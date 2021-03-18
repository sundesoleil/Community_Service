package com.greenart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.greenart.dao.BoardDao;
import com.greenart.vo.CategoryVO;
import com.greenart.vo.CommentReqVO;
import com.greenart.vo.CommentVO;
import com.greenart.vo.GoodBadVO;
import com.greenart.vo.PostRegistVO;
import com.greenart.vo.PostVO;

@Service
@Configurable
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;
	
	@Override
	public List<CategoryVO> getCategoryList(){
		return dao.getCategoryList();
	}
	
	@Override
	public List<PostVO> getPostList(Integer offset, Integer board) {
		List<PostVO> postList = dao.getPostList(offset, board);
		postList.forEach(post -> {
			Integer seq = post.getPi_seq();
			CommentReqVO vo = new CommentReqVO();
			vo.setBoard_seq(seq);
			Integer commentCnt = dao.selectCommentCount(vo);
			if(commentCnt > 0) {
				post.setPi_title(post.getPi_title()+" ("+commentCnt+")");
			}
		});
		
		return postList;
	}
	
	@Override
	public PostVO getPostBySeq(Integer no) {
		return dao.getPostBySeq(no);
	}
	
	@Override
	public void addComment(CommentVO vo) {
		dao.addComment(vo);
	}
	
	@Override
	public List<CommentVO> selectComment(CommentReqVO vo) {
		return dao.selectComment(vo);
	}
	
	@Override
	public Integer selectCommentCount(CommentReqVO vo) {
		return dao.selectCommentCount(vo);
	}
	
	@Override
	public void updatePostCount(Integer seq) {
		dao.updatePostCount(seq);
	}
	
	@Override
	public void insertPost(PostRegistVO vo) {
		dao.insertPost(vo);
	}
	
	@Override
	public void deletePost(Integer seq) {
		dao.deletePost(seq);
	}
	
	@Override
	public void modifyPost(PostVO vo) {
		dao.modifyPost(vo);
	}
	@Override
	public Integer getBoardPostCount(Integer board_seq) {
		return dao.getBoardPostCount(board_seq);
	}
	
	@Override
	public void insertPostGoodBad(GoodBadVO vo) {
		dao.insertPostGoodBad(vo);
	}
	
	@Override
	public GoodBadVO selectPostGoodBad(GoodBadVO vo) {
		return dao.selectPostGoodBad(vo);
	}
	@Override
	public void updatePostGoodBad(GoodBadVO vo) {
		dao.updatePostGoodBad(vo);
	}
	
	@Override
	public List<Integer> selectPostLikesCount(Integer seq) {
		return dao.selectPostLikesCount(seq);
	}
	@Override
	public void insertCommentGoodBad(GoodBadVO vo) {
		dao.insertCommentGoodBad(vo);
	}
	@Override
	public GoodBadVO selectCommentGoodBad(GoodBadVO vo) {
		return dao.selectCommentGoodBad(vo);
	}
	@Override
	public void updateCommentGoodBad(GoodBadVO vo) {
		dao.updateCommentGoodBad(vo);
	}
	@Override
	public List<Integer> selectCommentLikesCount(Integer seq) {
		return dao.selectCommentLikesCount(seq);
	}
	@Override
	public void deleteComment(Integer seq) {
		dao.deleteComment(seq);
	}
	@Override
	public PostVO getStockBySeq(Integer no) {
		return dao.getStockBySeq(no);
	}
	@Override
	public PostVO getQNABySeq(Integer no) {
		return dao.getQNABySeq(no);
	}
	@Override
	public PostVO getReportBySeq(Integer no) {
		return dao.getReportBySeq(no);
	}
	@Override
	public PostVO getCarBySeq(Integer no) {
		return dao.getCarBySeq(no);
	}
	@Override
	public PostVO getItBySeq(Integer no) {
		return dao.getItBySeq(no);
	}
	@Override
	public PostVO getItReviewBySeq(Integer no) {
		return dao.getItReviewBySeq(no);
	}
}
