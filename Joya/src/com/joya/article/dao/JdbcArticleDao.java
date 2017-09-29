package com.joya.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.joya.article.domain.Article;
import com.joya.common.db.DaoFactory;
import com.joya.common.web.Params;


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
				"             ?, \r\n" + 
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
			pstmt.setString(4, article.getWriter());
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
	
	/** 상품평, A/S게시판 글 등록 */
	@Override
	public void review(Article article) {
		String sql="";
		
	}

	/** 전체 글 목록 */
	@Override
	public List<Article> listAll() {
		List<Article> list = new ArrayList<Article>();
		String sql="SELECT article_id, \r\n" + 
				"       email, \r\n" + 
				"       board_id, \r\n" + 
				"       title, \r\n" + 
				"       contents, \r\n" + 
				"       writer, \r\n" + 
				"       regdate, \r\n" + 
				"       passwd, \r\n" + 
				"       group_no, \r\n" + 
				"       type, \r\n" + 
				"       hitcount, \r\n" + 
				"       file_path, \r\n" + 
				"       product_id \r\n" + 
				"FROM   articles \r\n" + 
				"WHERE  board_id = 2 \r\n" + 
				"ORDER  BY group_no DESC ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			//pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Article article = createArticle(rs);
				list.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}

	/** 게시글 상세보기 */
	@Override
	public Article read(int articleId) {
		
		String sql = "SELECT article_id, \r\n" + 
				"       email, \r\n" + 
				"       board_id, \r\n" + 
				"       title, \r\n" + 
				"       contents, \r\n" + 
				"       writer, \r\n" + 
				"       regdate, \r\n" + 
				"       passwd, \r\n" + 
				"       group_no, \r\n" + 
				"       type, \r\n" + 
				"       hitcount, \r\n" + 
				"       file_path, \r\n" + 
				"       product_id \r\n" + 
				"FROM   articles \r\n" + 
				"WHERE  board_id = 2 \r\n" + 
				"       AND article_id = ?";
		
		Article article = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con = dataSource.getConnection();
		
		
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
	public void reply(int articleId, Article article) {
		String sql="INSERT INTO articles \r\n" + 
				"            (article_id, \r\n" + 
				"             email, \r\n" + 
				"             board_id, \r\n" + 
				"             title, \r\n" + 
				"             contents, \r\n" + 
				"             writer, \r\n" + 
				"             passwd, \r\n" + 
				"             group_no, \r\n" + 
				"             type) \r\n" + 
				"VALUES      (articles_seq.nextval, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             1)";

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getEmail());
			pstmt.setInt(2, article.getBoardId());
			pstmt.setString(3, article.getTitle());
			pstmt.setString(4, article.getContents());
			pstmt.setString(5, article.getWriter());
			pstmt.setString(6, article.getPasswd());
			pstmt.setInt(7, articleId);
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
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
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

	
	/** CreateArticle 
	 * @throws SQLException */
	public Article createArticle(ResultSet rs) throws SQLException {
		int articleId = rs.getInt("article_id");
		String email = rs.getString("email");
		int boardId = rs.getInt("board_id");
		String title = rs.getString("title");
		String contents = rs.getString("contents");
		String writer = rs.getString("writer");
		String regdate = rs.getString("regdate");
		String passwd = rs.getString("passwd");
		int groupNo = rs.getInt("group_no");
		int type = rs.getInt("type");
		int hitcount = rs.getInt("hitcount");
		String filePath = rs.getString("file_path");
		int productId = rs.getInt("product_id");
		
		Article article = new Article();
		article.setArticleId(articleId);
		article.setEmail(email);
		article.setBoardId(boardId);
		article.setTitle(title);
		article.setContents(contents);
		article.setWriter(writer);
		article.setRegdate(regdate);
		article.setPasswd(passwd);
		article.setGroupNo(groupNo);
		article.setType(type);
		article.setHitcount(hitcount);
		article.setFilePath(filePath);
		article.setProductId(productId);
		
		return article;
	}
	
	public static void main(String[] args) {
		
		ArticleDao dao = (ArticleDao) DaoFactory.getInstance().getDao(JdbcArticleDao.class);
		/**
		Article article = new Article();
		
		article.setEmail("joa@joa");
		article.setTitle("질문");
		article.setContents("목걸이 재입고 언제되나요?");
		article.setPasswd("1111");
		dao.create(article);
		System.out.println(article.toString());
		
		
		article.setEmail("admin@joa");
		article.setBoardId(2);
		article.setTitle("답변");
		article.setContents("답변내용");
		article.setWriter("관리자");
		article.setPasswd("admin");
		dao.reply(8, article);
		System.out.println(article.toString());
		*/
		List<Article> list = dao.listAll();
		for (Article article : list) {
			System.out.println(article);
		}
		
	}
	

}
