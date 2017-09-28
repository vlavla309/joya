package com.joya.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.joya.common.db.DaoFactory;
import com.joya.common.exception.MallException;
import com.joya.common.web.Params;
import com.joya.product.domain.Product;


public class JdbcProductDao implements ProductDao{

	private DataSource dataSource;

	public JdbcProductDao() {}

	public JdbcProductDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> listByParams(Params params, String categoryName, String orderType) {

		String type = params.getType();
		String value = params.getValue();

		List<Product> list = null;		

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT product_id,");
		sb.append("        product_name,");
		sb.append("        category_name,");
		sb.append("        maker,");
		sb.append("        product_desc,");
		sb.append("        regdate,");
		sb.append("        price,");
		sb.append("        amount,");
		sb.append("        hitcount");
		sb.append(" FROM   (SELECT CEIL(rownum / ?) request_page,");
		sb.append("       	 	product_id,");
		sb.append("       	 	product_name,");
		sb.append("       		category_name,");
		sb.append("       		maker,");
		sb.append("       		product_desc,");
		sb.append("        		regdate,");
		sb.append("        		price,");
		sb.append("        		amount,");
		sb.append("        		hitcount");
		sb.append("         FROM   (SELECT product_id,");
		sb.append("       	 			product_name,");
		sb.append("       				category_name,");
		sb.append("       				maker,");
		sb.append("       				product_desc,");
		sb.append("                     TO_CHAR(regdate, 'YYYY/MM/DD HH24:MI:SS') regdate,");
		sb.append("        				price,");
		sb.append("        				amount,");
		sb.append("        				hitcount");
		sb.append("                 	FROM   products ");
		sb.append(" 					where category_name = ?");
		sb.append(" 					or category_name in (select category_name from categories where parent=?)");
		if(type!=null) {
			sb.append(" and  product_name LIKE ?");
		}

		switch(orderType) {
		case "newProduct":
			sb.append(" ORDER BY regdate DESC))");
			break;
		case "hitProduct":
			sb.append(" ORDER BY hitcount DESC))");
			break;
		case "highPrice":
			sb.append(" ORDER BY price DESC))");
			break;
		case "lowPrice":
			sb.append(" ORDER BY price asc))");
			break;
		default:
		}

		sb.append(" WHERE  request_page = ?");

//		System.out.println(sb.toString());
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, params.getPageSize());
			pstmt.setString(2,  categoryName);
			pstmt.setString(3,  categoryName);

			if(type != null){
				pstmt.setString(4, value);
				pstmt.setInt(5, params.getPage());
			}else{
				pstmt.setInt(4, params.getPage());
			}

			rs = pstmt.executeQuery();
			list = new ArrayList<Product>();

			while(rs.next()){
				int productId=rs.getInt("product_id");
				String productName=rs.getString("product_name");
				String categoryNameGet=rs.getString("category_name");
				String maker=rs.getString("maker");
				String productDesc=rs.getString("product_desc");
				String regdate=rs.getString("regdate");
				int price=rs.getInt("price");
				int amount=rs.getInt("amount");
				int hitcount=rs.getInt("hitcount");
				Product product = new Product(productId, productName, categoryNameGet, maker, productDesc, regdate, price, amount, hitcount);
				list.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcUserDao.listByParams(Params params) 에러발생", e);
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return list;
	}

	@Override
	public int pageCount(Params params, String categoryName, String orderType) {
		
		String type = params.getType();
		String value = params.getValue();

		int count=0;		

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT count(*) count");
		sb.append("         FROM   (SELECT product_id,");
		sb.append("       	 			product_name,");
		sb.append("       				category_name,");
		sb.append("       				maker,");
		sb.append("       				product_desc,");
		sb.append("                     TO_CHAR(regdate, 'YYYY/MM/DD HH24:MI:SS') regdate,");
		sb.append("        				price,");
		sb.append("        				amount,");
		sb.append("        				hitcount");
		sb.append("                 	FROM   products ");
		sb.append(" 					where category_name = ?");
		sb.append(" 					or category_name in (select category_name from categories where parent=?)");
		if(type!=null) {
			sb.append(" and  product_name LIKE ?");
		}

		switch(orderType) {
		case "newProduct":
			sb.append(" ORDER BY regdate DESC)");
			break;
		case "hitProduct":
			sb.append(" ORDER BY hitcount DESC)");
			break;
		case "highPrice":
			sb.append(" ORDER BY price DESC)");
			break;
		case "lowPrice":
			sb.append(" ORDER BY price asc)");
			break;
		default:
		}


		//System.out.println(sb.toString());
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,  categoryName);
			pstmt.setString(2,  categoryName);

			if(type != null){
				pstmt.setString(3, value);
			}

			rs = pstmt.executeQuery();
			

			if(rs.next()){
				count=rs.getInt("count");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new MallException("JdbcUserDao.listByParams(Params params) 에러발생", e);
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return count;
	}



	//test
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void search(String id) {
		// TODO Auto-generated method stub

	}


	public static void main(String[] args) {

		JdbcProductDao productDao=(JdbcProductDao) DaoFactory.getInstance().getDao(JdbcProductDao.class);


		Params params = new Params();
		List<Product> products=productDao.listByParams(params, "반지", "highPrice");
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println(productDao.pageCount(params, "반지", "highPrice"));
	}

}












