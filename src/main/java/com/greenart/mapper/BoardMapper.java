package com.greenart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.vo.CategoryVO;
import com.greenart.vo.CommentReqVO;
import com.greenart.vo.CommentVO;
import com.greenart.vo.GoodBadVO;
import com.greenart.vo.PostRegistVO;
import com.greenart.vo.PostVO;

@Mapper
public interface BoardMapper {
	public List<CategoryVO> getCategoryList();
	public List<PostVO> getPostList(Integer offset, Integer board); // limit offset 활용 위함
	public PostVO getPostBySeq(Integer no);
	public void addComment(CommentVO vo);
	public List<CommentVO> selectComment(CommentReqVO vo);
	public Integer selectCommentCount(CommentReqVO vo);
	public void updatePostCount(Integer seq);
	public void insertPost(PostRegistVO vo);
	public void deletePost(Integer seq);
	public void modifyPost(PostVO vo);
	public Integer getBoardPostCount(Integer board_seq);
	
	public void insertPostGoodBad(GoodBadVO vo);
	public GoodBadVO selectPostGoodBad(GoodBadVO vo);
	public void updatePostGoodBad(GoodBadVO vo);
	public List<Integer> selectPostLikesCount(Integer seq);
	
	public void insertCommentGoodBad(GoodBadVO vo);
	public GoodBadVO selectCommentGoodBad(GoodBadVO vo);
	public void updateCommentGoodBad(GoodBadVO vo);
	public List<Integer> selectCommentLikesCount(Integer seq);
	
	public void deleteComment(Integer seq);
}
