package com.joya.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.joya.article.domain.Article;
import com.joya.common.web.Params;

import kr.or.kosta.blog.common.exception.EMSException;

public class JdbcArticleDao implements ArticleDao {
	
	private DataSource dataSource;
	
	public JdbcArticleDao() {}
	
	public JdbcArticleDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/** 글 등록 */
	@Override
	public void create(Article article) {
		
		String sql = "INSERT INTO articles \r\n" + 
				"            (article_id, \r\n" + 
				"             email, \r\n" + 
				"             board_id, \r\n" + 
				"             title, \r\n" + 
				"             contents, \r\n" + 
				"             writer, \r\n" + 
				"             passwd, \r\n" + 
				"             group_no, \r\n" + 
				"             type, \r\n" + 
				"             file_path) \r\n" + 
				"VALUES      (articles_seq.nextval, \r\n" + 
				"             ?, \r\n" + 
				"             2, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             (SELECT NAME \r\n" + 
				"              FROM   users \r\n" + 
				"              WHERE  email = ?), \r\n" + 
				"             ?, \r\n" + 
				"             articles_seq.currval, \r\n" + 
				"             0, \r\n" + 
				"             ?) ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getEmail());
			pstmt.setString(2, article.getTitle());
			pstmt.setString(3, article.getContents());
			pstmt.setString(4, article.getEmail());
			pstmt.setString(5, article.getPasswd());
			pstmt.setString(6, article.getFilePath());
			pstmt.executeQuery();
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if(pstmt != null)pstmt.close();
				if(con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}
	
	/** 상품평 등록 */
	@Override
	public void review(Article article) {
		// TODO Auto-generated method stub
		
	}

	/** 전체 글 목록 */
	@Override
	public List<Article> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/** 게시글 상세보기 */
	@Override
	public Article read(int articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 글 수정 */
	@Override
	public void edit(Article article) {
		// TODO Auto-generated method stub

	}

	/** 글 삭제 */
	@Override
	public void delete(Article article) {
		// TODO Auto-generated method stub

	}

	/** 답글등록(관리자) */
	@Override
	public void reply(Article article) {
		// TODO Auto-generated method stub

	}

	/** 게시글 조회수 증가 */
	@Override
	public void count(int articleId) {
		// TODO Auto-generated method stub

	}

	/** 선택페이지, 검색유형, 검색값, 한페이지당 출력 행수에 대한 글목록 반환 */
	@Override
	public List<Article> listByParams(Params params) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 출력페이지 계산을 위한 검색유형, 검색값에 대한 행의 수 반환 */
	@Override
	public int pageCount(Params params) {
		// TODO Auto-generated method stub
		return 0;
	}



}
