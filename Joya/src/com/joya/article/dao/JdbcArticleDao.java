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

	public JdbcArticleDao() {
	}

	public JdbcArticleDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/** 공지사항, QnA, A/S, 상품평 게시글 등록 */
	public void create(Article article, String articleType) {
		StringBuilder sb = new StringBuilder();

		String productId = Integer.toString(article.getProductId());

		sb.append("INSERT INTO articles ");
		sb.append("            (article_id,");
		sb.append("             email, ");
		sb.append("             board_id, ");
		sb.append("             title, ");
		sb.append("             contents, ");
		sb.append("             writer, ");
		sb.append("             passwd, ");
		sb.append("             group_no, ");
		sb.append("             type, ");

		if (productId != null) {

			sb.append("             file_path, ");
			sb.append(" 			  product_id) ");
			sb.append(" VALUES      (articles_seq.nextval, ");
			sb.append(" ?, "); // email

			/** 게시판 종류 */
			if (articleType != null) { // board_id
				switch (articleType) {
				case "notice":
					sb.append("1, "); // 공지사항
					break;
				case "qna":
					sb.append("2, "); // QnA
					break;
				case "review":
					sb.append("3, "); // 상품평
					break;
				case "as":
					sb.append("4, "); // A/S
					break;
				}
			}

			sb.append("?, "); // title
			sb.append("?, "); // contents
			sb.append("?, "); // writer
			sb.append("?, "); // passwd
			sb.append("articles_seq.currval, ");

			if (articleType == "notice") {
				sb.append("1, ");
			} else {
				sb.append("0, ");
			}

			sb.append("?, "); // filePath
			sb.append("?) "); // product_id

		} else {

			sb.append("             file_path) ");
			sb.append(" VALUES      (articles_seq.nextval, ");
			sb.append(" ?, "); // email

			
			if (articleType != null) { // board_id
				switch (articleType) {
				case "notice":
					sb.append("1, "); // 공지사항
					break;
				case "qna":
					sb.append("2, "); // QnA
					break;
				case "review":
					sb.append("3, "); // 상품평
					break;
				case "as":
					sb.append("4, "); // A/S
					break;
				}
			}

			sb.append("?, "); // title
			sb.append("?, "); // contents
			sb.append("?, "); // writer
			sb.append("?, "); // passwd
			sb.append("articles_seq.currval, ");

			if (articleType == "notice") {
				sb.append("1, ");
			} else {
				sb.append("0, ");
			}

			sb.append("?) "); // filePath

		}

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, article.getEmail());
			pstmt.setString(2, article.getTitle());
			pstmt.setString(3, article.getContents());
			pstmt.setString(4, article.getWriter());
			pstmt.setString(5, article.getPasswd());
			pstmt.setString(6, article.getFilePath());
			pstmt.setInt(7, article.getProductId());

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
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/** 전체 글 목록 */
	@Override
	public List<Article> listAll() {
		List<Article> list = new ArrayList<Article>();
		String sql = "SELECT article_id, \r\n" + "       email, \r\n" + "       board_id, \r\n" + "       title, \r\n"
				+ "       contents, \r\n" + "       writer, \r\n" + "       regdate, \r\n" + "       passwd, \r\n"
				+ "       group_no, \r\n" + "       type, \r\n" + "       hitcount, \r\n" + "       file_path, \r\n"
				+ "       product_id \r\n" + "FROM   articles \r\n" + "WHERE  board_id = 2 \r\n"
				+ "ORDER  BY group_no DESC ";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Article article = createArticle(rs);
				list.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list;
	}

	/** 게시글 상세보기 */
	@Override
	public Article read(int articleId) {
		String sql = "SELECT article_id, \r\n" + "       email, \r\n" + "       board_id, \r\n" + "       title, \r\n"
				+ "       contents, \r\n" + "       writer, \r\n" + "       regdate, \r\n" + "       passwd, \r\n"
				+ "       group_no, \r\n" + "       type, \r\n" + "       hitcount, \r\n" + "       file_path, \r\n"
				+ "       product_id \r\n" + "FROM   articles \r\n" + "WHERE  article_id = ?";

		Article article = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				article = createArticle(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return article;
	}

	/** 글 수정 */
	@Override
	public boolean edit(Article article) {
		boolean result = false;
		String sql = "UPDATE articles \r\n" + "SET    title = ?, \r\n" + "       contents = ?, \r\n"
				+ "       regdate = sysdate, \r\n" + "       passwd = ?, \r\n" + "       file_path = ?, \r\n"
				+ "       product_id = ? \r\n" + "WHERE  article_id = (SELECT article_id \r\n"
				+ "                     FROM   articles \r\n" + "                     WHERE  article_id = ?) ";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContents());
			pstmt.setString(3, article.getPasswd());
			pstmt.setString(4, article.getFilePath());
			pstmt.setInt(5, article.getProductId());
			pstmt.setInt(6, article.getArticleId());

			int flag = pstmt.executeUpdate();
			if (flag > 0) {
				result = true;
				con.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/** 글 삭제 */
	@Override
	public boolean delete(Article article) {
		boolean result = false;
		String sql = "UPDATE articles \r\n" + "SET    title = '삭제된 글입니다.', \r\n" + "       contents = '삭제' \r\n"
				+ "WHERE  article_id = (SELECT article_id \r\n" + "					  FROM   articles \r\n"
				+ "					  WHERE  article_id = ?) ";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getArticleId());

			int flag = pstmt.executeUpdate();
			if (flag > 0) {
				result = true;
				con.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/** 답글등록(관리자) */
	@Override
	public void reply(Article article) {

		String sql = "INSERT INTO articles \r\n" + "            (article_id, \r\n" + "             email, \r\n"
				+ "             board_id, \r\n" + "             title, \r\n" + "             contents, \r\n"
				+ "             writer, \r\n" + "             passwd, \r\n" + "             group_no, \r\n"
				+ "             type) \r\n" + "VALUES      (articles_seq.nextval, \r\n" + "             ?, \r\n"
				+ "             (SELECT board_id \r\n" + "              FROM   articles \r\n"
				+ "              WHERE  article_id = ?), \r\n" + "             ?, \r\n" + "             ?, \r\n"
				+ "             ?, \r\n" + "             ?, \r\n" + "             (SELECT group_no \r\n"
				+ "              FROM   articles \r\n" + "              WHERE  article_id = ?), \r\n"
				+ "             1) ";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getEmail());
			pstmt.setInt(2, article.getArticleId());
			pstmt.setString(3, article.getTitle());
			pstmt.setString(4, article.getContents());
			pstmt.setString(5, article.getWriter());
			pstmt.setString(6, article.getPasswd());
			pstmt.setInt(7, article.getArticleId());
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
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	/** 게시글 조회수 증가 */
	@Override
	public void count(int articleId) {
		String sql = "UPDATE articles \r\n" + "SET    hitcount = hitcount + 1 \r\n" + "WHERE  article_id = ?";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleId);
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
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/** 선택페이지, 검색유형, 검색값, 한페이지당 출력 행수에 대한 글목록 반환 */
	// 1번 공지사항, 2번 Q&A, 3번 상품평, 4번 AS
	@Override
	public List<Article> listByParams(Params params, int boardId) {
		List<Article> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT article_id, ");
		sb.append("       email,");
		sb.append("       board_id,");
		sb.append("       title, ");
		sb.append("       contents,");
		sb.append("       regdate,");
		sb.append("       writer,");
		sb.append("       passwd,");
		sb.append("       group_no,");
		sb.append("       type,");
		sb.append("       hitcount,");
		sb.append("       file_path,");
		sb.append("       product_id ");
		sb.append("FROM   (SELECT Ceil(rownum / ?) request_page, ");
		sb.append("               article_id, ");
		sb.append("               email,");
		sb.append("               board_id,");
		sb.append("               title,");
		sb.append("               contents,");
		sb.append("               regdate,");
		sb.append("               writer,");
		sb.append("               passwd,");
		sb.append("               group_no,");
		sb.append("               type,");
		sb.append("               hitcount,");
		sb.append("               file_path,");
		sb.append("               product_id ");
		sb.append("        FROM   (SELECT article_id,");
		sb.append("                       email,");
		sb.append("                       board_id,");
		sb.append("                       title,");
		sb.append("                       contents,");
		sb.append("                       regdate,");
		sb.append("                       writer,");
		sb.append("                       passwd,");
		sb.append("                       group_no,");
		sb.append("                       type,");
		sb.append("                       hitcount,");
		sb.append("                       file_path,");
		sb.append("                       product_id");
		sb.append("                FROM   articles ");
		sb.append("                WHERE  group_no IN (SELECT group_no ");
		sb.append("                                    FROM   articles ");
		sb.append("                                    WHERE  board_id = ? ");

		String type = params.getType();
		String value = params.getValue();
		if (type != null) {
			switch (params.getType()) {
			case "title":
				sb.append("                                           AND title LIKE ? ");
				value = "%" + value + "%";
				break;
			case "contents":
				sb.append("                                           AND contents LIKE ? ");
				value = "%" + value + "%";
				break;
			case "writer":
				sb.append("                                           AND writer = ? ");
				break;
			}
		}

		sb.append("				    ) ");
		sb.append("                ORDER  BY group_no DESC, ");
		sb.append("                          type ASC)) ");
		sb.append(" WHERE  request_page = ? ");

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, params.getPageSize());
			pstmt.setInt(2, boardId);

			if (type != null) {
				pstmt.setString(3, value);
				pstmt.setInt(4, params.getPage());
			} else {
				pstmt.setInt(3, params.getPage());
			}

			rs = pstmt.executeQuery();
			list = new ArrayList<Article>();

			while (rs.next()) {
				Article article = createArticle(rs);
				list.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	
	@Override
	public List<Article> listByParams(Params params, int boardId, int productid) {
		List<Article> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT article_id, ");
		sb.append("       email,");
		sb.append("       board_id,");
		sb.append("       title, ");
		sb.append("       contents,");
		sb.append("       regdate,");
		sb.append("       writer,");
		sb.append("       passwd,");
		sb.append("       group_no,");
		sb.append("       type,");
		sb.append("       hitcount,");
		sb.append("       file_path,");
		sb.append("       product_id ");
		sb.append("FROM   (SELECT Ceil(rownum / ?) request_page, ");
		sb.append("               article_id, ");
		sb.append("               email,");
		sb.append("               board_id,");
		sb.append("               title,");
		sb.append("               contents,");
		sb.append("               regdate,");
		sb.append("               writer,");
		sb.append("               passwd,");
		sb.append("               group_no,");
		sb.append("               type,");
		sb.append("               hitcount,");
		sb.append("               file_path,");
		sb.append("               product_id ");
		sb.append("        FROM   (SELECT article_id,");
		sb.append("                       email,");
		sb.append("                       board_id,");
		sb.append("                       title,");
		sb.append("                       contents,");
		sb.append("                       regdate,");
		sb.append("                       writer,");
		sb.append("                       passwd,");
		sb.append("                       group_no,");
		sb.append("                       type,");
		sb.append("                       hitcount,");
		sb.append("                       file_path,");
		sb.append("                       product_id");
		sb.append("                FROM   articles ");
		sb.append("                WHERE  product_id IN (SELECT product_id ");
		sb.append("                                    FROM   articles ");
		sb.append("                                    WHERE  board_id = ? and product_id=?)");
		sb.append("                ORDER  BY group_no DESC,  type ASC))");
		sb.append(" WHERE  request_page = ? ");

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, params.getPageSize());
			pstmt.setInt(2, boardId);
			pstmt.setInt(3, productid);
			pstmt.setInt(4, params.getPage());
			
			rs = pstmt.executeQuery();
			list = new ArrayList<Article>();

			while (rs.next()) {
				Article article = createArticle(rs);
				list.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	/** 출력페이지 계산을 위한 검색유형, 검색값에 대한 행의 수 반환 */
	@Override
	public int pageCount(Params params, int boardId) {
		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT Count(article_id) count ");
		sb.append("FROM   articles ");
		sb.append("WHERE  group_no IN (SELECT group_no ");
		sb.append("FROM   articles ");
		sb.append("WHERE  board_id = ? ");

		String type = params.getType();
		String value = params.getValue();
		if (type != null) {
			switch (params.getType()) {
			case "title":
				sb.append("       AND title LIKE ? ");
				value = "%" + value + "%";
				break;
			case "contents":
				sb.append("       AND contents LIKE ? ");
				value = "%" + value + "%";
				break;
			case "writer":
				sb.append("       AND writer = ? ");
				break;
			}
		}
		sb.append("				    ) ");

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, boardId);
			if (type != null) {
				pstmt.setString(2, value);
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	/** Read 메소드 구현시 필요한 CreateArticle */
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
		JdbcArticleDao artdao=(JdbcArticleDao) DaoFactory.getInstance().getDao(JdbcArticleDao.class);
		
		int pageSize = 16;
		int pageNum = 5;
		int pageCount = 1;
		Params param = new Params();
		param.setPage(pageCount);
		param.setPageNum(pageNum);
		param.setPageSize(pageSize);
		System.out.println("[param] : "+param);
		
		List<Article> artlist = artdao.listByParams(param, 3, 1);
		
		for (Article article : artlist) {
			System.out.println(article);
		}
	}

}
