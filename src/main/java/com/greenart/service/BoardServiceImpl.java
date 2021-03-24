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
	public List<PostVO> getPostList(Integer offset, Integer board, String keyword, String type) {
		List<PostVO> postList = dao.getPostList(offset, board, keyword, type);
		postList.forEach(post -> {
			Integer seq = post.getPi_seq();
			CommentReqVO vo = new CommentReqVO();
			vo.setBoard_seq(seq);
			Integer commentCnt = dao.selectCommentCount(vo);
			if(commentCnt > 0) {
				post.setPi_title(post.getPi_title()+" ("+commentCnt+")");
			}
		});
		
		Integer total = this.getBoardPostCount(board, "%%", null);
		for(int i =0; i<postList.size(); i++) {
			postList.get(i).setNo(total-i-offset);
		}
		
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
	public Integer getBoardPostCount(
			Integer board_seq, String keyword, String type) {
		return dao.getBoardPostCount(board_seq, keyword, type);
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
	@Override
	public List<PostVO> selectPostByUserId(Integer user_seq) {
		/*board 이름을 sql에서 가져오지 않았을 때의 처리
		List<PostVO> list = dao.selectPostByUserId(user_seq);
		list.forEach(post -> {
			String board_name = "";
			switch(post.getPi_board_seq()) {
			case 1:
				board_name = "공지사항";
				break;
			case 2:
				board_name = "문의";
				break;
			case 3:
				board_name = "문제신고";
				break;
			case 5:
				board_name = "주식";
				break;
			case 6:
				board_name = "자동차";
				break;
			case 7:
				board_name = "IT";
				break;
			case 8:
				board_name = "사용기";
				break;
			default:
				board_name = "-";
			}
			post.setBi_name(board_name);
		});
		return list;*/
		return dao.selectPostByUserId(user_seq);
	}
}
